package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class CodeUtil {
	//获取正确验证码和验证码图片的Map集
	public static Map<String, BufferedImage> getImage(){
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random rd = new Random();
		g.setColor(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
		g.fillRect(0, 0, 80, 30);
		for(int i=0;i<5;i++) {
			g.setColor(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
			g.drawLine(rd.nextInt(80), rd.nextInt(30), rd.nextInt(80), rd.nextInt(30));
		}
		g.setFont(new Font("����", Font.BOLD, 20));
		g.setColor(Color.BLACK);
		String ConnectCode = getCode(4);
		g.drawString(ConnectCode, 5, 25);
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(ConnectCode,image);
		return map;
	}
	//将BufferedImage转换成InputStream
	public static InputStream changeImage(BufferedImage image) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpeg", os);
			byte[] bs = os.toByteArray();
			InputStream ins = new ByteArrayInputStream(bs);
			return ins;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	//返回一个长度为length的验证码
	public static String getCode(int length) {
		String getCode = "";
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random rd = new Random();
		for(int i=0;i<length;i++) {
			int index = rd.nextInt(str.length());
			char ch = str.charAt(index);
			getCode += ch;
		}
		return getCode;
	}
}
