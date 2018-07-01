package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * メニューのViewに関わるクラスです。
 * 
 * @author 柴田航平
 * @see Observer
 */
public class MainView extends JFrame implements Observer {

	private JPanel panel = new JPanel();
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JButton button1, button2, button3;
	public JComboBox combo1, combo2, combo3;

	private Player p1, p2, p3;

	public MainView(Player player1, Player player2, Player player3) {
		this();
		p1 = player1;
		p2 = player2;
		p3 = player3;
	}

	public MainView() {

		setTitle("最中限");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1080);
		setLocationRelativeTo(null);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		label1.setText("最中限");
		label1.setFont(new Font("MS　ゴシック", Font.BOLD, 100));
		label1.setBackground(Color.ORANGE);
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setAlignmentX(0.5f);

		button1 = new JButton("ゲームスタート");
		button1.setAlignmentX(0.5f);
		button1.setMaximumSize(new Dimension(280, 100));
		button1.setFont(new Font("MS　ゴシック", Font.PLAIN, 30));
		button1.setActionCommand("GameStart");

		button2 = new JButton("シュミュレーション");
		button2.setAlignmentX(0.5f);
		button2.setMaximumSize(new Dimension(280, 100));
		button2.setFont(new Font("MS　ゴシック", Font.PLAIN, 30));
		button2.setActionCommand("Simulation");

		button3 = new JButton("ルール説明");
		button3.setAlignmentX(0.5f);
		button3.setMaximumSize(new Dimension(280, 100));
		button3.setFont(new Font("MS　ゴシック", Font.PLAIN, 30));
		button3.setActionCommand("Rule");

		label2.setText("Player1");
		label2.setFont(new Font("MS　ゴシック", Font.BOLD, 30));
		label2.setBackground(Color.GREEN);
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setAlignmentX(0.5f);

		label3.setText("Player2");
		label3.setFont(new Font("MS　ゴシック", Font.BOLD, 30));
		label3.setBackground(Color.GREEN);
		label3.setForeground(Color.BLACK);
		label3.setOpaque(true);
		label3.setHorizontalTextPosition(JLabel.CENTER);
		label3.setAlignmentX(0.5f);

		label4.setText("Player3");
		label4.setFont(new Font("MS　ゴシック", Font.BOLD, 30));
		label4.setBackground(Color.GREEN);
		label4.setForeground(Color.BLACK);
		label4.setOpaque(true);
		label4.setHorizontalTextPosition(JLabel.CENTER);
		label4.setAlignmentX(0.5f);

		File file = new File("./bin");
		File[] filelist = file.listFiles();
		ArrayList<String> strList1 = new ArrayList<String>();
		ArrayList<String> strList2 = new ArrayList<String>();
		ArrayList<String> strList3 = new ArrayList<String>();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isFile() && filelist[i].getName().matches(".*class")) {
				strList1.add(filelist[i].getName());
				strList2.add(filelist[i].getName());
				strList3.add(filelist[i].getName());
			}
		}
		String[] strArray1 = new String[strList1.size()];
		String[] strArray2 = new String[strList2.size()];
		String[] strArray3 = new String[strList3.size()];

		for (int i = 0; i < strList1.size(); i++) {
			int strlen1 = strList1.get(i).length();
			// ".class" -> 6文字
			int cutNum = 6;
			strArray1[i] = strList1.get(i).substring(0, strlen1 - cutNum);
		}
		for (int i = 0; i < strList2.size(); i++) {
			int strlen2 = strList2.get(i).length();
			// ".class" -> 6文字
			int cutNum = 6;
			strArray2[i] = strList2.get(i).substring(0, strlen2 - cutNum);
		}
		for (int i = 0; i < strList3.size(); i++) {
			int strlen3 = strList3.get(i).length();
			// ".class" -> 6文字
			int cutNum = 6;
			strArray3[i] = strList3.get(i).substring(0, strlen3 - cutNum);
		}
		combo1 = new JComboBox(strArray1);
		combo1.setAlignmentX(0.5f);
		combo1.setMaximumSize(new Dimension(280, 50));
		combo2 = new JComboBox(strArray2);
		combo2.setAlignmentX(0.5f);
		combo2.setMaximumSize(new Dimension(280, 50));
		combo3 = new JComboBox(strArray3);
		combo3.setAlignmentX(0.5f);
		combo3.setMaximumSize(new Dimension(280, 50));

		panel.add(Box.createRigidArea(new Dimension(10, 80)));
		panel.add(label1);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(button1);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(button3);
		panel.add(Box.createRigidArea(new Dimension(10, 40)));
		panel.add(label2);
		panel.add(combo1);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(label3);
		panel.add(combo2);
		panel.add(Box.createRigidArea(new Dimension(10, 20)));
		panel.add(label4);
		panel.add(combo3);

		add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	public void addToButton1ActionListener(ActionListener actionListener) {
		button1.addActionListener(actionListener);
	}

	public void addToButton2ActionListener(ActionListener actionListener) {
		button2.addActionListener(actionListener);
	}

	public void addToButton3ActionListener(ActionListener actionListener) {
		button3.addActionListener(actionListener);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (Objects.isNull(arg)) {
			MainModel mm = (MainModel) o;
			int button1 = mm.getButton1();
			int button2 = mm.getButton2();
			int button3 = mm.getButton3();

			if (button1 == 1) {
				this.button1.setText("実行中…");
				this.button1.setEnabled(false);
			} else {
				this.button1.setText("ゲームスタート");
				this.button1.setEnabled(true);
			}
			if (button2 == 1) {
				this.button2.setText("実行中…");
				this.button2.setEnabled(false);
			} else {
				this.button2.setText("シュミュレーション");
				this.button2.setEnabled(true);
			}
			if (button3 == 1) {
				this.button3.setText("実行中…");
				this.button3.setEnabled(false);
			} else {
				this.button3.setText("遊び方");
				this.button3.setEnabled(true);
			}
		}
	}
}