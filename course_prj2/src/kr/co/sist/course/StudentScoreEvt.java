package kr.co.sist.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentScoreEvt extends WindowAdapter implements ActionListener {
	
	private StudentScoreDialog ssd;

	public StudentScoreEvt(StudentScoreDialog ssd) {
		this.ssd = ssd;
		setSearchBox(StudentMainFrame.sVO.getId());
	}
	
	public void setSearchBox(int stuNum) {
		//다오 연결해서 해당 학생이 들은 학기 가져오
		
		DefaultComboBoxModel<String> dcbm = ssd.getDcbmSemester();
		try {
			List<String> list = StudentScoreDAO.getInstance().selectSemester(stuNum);
			
			dcbm.addElement("학기 선택");
			for(int i = 0; i < list.size(); i++) {
				dcbm.addElement(list.get(i));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void searchSemester() {
		String temp = (String)(ssd.getJcbSemester().getSelectedItem());
		int sLevel = Character.getNumericValue(temp.charAt(0));
		int semester = Character.getNumericValue(temp.charAt(6));
		
		try {
			List<StudentScoreVO> list = StudentScoreDAO.getInstance().selectScore(sLevel, semester);
			
			if(list == null) {
				JOptionPane.showMessageDialog(ssd, "성적 조회 불가\n학과에 문의해주세요.");
				return;
			}
			
			DefaultTableModel dtm = ssd.getDtmScore();
			String[] arr = new String[5];
			
			for(StudentScoreVO ssVO : list) {
				arr[0] = ssVO.getMajorName();
				arr[1] = ssVO.getLectureName();
				arr[2] = String.valueOf(ssVO.getCredit());
				arr[3] = ssVO.getGrade();
				arr[4] = ssVO.getSubType();
				
				dtm.addRow(arr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		searchSemester();
	}

	@Override
	public void windowClosing(WindowEvent we) {
		ssd.dispose();
	}

}
