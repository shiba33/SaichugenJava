package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * メニューのViewに関わるクラスです。
 * @author 柴田航平 
 * @see Observer
 */
public class MainView extends JFrame implements Observer {

	private JPanel panel = new JPanel();
	private JLabel label1 = new JLabel();
	private JButton button1, button2, button3;

	public MainView() {

		setTitle("最中限");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		label1.setText("最中限");
		label1.setFont(new Font("MS　ゴシック",Font.BOLD, 100));
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

		panel.add(Box.createRigidArea(new Dimension(10, 80)));
		panel.add(label1);
		panel.add(Box.createRigidArea(new Dimension(10,120)));
		panel.add(button1);
		panel.add(Box.createRigidArea(new Dimension(10,20)));
		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(10,20)));
		panel.add(button3);

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
		MainModel mm = (MainModel)o;
		int button1 = mm.getButton1();
		int button2 = mm.getButton2();
		int button3 = mm.getButton3();
		
		if(button1 == 1) {
			this.button1.setText("実行中…");
			this.button1.setEnabled(false);
		}else {
			this.button1.setText("ゲームスタート");
			this.button1.setEnabled(true);
		}
		
		if(button2 == 1) {
			this.button2.setText("実行中…");
			this.button2.setEnabled(false);
		}else {
			this.button2.setText("シュミュレーション");
			this.button2.setEnabled(true);
		}

		if(button3 == 1) {
			this.button3.setText("実行中…");
			this.button3.setEnabled(false);
		}else {
			this.button3.setText("遊び方");
			this.button3.setEnabled(true);
		}
		
	}
}
