package framework;

import java.util.ArrayList;

/**
 * プレイヤーを識別する抽象クラスです。
 * @author 柴田航平
 */
public abstract class Player {
	/**
	 * プレイヤー名を表すフィールドです。
	 */
	private String name;

	/**
	 * プレイヤーの識別番号を生成するコンストラクタです。
	 */
	public Player() {
		name = "HOGE";
	}

	/**
	 * プレイヤー名を指定するコンストラクタです。
	 * @param name プレイヤー名
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * プレイヤー名の名前を指定するメソッドです。
	 * @param name プレイヤー名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * プレイヤー名を取得します。
	 * @return プレイヤー名
	 */
	public String getName() {
		return name;
	}

	/**
	 * プレイヤーのゲームアルゴリズムを抽象メソッドとして定義します。
	 * @param hands 手札
	 * @param score プレイ成績
	 * @param id プレイヤーID
	 * @param info ターン・ラウンド情報
	 * @return プレイヤーの出すカード(0-51)
	 */
	public abstract int strategy(ArrayList<Integer> hands, Score score, int id, InfoGame info);
}
