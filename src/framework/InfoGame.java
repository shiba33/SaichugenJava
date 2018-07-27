package framework;

/**
 * ゲームの状態とターン・ラウンド数を保持するクラスです。
 * @author 柴田航平 & 鈴木大河
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
	 * エラーを起こしたプレイヤを格納するフィールドです。
	 */
	private String[] errorPlayerName = new String[3];

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

	void setErrorPlayerName(String name) {
		if(errorPlayerName[0]!=null) {
			if(errorPlayerName[1]!=null)errorPlayerName[2]=name;
			else errorPlayerName[1]=name;
		}else errorPlayerName[0]=name;
	}
	/**
	 * ゲームのステータスを取得するメソッドです。
	 * @return ゲームステータス
	 */
	public int getGameStatus()  {
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
	public String getErrorPlayerName (int i) {
		return errorPlayerName[i];
	}
	

}
