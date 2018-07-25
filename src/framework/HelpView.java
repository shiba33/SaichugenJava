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

import main.Main;

/**
 * ヘルプの紙芝居を描画するクラスです。
 * @author 鈴木大河
 */
public class HelpView extends JFrame implements Observer {
	private GridBagLayout layout = new GridBagLayout();
	private JPanel p = new JPanel();
	private JLabel img = new JLabel();
	private JButton button1 = new JButton();
	private ImageIcon helpImg;

	public HelpView() {

	}
	
	public void addToButton1ActionListener(ActionListener actionListener) {
		button1.addActionListener(actionListener);
	}

	@Override
	public void update(Observable o, Object arg) {

		HelpModel help = (HelpModel) o;
		p.removeAll();
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		p.setLayout(layout);
		
		// ウィンドタイトルの修正と紙芝居の差し替え
		setTitle("最中限 -ヘルプ"+(help.getHelpStatus()+1)+"-");
		helpImg = new ImageIcon("./image/help"+help.getHelpStatus()+".png");
		img.setIcon(helpImg);
		img.setBounds(0, 0, 640, 480);

		// 画面生成
		if (help.getHelpStatus() == 0){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(640, 480);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
		}
		if(help.getHelpMaxPage()>help.getHelpStatus()){
			if(Objects.nonNull(arg)){
				setVisible(false);
				dispose();
			}

			p.add(img);
			getContentPane().add(p, BorderLayout.CENTER);
		}else if(help.getHelpStatus()==help.getHelpMaxPage()){ 
			if(Objects.nonNull(arg)){
				setVisible(false);
				dispose();
			}
			setTitle("最中限 -ヘルプ"+help.getHelpMaxPage()+"-");
			button1.setIcon(helpImg);
			button1.setPreferredSize(new Dimension(640,480));
			button1.setActionCommand("GoBack");

			p.add(button1);

			getContentPane().add(p, BorderLayout.CENTER);
		}else {
			
		}
	}

}