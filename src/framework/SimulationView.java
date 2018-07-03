package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
 * シュミュレーションのView(描画)に関わるクラスです。
 * @author 柴田航平
 */
public class SimulationView extends JFrame implements Observer {
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JPanel p = new JPanel();
	private JLabel labelTop = new JLabel();
	private JLabel labelWin = new JLabel();
	private JLabel labelLeft = new JLabel();
	private JLabel labelCenter = new JLabel();
	private JLabel labelRight = new JLabel();
	private JLabel BottomLeft = new JLabel();
	private JLabel BottomCenter = new JLabel();
	private JLabel BottomRight = new JLabel();
	private JButton button1 = new JButton();
	
	public void addToButton1ActionListener(ActionListener actionListener) {
		button1.addActionListener(actionListener);
	}

	@Override
	public void update(Observable o, Object arg) {

		SimulationModel model = (SimulationModel) o;
		String[] playerName = model.getAllPlayerName();
		Score score = model.getScore();
		Judgement judge = model.getJudge();
		InfoGame info = model.getInfo();
		int[] putOutArray = model.getPutOutArray();

		p.removeAll();
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		p.setLayout(layout);
		
		if ((info.getRoundNum() == 5)||((info.getRoundNum() == 1) && (info.getTurnNum() == 1))){
			setTitle("最中限 -シミュレーション-");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1280, 720);
			setLocationRelativeTo(null);
			setVisible(true);
		}

		if (info.getRoundNum() < 4) {

			labelTop.setText("ラウンド: " + info.getRoundNum() + " , ターン: " + info.getTurnNum());
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, 60));
			labelTop.setForeground(Color.BLACK);
			labelTop.setBackground(Color.YELLOW);
			labelTop.setHorizontalAlignment(JLabel.CENTER);
			labelTop.setOpaque(true);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.2;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelTop, gbc);

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
			labelWin.setHorizontalAlignment(JLabel.CENTER);
			labelWin.setIcon(iconWin);
			gbc.gridx = gridxValue;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.3;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelWin, gbc);

			String imageTitleLeft = "./image/" + putOutArray[0] + ".png";
			ImageIcon iconLeft = new ImageIcon(imageTitleLeft);
			labelLeft.setText(null);
			labelLeft.setHorizontalAlignment(JLabel.CENTER);
			labelLeft.setIcon(iconLeft);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelLeft, gbc);

			String imageTitleCenter = "./image/" + putOutArray[1] + ".png";
			ImageIcon iconCenter = new ImageIcon(imageTitleCenter);
			labelCenter.setText(null);
			labelCenter.setHorizontalAlignment(JLabel.CENTER);
			labelCenter.setIcon(iconCenter);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelCenter, gbc);

			String imageTitleRight = "./image/" + putOutArray[2] + ".png";
			ImageIcon iconRight = new ImageIcon(imageTitleRight);
			labelRight.setText(null);
			labelRight.setHorizontalAlignment(JLabel.CENTER);
			labelRight.setIcon(iconRight);
			gbc.gridx = 2;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelRight, gbc);

			BottomLeft.setText(playerName[0] + ": " + score.getTurnScore(0) + "(" + score.getRoundScore(0) + ")");
			BottomLeft.setFont(new Font("MS　ゴシック", Font.BOLD, 50));
			BottomLeft.setForeground(Color.BLACK);
			BottomLeft.setBackground(Color.GREEN);
			BottomLeft.setOpaque(true);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.2;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(BottomLeft, gbc);

			BottomCenter.setText(playerName[1] + ": " + score.getTurnScore(1) + "(" + score.getRoundScore(1) + ")");
			BottomCenter.setFont(new Font("MS　ゴシック", Font.BOLD, 50));
			BottomCenter.setForeground(Color.BLACK);
			BottomCenter.setBackground(Color.CYAN);
			BottomCenter.setOpaque(true);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.2;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(BottomCenter, gbc);

			BottomRight.setText(playerName[2] + ": " + score.getTurnScore(2) + "(" + score.getRoundScore(2) + ")");
			BottomRight.setFont(new Font("MS　ゴシック", Font.BOLD, 50));
			BottomRight.setForeground(Color.BLACK);
			BottomRight.setBackground(Color.GRAY);
			BottomRight.setOpaque(true);
			gbc.gridx = 2;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.2;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(BottomRight, gbc);

			p.add(labelTop);
			p.add(labelWin);
			p.add(labelLeft);
			p.add(labelCenter);
			p.add(labelRight);
			p.add(BottomLeft);
			p.add(BottomCenter);
			p.add(BottomRight);

			getContentPane().add(p, BorderLayout.CENTER);

		} else if (info.getRoundNum() == 4) {
			if(Objects.nonNull(arg)){
				setVisible(false);
				dispose();
			}

			labelTop.setText("最終結果");
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, 60));
			labelTop.setForeground(Color.BLACK);
			labelTop.setBackground(Color.YELLOW);
			labelTop.setHorizontalAlignment(JLabel.CENTER);
			labelTop.setOpaque(true);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelTop, gbc);
			
			
			labelLeft.setText(score.getRoundRanking()[0] + "位 : " + playerName[0]);
			labelLeft.setFont(new Font("MS　ゴシック", Font.BOLD, 60));
			labelLeft.setHorizontalAlignment(JLabel.CENTER);
			labelLeft.setIcon(null);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 4;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelLeft, gbc);

			labelCenter.setText(score.getRoundRanking()[1] + "位 : " + playerName[1]);
			labelCenter.setFont(new Font("MS　ゴシック", Font.BOLD, 60));
			labelCenter.setHorizontalAlignment(JLabel.CENTER);
			labelCenter.setIcon(null);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 4;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelCenter, gbc);

			labelRight.setText(score.getRoundRanking()[2] + "位 : " + playerName[2]);
			labelRight.setFont(new Font("MS　ゴシック", Font.BOLD, 60));
			labelRight.setHorizontalAlignment(JLabel.CENTER);
			labelRight.setIcon(null);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 4;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelRight, gbc);

			button1.setText("メニューに戻る");
			button1.setPreferredSize(new Dimension(300, 100));
			button1.setFont(new Font("MS　ゴシック", Font.PLAIN, 35));
			button1.setMargin(new Insets(10, 10, 10, 10));
			button1.setActionCommand("GoBack");
			gbc.gridx = 1;
			gbc.gridy = 4;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.NONE;
			layout.setConstraints(button1, gbc);

			p.add(labelTop);
			p.add(labelLeft);
			p.add(labelCenter);
			p.add(labelRight);
			p.add(button1);

			getContentPane().add(p, BorderLayout.CENTER);
		}else {
			if(Objects.nonNull(arg)){
				setVisible(false);
				dispose();
			}
			labelTop.setText("値が不正です");
			labelTop.setFont(new Font("MS　ゴシック", Font.BOLD, 60));
			labelTop.setForeground(Color.BLACK);
			labelTop.setBackground(Color.YELLOW);
			labelTop.setHorizontalAlignment(JLabel.CENTER);
			labelTop.setOpaque(true);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.BOTH;
			layout.setConstraints(labelTop, gbc);

			button1.setText("メニューに戻る");
			button1.setPreferredSize(new Dimension(300, 100));
			button1.setFont(new Font("MS　ゴシック", Font.PLAIN, 35));
			button1.setMargin(new Insets(10, 10, 10, 10));
			button1.setActionCommand("GoBack");
			gbc.gridx = 1;
			gbc.gridy = 4;
			gbc.gridwidth = 2;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.fill = GridBagConstraints.NONE;
			layout.setConstraints(button1, gbc);

			p.add(labelTop);
			p.add(labelCenter);
			p.add(button1);

			getContentPane().add(p, BorderLayout.CENTER);

		}
	}

}