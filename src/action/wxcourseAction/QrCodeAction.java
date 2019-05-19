package action.wxcourseAction;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import dao.CourseDAO;
import factory.DAOFactory;
import util.QRCodeUtil;

public class QrCodeAction {
	String courseId;
	InputStream ins;
	/*获取图片以及验证码
	 * 将图片修改成输入流返回给ins
	 */
	public String execute() {
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		String endTime;
		try {
			endTime = cd.find(courseId).getEndTime();
			String url = "http://localhost:8080/Community/wx-course/sign.action?"+
					"courseId="+courseId+"&endTime="+endTime;
			BufferedImage image = QRCodeUtil.qRCodeCommon(url, "png", 7);
			ins = QRCodeUtil.changeImage(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public InputStream getIns() {
		return ins;
	}
	public void setIns(InputStream ins) {
		this.ins = ins;
	}
}

