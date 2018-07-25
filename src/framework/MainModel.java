package framework;

import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.SwingUtilities;

/**
 * メニューのModelを表すクラスです。
 * @author 柴田航平 
 * @see Observable
 */
public class MainModel extends Observable{
	/**
	 * ボタン1が押さかを保持するフィールです。
	 * 0は押されていない、1は押されている 
	 */
	private int button1;
	/**
	 * ボタン2が押さかを保持するフィールです。
	 * 0は押されていない、1は押されている 
	 */
	private int button2;
	/**
	 * ボタン3が押さかを保持するフィールです。
	 * 0は押されていない、1は押されている 
	 */
	private int button3;
	
	/**
	 * コンストラクタです。
	 */
	public MainModel() {
		button1 = 0;
		button2 = 0;
		button3 = 0;
	}
	/**
	 * ボタン1の状態を変化させるメソッドです。
	 */
	public void setButton1() {
		button1 = (button1 + 1) % 2;
	}
	
	/**
	 * ボタン2の状態を変化させるメソッドです。
	 */
	public void setButton2() {
		button2 = (button2 + 1) % 2;
		setChanged();
		notifyObservers();
	}
	/**
	 * ボタン3の状態を変化させるメソッドです。
	 */
	public void setButton3() {
		button3 = (button3 + 1) % 2;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * ボタン1へイベントが発生したかを表すメソッドです。
	 * @return イベント発生時1,それ以外は0
	 */
	public boolean isButton1() {
		return (button1 == 1) ? true : false;
	}
	/**
	 * ボタン2へイベントが発生したかを表すメソッドです。
	 * @return イベント発生時1,それ以外は0
	 */
	public boolean isButton2() {
		return (button2 == 1) ? true : false;
	}
	/**
	 * ボタン2へイベントが発生したかを表すメソッドです。
	 * @return イベント発生時1,それ以外は0
	 */
	public boolean isButton3() {
		return (button3 == 1) ? true : false;
	}
	
	/**
	 * ボタン1の値を取得するメソッドです。
	 * @return button1の値
	 */
	public int getButton1() {
		return button1;
	}
	/**
	 * ボタン2の値を取得するメソッドです。
	 * @return button2の値
	 */
	public int getButton2() {
		return button2;
	}
	/**
	 * ボタン3の値を取得するメソッドです。
	 * @return button2の値
	 */
	public int getButton3() {
		return button3;
	}
}
