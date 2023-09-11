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
	
}
