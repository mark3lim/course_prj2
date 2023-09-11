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
	
	public int updateProfile(EmployVO eVO) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
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
			
			StringBuilder query = new StringBuilder();
			query
			.append("")
			.append("")
			.append("")
			.append("");
			
			pstmt = con.prepareStatement(query.toString());
			
		} finally {
			db.dbClose(null, pstmt, con);
		}
		
		return result;
	}
	
}
