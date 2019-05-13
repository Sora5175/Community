package action.userAction;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import action.BaseAction;
import util.CodeUtil;

public class CodeAction extends BaseAction{
	InputStream ins;
	/*获取图片以及验证码
	 * 将图片修改成输入流返回给ins
	 */
	public String execute() {
		Map<String, BufferedImage> map = CodeUtil.getImage();
		String key = map.keySet().iterator().next();
		session.put("ConnectCode", key);
		BufferedImage image = map.get(key);
		ins = CodeUtil.changeImage(image);
		return "success";
	}
	public InputStream getIns() {
		return ins;
	}
	public void setIns(InputStream ins) {
		this.ins = ins;
	}
}
