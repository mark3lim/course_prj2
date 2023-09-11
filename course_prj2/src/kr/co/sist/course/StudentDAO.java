package kr.co.sist.course;

public class StudentDAO {
	//돼라
	private static StudentDAO sDAO;
	
	private StudentDAO() {
	}
	
	public static StudentDAO getInstance() {
		if(sDAO == null) {
			sDAO = new StudentDAO();
		}
		
		return sDAO;
	}
	
	public StudentVO selectMyInfo(int stuNum) {
		StudentVO sVO = null;
		
		
		return sVO;
	}
	
	public StudentVO selectMyProfile(int stuNum) {
		StudentVO sVO = null;
		
		
		return sVO;
	}
	
	public int updateMyInfo(StudentVO sVO) {
		int result = 0;
		
		
		return result;
	}
	
	public int updatePw(StudentVO sVO) {
		int result = 0;
		
		
		return result;
	}
	
}
