package com.make.rpggame;

/**
 * テキストベースRPGゲームのメインクラス
 * このクラスはゲームの開始点となり、ゲームエンジンを初期化して起動します。
 */
public class RPGGame {
    public static void main(String[] args) {
        // ゲーム開始メッセージをシアン色で表示
        System.out.println(ANSIColors.CYAN + "テキストベースRPGを開始します..." + ANSIColors.RESET);      
        // ゲームエンジンのインスタンス作成と起動
        GameEngine gameEngine = new GameEngine();
        gameEngine.start();
    }
}