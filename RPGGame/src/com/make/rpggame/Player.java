package com.make.rpggame;

import java.util.EnumMap;
import java.util.Map;

/**
 * プレイヤーキャラクターを表すクラス
 * プレイヤーの属性、レベル、経験値、ステータスを管理します。
 */
public class Player {
    private final String name;
    private int level;
    private int exp;
    private final Map<Stat, Integer> stats;

    /**
     * プレイヤーのステータスを表す列挙型
     */
    public enum Stat {
        HP, MAX_HP, MP, MAX_MP, ATTACK, DEFENSE, SPEED
    }

    /**
     * Playerのコンストラクタ
     * @param name プレイヤーの名前
     */
    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.stats = new EnumMap<>(Stat.class);
        initializeStats();
    }

    /**
     * 初期ステータスを設定するメソッド
     */
    private void initializeStats() {
        stats.put(Stat.HP, 100);
        stats.put(Stat.MAX_HP, 100);
        stats.put(Stat.MP, 50);
        stats.put(Stat.MAX_MP, 50);
        stats.put(Stat.ATTACK, 10);
        stats.put(Stat.DEFENSE, 5);
        stats.put(Stat.SPEED, 5);
    }

    /**
     * 経験値を獲得するメソッド
     * @param amount 獲得する経験値の量
     */
    public void gainExp(int amount) {
        exp += amount;
        System.out.printf(ANSIColors.GREEN + "%sは%d経験値を獲得しました！%n" + ANSIColors.RESET, name, amount);
        checkLevelUp();
    }

    /**
     * レベルアップの条件を確認し、必要に応じてレベルアップを行うメソッド
     */
    private void checkLevelUp() {
        int expToNextLevel = level * 100;
        while (exp >= expToNextLevel) {
            levelUp();
            expToNextLevel = level * 100;
        }
    }

    /**
     * レベルアップの処理を行うメソッド
     * ステータスの増加と経験値の調整を行います。
     */
    private void levelUp() {
        level++;
        exp -= (level - 1) * 100;
        
        increaseStat(Stat.MAX_HP, 10);
        increaseStat(Stat.MAX_MP, 5);
        increaseStat(Stat.ATTACK, 2);
        increaseStat(Stat.DEFENSE, 2);
        increaseStat(Stat.SPEED, 1);
        
        setStat(Stat.HP, getStat(Stat.MAX_HP));
        setStat(Stat.MP, getStat(Stat.MAX_MP));

        System.out.printf(ANSIColors.BRIGHT_PINK + "%sはレベル%dになりました！%n" + ANSIColors.RESET, name, level);
    }

    /**
     * 指定されたステータスを増加させるメソッド
     * @param stat 増加させるステータス
     * @param amount 増加量
     */
    private void increaseStat(Stat stat, int amount) {
        stats.put(stat, stats.get(stat) + amount);
    }

    /**
     * プレイヤーのステータスを表示するメソッド
     */
    public void displayStatus() {
        System.out.println(ANSIColors.CYAN + name + "のステータス:" + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "レベル: " + ANSIColors.YELLOW + level + ANSIColors.RESET);
        System.out.println(ANSIColors.CYAN + "経験値: " + ANSIColors.YELLOW + exp + "/" + (level * 100) + ANSIColors.RESET);
        for (Stat stat : Stat.values()) {
            System.out.printf(ANSIColors.CYAN + "%s:" + ANSIColors.YELLOW + " %d%n" + ANSIColors.RESET, stat.name(), stats.get(stat));
        }
    }

    /**
     * 指定されたステータスの値を取得するメソッド
     * @param stat 取得するステータス
     * @return ステータスの値
     */
    public int getStat(Stat stat) {
        return stats.getOrDefault(stat, 0);
    }

    /**
     * 指定されたステータスに値を設定するメソッド
     * @param stat 設定するステータス
     * @param value 設定する値
     */
    public void setStat(Stat stat, int value) {
        stats.put(stat, value);
    }

    /**
     * プレイヤーの名前を取得するメソッド
     * @return プレイヤーの名前
     */
    public String getName() {
        return name;
    }

    /**
     * プレイヤーのレベルを取得するメソッド
     * @return プレイヤーのレベル
     */
    public int getLevel() {
        return level;
    }
}