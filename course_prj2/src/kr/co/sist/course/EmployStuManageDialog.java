package kr.co.sist.course;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
//돼라
@SuppressWarnings("serial")
public class EmployStuManageDialog extends JDialog {

	private Main main;

	public EmployStuManageDialog(Main main) {
		super(main, "관리자", true);
		this.main = main;
		Font font = new Font("Pretendard", Font.BOLD, 14);

		setLayout(null);

		// 타이틀
		JLabel jlblTitle = new JLabel("학생 관리");
		// 배경
		JLabel jlblback = new JLabel(
				new ImageIcon("C:/Users/user/git/group_prj/course_prj/src/kr/co/sist/course/images/backgr.png"));
		// 검색
		DefaultComboBoxModel<String> dcbmSearch = new DefaultComboBoxModel<String>();
		JComboBox<String> jcbSearch = new JComboBox<String>(dcbmSearch);
		dcbmSearch.addElement("이름");
		dcbmSearch.addElement("사번");
		// 검색창
		JTextField jtfSearch = new JTextField();
		// 등록 버튼
		JButton jbtnAdd = new JButton("등록");
		// 검색 조회 버튼
		JButton jbtnSearch = new JButton("조회");
		// 학부 학과 조회 버튼
		JButton jbtnDMSearch = new JButton("조회");
		// 테이블
		String[] columnNames = { "No", "학번", "이름", "학부", "학과", "학년", "전화번호", "이메일", "주소" };
		DefaultTableModel dtmStu = new DefaultTableModel(null, columnNames);
		JTable jtStu = new JTable(dtmStu);
		JScrollPane jspJtStu = new JScrollPane(jtStu);
		// 학부
		DefaultComboBoxModel<String> dcbmDept = new DefaultComboBoxModel<String>();
		JComboBox<String> jcbDept = new JComboBox<String>(dcbmDept);
		// 임시 값
		dcbmDept.addElement("컴퓨터공학부");
		dcbmDept.addElement("연극학부");
		// 학과
		DefaultComboBoxModel<String> dcbmMajor = new DefaultComboBoxModel<String>();
		JComboBox<String> jcbMajor = new JComboBox<String>(dcbmMajor);
		// 임시 값
		dcbmMajor.addElement("컴퓨터공학과");
		dcbmMajor.addElement("연극영화과");

		// 행크기 변경 - setRowHeight
		jtStu.setRowHeight(25);
		
		jtStu.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtStu.getColumnModel().getColumn(1).setPreferredWidth(60);
		jtStu.getColumnModel().getColumn(5).setPreferredWidth(30);

		// setFont
		jlblTitle.setFont(new Font("Pretendard", Font.BOLD, 20));
		jcbSearch.setFont(font);
		jcbDept.setFont(font);
		jcbMajor.setFont(font);
		jtfSearch.setFont(font);
		jbtnSearch.setFont(font);
		jbtnDMSearch.setFont(font);
		jbtnAdd.setFont(font);
		jtStu.setFont(font);

		// setBounds
		jlblback.setBounds(0, 0, 1000, 700);
		jlblTitle.setBounds(115, 65, 210, 50);
		jcbSearch.setBounds(555, 80, 100, 30);
		jtfSearch.setBounds(665, 80, 140, 30);
		jbtnSearch.setBounds(815, 80, 60, 30);
		jbtnAdd.setBounds(795, 540, 80, 30);
		jspJtStu.setBounds(110, 170, 770, 355);
		jcbDept.setBounds(113, 118, 120, 30);
		jcbMajor.setBounds(243, 118, 120, 30);
		jbtnDMSearch.setBounds(373, 118, 60, 30);

		// setBackground
		Color color = new Color(0xE0E0E0);
		jcbSearch.setBackground(Color.white);
		jcbDept.setBackground(Color.white);
		jcbMajor.setBackground(Color.white);
		jbtnSearch.setBackground(color);
		jbtnDMSearch.setBackground(color);
		jbtnAdd.setBackground(color);
		jtfSearch.setBorder(new LineBorder(new Color(0xCFCFCF)));
		jcbDept.setBorder(null);
		jbtnSearch.setBorder(null);
		jbtnDMSearch.setBorder(null);
		jbtnAdd.setBorder(null);

		// add
		add(jcbSearch);
		add(jtfSearch);
		add(jbtnSearch);
		add(jlblTitle);
		add(jbtnAdd);
		add(jspJtStu);
		add(jcbDept);
		add(jcbMajor);
		add(jbtnDMSearch);

		// 배경
		add(jlblback);
		
		setResizable(false);

		setBounds(main.getX() + 100, main.getY() + 50, 1000, 700);
		setVisible(true);
	}

}
