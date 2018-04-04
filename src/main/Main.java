package main;

import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import framework.MainController;
import framework.MainModel;
import framework.MainView;
import framework.Player;
import framework.SimulationController;
import framework.SimulationModel;
import framework.SimulationView;

public class Main {
	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("usage : java -cp *.jar <ClassFile1> <ClassFile2> <ClassFile3>");
		}
		try {

			@SuppressWarnings("unchecked")
			Class<Player> player1 = (Class<Player>) Class.forName(args[0]);
			@SuppressWarnings("unchecked")
			Class<Player> player2 = (Class<Player>) Class.forName(args[1]);
			@SuppressWarnings("unchecked")
			Class<Player> player3 = (Class<Player>) Class.forName(args[2]);

			MainModel mm = new MainModel();
			SimulationModel sm = new SimulationModel(player1.newInstance(), player2.newInstance(),player3.newInstance());
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MainView mv = new MainView();
					MainController mc = new MainController(mm, sm);

					SimulationView sv = new SimulationView();
					SimulationController sc = new SimulationController(mm, sm);

					mv.addToButton2ActionListener((ActionListener) mc);
					sv.addToButton1ActionListener((ActionListener) sc);

					mm.addObserver(mv);
					sm.addObserver(sv);
				}
			});

		} catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {

			System.err.println("Nothing Class Files.");
			e.printStackTrace();

		}
	}
}
