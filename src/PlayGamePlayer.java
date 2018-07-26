
import java.io.IOException;
import java.util.ArrayList;

import framework.InfoGame;
import framework.PlayGameView;
import framework.Player;
import framework.Score;

/**
 * Playerを管理するクラスです。
 * @author 古田亮汰郎
 * @see Player
 */
public class PlayGamePlayer extends Player {
	/**
	 * プレイヤー名を指定するコンストラクタです。
	 */
	public PlayGamePlayer() {
		super("自分");
	}

	@Override
	public int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info) {
		String str = null;
		PlayGameView.hands(hands);
		try {
			str = PlayGameView.sendStr(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PlayGameView.lock2 = false;
		return Integer.valueOf(str);
	}

}
