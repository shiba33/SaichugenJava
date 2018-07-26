package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * メニューのViewに関わるクラスです。
 *
 * @author 柴田航平 & 古田亮汰郎
 * @see Observer
 */
public class MainView extends JFrame implements Observer {

	private JPanel panel = new JPanel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JLabel background = new JLabel();
	private Dimension size;
	private JButton button1, button2, button3, button4;
	public JComboBox combo1, combo2, combo3;
	public static int screen_size_x;
	public static int screen_size_y;
	private Player p1, p2, p3;

	public MainView(Player player1, Player player2, Player player3) {
		this();
		p1 = player1;
		p2 = player2;
		p3 = player3;
	}

	protected static int getSX() {
		return screen_size_x;
	}

	protected static int getSY() {
		return screen_size_y;
	}

	public MainView() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {

			}

			@Override
			public void componentResized(ComponentEvent e) {
				size = getSize();
				screen_size_x = (int) size.getWidth();
				screen_size_y = (int) size.getHeight();
				setTitle("最中限" + "(" + screen_size_x + "×" + screen_size_y + ")");
				ImageIcon start1 = new ImageIcon("./image/start1.png");
				ImageIcon resizing_start = ResizingImage.resizeIcon(start1, screen_size_x / 3, screen_size_y / 14);
				ImageIcon start2 = new ImageIcon("./image/start2.png");
				ImageIcon resizing_start2 = ResizingImage.resizeIcon(start2, screen_size_x / 3, screen_size_y / 14);
				ImageIcon sim1 = new ImageIcon("./image/simulation1.png");
				ImageIcon resizing_sim1 = ResizingImage.resizeIcon(sim1, screen_size_x / 3, screen_size_y / 14);
				ImageIcon sim2 = new ImageIcon("./image/simulation2.png");
				ImageIcon resizing_sim2 = ResizingImage.resizeIcon(sim2, screen_size_x / 3, screen_size_y / 14);
				ImageIcon rule1 = new ImageIcon("./image/rule1.png");
				ImageIcon resizing_rule1 = ResizingImage.resizeIcon(rule1, screen_size_x / 3, screen_size_y / 14);
				ImageIcon rule2 = new ImageIcon("./image/rule2.png");
				ImageIcon resizing_rule2 = ResizingImage.resizeIcon(rule2, screen_size_x / 3, screen_size_y / 14);
				ImageIcon exit1 = new ImageIcon("./image/exit1.png");
				ImageIcon resizing_exit1 = ResizingImage.resizeIcon(exit1, screen_size_x / 3, screen_size_y / 14);
				ImageIcon exit2 = new ImageIcon("./image/exit2.png");
				ImageIcon resizing_exit2 = ResizingImage.resizeIcon(exit2, screen_size_x / 3, screen_size_y / 14);
				button1.setIcon(resizing_start);
				button1.setRolloverIcon(resizing_start2);
				button2.setIcon(resizing_sim1);
				button2.setRolloverIcon(resizing_sim2);
				button3.setIcon(resizing_rule1);
				button3.setRolloverIcon(resizing_rule2);
				button4.setIcon(resizing_exit1);
				button4.setRolloverIcon(resizing_exit2);
				button1.setBounds(screen_size_x / 2 - (screen_size_x / 3 / 2), screen_size_y / 3 + screen_size_y / 14,
						screen_size_x / 3, screen_size_y / 14);
				button2.setBounds(screen_size_x / 2 - (screen_size_x / 3 / 2),
						screen_size_y / 3 + screen_size_y / 14 + screen_size_y / 14 + 15, screen_size_x / 3,
						screen_size_y / 14);
				button3.setBounds(screen_size_x / 2 - (screen_size_x / 3 / 2),
						screen_size_y / 3 + screen_size_y / 14 + screen_size_y / 14 + screen_size_y / 14 + 30,
						screen_size_x / 3, screen_size_y / 14);
				button4.setBounds(
						screen_size_x / 2 - (screen_size_x / 3 / 2), screen_size_y / 3 + screen_size_y / 14
								+ screen_size_y / 14 + screen_size_y / 14 + screen_size_y / 14 + 45,
						screen_size_x / 3, screen_size_y / 14);
				label2.setBounds(screen_size_x - 445,
						screen_size_y - (100 + (screen_size_x / 128) + (screen_size_y / 72)), 120, 35);
				label2.setFont(new Font("MS　ゴシック", Font.BOLD, 15));
				label3.setBounds(screen_size_x - 295,
						screen_size_y - (100 + (screen_size_x / 128) + (screen_size_y / 72)), 120, 35);
				label3.setFont(new Font("MS　ゴシック", Font.BOLD, screen_size_x / 128 + screen_size_y / 72));
				label4.setBounds(screen_size_x - 145,
						screen_size_y - (100 + (screen_size_x / 128) + (screen_size_y / 72)), 120, 35);
				label4.setFont(new Font("MS　ゴシック", Font.BOLD, screen_size_x / 128 + screen_size_y / 72));
				combo1.setBounds(screen_size_x - 450, screen_size_y - 80, 120, 20);
				combo2.setBounds(screen_size_x - 300, screen_size_y - 80, 120, 20);
				combo3.setBounds(screen_size_x - 150, screen_size_y - 80, 120, 20);
				ImageIcon backImg = new ImageIcon("./image/background.png");
				ImageIcon resizing_back = ResizingImage.resizeIcon(backImg, screen_size_x, screen_size_y);
				background.setIcon(resizing_back);
				background.setBounds(0, 0, screen_size_x, screen_size_y);

			}
		});
		setMinimumSize(new Dimension(640, 480));//Frameのサイズを(640×480)までしか縮小できないように設定]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Rectangle desktopBounds = env.getMaximumWindowBounds();
		setSize(desktopBounds.width, desktopBounds.height);
		setLocationRelativeTo(null);
		size = getSize();
		screen_size_x = (int) size.getWidth();
		screen_size_y = (int) size.getHeight();

		panel.setLayout(null);

		button1 = new JButton(new ImageIcon("./image/start1.png"));
		button1.setRolloverIcon(new ImageIcon("./image/start2.png"));
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setAlignmentX(0.5f);
		button1.setActionCommand("GameStart");

		button2 = new JButton(new ImageIcon("./image/simulation1.png"));
		button2.setRolloverIcon(new ImageIcon("./image/simulation2.png"));
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setAlignmentX(0.5f);
		button2.setActionCommand("Simulation");

		button3 = new JButton(new ImageIcon("./image/rule1.png"));
		button3.setRolloverIcon(new ImageIcon("./image/rule2.png"));
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setAlignmentX(0.5f);
		button3.setActionCommand("Rule");

		button4 = new JButton(new ImageIcon("./image/exit1.png"));
		button4.setRolloverIcon(new ImageIcon("./image/exit2.png"));
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setAlignmentX(0.5f);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		background.setIcon(new ImageIcon("./image/background.png"));

		label2.setText("Player or COM");
		label2.setOpaque(false);
		label2.setForeground(Color.WHITE);
		label2.setAlignmentX(0.5f);

		label3.setText("COM");
		label3.setForeground(Color.WHITE);
		label3.setOpaque(false);
		label3.setAlignmentX(0.5f);

		label4.setText("COM");
		label4.setForeground(Color.WHITE);
		label4.setOpaque(false);
		label4.setAlignmentX(0.5f);

		File file = new File("./bin");
		File[] filelist = file.listFiles();
		ArrayList<String> strList1 = new ArrayList<String>();
		ArrayList<String> strList2 = new ArrayList<String>();
		ArrayList<String> strList3 = new ArrayList<String>();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isFile() && filelist[i].getName().matches(".*class")) {
				if (filelist[i].getName().equals("PlayGamePlayer.class")) {
				} else {
					strList1.add(filelist[i].getName());
					strList2.add(filelist[i].getName());
					strList3.add(filelist[i].getName());
				}
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
		combo1.setBounds(screen_size_x - 450, 1000, 120, 20);
		combo2 = new JComboBox(strArray2);
		combo2.setAlignmentX(0.5f);
		combo2.setBounds(screen_size_x - 300, 1000, 120, 20);
		combo3 = new JComboBox(strArray3);
		combo3.setAlignmentX(0.5f);
		combo3.setBounds(screen_size_x - 150, 1000, 120, 20);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(label2);
		panel.add(combo1);
		panel.add(label3);
		panel.add(combo2);
		panel.add(label4);
		panel.add(combo3);
		panel.add(label4);
		panel.add(background);
		getContentPane().add(panel, BorderLayout.CENTER);
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
				this.button1.setEnabled(false);
			} else {
				this.button1.setEnabled(true);
			}
			if (button2 == 1) {
				this.button2.setEnabled(false);
			} else {
				this.button2.setEnabled(true);
			}
			if (button3 == 1) {
				this.button3.setEnabled(false);
			} else {
				this.button3.setEnabled(true);
			}
		}
	}

}