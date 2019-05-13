package entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	String userId;
	String name;
	String departmentId;
	String classId;
	String tel;
	String email;
	float deposite;
	String isExist;
	String isStu;
	String schoolId;
	String registerTime;
	String sex;
	String gradeId;
	public UserInfo(String userId, String name, String departmentId, String classId, String tel, String email,
			float deposite, String isExist, String isStu, String registerTime, String schoolId,String sex,String gradeId) {
		super();
		this.userId = userId;
		this.name = name;
		this.departmentId = departmentId;
		this.classId = classId;
		this.tel = tel;
		this.email = email;
		this.deposite = deposite;
		this.isExist = isExist;
		this.isStu = isStu;
		this.registerTime=registerTime;
		this.schoolId=schoolId;
		this.sex=sex;
		this.gradeId=gradeId;
	}
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getDeposite() {
		return deposite;
	}
	public void setDeposite(float deposite) {
		this.deposite = deposite;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public String getIsStu() {
		return isStu;
	}
	public void setIsStu(String isStu) {
		this.isStu = isStu;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	
}
