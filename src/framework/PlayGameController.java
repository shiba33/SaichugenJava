package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * プレイゲームのControllerを表すクラスです。
 * @author 古田亮汰郎
 */
public class PlayGameController implements ActionListener {
	private MainModel mm;
	private PlayGameModel pm;

	public PlayGameController(PlayGameModel model) {
		this.pm = model;
	}

	public PlayGameController(MainModel model) {
		this.mm = model;
	}

	public PlayGameController(MainModel mm, PlayGameModel pm) {
		this.mm = mm;
		this.pm = pm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("GoBack")) {
			pm.clickedButton1();
			mm.setButton1();
		}
	}

}
