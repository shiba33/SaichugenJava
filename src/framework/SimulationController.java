package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * シュミュレーションのControllerを表すクラスです。
 * @author 柴田航平
 */
public class SimulationController implements ActionListener {
	private MainModel mm;
	private SimulationModel sm;
	
	public SimulationController(SimulationModel model) {
		this.sm = model;
	}
	public SimulationController(MainModel model) {
		this.mm = model;
	}
	public SimulationController(MainModel mm, SimulationModel sm) {
		this.mm = mm;
		this.sm = sm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("GoBack")) {
			sm.clickedButton1();
			mm.setButton2();
		}
	}

}
