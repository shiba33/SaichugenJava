package framework;

/**
 * ゲームの状態とターン・ラウンド数を保持するクラスです。
 * @author 柴田航平
 */
public class InfoGame {
	/**
	 * ゲームの状態を表すフィールドです。
	 */
	private int gameStatus;
	/**
	 * ターン数を表すフィールドです。
	 */
	private int turnNum;
	/**
	 * ラウンド数を表すフィールです。
	 */
	private int roundNum;

	/**
	 * ゲームのステータスを設定するメソッドです。
	 * @param num ターン数
	 */
	void setGameStatus(int num) {
		gameStatus = num;
	}

	/**
	 * ターン数を設定するメソッドです。
	 * @param num ターン数
	 */
	void setTurnNum(int num) {
		turnNum = num;
	}

	/**
	 * ラウンド数を設定するメソッドです。
	 * @param num ラウンド数
	 */
	void setRoundNum(int num) {
		roundNum = num;
	}

	/**
	 * ゲームのステータスを取得するメソッドです。
	 * @return ゲームステータス
	 */
	public int getGameStatus() {
		return gameStatus;
	}

	/**
	 * ターン数を取得するメソッドです。
	 * @return ターン数
	 */
	public int getTurnNum() {
		return turnNum;
	}

	/**
	 * ラウンド数を取得するメソッドです。
	 * @return ラウンド数
	 */
	public int getRoundNum() {
		return roundNum;
	}

}