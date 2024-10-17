package com.make.rpggame;

import java.util.Scanner;

/**
 * テキストベースRPGのメインクラス
 */
public class RPGGame {
    private static final String EXIT_COMMAND = "exit";
    private static Scanner scanner;
    private static boolean isRunning;

    /**
     * ゲームの実行を開始するメインメソッド
     */
    public static void main(String[] args) {
        init();
        gameLoop();
        cleanup();
    }

    /**
     * ゲームの初期化を行うメソッド
     */
    private static void init() {
        scanner = new Scanner(System.in);
        isRunning = true;
        System.out.println("テキストベースRPGへようこそ！");
        System.out.println("ゲームを終了するには 'exit' と入力してください。");
    }

    /**
     * メインのゲームループ
     * ユーザーの入力を受け付け、適切な処理を行う
     */
    private static void gameLoop() {
        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            processCommand(input);
        }
    }

    /**
     * ユーザーが入力したコマンドを処理するメソッド
     * @param command ユーザーが入力したコマンド
     */
    private static void processCommand(String command) {
        switch (command) {
            case EXIT_COMMAND:
                isRunning = false;
                System.out.println("ゲームを終了します...");
                break;
            case "help":
                displayHelp();
                break;
            case "status":
                displayStatus();
                break;
            default:
                System.out.println("不明なコマンドです。'help' と入力してコマンドのリストを表示してください。");
        }
    }

    /**
     * ヘルプメッセージを表示するメソッド
     */
    private static void displayHelp() {
        System.out.println("利用可能なコマンド:");
        System.out.println("help   - このヘルプメッセージを表示");
        System.out.println("status - キャラクターのステータスを表示");
        System.out.println("exit   - ゲームを終了");
    }

    /**
     * キャラクターのステータスを表示するメソッド
     */
    private static void displayStatus() {
        System.out.println("あなたのキャラクターのステータス:");
        System.out.println("レベル: 1");
        System.out.println("HP: 100/100");
        System.out.println("MP: 50/50");
    }

    /**
     * ゲーム終了時のクリーンアップを行うメソッド
     */
    private static void cleanup() {
        scanner.close();
        System.out.println("プレイしていただきありがとうございました！");
    }
}