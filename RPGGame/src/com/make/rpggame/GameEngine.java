package com.make.rpggame;

import java.util.Scanner;

/**
 * ゲームの中核となるエンジンクラス
 * ゲームのメインループ、入力処理、初期化、終了処理を管理します。
 */
public class GameEngine {
    private static final String EXIT_COMMAND = "exit";
    private final Scanner scanner;
    private final CommandProcessor commandProcessor;
    private final Player player;
    private boolean isRunning;

    /**
     * GameEngineのコンストラクタ
     * 必要なオブジェクトの初期化を行います。
     */
    public GameEngine() {
        this.scanner = new Scanner(System.in);
        this.player = new Player("勇者");
        this.commandProcessor = new CommandProcessor(player);
        this.isRunning = true;
    }

    /**
     * ゲームを開始するメソッド
     * 初期化、メインループ、終了処理の順に実行します。
     */
    public void start() {
        init();
        gameLoop();
        cleanup();
    }

    /**
     * ゲームの初期化を行うメソッド
     * ウェルカムメッセージと操作方法を表示します。
     */
    private void init() {
        System.out.println(ANSIColors.GREEN + "テキストベースRPGへようこそ！" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "ゲームの操作方法：'help' と入力してください。" + ANSIColors.RESET);
    }

    /**
     * ゲームのメインループ
     * ユーザーからの入力を受け付け、処理を行います。
     */
    private void gameLoop() {
        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            processInput(input);
        }
    }

    /**
     * ユーザー入力を処理するメソッド
     * 終了コマンドの場合はゲームを終了し、それ以外はCommandProcessorに処理を委譲します。
     *
     * @param input ユーザーからの入力文字列
     */
    private void processInput(String input) {
        if (EXIT_COMMAND.equals(input)) {
            isRunning = false;
            System.out.println(ANSIColors.YELLOW + "ゲームを終了します..." + ANSIColors.RESET);
        } else {
            commandProcessor.processCommand(input);
        }
    }

    /**
     * ゲーム終了時の後処理を行うメソッド
     * リソースの解放とお別れメッセージの表示を行います。
     */
    private void cleanup() {
        scanner.close();
        System.out.println(ANSIColors.GREEN + "プレイしていただきありがとうございました！" + ANSIColors.RESET);
    }
}