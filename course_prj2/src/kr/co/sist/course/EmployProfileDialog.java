package kr.co.sist.course;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class EmployProfileDialog extends JDialog {
	
	private JLabel jlblEmpno;
	private JLabel jlblDpt;
	private JLabel jlblMajor;
	private JLabel jlblMyImg;
	private JLabel jlblName;
	private JPasswordField jpfPw;
	private JPasswordField jpfCheckPw;
	private JTextField jtfPhone;
	private JTextField jtfEmail;
	private DefaultComboBoxModel<String> dcbmEmail;
	private JComboBox<String> jcbChoiceEmail;
	private JButton jbtnEditImg;
	private JButton jbtnUpdatePw;
	private JButton jbtnEdit;
	
	private EmployMainFrame emf;
	
//	public EmployProfileFrame() {
	public EmployProfileDialog(EmployMainFrame emf) {
		this.emf = emf;
		super.setModal(false);
		super.setTitle("내 정보");
		
		int labelWidth = 100;
		int labelHeight = 30;
		int fieldWidth = 250;
		int fieldHeight = 30;
		
		//배경화면 설정 라벨
		JLabel bgLabel = new JLabel(new ImageIcon("C:/Users/user/git/course_prj2/course_prj2/src/images/backgr.png"));
		bgLabel.setBounds(0, 0, 1000, 700);
		
		//내 정보 제목 표시
		JLabel jlblTitle = new JLabel("내 정보");
		jlblTitle.setBounds(180, 100, 70, 30);
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		
		//학생 사진 보여주는 라벨
		jlblMyImg = new JLabel();
		jlblMyImg.setBounds(160, 170, 190, 250);
		jlblMyImg.setHorizontalAlignment(JLabel.CENTER);
		jlblMyImg.setToolTipText("크기: 190 X 250");
		
		//학번 설정
		JLabel jlStuNo = new JLabel("학번");
		jlStuNo.setBounds(420, 170, labelWidth, labelHeight);
		jlblEmpno = new JLabel();
		jlblEmpno.setBounds(jlStuNo.getX()+100, jlStuNo.getY(), fieldWidth, fieldHeight);
		
		//이름 설정
		JLabel jlName = new JLabel("이름");
		jlName.setBounds(jlStuNo.getX(), jlStuNo.getY()+32, labelWidth, labelHeight);
		jlblName = new JLabel();
		jlblName.setBounds(jlblEmpno.getX(), jlName.getY(), fieldWidth, fieldHeight);
		
		//비밀번호 라벨 및 필드 설정
		JLabel jlPw = new JLabel("비밀번호");
		jlPw.setBounds(jlName.getX(), jlName.getY()+32, labelWidth, labelHeight);
		
		jpfPw = new JPasswordField(50);
		jpfPw.setBounds(jlblName.getX(), jlPw.getY(), fieldWidth, fieldHeight);
		jpfCheckPw = new JPasswordField(50);
		jpfCheckPw.setBounds(jpfPw.getX(), jpfPw.getY()+32, fieldWidth, fieldHeight);
		
		//이메일 설정
		JLabel jlEmail = new JLabel("이메일");
		jlEmail.setBounds(jlPw.getX(), jlPw.getY()+70, labelWidth, labelHeight);
		jtfEmail = new JTextField(30);
		jtfEmail.setBounds(jpfCheckPw.getX(), jpfCheckPw.getY()+38, 100, fieldHeight);
				
		//이메일 컴포박스 설정
		dcbmEmail = new DefaultComboBoxModel<String>();
		jcbChoiceEmail = new JComboBox<String>(dcbmEmail);
		jcbChoiceEmail.setBounds(jtfEmail.getX()+120, jtfEmail.getY(), 130, fieldHeight);
		jcbChoiceEmail.setEditable(true);
		
		JLabel golbaengi = new JLabel("@");
		golbaengi.setBounds(jcbChoiceEmail.getX()-19, jtfEmail.getY()+3, 20, 20);
		
		//학부 설정
		JLabel jldpt = new JLabel("학부");
		jldpt.setBounds(jlEmail.getX(), jlEmail.getY()+32, labelWidth, labelHeight);
		jlblDpt = new JLabel();
		jlblDpt.setBounds(jtfEmail.getX(), jtfEmail.getY()+38, fieldWidth, fieldHeight);
				
		//학과 설정
		JLabel jlMajor = new JLabel("학과");
		jlMajor.setBounds(jldpt.getX(), jldpt.getY()+32, labelWidth, labelHeight);
		jlblMajor = new JLabel();
		jlblMajor.setBounds(jlblDpt.getX(), jlblDpt.getY()+32, fieldWidth, fieldHeight);
		
		//전화번호
		JLabel jlPhone = new JLabel("전화번호");
		jlPhone.setBounds(jlMajor.getX(), jlMajor.getY()+32, labelWidth, labelHeight);
		jtfPhone = new JTextField(50);
		jtfPhone.setBounds(jlblMajor.getX(), jlblMajor.getY()+32, fieldWidth, fieldHeight);
		
		//수정 버튼 설정
		jbtnEdit = new JButton("수정");
		jbtnEdit.setBounds(460, 520, 80, 30);
		
		//비밀번호 버튼 설정
		jbtnUpdatePw = new JButton("변경");
		jbtnUpdatePw.setBounds(jpfPw.getX()+255, jpfPw.getY()+3, 60, 25);
				
		//사진 편집 버튼 설정
		jbtnEditImg = new JButton("편집");
		jbtnEditImg.setBounds(jlblMyImg.getX(), jlblMyImg.getY()+250, 190, 30);
		
		// 라벨 폰트 설정
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		jlblTitle.setFont(font);
		jlStuNo.setFont(font);
		jlName.setFont(font);
		jlPw.setFont(font);
		jlblEmpno.setFont(font);
		jlblName.setFont(font);
		jlEmail.setFont(font);
		jldpt.setFont(font);
		jlMajor.setFont(font);
		jlPhone.setFont(font);
		golbaengi.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		//임시용 테두리 설정
		//정확한 위치와 크기를 알아보기 위해서 설정
		//디자인이 끝나면 삭제할 예
		jlblTitle.setBorder(new LineBorder(Color.red));
		jlblMyImg.setBorder(new LineBorder(Color.red));
		jlStuNo.setBorder(new LineBorder(Color.red));
		jlName.setBorder(new LineBorder(Color.red));
		jlPw.setBorder(new LineBorder(Color.red));
		jlblEmpno.setBorder(new LineBorder(Color.red));
		jlblName.setBorder(new LineBorder(Color.red));
		jpfPw.setBorder(new LineBorder(Color.red));
		jpfCheckPw.setBorder(new LineBorder(Color.red));
		jlEmail.setBorder(new LineBorder(Color.red));
		jcbChoiceEmail.setBorder(new LineBorder(Color.red));
		jldpt.setBorder(new LineBorder(Color.red));
		jlblDpt.setBorder(new LineBorder(Color.red));
		jlMajor.setBorder(new LineBorder(Color.red));
		jlblMajor.setBorder(new LineBorder(Color.red));
		jlPhone.setBorder(new LineBorder(Color.red));
		jtfPhone.setBorder(new LineBorder(Color.red));
		
		setLayout(null);
		
		//이벤트 연결
		EmployProfileEvt epe = new EmployProfileEvt(this);
		jbtnUpdatePw.addActionListener(epe);
		jbtnEdit.addActionListener(epe);
		jbtnEditImg.addActionListener(epe);
		addWindowListener(epe);
		
		bgLabel.add(jlblTitle);
		bgLabel.add(jlblMyImg);
		bgLabel.add(jlStuNo);
		bgLabel.add(jlblEmpno);
		bgLabel.add(jlName);
		bgLabel.add(jlblName);
		bgLabel.add(jlPw);
		bgLabel.add(jpfPw);
		bgLabel.add(jpfCheckPw);
		bgLabel.add(jlEmail);
		bgLabel.add(golbaengi);
		bgLabel.add(jtfEmail);
		bgLabel.add(jcbChoiceEmail);
		bgLabel.add(jldpt);
		bgLabel.add(jlblDpt);
		bgLabel.add(jlMajor);
		bgLabel.add(jlblMajor);
		bgLabel.add(jlPhone);
		bgLabel.add(jtfPhone);
		bgLabel.add(jbtnEdit);
		bgLabel.add(jbtnUpdatePw);
		bgLabel.add(jbtnEditImg);

		add(bgLabel);
		
		setBounds(150, 200, 1000, 700);
		setVisible(true);
	}

	public JLabel getJlblEmpno() {
		return jlblEmpno;
	}

	public JLabel getJlblDpt() {
		return jlblDpt;
	}

	public JLabel getJlblMajor() {
		return jlblMajor;
	}

	public JLabel getJlblMyImg() {
		return jlblMyImg;
	}

	public JLabel getJtfName() {
		return jlblName;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}

	public JPasswordField getJpfCheckPw() {
		return jpfCheckPw;
	}

	public JTextField getJtfPhone() {
		return jtfPhone;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public DefaultComboBoxModel<String> getDcbmEmail() {
		return dcbmEmail;
	}

	public JComboBox<String> getJcbChoiceEmail() {
		return jcbChoiceEmail;
	}

	public JButton getJbtnEditImg() {
		return jbtnEditImg;
	}

	public JButton getJbtnUpdatePw() {
		return jbtnUpdatePw;
	}

	public JButton getJbtnEdit() {
		return jbtnEdit;
	}

	public EmployMainFrame getEmf() {
		return emf;
	}

//	public static void main(String[] args) {
//		new EmployProfileFrame();
//	}

}
