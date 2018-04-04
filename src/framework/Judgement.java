package framework;

import java.util.ArrayList;

/**
 * ターンやラウンド、最終結果の勝敗判定をする抽象クラスです。
 * @author 柴田航平 
 */
abstract class Judgement {
	
	/**
	 * ターンの勝者を表すフィールドです。
	 */
	private int turnWinner = -1;
	/**
	 * ターンの勝者の得点を表すフィールドです。
	 */
	private int addPoint = 0;
	/**
	 * ラウンドの勝者を表すフィールドです。
	 * 勝利者のプレイヤーIDを保持します。
	 */
	private ArrayList<Integer> roundWinner = new ArrayList<>();
	/**
	 * 最終的な勝者を表すフィールドです。
	 */
	private ArrayList<Integer> finalWinner = new ArrayList<>();
	/**
	 * プレイヤーのターンのランキングを表すフィールドです。
	 * プレイヤーの識別IDと順位が関連しています。
	 */
	private ArrayList<Integer> turnRanking = new ArrayList<>();
	/**
	 * プレイヤーのラウンドのランキングを表すフィールドです。
	 * プレイヤーの識別IDと順位が関連しています。
	 */
	private ArrayList<Integer> roundRanking = new ArrayList<>();
	/**
	 * プレイヤーの最終のランキングを表すフィールドです。
	 * プレイヤーの識別IDと順位が関連しています。
	 */
	private ArrayList<Integer> finalRanking = new ArrayList<>();
	
	/**
	 * ターンの勝者のプレイヤーIDを設定するメソッドです。 
	 * @param num ターン勝者のプレイヤーID
	 */
	protected void setTurnWinner(int num) {
		turnWinner = num;
	}
	/**
	 * ターンの勝者のプレイヤーIDを取得するメソッドです。 
	 * @return ターン勝者のプレイヤーID
	 */
	public int geTurntWinner() {
		return turnWinner;
	}
	/**
	 * ターンの勝利で得た得点を設定するメソッドです。
	 * @param num 得点
	 */
	protected void setPoint(int num) {
		addPoint = num;
	}
	/**
	 * ターンで勝利で得た得点を取得するメソッドです。
	 * @return 得点
	 */
	public int getPoint() {
		return addPoint;
	}
	/**
	 * ラウンドの勝者を設定するメソッドです。
	 * @param numList 勝者リスト
	 */
	protected void setRoundWinner(ArrayList<Integer> numList) {
		roundWinner = numList;
	}
	/**
	 * ラウンドの勝者を取得するメソッドです。
	 * @return 勝者リスト
	 */
	public ArrayList<Integer> getRoundWinner() {
		return new ArrayList<>(roundWinner);
	}
	/**
	 * 最終的な勝者を設定するメソッドです。
	 * @param p 最終的な勝者リスト
	 */
	protected void setFinalWinner(ArrayList<Integer> p) {
		finalWinner = p;
	}
	/**
	 * 最終的な勝者を取得するメソッドです。
	 * @return 最終的な勝者リスト
	 */
	public ArrayList<Integer> getFinalWinner() {
		return new ArrayList<>(finalWinner);
	}
	/**
	 * ターンの順位を設定するメソッドです。
	 * @param rank ターンの順位リスト
	 */
	protected void setTurnRanking(ArrayList<Integer> rank) {
		turnRanking = rank;
	}
	/**
	 * ラウンドの順位を設定するメソッドです。
	 * @param rank ターンの順位リスト
	 */
	protected void setRoundRanking(ArrayList<Integer> rank) {
		roundRanking = rank;
	}
	/**
	 * 最終の順位を設定するメソッドです。
	 * @param rank ターンの順位リスト
	 */
	protected void setFinalRanking(ArrayList<Integer> rank) {
		finalRanking = rank;
	}
	/**
	 * ターンのランキングを取得するメソッドです。
	 * @return ターンの順位リスト
	 */
	protected ArrayList<Integer> getTurnRanking() {
		return new ArrayList<>(turnRanking);
	}
	/**
	 * ラウンドのランキングを取得するメソッドです。
	 * @return ラウンドの順位リスト
	 */
	protected ArrayList<Integer> getRoundRanking() {
		return new ArrayList<>(roundRanking);
	}
	/**
	 * 最終のランキングを取得するメソッドです。
	 * @return 最終の順位リスト
	 */
	protected ArrayList<Integer> getFinalRanking() {
		return new ArrayList<>(finalRanking);
	}

	/**
	 * ターンの勝敗を判定する抽象メソッドです。
	 * @param p1 プレイヤー1の出すカード
	 * @param p2 プレイヤー2の出すカード
	 * @param p3 プレイヤー3の出すカード
	 */
	abstract void turnJudgement(int p1, int p2, int p3);
	/**
	 * ラウンドの勝敗を判定する抽象メソッドです。
	 * @param score プレイヤーの成績
	 */
	abstract void roundJudgement(Score score);
	/**
	 * 最終的な勝者を判定する抽象メソッドです。
	 * @param score プレイヤーの成績
	 */
	abstract void finalJudgement(Score score);
	/**
	 * ターンの勝敗によるプレイヤーの順位を判定する抽象メソッドです。 
	 * @param score プレイヤーの成績
	 */
	abstract void turnRanking(Score scoe);
	/**
	 * ラウンドの勝敗によるプレイヤーの順位を判定する抽象メソッドです。 
	 * @param score プレイヤーの成績
	 */
	abstract void roundRanking(Score score);
	/**
	 * 最終の勝敗によるプレイヤーの順位を判定する抽象メソッドです。 
	 * @param score プレイヤーの成績
	 */
	abstract void finalRanking(Score score);
}
