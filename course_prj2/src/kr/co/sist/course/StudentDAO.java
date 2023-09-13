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
	
	public int updateMyInfo(StudentVO updateVO) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			StringBuilder updateProfile = new StringBuilder();
			updateProfile
			.append("	UPDATE STUDENT	")
			.append("	SET EMAIL=?, PHONE=?, ADDR=?, IMG=? 	")
			.append("	WHERE STUNO=?	");
			
			pstmt = con.prepareStatement(updateProfile.toString());
			pstmt.setString(1, updateVO.getEmail());
			pstmt.setString(2, updateVO.getPhone());
			pstmt.setString(3, updateVO.getAddr());
			pstmt.setString(4, updateVO.getImg());
			pstmt.setInt(5, StudentMainFrame.sVO.getId());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			db.dbClose(null, pstmt, con);
		}
		
		
		return result;
	}
	
	public int updatePw(int stuNum, String pw) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			String updatePw = "UPDATE STUDENT SET PASS=? WHERE STUNO=? ";
			
			pstmt = con.prepareStatement(updatePw);
			pstmt.setString(1, pw);
			pstmt.setInt(2, stuNum);
			
			result = pstmt.executeUpdate();
			
		} finally {
			db.dbClose(null, pstmt, con);
		}
		
		return result;
	}
	
}
