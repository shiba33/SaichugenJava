package framework;
/**
 * 文字関係のツールを格納するクラスです。
 * @author 鈴木大河
 *
 */
public class StringTools {
	/**
	 * 文字列を一定のバイト数にカットするメソッドです。
	 * @param s カット元の文字列
	 * @param n 指定バイト数
	 * @return カットされた文字列
	 */
	public static String cutString(String s,int n) {
		int b = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			String s1 = s.substring(i, i + 1);
			b += s1.getBytes().length;
			if (b > n) {
				break;
			}else sb.append(s1);
		}
		return sb.toString();
	}
}
