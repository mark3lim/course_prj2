package kr.co.sist.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class StudentScoreEvt extends WindowAdapter implements ActionListener {
	
	private StudentScoreDialog ssd;

	public StudentScoreEvt(StudentScoreDialog ssd) {
		this.ssd = ssd;
		setSearchBox();
		
		//테이블이 작동하는지 보기 위해서 만듬
		DefaultTableModel dtm = ssd.getDtmScore();
		String[] arr = {"컴퓨터공학", "컴퓨터의 이해", "3.0", "3.0", "전필"};
		dtm.addRow(arr);
	}
	
	public void setSearchBox() {
		//다오 연결해서 해당 학생이 들은 학기 가져오
		
		DefaultComboBoxModel<String> dcbm = ssd.getDcbmSemester();
		dcbm.addElement("학기 선택");
	}
	
//	public void initTable() {
//		DefaultTableModel dtm = ssd.getDtmScore();
//		dtm.addColumn("학과명");
//		dtm.addColumn("과목명");
//		dtm.addColumn("평점");
//		dtm.addColumn("성적");
//		dtm.addColumn("이수구분");
//		
//	}
	
	public void searchSemester() {
		System.out.println("학기 조회");
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
