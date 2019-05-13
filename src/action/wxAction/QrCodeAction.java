package action.wxAction;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import util.QRCodeUtil;

public class QrCodeAction {
	String uId;
	String planId;
	String signInTime;
	InputStream ins;
	/*获取图片以及验证码
	 * 将图片修改成输入流返回给ins
	 */
	public String execute() {
		String url = "http://localhost:8080/Community/wx-user/sign.action?"+"uId="+uId+"&planId="+planId+"&signInTime="+signInTime;
		BufferedImage image = QRCodeUtil.qRCodeCommon(url, "png", 7);
		ins = QRCodeUtil.changeImage(image);
		return "success";
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getSignInTime() {
		return signInTime;
	}
	public void setSignInTime(String signInTime) {
		this.signInTime = signInTime;
	}
	public InputStream getIns() {
		return ins;
	}
	public void setIns(InputStream ins) {
		this.ins = ins;
	}
}
