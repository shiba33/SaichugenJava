package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * メニューのControllerに関わるクラスです。
 *
 * @author 柴田航平 & 古田亮汰郎
 * @see ActionListener
 */
public class MainController implements ActionListener {
	private MainModel mm;
	private MainView mv;
	private SimulationModel sm;
	private SimulationView sv;
	private SimulationController sc;
	private PlayGameModel pm;
	private PlayGameView pv;
	private PlayGameController pc;

	public MainController(MainModel model, MainView view) {
		mm = model;
		mv = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("GameStart")) {
			try {
				@SuppressWarnings("unchecked")
				Class<Player> player1 = (Class<Player>) Class.forName("PlayGamePlayer");
				@SuppressWarnings("unchecked")
				Class<Player> player2 = (Class<Player>) Class.forName((String) mv.combo2.getSelectedItem());
				@SuppressWarnings("unchecked")
				Class<Player> player3 = (Class<Player>) Class.forName((String) mv.combo3.getSelectedItem());
				Player p1 = player1.newInstance();
				Player p2 = player2.newInstance();
				Player p3 = player3.newInstance();
				pm = new PlayGameModel(p1, p2, p3);
			} catch (IllegalAccessException | ClassNotFoundException | InstantiationException event) {
				System.err.println("Nothing Class Files.");
				event.printStackTrace();

			}
			pv = new PlayGameView();
			pc = new PlayGameController(mm, pm);

			pv.addToButton1ActionListener((ActionListener) pc);
			pm.addObserver(pv);

			mm.setButton2();
			pm.playGame();
		} else if (e.getActionCommand().equals("Simulation")) {
			try {
				@SuppressWarnings("unchecked")
				Class<Player> player1 = (Class<Player>) Class.forName((String) mv.combo1.getSelectedItem());
				@SuppressWarnings("unchecked")
				Class<Player> player2 = (Class<Player>) Class.forName((String) mv.combo2.getSelectedItem());
				@SuppressWarnings("unchecked")
				Class<Player> player3 = (Class<Player>) Class.forName((String) mv.combo3.getSelectedItem());
				Player p1 = player1.newInstance();
				Player p2 = player2.newInstance();
				Player p3 = player3.newInstance();
				sm = new SimulationModel(p1, p2, p3);
			} catch (IllegalAccessException | ClassNotFoundException | InstantiationException event) {
				System.err.println("Nothing Class Files.");
				event.printStackTrace();

			}
			sv = new SimulationView();
			sc = new SimulationController(mm, sm);

			sv.addToButton1ActionListener((ActionListener) sc);
			sm.addObserver(sv);

			mm.setButton2();
			sm.simulation();

		} else if (e.getActionCommand().equals("Rule")) {
		}

	}
}
