package kr.co.sist.course;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LecturePlanDialog extends JDialog {
	

	
	private JButton jbtnApply;
	private StudentMainFrame smf;
	private JTextField jtSubName;
	private JTextField jtSubGoal;
	private JTextArea jtaSubInfo;
	private StudentSubjectDialog ssDL;
	private MySubjectDialog msD;
	private LecturePlanEvt le;
	private Font font;
	public LecturePlanDialog(StudentSubjectDialog ssDL) {


		this();
		this.ssDL=ssDL;
		 jbtnApply = new JButton("신청");
			
			jbtnApply.setFont(font);
			jbtnApply.setBounds(310, 450, 80, 30);
				add(jbtnApply);
				jbtnApply.addActionListener(le);
		
	}
	
	
	public LecturePlanDialog (MySubjectDialog msd) {
		this();
		this.msD=msd;
	}
	
	public LecturePlanDialog() {
		 font = new Font("Pretendard", Font.BOLD, 14);
			setLayout(null);
			// 타이틀
			JLabel jlblTitle = new JLabel("강의계획서");
			// 배경
			// JLabel jlblback = new JLabel(
			// new
			// ImageIcon("C:/Users/user/git/group_prj/course_prj/src/kr/co/sist/course/images/backgr.png"));
			
			
			
			//버튼
			 
			// 라벨
			JLabel jlblSubName = new JLabel("과목명");
			JLabel jlblSubGoal = new JLabel("학습목표");
			JLabel jlblSubInfo = new JLabel("강의내용");
			// 내용창
			 jtSubName = new JTextField();
			 jtSubGoal = new JTextField();
			 jtSubName.setEditable(false);
			 jtSubGoal.setEditable(false);
			// 강의내용창
			 jtaSubInfo = new JTextArea();
			 jtaSubInfo.setEditable(false);
			 jtaSubInfo.setLineWrap(true);
			JScrollPane jspjtSubInfo = new JScrollPane(jtaSubInfo);
			
			// set font
			jlblTitle.setFont(new Font("Pretendard", Font.BOLD, 20));
			jlblSubName.setFont(new Font("Pretendard", Font.BOLD, 17));
			jlblSubGoal.setFont(new Font("Pretendard", Font.BOLD, 17));
			jlblSubInfo.setFont(new Font("Pretendard", Font.BOLD, 17));
			
			jtSubName.setFont(new Font("Pretendard", Font.BOLD, 17));
			jtSubGoal.setFont(new Font("Pretendard", Font.BOLD, 17));
			jtaSubInfo.setFont(new Font("Pretendard", Font.BOLD, 17));
//			jbtnApply.setFont(font);
//			jbtnApply.setVisible(false); 버튼 안 보이게 만들기.
			
			
	//	if (flag) {
	
				 le = new LecturePlanEvt(this);
				
				
			
			
//			jtSubName.setText(lpVO.getSubName());
//			jtSubGoal.setText(lpVO.getSubGoal());
//			jtaSubInfo.setText(lpVO.getSubInfo());
			
			//배경색설정
			Color backgroundColor = Color.decode("#D0E0EF");
			Container contentPane = getContentPane();
			contentPane.setBackground(backgroundColor);
			
			//bounds
//			jbtnApply.setBounds(310, 450, 80, 30);
			jlblTitle.setBounds(25, 10, 210, 50);
			jlblSubName.setBounds(50, 85, 100, 30);
			jlblSubGoal.setBounds(50, 135, 100, 30);
			jtSubName.setBounds(120, 85, 510, 30);
			jtSubGoal.setBounds(120, 138, 510, 30);
			jspjtSubInfo.setBounds(50, 220, 580, 210);
			jlblSubInfo.setBounds(50, 180, 100, 30);
			// jlblSubGoal
		

			//add
//			add(jbtnApply);
			add(jlblTitle);
			add(jlblSubName);
			add(jlblSubGoal);
			add(jtSubName);
			add(jtSubGoal);
			add(jspjtSubInfo);
			add(jlblSubInfo);
			setResizable(false);
			setBounds(140, 70, 700, 540);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
//	
//	public LecturePlanDialog(MySubjectDialog msd) {
//	
//		
//
//		 font = new Font("Pretendard", Font.BOLD, 14);
//		setLayout(null);
//		// 타이틀
//		JLabel jlblTitle = new JLabel("강의계획서");
//		// 배경
//		// JLabel jlblback = new JLabel(
//		// new
//		// ImageIcon("C:/Users/user/git/group_prj/course_prj/src/kr/co/sist/course/images/backgr.png"));
//		
//		
//		
//		//버튼
//		 
//		// 라벨
//		JLabel jlblSubName = new JLabel("과목명");
//		JLabel jlblSubGoal = new JLabel("학습목표");
//		JLabel jlblSubInfo = new JLabel("강의내용");
//		// 내용창
//		 jtSubName = new JTextField();
//		 jtSubGoal = new JTextField();
//		 jtSubName.setEditable(false);
//		 jtSubGoal.setEditable(false);
//		// 강의내용창
//		 jtaSubInfo = new JTextArea();
//		 jtaSubInfo.setEditable(false);
//		 jtaSubInfo.setLineWrap(true);
//		JScrollPane jspjtSubInfo = new JScrollPane(jtaSubInfo);
//		
//		// set font
//		jlblTitle.setFont(new Font("Pretendard", Font.BOLD, 20));
//		jlblSubName.setFont(new Font("Pretendard", Font.BOLD, 17));
//		jlblSubGoal.setFont(new Font("Pretendard", Font.BOLD, 17));
//		jlblSubInfo.setFont(new Font("Pretendard", Font.BOLD, 17));
//		
//		jtSubName.setFont(new Font("Pretendard", Font.BOLD, 17));
//		jtSubGoal.setFont(new Font("Pretendard", Font.BOLD, 17));
//		jtaSubInfo.setFont(new Font("Pretendard", Font.BOLD, 17));
////		jbtnApply.setFont(font);
////		jbtnApply.setVisible(false); 버튼 안 보이게 만들기.
//		
//		
////		if (flag) {
////			jbtnApply = new JButton("신청");
////			jbtnApply.addActionListener(lpEvt);
////			jbtnApply.setFont(font);
////			jbtnApply.setBounds(310, 450, 80, 30);
////			LecturePlanEvt le = new LecturePlanEvt(this);
////			jbtnApply.addActionListener(le);
////			add(jbtnApply);
////			
////		}
//		
////		jtSubName.setText(lpVO.getSubName());
////		jtSubGoal.setText(lpVO.getSubGoal());
////		jtaSubInfo.setText(lpVO.getSubInfo());
//		
//		//배경색설정
//		Color backgroundColor = Color.decode("#D0E0EF");
//		Container contentPane = getContentPane();
//		contentPane.setBackground(backgroundColor);
//		
//		//bounds
////		jbtnApply.setBounds(310, 450, 80, 30);
//		jlblTitle.setBounds(25, 10, 210, 50);
//		jlblSubName.setBounds(50, 85, 100, 30);
//		jlblSubGoal.setBounds(50, 135, 100, 30);
//		jtSubName.setBounds(120, 85, 510, 30);
//		jtSubGoal.setBounds(120, 138, 510, 30);
//		jspjtSubInfo.setBounds(50, 220, 580, 210);
//		jlblSubInfo.setBounds(50, 180, 100, 30);
//		// jlblSubGoal
//	
//
//		//add
////		add(jbtnApply);
//		add(jlblTitle);
//		add(jlblSubName);
//		add(jlblSubGoal);
//		add(jtSubName);
//		add(jtSubGoal);
//		add(jspjtSubInfo);
//		add(jlblSubInfo);
//		setResizable(false);
//		setBounds(140, 70, 700, 540);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		
//	}
	
	public JTextField getJtSubName() {
		return jtSubName;
	}

	public void setJtSubName(JTextField jtSubName) {
		this.jtSubName = jtSubName;
	}

	public StudentSubjectDialog getSsDL() {
		return ssDL;
	}
	
	public void setSsDL(StudentSubjectDialog ssDL) {
		this.ssDL = ssDL;
	}
	
	public JTextField getJtSubGoal() {
		return jtSubGoal;
	}

	public void setJtSubGoal(JTextField jtSubGoal) {
		this.jtSubGoal = jtSubGoal;
	}

	public JTextArea getJtaSubInfo() {
		return jtaSubInfo;
	}

	public void setJtaSubInfo(JTextArea jtaSubInfo) {
		this.jtaSubInfo = jtaSubInfo;
	}

	/**
	 * @return the jbtnApply
	 */
	public JButton getJbtnApply() {
		return jbtnApply;
	}

	/**
	 * @return the smf
	 */
	public StudentMainFrame getSmf() {
		return smf;
	}

	public static void main(String[] args) {
// new LecturePlanDialog(new StudentSubjectDialog());
		
		
		

	}
}
