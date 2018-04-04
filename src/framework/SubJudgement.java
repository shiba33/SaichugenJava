package framework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ターン・ラウンドの勝敗を決定する抽象クラスの実装です。
 * 
 * @author 柴田航平
 * @see Judgement
 */
class SubJudgement extends Judgement {

	/**
	 * ターンの勝敗を決定する抽象メソッドの実装です。
	 * 
	 * @param p1
	 *            プレイヤー1の出すカード
	 * @param p2
	 *            プレイヤー2の出すカード
	 * @param p3
	 *            プレイヤー3の出すカード
	 */
	@Override
	protected void turnJudgement(int p1, int p2, int p3) {
		ArrayList<Integer> numList = new ArrayList<>();

		numList.add(p1);
		numList.add(p2);
		numList.add(p3);
		Collections.sort(numList);

		if (numList.get(1) == p1) {
			setTurnWinner(0);
		} else if (numList.get(1) == p2) {
			setTurnWinner(1);
		} else {
			setTurnWinner(2);
		}

		setPoint(numList.get(1) / 4 + 1);

	}

	/**
	 * ラウンドの勝敗を決定する抽象メソッドの実装です。
	 * 
	 * @param score
	 *            プレイ成績
	 */
	@Override
	protected void roundJudgement(Score score) {
		setRoundWinner(comparePoint(score, "turn"));
	}

	/**
	 * 最終的な勝敗を決定する抽象メソッドの実装です。
	 * 
	 * @param score
	 *            プレイ成績
	 */
	@Override
	protected void finalJudgement(Score score) {
		setFinalWinner(comparePoint(score, "round"));
	}

	/**
	 * ラウンドや最終的な成績を比較し、勝者をリストとして取得する。
	 * 
	 * @param score
	 *            プレイヤー成績
	 * @param str
	 *            文字列"turn"(ラウンド)または、"round"(最終)
	 * @return 勝者のリスト
	 */
	protected ArrayList<Integer> comparePoint(Score score, String str) {
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Integer> winner = new ArrayList<>();

		if (str.equals("turn")) {
			numList.add(score.getTurnScore(0));
			numList.add(score.getTurnScore(1));
			numList.add(score.getTurnScore(2));
		} else {
			numList.add(score.getRoundScore(0));
			numList.add(score.getRoundScore(1));
			numList.add(score.getRoundScore(2));
		}
		Collections.sort(numList);

		if (str.equals("turn")) {
			for (int i = 0; i < numList.size(); i++) {
				if (numList.get(1) == score.getTurnScore(i)) {
					winner.add(i);
				}
			}
		} else {
			for (int i = 0; i < numList.size(); i++) {
				if (numList.get(1) == score.getRoundScore(i)) {
					winner.add(i);
				}
			}
		}

		return winner;
	}

	@Override
	protected void turnRanking(Score score) {
		int p1 = score.getTurnScore(0);
		int p2 = score.getTurnScore(1);
		int p3 = score.getTurnScore(2);

		setTurnRanking(getRankingList(p1, p2, p3));
	}
	
	@Override
	protected void roundRanking(Score score) {
		int p1 = score.getRoundScore(0);
		int p2 = score.getRoundScore(1);
		int p3 = score.getRoundScore(2);
		
		setRoundRanking(getRankingList(p1, p2, p3));
	}

	@Override
	protected void finalRanking(Score score) {
		int p1 = score.getFinalScore(0);
		int p2 = score.getFinalScore(1);
		int p3 = score.getFinalScore(2);
		
		setRoundRanking(getRankingList(p1, p2, p3));
	}
	
	protected ArrayList<Integer> getRankingList(int p1, int p2, int p3) {
		ArrayList<Integer> rank = new ArrayList<Integer>();
		if ((p1 == p2) && (p2 == p3)) {
			rank.add(1);
			rank.add(1);
			rank.add(1);
		} else if (p1 == p2) {
			rank.add(1);
			rank.add(1);
			rank.add(3);
		} else if (p1 == p3) {
			rank.add(1);
			rank.add(3);
			rank.add(1);
		}else if(p2 == p3) {
			rank.add(3);
			rank.add(1);
			rank.add(1);
		}else if((p1 < p2) && (p2 < p3)) {
			rank.add(2);
			rank.add(1);
			rank.add(2);
		}else if((p1 < p3) && (p3 < p2)) {
			rank.add(2);
			rank.add(2);
			rank.add(1);
		}else if((p2 < p1) && (p1 < p3)) {
			rank.add(1);
			rank.add(2);
			rank.add(2);
		}else if((p3 < p1) && (p1 < p2)) {
			rank.add(1);
			rank.add(2);
			rank.add(2);
		}else if((p2 < p3) && (p3 < p1)) {
			rank.add(2);
			rank.add(2);
			rank.add(1);
		}else {
			rank.add(2);
			rank.add(1);
			rank.add(2);
		}

		return rank;
	}
}
