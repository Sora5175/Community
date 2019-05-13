package util;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import com.swetake.util.Qrcode;

public class QRCodeUtil {

    /**
     * 生成二维码(QRCode)图片的公共方法
     * 
     * @return BufferedImage
     */
    public static BufferedImage qRCodeCommon(String content, String imgType, int size) {
        BufferedImage bufImg = null;
        try {
            Qrcode qrcode = new Qrcode();
            // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
            qrcode.setQrcodeErrorCorrect('M');
            qrcode.setQrcodeEncodeMode('B');
            // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
            qrcode.setQrcodeVersion(size);
            // 获得内容的字节数组，设置编码格式
            byte[] contentBytes = content.getBytes("utf-8");
            // 图片尺寸
            int imgSize = 67 + 12 * (size - 1);
            // BufferedImage.TYPE_INT_RGB表示一个图像，该图像具有整数像素的 8 位 RGB 颜色
            bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);

            Graphics2D gs = bufImg.createGraphics();
            // 设置背景颜色
            gs.setBackground(Color.WHITE);
            // 画矩形
            gs.clearRect(0, 0, imgSize, imgSize);

            // 设定图像颜色 BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量，不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容> 二维码
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                // calQrcode()让字符串生成二维码。
                boolean[][] codeOut = qrcode.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
            }
            gs.dispose();
            bufImg.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImg;
    }
    //将二维码改为流形式输出
    public static InputStream changeImage(BufferedImage image) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", os);
			byte[] bs = os.toByteArray();
			InputStream ins = new ByteArrayInputStream(bs);
			return ins;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
