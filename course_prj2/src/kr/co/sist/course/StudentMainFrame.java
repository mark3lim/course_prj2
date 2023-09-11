package kr.co.sist.course;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
//돼라
/* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 */
@SuppressWarnings("serial")
public class StudentMainFrame extends JFrame {
	
	private JButton jbtnMyProfile; 
	private JButton jbtnLogout;
	private JButton jbtnRegisterSubject;
	private JButton jbtnGradeSearch;
	private JButton jbtnCourseApply;
	private JLabel jlblMyPhoto;
	private JLabel jlblMyName;
	private JLabel jlblDept;
	private JLabel jlblMajor;
	private JLabel jlblEmail;
	private JLabel jlblLoginTime;

	private static StudentVO sVO;
	
	public StudentMainFrame(StudentVO stuVO) {
		sVO = stuVO;
		
		//배경 사진 설정
		JLabel jlblBg = new JLabel(new ImageIcon("C:/Users/user/git/group_prj/course_prj/src/kr/co/sist/course/images/mainBg.png"));
		jlblBg.setBounds(0, 0, 1200, 800);
		
		//학생 사진을 보여주는 라벨 설정
		jlblMyPhoto = new JLabel();
		jlblMyPhoto.setBounds(220, 150, 200, 250);
		jlblMyPhoto.setBorder(new LineBorder(Color.red));
		
		//메인 버튼들을 모아두는 패널과 버튼들 설정
		JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 60));
		pnlButton.setBounds(620, 170, 400, 400);
		pnlButton.setBorder(new LineBorder(Color.red));
		Dimension d = new Dimension(300, 50);
		
		jbtnRegisterSubject = new JButton("수강과목");
		jbtnRegisterSubject.setPreferredSize(d);
		jbtnGradeSearch = new JButton("성적조회");
		jbtnGradeSearch.setPreferredSize(d);
		jbtnCourseApply = new JButton("수강신청");
		jbtnCourseApply.setPreferredSize(d);
		
		pnlButton.add(jbtnRegisterSubject);
		pnlButton.add(jbtnGradeSearch);
		pnlButton.add(jbtnCourseApply);
		
		//로그인하면 보여주는 학생 정보를 보여주는 패널과 라벨 설정
		JPanel pnlInfoTag = setInfoLable(); //분류 라벨 만드는 method
		pnlInfoTag.setLocation(jlblMyPhoto.getX(), jlblMyPhoto.getY()+290);
		
		jlblDept = new JLabel();
		jlblDept.setBounds(100, 0, 200, 30);
		jlblMajor = new JLabel();
		jlblMajor.setBounds(100, 35, 200, 30);
		jlblEmail = new JLabel();
		jlblEmail.setBounds(100, 70, 200, 30);
		jlblLoginTime = new JLabel();
		jlblLoginTime.setBounds(100, 105, 200, 30);
		
		pnlInfoTag.add(jlblDept);
		pnlInfoTag.add(jlblMajor);
		pnlInfoTag.add(jlblEmail);
		pnlInfoTag.add(jlblLoginTime);
		
		//이름, 내 정보, 로그아웃이 모여있는 패널과 설정
		JPanel pnlName = new JPanel();
		pnlName.setBounds(720, jlblMyPhoto.getY()-45, 300, 35);
		pnlName.setLayout(null);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 16);
		
		jlblMyName = new JLabel();
		jlblMyName.setHorizontalAlignment(JLabel.CENTER);
		jlblMyName.setBounds(0, 2, 105, 30);
		jlblMyName.setBorder(new LineBorder(Color.pink));
		jlblMyName.setFont(font);
		
		jbtnMyProfile = new JButton("내 정보");
		jbtnMyProfile.setBounds(115, 5, 85, 25);
		jbtnLogout = new JButton("로그아웃");
		jbtnLogout.setBounds(212, 5, 85, 25);
		
		pnlName.add(jlblMyName);
		pnlName.add(jbtnMyProfile);
		pnlName.add(jbtnLogout);
		
		
		setLayout(null);
		
		add(jlblMyPhoto);
		add(pnlButton);
		add(pnlInfoTag);
		add(pnlName);
		
		add(jlblBg);

		//이벤트 연결
		StudentMainEvt sme = new StudentMainEvt(this);
		jbtnMyProfile.addActionListener(sme);
		jbtnLogout.addActionListener(sme);
		jbtnRegisterSubject.addActionListener(sme);
		jbtnGradeSearch.addActionListener(sme);
		jbtnCourseApply.addActionListener(sme);
		addWindowListener(sme);
		
		//화면 크기 설정
		setBounds(200, 150, 1200, 800);
		setVisible(true);
	}
	
	public JPanel setInfoLable() {
		String[] strArr = {"학부", "학과", "이메일", "로그인 시간"};
		JLabel[] jl = new JLabel[strArr.length];
		Font font = new Font(null, Font.BOLD, 14);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.setSize(310, 140);
		
		for(int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel(strArr[i]);
			jl[i].setBounds(10, 35*i, 80, 30);
			jl[i].setFont(font);
			
			pnl.add(jl[i]);
		}
		
		
		return pnl;
	}

	public JButton getJbtnMyProfile() {
		return jbtnMyProfile;
	}

	public JButton getJbtnLogout() {
		return jbtnLogout;
	}

	public JButton getJbtnRegisterSubject() {
		return jbtnRegisterSubject;
	}

	public JButton getJbtnGradeSearch() {
		return jbtnGradeSearch;
	}

	public JButton getJbtnCourseApply() {
		return jbtnCourseApply;
	}

	public JLabel getJlblMyPhoto() {
		return jlblMyPhoto;
	}

	public JLabel getJlblMyName() {
		return jlblMyName;
	}

	public JLabel getJlblDept() {
		return jlblDept;
	}

	public JLabel getJlblMajor() {
		return jlblMajor;
	}

	public JLabel getJlblEmail() {
		return jlblEmail;
	}

	public JLabel getJlblLoginTime() {
		return jlblLoginTime;
	}

	public static StudentVO getsVO() {
		return sVO;
	}

//	public static void main(String[] args) {
//		//임시 값
//		StudentVO s = new StudentVO();
//		s.setName("농담곰");
//		s.setDptName("연극영화부");
//		s.setMajorName("연극영화과");
//		s.setEmail("testest@naver.com");
//		s.setId(2023001);
//		new StudentMainFrame(s);
//	}
	
}
