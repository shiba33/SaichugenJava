package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ヘルプのControllerを表すクラスです。
 * @author 鈴木大河
 */
public class HelpController implements ActionListener {
	private MainModel mm;
	private HelpModel hm;
	
	public HelpController(HelpModel model) {
		this.hm = model;
	}
	public HelpController(MainModel model) {
		this.mm = model;
	}
	public HelpController(MainModel mm, HelpModel hm) {
		this.mm = mm;
		this.hm = hm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("GoBack")) {
			hm.clickedButton1();
			mm.setButton3();
		}
		if(e.getActionCommand().equals("Back")) {
			hm.clickedButton2();
		}
		if(e.getActionCommand().equals("Next")) {
			hm.clickedButton3();
		}
	}

}
