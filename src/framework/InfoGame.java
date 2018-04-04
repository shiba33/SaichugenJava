package framework;

/**
 * ゲームのターン・ラウンド数を保持するクラスです。	
 * @author 柴田航平
 */
public class InfoGame {
	/**
	 * ターン数を表すフィールドです。
	 */
	private int turnNum;
	/**
	 * ラウンド数を表すフィールです。
	 */
	private int roundNum;

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
	 * ターン数を取得するメソッドです。
	 * @return ターン数
	 */
	public int getTurnNum()  {
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
