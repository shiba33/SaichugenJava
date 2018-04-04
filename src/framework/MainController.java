package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

/**
 * メニューのControllerに関わるクラスです。
 * @author 柴田航平 
 * @see ActionListener
 */
public class MainController implements ActionListener {
	private MainModel mm;
	private SimulationModel sm;

	public MainController(MainModel model) {
		mm = model;
	}
	

	public MainController(SimulationModel model) {
		sm = model;
	}
	
	public MainController(MainModel mm, SimulationModel sm) {
		this.mm = mm;
		this.sm = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("GameStart")) {

		} else if (e.getActionCommand().equals("Simulation")) {
			mm.setButton2();
			sm.simulation();
		} else if (e.getActionCommand().equals("Rule")) {

		}
	}
}
