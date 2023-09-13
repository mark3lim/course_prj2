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
	
	public List<StudentScoreVO> selectScore(int sLevel, int semester) throws SQLException {
		List<StudentScoreVO> list = new ArrayList<StudentScoreVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("192.168.10.142", "applepie", "mincho");
			StringBuilder selectQuery = new StringBuilder();
			selectQuery
			.append("	SELECT M.MAJORNAME,S.SUBNAME, S.CREDIT,G.GRADE,S.SUBTYPE					")
			.append("	FROM TGRADE G, SUBJECT S, MAJOR M											")
			.append("	WHERE G.STUNO=? AND G.SLEVEL=? AND G.SEMESTER=? AND							")
			.append("	G.SUBCODE=S.SUBCODE AND S.MAJORCODE=M.MAJORCODE								");
			
			pstmt = con.prepareStatement(selectQuery.toString());
			pstmt.setInt(1, StudentMainFrame.sVO.getId());
			pstmt.setInt(2, sLevel);
			pstmt.setInt(3, semester);
			
			rs = pstmt.executeQuery();
			
			StudentScoreVO ssVO = null;
			while (rs.next()) {
				ssVO = new StudentScoreVO(
					rs.getString("MAJORNAME"),
					rs.getString("SUBNAME"),
					rs.getInt("CREDIT"),
					rs.getString("GRADE"),
					rs.getString("SUBTYPE")
				);
				
				list.add(ssVO);
			}
			
		} finally {
			db.dbClose(rs, pstmt, con);
		}
		
		return list;
	}

}
