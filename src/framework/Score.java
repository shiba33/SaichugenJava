package framework;

import java.util.ArrayList;

/**
 * プレイヤーの得点を管理するクラスです。
 * @author 柴田航平
 */
public class Score {
	/**
	 * プレイヤーのターンの得点を表すフィールドです。
	 */
	private int[] turnScore = new int[3];
	/**
	 * プレイヤーのラウンドの得点を表すフィールドです。
	 */
	private int[] roundScore = new int[3];
	/**
	 * プレイヤーの最終の得点を表すフィールドです。
	 */
	private int[] finalScore = new int[3];
	/**
	 * プレイヤーのターンのランキングを表すフィールドです。
	 */
	private int[] turnRanking = new int[3];
	/**
	 * プレイヤーのラウンドのランキングを表すフィールドです。
	 */
	private int[] roundRanking = new int[3];

	
	/**
	 * プレイヤーのターンの得点を取得するメソッドです。
	 * @param num プレイヤーID
	 * @return ターンの得点
	 */
	public int getTurnScore(int num) {
		return turnScore[num];
	}
	/**
	 * プレイヤーのラウンドの得点を取得するメソッドです。
	 * @param num プレイヤーID
	 * @return ラウンドの得点
	 */
	public int getRoundScore(int num) {
		return roundScore[num];
	}
	/**
	 * プレイヤーの最終の得点を取得するメソッドです。
	 * @param num プレイヤーID
	 * @return ラウンドの得点
	 */
	public int getFinalScore(int num) {
		return finalScore[num];
	}
	/**
	 * プレイヤーのターンの順位を設定するメソッドです。
	 * @param p 順位リスト
	 */
	protected void setTurnRanking(ArrayList<Integer> p) {
		for(int i = 0; i < 3; i++) {
			turnRanking[i] = p.get(i);
		}
	}
	/**
	 * プレイヤーのラウンドの順位を設定するメソッドです。
	 * @param p 順位リスト
	 */
	protected void setRoundRanking(ArrayList<Integer> p) {
		for(int i = 0; i < 3; i++) {
			roundRanking[i] = p.get(i);
		}
	}
	/**
	 * プレイヤーのターンの得点を設定するメソッドです。
	 * @param playerNum プレイヤーID
	 * @param point ターンの得点
	 */
	void setTurnScore(int playerNum, int point) {
		turnScore[playerNum] += point;
	}
	/**
	 * プレイヤーのラウンドの得点を設定するメソッドです。
	 * @param p 最終の得点リスト
	 */
	void setRoundScore(ArrayList<Integer> p) {
		for(int playerNum : p) {
			roundScore[playerNum] += 1;
		}
	}
	/**
	 * プレイヤーの最終の得点を設定するメソッドです。
	 * @param p 最終の勝者リスト
	 */
	void setFinalScore(ArrayList<Integer> p) {
		for(int playerNum : p) {
			finalScore[playerNum] += 1;
		}
	}
	/**
	 * プレイヤー全員のターンの得点を取得するメソッドです。
	 * @return ターンの得点
	 */
	public int[] getTurnScoreArray() {
		return turnScore.clone();
	}
	/**
	 * プレイヤー全員のラウンドの得点を取得するメソッドです。
	 * @return ラウンドの得点
	 */
	public int[] getRoundScoreArray() {
		return roundScore.clone();
	}
	/**
	 * プレイヤー全員の最終の得点を取得するメソッドです。
	 * @return 最終の得点
	 */
	public int[] getFinalScoreArray() {
		return finalScore.clone();
	}
	/**
	 * ターンのランキングを取得するメソッドです。
	 * @return ターンのランキング
	 */
	public int[] getTurnRanking() {
		return turnRanking.clone();
	}
	/**
	 * ラウンドのランキングを取得するメソッドです。
	 * @return ラウンドのランキング
	 */
	public int[] getRoundRanking() {
		return roundRanking.clone();
	}
	/**
	 * プレイヤー全員のターンの得点を0にする。
	 */
	void clearTurnScore() {
		turnScore = new int[3];
	}
}
