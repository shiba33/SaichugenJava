
import java.util.ArrayList;

import framework.ValueUtility;
import framework.InfoGame;
import framework.Player;
import framework.Score;

/**
 * プレイヤーの戦略を表すクラスです。
 * 手札からランダムなカードを出します。
 * 
 * @author 柴田航平
 * @see Player
 * @return カードの識別番号(0-51)
 */
public class Random2 extends Player {
	/**
	 * プレイヤー名を指定するコンストラクタです。
	 */
	public Random2() {
		super("わいRadeon's2018記念");
	}

	/**
	 * プレイヤーの戦略を表すメソッドです。
	 * @param hands 自分の手札
	 * @param score プレイヤー全員のターン・ラウンドの得点
	 * @return 手札から出すカード番号
	 */
	@Override
	public int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info) {
		return ValueUtility.randomValue(hands);
	}
}
