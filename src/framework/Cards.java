package framework;

import java.util.ArrayList;

/**
 * カードを管理する抽象クラスです。 
 * カードは0から51の数値に割り当てます。
 * 具体的には、0はクラブ1、1はダイヤ1、2はハート1、3はスペード1、4はクラブ2…となる。
 * @author 柴田航平
 */
public abstract class Cards {
	/**
	 * プレイヤー1の手札を表すフィールドです
	 * 辞書順に0から51の範囲の数値を17個保持し、ターン毎に出したカードを取り除きます。
	 */
	private ArrayList<Integer> player1 = new ArrayList<Integer>();
	/**
	 * プレイヤー2の手札を表すフィールドです
	 * 辞書順に0から51の範囲の数値を17個保持し、ターン毎に出したカードを取り除きます。
	 */
	private ArrayList<Integer> player2 = new ArrayList<Integer>();
	/**
	 * プレイヤー3の手札を表すフィールドです
	 * 辞書順に0から51の範囲の数値を17個保持し、ターン毎に出したカードを取り除きます。
	 */
	private ArrayList<Integer> player3 = new ArrayList<Integer>();
	
	/**
	 * プレイヤーが出したカードを一次元に保持するフィールドです。
	 * 全てのターン・ラウンドで利用したカード情報を含みます。
	 */
	private ArrayList<Integer> putOutCards = new ArrayList<Integer>();
	
	/**
	 * 手札を設定するメソッドです。
	 * @param numList
	 * @param playerNum
	 */
	protected void setHandsList(ArrayList<Integer> numList, int playerNum) {
		if(playerNum == 0) {
			player1 = numList;
		}else if(playerNum == 1) {
			player2 = numList;
		}else if(playerNum == 2){
			player3 = numList;
		}else {
			throw new IllegalArgumentException("引数が不正な値です。(0...Player1, 2...Player2, 3...Player3)");
		}
	}
	/**
	 * 任意の手札を取得するメソッドです。
	 * 手札の値渡しに相当します。
	 * @param num 0, 1, 2のそれぞれがプレイヤー1, 2, 3
	 * @return 手札を取得
	 */
	protected ArrayList<Integer> getDeepHands(int num) {
		if(num == 0) {
			return new ArrayList<>(player1);
		}else if(num == 1) {
			return new ArrayList<>(player2);
		}else if(num == 2) {
			return new ArrayList<>(player3);
		}else {
			throw new IllegalArgumentException("引数が不正な値です。(0...Player1, 2...Player2, 3...Player3)");
		}
	}
	/**
	 * 利用した全てのカードを記録するメソッドです。
	 * ターン・ラウンドの全てが含まれます。
	 * @param num
	 */
	protected void setPutOutCards(int num) {
		putOutCards.add(num);
	}
	/**
	 * 全てのプレイヤーが使用したカードを一次元なリストとして取得します。
	 * ターン・ラウンドの全てが含まれます。
	 * @return
	 */
	public ArrayList<Integer> getPutOutCards() {
		return putOutCards;
	}
	/**
	 * 1ラウンドで使用した手札を0クリアする。
	 */
	protected void clearAllHands() {
		player1.clear();
		player2.clear();
		player3.clear();
	}
	

	/**
	 * 手札を配布する抽象メソッドを定義します。
	 */
	abstract void dealCards();
	/**
	 * 手札から利用したカードを手札から取り除く抽象メソッドを定義します。
	 */
	abstract void removeAndRecordCards(ArrayList<Integer> p, int playerNum, int putOutCard); 
}
