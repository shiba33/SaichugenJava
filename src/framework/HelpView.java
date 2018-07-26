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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

/**
 * ヘルプの紙芝居を描画するクラスです。
 * @author 鈴木大河
 */
public class HelpView extends JFrame implements Observer {
	private GridBagLayout layout = new GridBagLayout();
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JLabel img = new JLabel();
	private ImageIcon helpImg;

	public HelpView() {

	}
	
	public void addToButtonsActionListener(ActionListener actionListener) {
		button1.addActionListener(actionListener);
		button2.addActionListener(actionListener);
		button3.addActionListener(actionListener);
	}
	
	
	public void helpWindowSet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 530);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void update(Observable o, Object arg) {

		HelpModel help = (HelpModel) o;
		mainPanel.removeAll();
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		mainPanel.setLayout(layout);
		mainPanel.setPreferredSize(new Dimension(640, 480));
		
		// ウィンドタイトルの修正と紙芝居の差し替え
		setTitle("最中限 -ヘルプ"+(help.getHelpStatus()+1)+"-");
		helpImg = new ImageIcon("./image/help"+help.getHelpStatus()+".png");
		img.setIcon(helpImg);
		img.setBounds(0, 0, 640, 480);
		
		// ヘルプのコントローラー(ボタン)の設定
		button1.setText("メニューに戻る");
		button1.setActionCommand("GoBack");
		button1.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));
		button1.setPreferredSize(new Dimension(200,40));
		
		button2.setText("戻る");
		button2.setActionCommand("Back");
		button2.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));
		button2.setPreferredSize(new Dimension(200,40));
		
		button3.setText("進む");
		button3.setActionCommand("Next");
		button3.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));
		button3.setPreferredSize(new Dimension(200,40));
		
		buttonPanel.setPreferredSize(new Dimension(640, 50));

		if(help.getHelpMaxPage()>=help.getHelpStatus()){
			if(Objects.nonNull(arg)){
				setVisible(false);
				dispose();
			}
			mainPanel.add(img);
			getContentPane().add(mainPanel, BorderLayout.CENTER);
		}else {
			
		}
		
		buttonPanel.add(button2);
		buttonPanel.add(button1);
		buttonPanel.add(button3);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

}