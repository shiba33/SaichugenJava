package framework;

import java.util.ArrayList;

/**
 * 戦術の構築に利用するユーティリティクラスです。 
 * @author 柴田航平
 */
public class IndexUtility {
	
	/**
	 * 手札リストから定数値に最も近い値を持つカードを選び、その手札の添字(0-17)を取得します。
	 * 上記に適するカードが2つある場合、若い添字を採用する。
	 * @param hands 手札リスト
	 * @param num 定数値
	 * @return 手札リストの添字。リストが0以下の場合は-1。
	 */
	public static int nearIndexOf(ArrayList<Integer> hands, double num) {
		if(hands.size() == 1) {
			return 0;
		}else if(hands.size() <= 0) {
			return -1;
		}

		int minIndex = 0;
		double minAbs = Math.abs(num - hands.get(0));
		for(int i = 1; i < hands.size(); i++) {
			if(Math.abs(num - hands.get(i)) < minAbs) {
				minIndex = i;
				minAbs = Math.abs(num - hands.get(i)); 
			}
		}
		return minIndex;
	}
	
	/**
	 * 手札リストから定数値に最も近い値を持つカードを選び、その手札の添字(0-17)を取得します。
	 * 上記に適するカードが2つある場合、老いた添字を採用する。
	 * @param hands 手札リスト
	 * @param num 定数値
	 * @return 手札リストの添字。リストが0以下の場合は-1。
	 */
	public static int nearLastIndexOf(ArrayList<Integer> hands, double num) {
		if(hands.size() == 1) {
			return 0;
		}else if(hands.size() <= 0) {
			return -1;
		}
		
		int minIndex = hands.size() - 1;
		double minAbs = Math.abs(num - hands.get(0));
		for(int i = minIndex; i >= 0; i--) {
			if(Math.abs(num - hands.get(i)) < minAbs) {
				minIndex = i;
				minAbs = Math.abs(num - hands.get(i)); 
			}
		}
		return minIndex;
	}

}
