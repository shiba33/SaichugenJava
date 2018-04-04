package framework;

import java.util.ArrayList;
import java.util.Random;

/**
 * 戦術の構築に利用するユーティリティクラスです。 
 * @author 柴田航平
 */
public class ValueUtility {
	private	static Random rand = new Random();
	
	/**
	 * 手札からランダムにカードを取得します。
	 * @param hands 手札リスト
	 * @return ランダムなカード番号
	 */
	public static int randomValue(ArrayList<Integer> hands) {
		return hands.get(rand.nextInt(hands.size()));
	}

	/**
	 * 手札から最大値のカードを取得する。
	 * @param hands 手札リスト
	 * @return 最大値のカード番号
	 */
	public static int maxValue(ArrayList<Integer> hands) {
		return hands.get(hands.size()-1);
	}
	
	/**
	 * 手札から最小値のカードを取得する。
	 * @param hands 手札リスト
	 * @return 最小値のカード番号
	 */
	public static int minValue(ArrayList<Integer> hands) {
		return hands.get(0);
	}

	/**
	 * 手札からカードを識別する値(0-51)の平均値を取得する。
	 * @param hands 手札リスト
	 * @return カートを識別する値の平均値
	 */
	public static double averageValue(ArrayList<Integer> hands) {
		double sum = 0.0;
		for( int hand : hands) {
			sum += hand;
		}
		return sum / hands.size();
	}
	
	/**
	 * 手札からカードを識別する値(0-51)の中央値を取得する。
	 * @param hands 手札	リスト
	 * @return 中央値
	 */
	public static double medianValue(ArrayList<Integer> hands) {
		int index = hands.size();
		int half = index / 2;
		if((half % 2) == 0) {
			return (hands.get(half) + hands.get(half + 1)) / 2.0;
		}else {
			return (double)hands.get(half + 1);
		}
	}

	/**
	 * 手札からカードを識別する値(0-51)の第一四分位数を取得する。
	 * @param hands 手札リスト
	 * @return 第一四分位数
	 */
	public static double theFirstQuartile(ArrayList<Integer> hands) {
		int index = hands.size();
		int upperLimitIndex = index / 2 - 1;
		if(index <= 3) {
			upperLimitIndex = 0;
		}
		ArrayList<Integer> halfHands = new ArrayList<Integer>();
		for(int i = 0; i <= upperLimitIndex; i++) {
			halfHands.add(hands.get(i));
		}
		return medianValue(halfHands);
	}
	
	/**
	 * 手札からカードを識別する値(0-51)の第三四分位数を取得する。
	 * @param hands 手札リスト
	 * @return 第三四分位数
	 */
	public static double theThirdQuartile(ArrayList<Integer> hands) {
		int index = hands.size();
		int lowerLimitIndex = index - index / 2;
		ArrayList<Integer> halfHands = new ArrayList<Integer>();
		if(index <= 3) {
			lowerLimitIndex = index - 1;
		}
		for(int i = lowerLimitIndex; i < hands.size(); i++) {
			halfHands.add(i);
		}
		return medianValue(halfHands);
	}
	
	/**
	 * 手札からカードを識別する値(0-51)の四分位範囲を取得する。
	 * @param hands 手札リスト
	 * @return 四分位範囲
	 */
	public static double interquartileRange(ArrayList<Integer> hands) {
		return theThirdQuartile(hands) - theFirstQuartile(hands);
	}
	
	/**
	 * 手札からカードを識別する値(0-51)の四分位偏差を取得する。
	 * @param hands 手札リスト
	 * @return 四分位偏差
	 */
	public static double quartileDeviation(ArrayList<Integer> hands) {
		return interquartileRange(hands) / 2;
	}
}
