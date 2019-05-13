package action.wxlostfoundAction;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import dao.FoundDAO;
import entity.Found;
import factory.DAOFactory;
import util.BeanUtil;

public class FoundUploadAction {
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	private String errormsg="";
	private Boolean pass = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		destPath=req.getServletContext().getRealPath("/foundimgupload");
		String foundname=req.getParameter("foundname");
		String foundlocation=req.getParameter("foundlocid");
		String returnlocation=req.getParameter("returnlocid");
		String founddescribe=req.getParameter("founddescribe");
		String publisherno=req.getParameter("uid");
		String foundtype=req.getParameter("type");
    	String type=myFileContentType.substring(myFileContentType.indexOf("/")+1, myFileContentType.length());
    	myFileFileName=UUID.randomUUID().toString()+"."+type;
    	FoundDAO founddao=(FoundDAO) DAOFactory.getInstance("FoundDAO");
    	Found f=new Found();
    	String time=BeanUtil.getNow(),fno=UUID.randomUUID().toString();
    	f.setDescribe(founddescribe);
    	f.setfName(foundname);
    	f.setfNo(fno);
    	f.setFoundLocation(foundlocation);
    	f.setReturnLocation(returnlocation);
    	f.setPublisherNo(publisherno);
    	f.setPublisherTime(time);
    	f.setPhoto("foundimgupload/"+myFileFileName);
    	f.setType(foundtype);
    	
    	File destFile  = new File(destPath, myFileFileName);
    	try {
    		FileUtils.copyFile(myFile, destFile);
			founddao.foundAdd(f);
		} catch (IOException e) {
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
