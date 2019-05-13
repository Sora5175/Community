package action.wxlostfoundAction;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import dao.NoticeLostDAO;
import entity.NoticeLost;
import factory.DAOFactory;
import util.BeanUtil;

public class ReturnUploadAction {
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	private String errormsg="";
	private Boolean pass = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		destPath=req.getServletContext().getRealPath("/returnimgupload");
		String uid=req.getParameter("uid");
		String returnloc=req.getParameter("returnlocid");
		String lno=req.getParameter("lno");
		String type=myFileContentType.substring(myFileContentType.indexOf("/")+1, myFileContentType.length());
    	myFileFileName=UUID.randomUUID().toString()+"."+type;
    	NoticeLostDAO dao=(NoticeLostDAO) DAOFactory.getInstance("NoticeLostDAO");
    	NoticeLost obj=new NoticeLost();
    	obj.setId(UUID.randomUUID().toString());
    	obj.setlNo(lno);
    	obj.setPic(myFileFileName);
    	obj.setReturnLoc(returnloc);
    	obj.setTime(BeanUtil.getNow());
    	obj.setPublisherId(uid);
    	File destFile  = new File(destPath, myFileFileName);
   	    try {
			FileUtils.copyFile(myFile, destFile);
			dao.add(obj);
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
