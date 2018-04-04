
import java.util.ArrayList;

import framework.*;

/**
 * プレイヤーの戦略を表すクラスです。
 * 手札のカードの最大値を出します。
 * @author 柴田航平 
 * @see Player
 * @return カードの識別番号(0-51)
 */
public class Max extends Player{

	/**
	 * プレイヤー名を指定するコンストラクタです。
	 */
	public Max() {
		super("Max");
	}
	
	/**
	 * プレイヤーの戦略を表す抽象メソッドの実装です。
	 * @param hands 自分の手札
	 * @param score プレイヤー全員のターン・ラウンドの得点
	 * @return 手札から出すカード番号
	 */
	@Override
	public int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info) {
		return ValueUtility.maxValue(hands);
	}
}
