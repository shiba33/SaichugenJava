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
	private int helpMaxPage = 3;
	
	public HelpModel() {
		
	}

	/**
	 * ボタン1が押したイベントの処理を記したメソッドです。
	 */
	public void clickedButton1() {
		setChanged();
		notifyObservers("hide");
	}

	/**
	 * 紙芝居を動かすメソッドです。
	 */
	public void help() {

		SwingWorker<Object, Object[]> sw = new SwingWorker<Object, Object[]>() {
			@Override
			protected Object doInBackground() throws Exception {
				for(int i = 0;i<helpMaxPage;i++) {
					setHelpStatus(i);
					publish();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {

					}
				}
				setHelpStatus(helpMaxPage);
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
	 * 紙芝居の最大枚数を指定するメソッドです
	 * @param set 設定する最大ページ数
	 */
	protected void setHelpMaxPage(int set) {
		helpMaxPage = set;
	}
	/**
	 * 紙芝居の合計枚数を取得するメソッドです
	 * @return 合計枚数
	 */
	protected int getHelpMaxPage() {
		return helpMaxPage;
	}

}
