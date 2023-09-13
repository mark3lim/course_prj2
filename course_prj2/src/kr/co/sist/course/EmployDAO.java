package kr.co.sist.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class EmployDAO {
	
	private static EmployDAO eDAO;
	
	private EmployDAO() {
	}

	public static EmployDAO getInstance() {
		if(eDAO == null) {
			eDAO = new EmployDAO();
		}
		
		return eDAO;
	}
	
	public EmployVO selectEmp(String empno) throws SQLException {
		EmployVO eVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			
			StringBuilder query = new StringBuilder();
			query
			.append("")
			.append("")
			.append("")
			.append("");
			
			pstmt = con.prepareStatement(query.toString());
			
			rs = pstmt.executeQuery();
			
		} finally {
			db.dbClose(rs, pstmt, con);
		}
		
		return eVO;
	}
	
	public int updateProfile(EmployVO updateVO) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			StringBuilder updateProfile = new StringBuilder();
			//교수 UI로 만듬
			updateProfile
			.append("	UPDATE EMP	")
			.append("	SET ENAME=?, EMAIL=?, PHONE=?, IMG=? 	")
			.append("	WHERE EMPNO=?	");
			
			pstmt = con.prepareStatement(updateProfile.toString());
			pstmt.setString(1, updateVO.getName());
			pstmt.setString(2, updateVO.getEmail());
			pstmt.setString(3, updateVO.getPhone());
			pstmt.setString(3, updateVO.getImage());
			pstmt.setInt(5, StudentMainFrame.sVO.getId());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			db.dbClose(null, pstmt, con);
		}
		
		
		return result;
	}
	
	public int updatePw(String empno, String pw) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			String updatePw = "UPDATE EMP SET PASS=? WHERE EMPNO=? ";
			
			pstmt = con.prepareStatement(updatePw);
			pstmt.setString(1, pw);
			pstmt.setString(2, empno);
			
			result = pstmt.executeUpdate();
			
			
			
		} finally {
			db.dbClose(null, pstmt, con);
		}
		
		return result;
	}
	
}
