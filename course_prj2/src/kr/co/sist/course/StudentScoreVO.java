package kr.co.sist.course;

public class StudentScoreVO {
	
	private String majorName;
	private String LectureName;
	private int credit;
	private String grade;
	private String subType;
	
	public StudentScoreVO() {
	}
	
	public StudentScoreVO(String majorName, String lectureName, int credit, String grade, String subType) {
		super();
		this.majorName = majorName;
		LectureName = lectureName;
		this.credit = credit;
		this.grade = grade;
		this.subType = subType;
	}
	
	@Override
	public String toString() {
		return "StudentScoreVO [majorName=" + majorName + ", LectureName=" + LectureName + ", credit=" + credit
				+ ", grade=" + grade + ", subType=" + subType + "]";
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getLectureName() {
		return LectureName;
	}

	public void setLectureName(String lectureName) {
		LectureName = lectureName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}
	
}
