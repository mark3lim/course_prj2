package kr.co.sist.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kr.co.sist.dao.DbConn;

public class StudentScoreDAO {
	
	private static StudentScoreDAO ssDAO;
	
	private StudentScoreDAO() {
	}
	
	public static StudentScoreDAO getInstance() {
		if(ssDAO == null) {
			ssDAO = new StudentScoreDAO();
		}
		
		return ssDAO;
	}
	
	public List<String> selectSemester(int stuno) throws SQLException {
		Set<String> set = new HashSet<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			String query = "SELECT SLEVEL, SEMESTER FROM COURSE WHERE STUNO=?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stuno);
			
			rs = pstmt.executeQuery();
			
			StringBuilder sb = null;
			while (rs.next()) {
				sb = new StringBuilder();
				sb.append(rs.getString("SLEVEL")).append("학년 - ")
				.append(rs.getString("SEMESTER")).append("학기");
				
				set.add(sb.toString());
			}
			
		} finally {
			db.dbClose(rs, pstmt, con);
		}
		
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		return list;
	}
	
	public List<StudentScoreVO> selectScore(String gradeYear) {
		List<StudentScoreVO> list = null;
		
		
		return list;
	}

}
