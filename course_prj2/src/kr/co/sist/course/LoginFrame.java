package kr.co.sist.course;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
//돼라
/* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 */
@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	
	private JButton jbtnLogin;
	private JTextField jtfId;
	private JPasswordField jpPw;
	private JCheckBox jcbChangeAdmin;
	private JCheckBox jcbIdSave;
	
	public LoginFrame() {
		super("로그인");
		
		//배경화면 설정
		JLabel jlblBg = new JLabel(new ImageIcon("C:/Users/user/git/group_prj/course_prj/src/kr/co/sist/course/images/mainBg.png"));
		jlblBg.setBounds(0, 0, 1200, 800);
		
		
		
		//아이디 라벨 설정
		JLabel jlblId = new JLabel("ID");
		jlblId.setBounds(250, 210, 70, 40);
		
		//아이디 입력 필드 설정
		jtfId = new JTextField(20);
		jtfId.setBounds(jlblId.getX()+75, jlblId.getY()+2, 220, 40);
		
		//비밀번호 라벨 설정
		JLabel jlblPw = new JLabel("PW");
		jlblPw.setBounds(jlblId.getX(), jlblId.getY()+42, 70, 40);
		
		//비밀번호 입력 필드 설정
		jpPw = new JPasswordField(20);
		jpPw.setBounds(jlblPw.getX()+75, jlblPw.getY()+2, 220, 40);
		
		//비밀번호 입력 필드 설정
		
		//아이디(학번)과 비밀번호 라벨, 입력 폰트 설정
		Font font = new Font("맑은 고딕", Font.BOLD, 26);
		jlblId.setFont(font);
		jlblPw.setFont(font);
		font = new Font("맑은 고딕", Font.PLAIN, 22);
		jtfId.setFont(font);

		//관리자 모드 전환 체크박스
		jcbChangeAdmin = new JCheckBox("관리자 모드 전환", false);
		jcbChangeAdmin.setBounds(jlblId.getX(), jlblId.getY()-35, 120, 30);
		jcbChangeAdmin.setFocusPainted(false);
		
		//아이디 저장 여부 체크박스
		jcbIdSave = new JCheckBox("아이디 저장");
		jcbIdSave.setBounds(jlblPw.getX(), jlblPw.getY()+50, 120, 30);
		jcbIdSave.setFocusPainted(false);
		
		//로그인 버튼 설정
		jbtnLogin = new JButton("로그인");
		jbtnLogin.setBounds(jlblPw.getX(), jlblPw.getY()+90, 295, 30);
		
		//학교 이미지 설정
		JLabel jlblImg = new JLabel();
		jlblImg.setBounds(590, 130, 435, 280);
		jlblImg.setBorder(new LineBorder(Color.red));
		
		//사용방법 표시하는 라벨(로그인 가장 아래 있는 설명)
		JTextArea jtaMsg = new JTextArea();
		StringBuilder sb = new StringBuilder();
		sb.append("- 최초 사용자는 전화번호 뒷자리 4개가 임시 비밀번호로 설정돼있습니다.").append("\n")
		.append("- 비밀번호는 마이페이지에서 변경할 수 있습니다.").append("\n")
		.append("- ID는 학번/사번 입니다.").append("\n")
		.append("- 학생, 교직원은 별도의 회원가입 절차 없이 학번/사번으로 로그인이 가능합니다.");
		
		jtaMsg.setText(sb.toString());
		jtaMsg.setEditable(false);
		jtaMsg.setBounds(jbtnLogin.getX(), jbtnLogin.getY()+85, 600, 100);
		
		//화면에 표시(추가)
		add(jcbChangeAdmin);
		add(jlblId);
		add(jtfId);
		add(jlblPw);
		add(jpPw);
		add(jcbIdSave);
		add(jbtnLogin);
		add(jlblImg);
		add(jtaMsg);
		
		add(jlblBg);
		
		//이벤트 설정
		LoginEvt le = new LoginEvt(this);
		jbtnLogin.addActionListener(le);
		jcbChangeAdmin.addActionListener(le);
		jcbIdSave.addActionListener(le);
		addWindowListener(le);
		
		//화면 크기 설정
		setBounds(200, 150, 1200, 800);
		setVisible(true);
	}

	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpPw() {
		return jpPw;
	}

	public JCheckBox getJcbChangeAdmin() {
		return jcbChangeAdmin;
	}

	public JCheckBox getJcbIdSave() {
		return jcbIdSave;
	}

	public static void main(String[] args) {
		new LoginFrame();
	}

}
