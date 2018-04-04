package framework;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * 手札を配布する抽象メソッドと、使用したカードを手札から取り除く抽象メソッドを実装するクラスです。
 * @author 柴田航平
 * @see Cards
 */
class AdjustCards extends Cards {
	
	/**
	 * 本クラスのコンストラクタです。
	 * 初期手札を生成します。
	 */
	AdjustCards() {
		dealCards();
	}

	/**
	 * 各プレイヤーに手札を配布する抽象メソッドを実装しています。
	 */
	@Override
	protected void dealCards() {
		for(int i = 0; i < 3; i++) {
			setInitialHands(new ArrayList<Integer>(), i);
		}
	}
	/**
	 * 使用したカードを手札から取り除く抽象メソッドを実装しています。
	 * @param p プレイヤーの手札
	 * @param playerNum プレイヤーID
	 * @param putOutCard 手札から出すカード
	 */
	@Override
	protected void removeAndRecordCards(ArrayList<Integer> p, int playerNum, int putOutCard) {
		p.remove(p.indexOf(putOutCard));
		setPutOutCards(putOutCard);
		setHandsList(p, playerNum);
	}

	/**
	 * プレイヤーの初期手札を設定します。
	 * @param p プレイヤーの手札
	 * @param playerNum プレイヤーID
	 */
	protected void setInitialHands(ArrayList<Integer> p, int playerNum) {
		Random rand = new Random();
		int count = 0;

		while(count < 17){
			int num = rand.nextInt(52);
			if(!hasNum(num)) {
				p.add(num);
				setHandsList(p, playerNum);
				count++;
			}
		}
		Collections.sort(p);
		setHandsList(p, playerNum);
	}
	/**
	 * プレイヤーの手札に配ったカードかを表すメソッドです。
	 * @param num 配布予定のカード
	 * @return 未だ配られていないならfalse、既に配られたならtrue
	 */
	protected boolean hasNum(int num){
		boolean flag = false;

		if(getDeepHands(0).indexOf(num) != -1) {
			flag = true;
		}else if(getDeepHands(1).indexOf(num) != -1) {
			flag = true;
		}else if(getDeepHands(2).indexOf(num) != -1) {
			flag = true;
		}
		return flag;
	}
}
