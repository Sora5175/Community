package action.wxlostfoundAction;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import dao.NoticeFoundDAO;
import entity.NoticeFound;
import factory.DAOFactory;
import util.BeanUtil;

public class getLostUploadAction {
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	private String errormsg="";
	private Boolean pass = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		destPath=req.getServletContext().getRealPath("/getlostimgupload");
		String lostloc=req.getParameter("lostloc");
		String lostname=req.getParameter("lostname");
		String color=req.getParameter("color");
		String losttype=req.getParameter("type");
		String publisherno=req.getParameter("uid");
		String fno=req.getParameter("fno");
		String losttime=req.getParameter("time");
		NoticeFoundDAO dao=(NoticeFoundDAO) DAOFactory.getInstance("NoticeFoundDAO");
		NoticeFound nf=new NoticeFound();
		String type=myFileContentType.substring(myFileContentType.indexOf("/")+1, myFileContentType.length());
    	myFileFileName=UUID.randomUUID().toString()+"."+type;
    	nf.setPic(myFileFileName);
    	nf.setLostName(lostname);
    	nf.setColor(color);
    	nf.setType(losttype);
		nf.setfNo(fno);
		nf.setId(UUID.randomUUID().toString());
		nf.setLostLoc(lostloc);
		nf.setLostTime(losttime);
		nf.setPublisherId(publisherno);
		nf.setTime(BeanUtil.getNow());
		File destFile  = new File(destPath, myFileFileName);
		try {
			FileUtils.copyFile(myFile, destFile);
			dao.add(nf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pass=false;
			errormsg="图片上传失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pass=false;
			errormsg="服务器发生错误，请稍后再试";
		}
		return "success";
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public Boolean getPass() {
		return pass;
	}
	public void setPass(Boolean pass) {
		this.pass = pass;
	}
	
}
