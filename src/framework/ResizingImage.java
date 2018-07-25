package framework;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * 画像を指定したサイズに変換するクラスです。
 *
 * @author 古田亮汰郎
 *
 */
public class ResizingImage {
	public static ImageIcon resizeIcon(ImageIcon icon, int x, int y) {
		Image Gresize = icon.getImage();
		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(Gresize, 0, 0, x, y, null);
		g2.dispose();
		ImageIcon resized = new ImageIcon();
		resized.setImage(resizedImg);
		return resized;
	}
}
