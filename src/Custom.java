
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import framework.InfoGame;
import framework.Player;
import framework.Score;

/**
 * 端末で手札指定してね？
 * 
 * @author 鈴木大河
 * @see Player
 * @return カードの識別番号(0-51)
 */
public class Custom extends Player {
	/**
	 * プレイヤー名を指定するコンストラクタです。
	 */
	public Custom() {
		super("Custom");
	}

	/**
	 * プレイヤーの戦略を表すメソッドです。
	 * @param hands 自分の手札
	 * @param score プレイヤー全員のターン・ラウンドの得点
	 * @return 手札から出すカード番号
	 */
	@Override
	public int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info) {
		String str=null;
		System.out.println("てふだ:"+hands);
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("num[0-51]:");
			str = br.readLine();
		}catch(IOException e){
			System.out.println("Exception :" + e);
		}
		return Integer.valueOf(str) ;
	}
}
