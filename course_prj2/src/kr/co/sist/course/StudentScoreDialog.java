package kr.co.sist.course;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class StudentScoreDialog extends JDialog {
	
	private StudentMainFrame smf;
	private JTable jtScore;
	private DefaultTableModel dtmScore;
	private JButton jbtnSearch;
	private JComboBox<String> jcbSemester;
	private DefaultComboBoxModel<String> dcbmSemester;
	
	public StudentScoreDialog(/*StudentMainFrame smf*/) {
		this.smf = smf;
		super.setModal(false);
		super.setTitle("성적 조회");
		
		//배경화면 설정 라벨
		JLabel bgLabel = new JLabel(new ImageIcon("/Users/marklim/Documents/ForCoding/workplace/course_prj/src/kr/co/sist/course/images/backgr.png"));
		bgLabel.setBounds(0, 0, 1000, 700);
		
		//타이틀 설정
		JLabel jlTitle = new JLabel("성적조회");
		jlTitle.setBounds(145, 100, 70, 30);
		
		//콤보박스 설정
		dcbmSemester = new DefaultComboBoxModel<String>();
		jcbSemester = new JComboBox<String>(dcbmSemester);
		jcbSemester.setBounds(jlTitle.getX()-3, jlTitle.getY()+40, 150, 30);
		
		//성적 테이블 설정
		String[] header = {"학과명", "과목명", "평점", "성적", "이수구분"};
		dtmScore = new DefaultTableModel(header, 0);
		jtScore = new JTable();
		jtScore.setModel(dtmScore);
		jtScore.setBounds(jcbSemester.getX(), jcbSemester.getY()+40, 705, 385);
		
		jtScore.getTableHeader().setReorderingAllowed(false);
		JScrollPane jsp = new JScrollPane(jtScore);
		
		//검색 버튼 설정
		jbtnSearch = new JButton("조회");
		jbtnSearch.setBounds(jcbSemester.getX()+150, jcbSemester.getY(), 80, 30);
		
		//임시용 테두리 설정
		//정확한 위치와 크기를 알아보기 위해서 설정
		//디자인이 끝나면 삭제할 예정
		jlTitle.setBorder(new LineBorder(Color.red));
		jtScore.setBorder(new LineBorder(Color.red));
		jsp.setBorder(new LineBorder(Color.red));
		
		//이벤트 연결
		StudentScoreEvt sse = new StudentScoreEvt(this);
		jbtnSearch.addActionListener(sse);
		addWindowListener(sse);
		
		setLayout(null);
		
		bgLabel.add(jlTitle);
		bgLabel.add(jcbSemester);
		bgLabel.add(jtScore);
		bgLabel.add(jbtnSearch);
		
		add(bgLabel);
		
		setBounds(150, 200, 1000, 700);
		setVisible(true);
	}

	public StudentMainFrame getSmf() {
		return smf;
	}

	public JTable getJtScore() {
		return jtScore;
	}

	public DefaultTableModel getDtmScore() {
		return dtmScore;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}

	public JComboBox<String> getJcbSemester() {
		return jcbSemester;
	}

	public DefaultComboBoxModel<String> getDcbmSemester() {
		return dcbmSemester;
	}
	
	public static void main(String[] args) {
		new StudentScoreDialog();
	}

}
