package framework;

import java.util.List;
import java.util.Observable;

import javax.swing.SwingWorker;

/**
 * ヘルプ紙芝居のModelクラスを表す。 
 * @author 鈴木大河
 */
public class HelpModel extends Observable {

	/**
	 * 現在表示している紙芝居のページを保持するフィールドです。
	 */
	private int helpStatus;
	/**
	 * 紙芝居の枚数を保持するフィールドです。
	 */
	final private int helpMaxPage = 3;
	/**
	 * 紙芝居の終了を管理するフィールドです。
	 */
	private boolean goBack = true;
	
	public HelpModel() {
		
	}

	/**
	 * ボタン1が押したイベントの処理を記したメソッドです。
	 */
	public void clickedButton1() {
		goBack = false;
		setChanged();
		notifyObservers("hide");
	}
	public void clickedButton2() {
		helpStatus--;
		if(helpStatus<0)helpStatus=helpMaxPage;
		setChanged();
	}
	public void clickedButton3() {
		helpStatus++;
		if(helpStatus>helpMaxPage)helpStatus=0;
		setChanged();
	}

	/**
	 * 紙芝居を動かすメソッドです。
	 */
	public void help() {

		SwingWorker<Object, Object[]> sw = new SwingWorker<Object, Object[]>() {
			@Override
			protected Object doInBackground() throws Exception {
				do{
					publish();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}while(goBack);
				return null;
			}

			@Override
			protected void process(List<Object[]> chunks) {
				setChanged();
				notifyObservers();
			}

			@Override
			protected void done() {
				setChanged();
				notifyObservers();
			}
		};
		sw.execute();

	}
	/**
	 * 紙芝居のページを指定するメソッドです
	 * @param set 設定するページ番号
	 */
	protected void setHelpStatus(int set) {
		helpStatus = set;
	}
	/**
	 * 紙芝居のページ番号を取得するメソッドです
	 * @return 現在表示しているページ番号
	 */
	protected int getHelpStatus() {
		return helpStatus;
	}
	/**
	 * 紙芝居の枚数を取得するメソッドです
	 * @return 枚数
	 */
	protected int getHelpMaxPage() {
		return helpMaxPage;
	}

}
