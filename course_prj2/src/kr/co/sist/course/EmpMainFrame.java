package kr.co.sist.course;
//package kr.co.sist.course;
//
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Font;
////돼라
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//
///**
// * 메인 화면 공통으로 사용하는 부모 class이다.<br>
// * 화면 구성만 있고 이벤트는 연결이 안 되어있음.<br>
// * 버튼 또한 없음.
// * @author user
// */
//
///* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 */
// 사용은 안 하지만 나중에 관리자 창과 교수 창을 분리하는 것으로 변경되면 사용하기 위해서
// 삭제하지 않고 주석으로 막아 둠.
//@SuppressWarnings("serial")
//public class EmpMainFrame extends JFrame {
//
//	JButton jbtnMyProfile;
//	JButton jbtnLogout;
//	JLabel jlblMyPhoto;
//	JLabel jlblMyName;
//	JPanel pnlButton;
//	JPanel pnlInfoTag;
//	JPanel pnlName;
//	
//	FlowLayout flow;
//
//	public EmpMainFrame() {
//
//		// 배경 사진 설정
//		JLabel jlblBg = new JLabel(new ImageIcon("C:/Users/user/git/group_prj/course_prj/src/kr/co/sist/course/images/mainBg.png"));
//		jlblBg.setBounds(0, 0, 1200, 800);
//
//		// 학생 사진을 보여주는 라벨 설정
//		jlblMyPhoto = new JLabel();
//		jlblMyPhoto.setBounds(220, 150, 200, 250);
//		jlblMyPhoto.setBorder(new LineBorder(Color.red));
//
//		// 메인 버튼들을 모아두는 패널 설정
//		flow = new FlowLayout(FlowLayout.CENTER, 10, 60);
//				
//		pnlButton = new JPanel(flow);
//		pnlButton.setBounds(620, 170, 400, 400);
//		pnlButton.setBorder(new LineBorder(Color.red));
//
//		// 로그인하면 보여주는 학생 정보를 보여주는 패널 설정
//		pnlInfoTag = setInfoLable(); //분류 라벨 만드는 method
//		pnlInfoTag.setLocation(jlblMyPhoto.getX(), jlblMyPhoto.getY()+290);
//		pnlInfoTag.setBorder(new LineBorder(Color.red));
//
//		// 이름, 내 정보, 로그아웃이 모여있는 패널과 설정
//		pnlName = new JPanel();
//		pnlName.setBounds(680, jlblMyPhoto.getY() - 45, 340, 35);
//		pnlName.setLayout(null);
//
//		Font font = new Font("맑은 고딕", Font.BOLD, 16);
//
//		jlblMyName = new JLabel();
//		jlblMyName.setBounds(0, 2, 140, 30);
//		jlblMyName.setBorder(new LineBorder(Color.pink));
//		jlblMyName.setFont(font);
//
//		jbtnMyProfile = new JButton("내 정보");
//		jbtnMyProfile.setBounds(152, 5, 85, 25);
//		jbtnLogout = new JButton("로그아웃");
//		jbtnLogout.setBounds(250, 5, 85, 25);
//
//		pnlName.add(jlblMyName);
//		pnlName.add(jbtnMyProfile);
//		pnlName.add(jbtnLogout);
//
//		setLayout(null);
//
//		add(jlblMyPhoto);
//		add(pnlButton);
//		add(pnlInfoTag);
//		add(pnlName);
//
//		add(jlblBg);
//
//		setBounds(200, 150, 1200, 800);
//		setVisible(true);
//	}
//	
//	public JPanel setInfoLable() {
//		String[] strArr = {"학부", "학과", "이메일", "로그인 시간"};
//		JLabel[] jl = new JLabel[strArr.length];
//		Font font = new Font(null, Font.BOLD, 14);
//		
//		JPanel pnl = new JPanel();
//		pnl.setLayout(null);
//		pnl.setSize(310, 140);
//		
//		for(int i = 0; i < jl.length; i++) {
//			jl[i] = new JLabel(strArr[i]);
//			jl[i].setBounds(10, 35*i, 80, 30);
//			jl[i].setFont(font);
//			
//			pnl.add(jl[i]);
//		}
//		
//		
//		return pnl;
//	}
//
//	public JButton getJbtnMyProfile() {
//		return jbtnMyProfile;
//	}
//
//	public JButton getJbtnLogout() {
//		return jbtnLogout;
//	}
//
//	public JLabel getJlblMyPhoto() {
//		return jlblMyPhoto;
//	}
//
//	public JLabel getJlblMyName() {
//		return jlblMyName;
//	}
//
//}