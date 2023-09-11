package kr.co.sist.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

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
	
	//왜 있는지 몰라서 일단 주석
//	public StudentVO selectMyInfo(int stuNum) {
//		StudentVO sVO = null;
//		
//		
//		return sVO;
//	}
	
	public StudentVO selectMyProfile(int stuNum) throws SQLException {
		StudentVO sVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db  = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			String selectVO = "SELECT * FROM STUDENT WHERE STUNO=?";
			
			pstmt = con.prepareStatement(selectVO);
			pstmt.setInt(1, stuNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sVO = new StudentVO(
						rs.getInt("STUNO"),
						rs.getString("SNAME"),
						rs.getString("EMAIL"),
						rs.getString("DPTCODE"),
						rs.getString("MAJORCODE"),
						rs.getString("PHONE"),
						rs.getString("ADDR"),
						rs.getString("IMG")
				);
						
			}
			
			
		} finally {
			db.dbClose(rs, pstmt, con);
		}
		
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
