package entity;

public class Course {
	long courseId;
	String uId;
	String name;
	String endTime;
	String isExist;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCourseId() {
		return courseId;
	}

	
	public Course(long courseId, String uId, String name, String endTime, String isExist) {
		super();
		this.courseId = courseId;
		this.uId = uId;
		this.name = name;
		this.endTime = endTime;
		this.isExist = isExist;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getIsExist() {
		return isExist;
	}

	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}

	
}
