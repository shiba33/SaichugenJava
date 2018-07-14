package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * シミュレーションのView(描画)に関わるクラスです。
 * @author 柴田航平 & 古田亮汰郎
 */
public class SimulationView extends JFrame implements Observer {
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JPanel p = new JPanel();
	private JLabel Round = new JLabel();
	private JLabel ScoreR = new JLabel();
	private JLabel ScoreB = new JLabel();
	private JLabel ScoreY = new JLabel();
	private JLabel labelTop = new JLabel();
	private JLabel labelWin = new JLabel();
	private JLabel cardsLeft = new JLabel();
	private JLabel cardsCenter = new JLabel();
	private JLabel cardsRight = new JLabel();
	private JLabel NameLeft = new JLabel();
	private JLabel ScoreLeft = new JLabel();
	private JLabel RoundsWinLeft = new JLabel();
	private JLabel NameCenter = new JLabel();
	private JLabel ScoreCenter = new JLabel();
	private JLabel RoundsWinCenter = new JLabel();
	private JLabel NameRight = new JLabel();
	private JLabel ScoreRight = new JLabel();
	private JLabel RoundsWinRight = new JLabel();
	private JLabel background = new JLabel();
	private JButton button1 = new JButton();
	private ImageIcon convert_Card[] = new ImageIcon[53];
	private int simulation_size_x = MainView.getSX();
	private int simulation_size_y = MainView.getSY();

	public void addToButton1ActionListener(ActionListener actionListener) {
		button1.addActionListener(actionListener);
	}

	public SimulationView() {
		/*カードのサイズ変換*/
		for (int convert = 0; convert < 53; convert++) {
			String imageTitle = "./image/" + convert + ".png";
			ImageIcon iconCard = new ImageIcon(imageTitle);
			ImageIcon resizing_Card = ResizingImage.resizeIcon(iconCard, (int) (simulation_size_x / 6.4),
					(int) (simulation_size_y / 2.4));
			convert_Card[convert] = resizing_Card;
		}
		setTitle("最中限" + "(" + simulation_size_x + "×" + simulation_size_y + ")" + " -シミュレーション- (実行中)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(MainView.getSX(), MainView.getSY());
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		setMinimumSize(new Dimension(640, 480));//Frameのサイズを(640×480)までしか縮小できないように設定
		SimulationModel model = (SimulationModel) o;
		String[] playerName = model.getAllPlayerName();
		Score score = model.getScore();
		Judgement judge = model.getJudge();
		InfoGame info = model.getInfo();
		int[] putOutArray = model.getPutOutArray();
		ImageIcon GoMenu1 = new ImageIcon("./image/GoMenu1.png");
		ImageIcon resizing_Button1 = ResizingImage.resizeIcon(GoMenu1, (int) (simulation_size_x / 6.4),
				(int) (simulation_size_y / 10.8));
		ImageIcon GoMenu2 = new ImageIcon("./image/GoMenu2.png");
		ImageIcon resizing_Button2 = ResizingImage.resizeIcon(GoMenu2, (int) (simulation_size_x / 6.4),
				(int) (simulation_size_y / 10.8));
		p.setLayout(null);
		if (info.getGameStatus() == 1) {

			labelTop.setText("ラウンド: " + info.getRoundNum() + "  ターン: " + info.getTurnNum());
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 32)));
			labelTop.setForeground(Color.BLACK);
			labelTop.setOpaque(false);

			int gridxValue;
			int turnWinner = judge.geTurntWinner();
			if (turnWinner == 0) {
				gridxValue = 0;
			} else if (turnWinner == 1) {
				gridxValue = 1;
			} else {
				gridxValue = 2;
			}
			ImageIcon iconWin = new ImageIcon("./image/win.png");
			ImageIcon resizing_win = ResizingImage.resizeIcon(iconWin, (int) (simulation_size_x / 8.06),
					simulation_size_y / 12);
			labelWin.setHorizontalAlignment(JLabel.CENTER);
			labelWin.setIcon(resizing_win);

			cardsLeft.setText(null);
			cardsLeft.setHorizontalAlignment(JLabel.CENTER);
			cardsLeft.setIcon(convert_Card[putOutArray[0]]);

			cardsCenter.setText(null);
			cardsCenter.setHorizontalAlignment(JLabel.CENTER);
			cardsCenter.setIcon(convert_Card[putOutArray[1]]);

			cardsRight.setText(null);
			cardsRight.setHorizontalAlignment(JLabel.CENTER);
			cardsRight.setIcon(convert_Card[putOutArray[2]]);

			NameLeft.setText("名前 : " + playerName[0]);
			NameLeft.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			NameLeft.setForeground(Color.WHITE);
			NameLeft.setOpaque(false);
			ScoreLeft.setText("得点 : " + score.getTurnScore(0));
			ScoreLeft.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			ScoreLeft.setForeground(Color.WHITE);
			ScoreLeft.setOpaque(false);
			RoundsWinLeft.setText("ラウンド勝利数 : " + score.getRoundScore(0));
			RoundsWinLeft.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			RoundsWinLeft.setForeground(Color.WHITE);
			RoundsWinLeft.setOpaque(false);

			NameCenter.setText("名前 : " + playerName[1]);
			NameCenter.setFont(
					new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			NameCenter.setForeground(Color.WHITE);
			NameCenter.setOpaque(false);
			ScoreCenter.setText("得点 : " + score.getTurnScore(1));
			ScoreCenter.setFont(
					new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			ScoreCenter.setForeground(Color.WHITE);
			ScoreCenter.setOpaque(false);
			RoundsWinCenter.setText("ラウンド勝利数 : " + score.getRoundScore(1));
			RoundsWinCenter.setFont(
					new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			RoundsWinCenter.setForeground(Color.WHITE);
			RoundsWinCenter.setOpaque(false);

			NameRight.setText("名前 : " + playerName[2]);
			NameRight.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			NameRight.setForeground(Color.WHITE);
			NameRight.setOpaque(false);
			ScoreRight.setText("得点 : " + score.getTurnScore(2));
			ScoreRight.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			ScoreRight.setForeground(Color.WHITE);
			ScoreRight.setOpaque(false);
			RoundsWinRight.setText("ラウンド勝利数 : " + score.getRoundScore(2));
			RoundsWinRight.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 38.4)));
			RoundsWinRight.setForeground(Color.WHITE);
			RoundsWinRight.setOpaque(false);

			/*変更*/
			ImageIcon backImg = new ImageIcon("./image/SimBack.jpg");
			ImageIcon resizing_back = ResizingImage.resizeIcon(backImg, simulation_size_x, simulation_size_y);
			background.setIcon(resizing_back);
			background.setBounds(0, 0, simulation_size_x, simulation_size_y);
			labelTop.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 2.93 / 2)),
					22 + (simulation_size_y / -48),
					(int) (simulation_size_x / 2.93),
					(int) (simulation_size_y / 8.06));

			ImageIcon RoundImg = new ImageIcon("./image/Round.png");
			ImageIcon resizing_round = ResizingImage.resizeIcon(RoundImg, (int) (simulation_size_x / 1.92),
					(int) (simulation_size_y / 10.8));
			Round.setIcon(resizing_round);
			Round.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 1.92 / 2)), 20,
					(int) (simulation_size_x / 1.92),
					(int) (simulation_size_y / 10.8));

			ImageIcon ScoreBImg = new ImageIcon("./image/ScoreB.png");
			ImageIcon resizing_ScoreB = ResizingImage.resizeIcon(ScoreBImg, (int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			ScoreB.setIcon(resizing_ScoreB);
			ScoreB.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 * 1.5)),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 50),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));

			ImageIcon ScoreYImg = new ImageIcon("./image/ScoreY.png");
			ImageIcon resizing_ScoreY = ResizingImage.resizeIcon(ScoreYImg, (int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			ScoreY.setIcon(resizing_ScoreY);
			ScoreY.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 / 2)),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 50),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));

			ImageIcon ScoreRImg = new ImageIcon("./image/ScoreR.png");
			ImageIcon resizing_ScoreR = ResizingImage.resizeIcon(ScoreRImg, (int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			ScoreR.setIcon(resizing_ScoreR);
			ScoreR.setBounds((int) (simulation_size_x / 2 + (simulation_size_x / 3.2 / 2)),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 50),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			if (gridxValue == 0) {
				labelWin.setBounds(
						(int) (simulation_size_x / 2 - (simulation_size_x / 8.06 * 2) - (simulation_size_x / 21)),
						(int) (simulation_size_y / 6),
						(int) (simulation_size_x / 8.06),
						simulation_size_y / 12);
			} else if (gridxValue == 1) {
				labelWin.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 8.06 / 2)),
						(int) (simulation_size_y / 6),
						(int) (simulation_size_x / 8.06),
						simulation_size_y / 12);
			} else {
				labelWin.setBounds(
						(int) (simulation_size_x / 2 + (simulation_size_x / 8.06) + (simulation_size_x / 21)),
						(int) (simulation_size_y / 6),
						(int) (simulation_size_x / 8.06),
						simulation_size_y / 12);
			}
			cardsLeft.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 6.4 * 2)),
					(int) (simulation_size_y / 4),
					(int) (simulation_size_x / 6.4), (int) (simulation_size_y / 2.4));
			cardsCenter.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 6.4 / 2)),
					(int) (simulation_size_y / 4),
					(int) (simulation_size_x / 6.4), (int) (simulation_size_y / 2.4));
			cardsRight.setBounds((int) (simulation_size_x / 2 + (simulation_size_x / 6.4)),
					(int) (simulation_size_y / 4),
					(int) (simulation_size_x / 6.4), (int) (simulation_size_y / 2.4));

			NameLeft.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 * 1.5) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 60 + (simulation_size_x / -32)),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			ScoreLeft.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 * 1.5) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 50),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			RoundsWinLeft.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 * 1.5) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - (40 + (simulation_size_x / -32))),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));

			NameCenter.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 / 2) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 60 + (simulation_size_x / -32)),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			ScoreCenter.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 / 2) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 50),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			RoundsWinCenter.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 3.2 / 2) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - (40 + (simulation_size_x / -32))),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));

			NameRight.setBounds((int) (simulation_size_x / 2 + (simulation_size_x / 3.2 / 2) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 60 + (simulation_size_x / -32)),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			ScoreRight.setBounds((int) (simulation_size_x / 2 + (simulation_size_x / 3.2 / 2) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - 50),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			RoundsWinRight.setBounds((int) (simulation_size_x / 2 + (simulation_size_x / 3.2 / 2) + 10),
					(int) (simulation_size_y - (simulation_size_y / 4.8) - (40 + (simulation_size_x / -32))),
					(int) (simulation_size_x / 3.2),
					(int) (simulation_size_y / 4.8));
			/*終了*/
			p.add(button1);

			p.add(NameLeft);
			p.add(ScoreLeft);
			p.add(RoundsWinLeft);

			p.add(NameCenter);
			p.add(ScoreCenter);
			p.add(RoundsWinCenter);

			p.add(NameRight);
			p.add(ScoreRight);
			p.add(RoundsWinRight);

			p.add(ScoreB);
			p.add(ScoreY);
			p.add(ScoreR);

			p.add(labelTop);
			p.add(Round);
			p.add(labelWin);

			p.add(cardsLeft);
			p.add(cardsCenter);
			p.add(cardsRight);

			p.add(background);
			getContentPane().add(p, BorderLayout.CENTER);

		} else if (info.getGameStatus() == 2) { // 最終結果の描画
			if (Objects.nonNull(arg)) {
				setVisible(false);
				dispose();
			}
			setTitle("最中限" + "(" + simulation_size_x + "×" + simulation_size_y + ")" + " -シミュレーション- (結果)");
			labelTop.setText("最終結果");
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 19.2)));
			labelTop.setHorizontalAlignment(JLabel.CENTER);
			labelTop.setOpaque(false);
			RoundsWinLeft.setText("ラウンド勝利数 : " + score.getRoundScore(0));
			RoundsWinCenter.setText("ラウンド勝利数 : " + score.getRoundScore(1));
			RoundsWinRight.setText("ラウンド勝利数 : " + score.getRoundScore(2));
			for (int i = 0; i < 3; i++) { // 結果の描画
				if (score.getRoundRanking()[i] == 3 || (score.getRoundRanking()[i] == 2 && i == 1) || i == 0) {
					cardsRight.setText(score.getRoundRanking()[i] + "位 : " + playerName[i]);
					cardsRight.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 24)));
					cardsRight.setIcon(null);

				}
				if (score.getRoundRanking()[i] == 2 || (score.getRoundRanking()[i] == 1 && i == 1) || i == 0) {
					cardsCenter.setText(score.getRoundRanking()[i] + "位 : " + playerName[i]);
					cardsCenter.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 24)));
					cardsCenter.setIcon(null);

				}
				if (score.getRoundRanking()[i] == 1 || i == 0) {
					cardsLeft.setText(score.getRoundRanking()[i] + "位 : " + playerName[i]);
					cardsLeft.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 24)));
					cardsLeft.setIcon(null);
				}

			}

			labelTop.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 2.93 / 2)),
					33 + (simulation_size_y / -48),
					(int) (simulation_size_x / 2.93),
					(int) (simulation_size_y / 8.06));

			button1.setContentAreaFilled(false);
			button1.setBorderPainted(false);
			button1.setIcon(resizing_Button1);
			button1.setRolloverIcon(resizing_Button2);
			button1.setAlignmentX(0.5f);
			button1.setActionCommand("GoBack");
			button1.setBounds(simulation_size_x / 2 + simulation_size_x / 4, simulation_size_y / 24,
					(int) (simulation_size_x / 6.4),
					(int) (simulation_size_y / 10.8));

			cardsLeft.setForeground(Color.BLACK);
			cardsCenter.setForeground(Color.BLACK);
			cardsRight.setForeground(Color.BLACK);

			cardsLeft.setBounds(simulation_size_x / 2 - (simulation_size_x / 3 / 2),
					simulation_size_y / 4 + simulation_size_y / 14,
					simulation_size_x / 3, simulation_size_y / 14);
			cardsCenter.setBounds(simulation_size_x / 2 - (simulation_size_x / 3 / 2),
					simulation_size_y / 4 + simulation_size_y / 14 + simulation_size_y / 14 + 15, simulation_size_x / 3,
					simulation_size_y / 14);
			cardsRight.setBounds(simulation_size_x / 2 - (simulation_size_x / 3 / 2),
					simulation_size_y / 4 + simulation_size_y / 14 + simulation_size_y / 14 + simulation_size_y / 14
							+ 30,
					simulation_size_x / 3, simulation_size_y / 14);

			Round.setIcon(null);
			labelWin.setIcon(null);

			getContentPane().add(p, BorderLayout.CENTER);
		} else if (info.getGameStatus() == 5) { // 値異常時のエラー描画
			if (Objects.nonNull(arg)) {
				setVisible(false);
				dispose();
			}
			setTitle("最中限" + "(" + simulation_size_x + "×" + simulation_size_y + ")" + " -シミュレーション- (エラー)");
			labelTop.setText("値が不正です");
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 19.2)));
			labelTop.setForeground(Color.BLACK);
			labelTop.setHorizontalAlignment(JLabel.CENTER);
			labelTop.setOpaque(false);

			ImageIcon backImg = new ImageIcon("./image/SimBack.jpg");
			ImageIcon resizing_back = ResizingImage.resizeIcon(backImg, simulation_size_x, simulation_size_y);
			background.setIcon(resizing_back);
			background.setBounds(0, 0, simulation_size_x, simulation_size_y);

			labelTop.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 2.93 / 2)),
					33 + (simulation_size_y / -48),
					(int) (simulation_size_x / 2.93),
					(int) (simulation_size_y / 8.06));

			button1.setContentAreaFilled(false);
			button1.setBorderPainted(false);
			button1.setIcon(resizing_Button1);
			button1.setRolloverIcon(resizing_Button2);
			button1.setAlignmentX(0.5f);
			button1.setActionCommand("GoBack");
			button1.setBounds(simulation_size_x / 2 + simulation_size_x / 4, simulation_size_y / 24,
					(int) (simulation_size_x / 6.4),
					(int) (simulation_size_y / 10.8));

			cardsLeft.setIcon(null);
			cardsCenter.setIcon(null);
			cardsRight.setIcon(null);
			Round.setIcon(null);
			labelWin.setIcon(null);

			p.add(labelTop);
			p.add(cardsCenter);
			p.add(button1);
			p.add(background);
			getContentPane().add(p, BorderLayout.CENTER);

		} else {
			if (Objects.nonNull(arg)) {
				setVisible(false);
				dispose();
			}
			setTitle("最中限" + "(" + simulation_size_x + "×" + simulation_size_y + ")" + " -シミュレーション- (エラー)");
			labelTop.setText("不明なエラー");
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, (int) (simulation_size_x / 19.2)));
			labelTop.setForeground(Color.BLACK);
			labelTop.setHorizontalAlignment(JLabel.CENTER);
			labelTop.setOpaque(false);

			ImageIcon backImg = new ImageIcon("./image/SimBack.jpg");
			ImageIcon resizing_back = ResizingImage.resizeIcon(backImg, simulation_size_x, simulation_size_y);
			background.setIcon(resizing_back);
			background.setBounds(0, 0, simulation_size_x, simulation_size_y);

			labelTop.setBounds((int) (simulation_size_x / 2 - (simulation_size_x / 2.93 / 2)),
					33 + (simulation_size_y / -48),
					(int) (simulation_size_x / 2.93),
					(int) (simulation_size_y / 8.06));

			button1.setContentAreaFilled(false);
			button1.setBorderPainted(false);
			button1.setIcon(resizing_Button1);
			button1.setRolloverIcon(resizing_Button2);
			button1.setAlignmentX(0.5f);
			button1.setActionCommand("GoBack");
			button1.setBounds(simulation_size_x / 2 + simulation_size_x / 4, simulation_size_y / 24,
					(int) (simulation_size_x / 6.4),
					(int) (simulation_size_y / 10.8));

			cardsLeft.setIcon(null);
			cardsCenter.setIcon(null);
			cardsRight.setIcon(null);
			Round.setIcon(null);
			labelWin.setIcon(null);

			p.add(labelTop);
			p.add(cardsCenter);
			p.add(button1);
			p.add(background);

			getContentPane().add(p, BorderLayout.CENTER);

		}
	}

}