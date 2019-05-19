package entity;

public class CourseUser {
	long courseId;
	String uId;
	int absenceNum;
	int attendanceNum;
	String endTime;
	String isExist;
	
	public CourseUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseUser(long courseId, String uId, int absenceNum, int attendanceNum, String endTime, String isExist) {
		super();
		this.courseId = courseId;
		this.uId = uId;
		this.absenceNum = absenceNum;
		this.attendanceNum = attendanceNum;
		this.endTime = endTime;
		this.isExist = isExist;
	}

	public long getCourseId() {
		return courseId;
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

	public int getAbsenceNum() {
		return absenceNum;
	}

	public void setAbsenceNum(int absenceNum) {
		this.absenceNum = absenceNum;
	}

	public int getAttendanceNum() {
		return attendanceNum;
	}

	public void setAttendanceNum(int attendanceNum) {
		this.attendanceNum = attendanceNum;
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
