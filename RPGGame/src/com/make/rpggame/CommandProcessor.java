package com.make.rpggame;

/**
 * ユーザーコマンドを処理するクラス
 * 入力されたコマンドに応じて適切な処理を実行します。
 */
public class CommandProcessor {
    private final Player player;

    /**
     * CommandProcessorのコンストラクタ
     * @param player 操作対象のPlayerオブジェクト
     */
    public CommandProcessor(Player player) {
        this.player = player;
    }

    /**
     * 入力されたコマンドを処理するメソッド
     * @param command ユーザーが入力したコマンド文字列
     */
    public void processCommand(String command) {
        switch (command) {
            case "help" -> displayHelp();
            case "status" -> player.displayStatus();
            case "train" -> trainPlayer();
            default -> System.out.println(ANSIColors.RED + "不明なコマンドです。'help' と入力してコマンドのリストを表示してください。" + ANSIColors.RESET);
        }
    }

    /**
     * ヘルプメッセージを表示するメソッド
     * 利用可能なコマンドとその説明を表示します。
     */
    private void displayHelp() {
        System.out.println(ANSIColors.CYAN + "利用可能なコマンド:" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "help   - このヘルプメッセージを表示" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "status - キャラクターのステータスを表示" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "train  - トレーニングを行い経験値を獲得" + ANSIColors.RESET);
        System.out.println(ANSIColors.YELLOW + "exit   - ゲームを終了" + ANSIColors.RESET);
    }

    /**
     * プレイヤーのトレーニングを実行するメソッド
     * ランダムな経験値を獲得し、プレイヤーのステータスを更新・表示します。
     */
    private void trainPlayer() {
        int expGained = (int) (Math.random() * 50) + 10; // 10から59の間でランダムな経験値を生成
        player.gainExp(expGained);
        player.displayStatus();
    }
}