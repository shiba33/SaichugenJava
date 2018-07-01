package main;

import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import framework.MainController;
import framework.MainModel;
import framework.MainView;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainModel mm = new MainModel();
				MainView mv = new MainView();
				MainController mc = new MainController(mm, mv);

				mv.addToButton2ActionListener((ActionListener) mc);
				mm.addObserver(mv);
			}
		});
	}
}
