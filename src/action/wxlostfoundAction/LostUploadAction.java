package action.wxlostfoundAction;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import dao.FoundDAO;
import dao.LostDAO;
import dao.NoticeLostDAO;
import entity.Found;
import entity.Lost;
import entity.NoticeLost;
import factory.DAOFactory;
import util.BeanUtil;


public class LostUploadAction{
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	private String errormsg="";
	private Boolean pass = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		destPath=req.getServletContext().getRealPath("/lostimgupload");
		String lostname=req.getParameter("lostname");
		String lostlocation=req.getParameter("lostlocid");
		String describe=req.getParameter("describe");
		String publisherno=req.getParameter("uid");
		String losttype=req.getParameter("type");
		String lostdate=req.getParameter("time");
		String time=BeanUtil.getNow(),lno=UUID.randomUUID().toString();
		
		LostDAO lostdao=(LostDAO) DAOFactory.getInstance("LostDAO");
		Lost lost=new Lost();
		lost.setDescribe(describe);
    	lost.setlName(lostname);
    	lost.setlNo(lno);
    	lost.setLostLocation(lostlocation);
    	lost.setPublisherNo(publisherno);
    	lost.setPublisherTime(time);
    	lost.setType(losttype);
    	lost.setLostTime(lostdate);
		
    	String type=myFileContentType.substring(myFileContentType.indexOf("/")+1, myFileContentType.length());
    	myFileFileName=UUID.randomUUID().toString()+"."+type;
    	lost.setPhoto(myFileFileName);
    	
    	FoundDAO founddao=(FoundDAO) DAOFactory.getInstance("FoundDAO");
    	NoticeLostDAO noticelostdao=(NoticeLostDAO) DAOFactory.getInstance("NoticeLostDAO");
    	List<Found> randomlist=null;
    	NoticeLost obj=null;
    	Found f=null;
    	File destFile  = new File(destPath, myFileFileName);
   	    try {
			FileUtils.copyFile(myFile, destFile);
			lostdao.lostAdd(lost);
			randomlist=founddao.randomReturn(lostlocation, lostdate, losttype, 3);
			for(int i=0;i<randomlist.size();i++) {
				f=randomlist.get(i);
				obj=new NoticeLost();
				obj.setId(UUID.randomUUID().toString());
				obj.setIsExist("1");
				obj.setlNo(lno);
				obj.setPic(f.getPhoto());
				obj.setPublisherId(f.getPublisherNo());
				obj.setReturnLoc(f.getReturnLocation());
				obj.setTime(f.getPublisherTime());
				noticelostdao.add(obj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pass=false;
			errormsg="图片上传失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pass=false;
			errormsg="服务器发生错误,请稍后再试";
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
