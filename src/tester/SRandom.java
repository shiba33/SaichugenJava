
import java.util.ArrayList;

import framework.ValueUtility;
import framework.InfoGame;
import framework.Player;
import framework.Score;

/**
 * プレイヤーの戦略を表すクラスです。
 * 何も考えずランダムなカードを出します。
 * 
 * @author 鈴木大河
 * @see Player
 * @return カードの識別番号(0-51)
 */
public class SRandom extends Player {
	/**
	 * プレイヤー名を指定するコンストラクタです。
	 */
	public SRandom() {
		super("SRandom");
	}

	/**
	 * プレイヤーの戦略を表すメソッドです。
	 * @param hands 自分の手札
	 * @param score プレイヤー全員のターン・ラウンドの得点
	 * @return 手札から出すカード番号
	 */
	@Override
	public int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info) {
		return (int)Math.random()*51;
	}
}
