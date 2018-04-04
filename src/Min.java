import java.util.ArrayList;

import framework.InfoGame;
import framework.Player;
import framework.Score;
import framework.ValueUtility;

/**
 * プレイヤーの戦略を表すクラスです。
 * 手札のカードの最小値を出します。
 * @author 柴田航平 
 * @see Player
 * @return カードの識別番号(0-51)
 */
public class Min extends Player{
	/**
	 * プレイヤー名を指定するコンストラクタです。
	 */
	public Min() {
		super("Min");
	}
	
	/**
	 * プレイヤーの戦略を表す抽象メソッドの実装です。
	 * @param hands 自分の手札
	 * @param score プレイヤー全員のターン・ラウンドの得点
	 * @return 手札から出すカード番号
	 */
	@Override
	public int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info) {
		return ValueUtility.minValue(hands);
	}
}
