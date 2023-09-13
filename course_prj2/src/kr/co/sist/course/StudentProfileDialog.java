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
public class StudentProfileDialog extends JDialog {
	
	private StudentMainFrame smf;
	private JButton jbtnUpdateInfo;
	private JLabel jlblStuNo;
	private JLabel jlblName;
	private JPasswordField jpfPw;
	private JPasswordField jpfPwConfirm;
	private JTextField jtfEmail;
	private DefaultComboBoxModel<String> dcbmEmail;
	private JComboBox<String> jcbChoiceEmail;
	private JLabel jlblDept;
	private JLabel jlblMajor;
	private JTextField jtfPhone;
	private JTextField jtfAddr;
//	private JButton jbtnAddr;
	private JButton jbtnEditPhoto;
	private JLabel jlblMyImg;
	private JButton jbtnChangePw;
	
//	public StudentProfileDialog(/* StudentMainFrame smf */) {
	public StudentProfileDialog(StudentMainFrame smf) {
		this.smf = smf;
		super.setModal(false);
		super.setTitle("내 정보");
		
		int labelWidth = 100;
		int labelHeight = 30;
		int fieldWidth = 150;
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
		jlblMyImg.setBounds(180, 170, 190, 250);
		jlblMyImg.setHorizontalAlignment(JLabel.CENTER);
		jlblMyImg.setToolTipText("크기: 190 X 250");
		
		//학번 설정
		JLabel jlStuNo = new JLabel("학번");
		jlStuNo.setBounds(510, 170, labelWidth, labelHeight);
		jlblStuNo = new JLabel();
		jlblStuNo.setBounds(jlStuNo.getX()+100, jlStuNo.getY(), fieldWidth, fieldHeight);
		
		//이름 설정
		JLabel jlName = new JLabel("이름");
		jlName.setBounds(jlStuNo.getX(), jlStuNo.getY()+32, labelWidth, labelHeight);
		jlblName = new JLabel();
		jlblName.setBounds(jlblStuNo.getX(), jlName.getY(), fieldWidth, fieldHeight);
		
		//비밀번호 라벨 및 필드 설정
		JLabel jlPw = new JLabel("비밀번호");
		jlPw.setBounds(jlName.getX(), jlName.getY()+32, labelWidth, labelHeight);
		
		jpfPw = new JPasswordField(50);
		jpfPw.setBounds(jlblName.getX(), jlPw.getY(), fieldWidth, fieldHeight);
		jpfPwConfirm = new JPasswordField(50);
		jpfPwConfirm.setBounds(jpfPw.getX(), jpfPw.getY()+32, fieldWidth, fieldHeight);
		
		//이메일 설정
		JLabel jlEmail = new JLabel("이메일");
		jlEmail.setBounds(jlPw.getX(), jlPw.getY()+70, labelWidth, labelHeight);
		jtfEmail = new JTextField(30);
		jtfEmail.setBounds(jpfPwConfirm.getX(), jpfPwConfirm.getY()+32, 50, fieldHeight);
		
		//이메일 컴포박스 설정
		dcbmEmail = new DefaultComboBoxModel<String>();
		jcbChoiceEmail = new JComboBox<String>(dcbmEmail);
		jcbChoiceEmail.setBounds(jtfEmail.getX()+28, jtfEmail.getY()+7, fieldWidth-28, fieldHeight);
		jcbChoiceEmail.setEditable(true);
		
		JLabel golbaengi = new JLabel("@");
		golbaengi.setBounds(jcbChoiceEmail.getX()-23, jtfEmail.getY()+10, 20, 20);
		
		//학부 설정
		JLabel jldpt = new JLabel("학부");
		jldpt.setBounds(jlEmail.getX(), jlEmail.getY()+32, labelWidth, labelHeight);
		jlblDept = new JLabel();
		jlblDept.setBounds(jtfEmail.getX(), jtfEmail.getY()+38, fieldWidth, fieldHeight);
		
		//학과 설정
		JLabel jlMajor = new JLabel("학과");
		jlMajor.setBounds(jldpt.getX(), jldpt.getY()+32, labelWidth, labelHeight);
		jlblMajor = new JLabel();
		jlblMajor.setBounds(jlblDept.getX(), jlblDept.getY()+32, fieldWidth, fieldHeight);
		
		//전화번호
		JLabel jlPhone = new JLabel("전화번호");
		jlPhone.setBounds(jlMajor.getX(), jlMajor.getY()+32, labelWidth, labelHeight);
		jtfPhone = new JTextField(50);
		jtfPhone.setBounds(jlblMajor.getX(), jlblMajor.getY()+32, fieldWidth, fieldHeight);
		
		//주소 설정
		JLabel jlAddr = new JLabel("주소");
		jlAddr.setBounds(jlPhone.getX(), jlPhone.getY()+32, labelWidth, labelHeight);
		jtfAddr = new JTextField(100);
		jtfAddr.setBounds(jtfPhone.getX(), jtfPhone.getY()+32, fieldWidth, fieldHeight);
		
		//수정 버튼 설정
		jbtnUpdateInfo = new JButton("수정");
		jbtnUpdateInfo.setBounds(460, 520, 80, 30);
		
		//비밀번호 버튼 설정
		jbtnChangePw = new JButton("변경");
		jbtnChangePw.setBounds(jpfPw.getX()+150, jpfPw.getY(), 80, 30);
		
		//사진 편집 버튼 설정
		jbtnEditPhoto = new JButton("편집");
		jbtnEditPhoto.setBounds(jlblMyImg.getX(), jlblMyImg.getY()+250, 190, 30);
		
		// 라벨 폰트 설정
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		jlblTitle.setFont(font);
		jlStuNo.setFont(font);
		jlName.setFont(font);
		jlPw.setFont(font);
		jlblStuNo.setFont(font);
		jlblName.setFont(font);
		jlEmail.setFont(font);
		jldpt.setFont(font);
		jlMajor.setFont(font);
		jlPhone.setFont(font);
		jlAddr.setFont(font);
		golbaengi.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		//임시용 테두리 설정
		//정확한 위치와 크기를 알아보기 위해서 설정
		//디자인이 끝나면 삭제할 예
		jlblTitle.setBorder(new LineBorder(Color.red));
		jlblMyImg.setBorder(new LineBorder(Color.red));
		jlStuNo.setBorder(new LineBorder(Color.red));
		jlName.setBorder(new LineBorder(Color.red));
		jlPw.setBorder(new LineBorder(Color.red));
		jlblStuNo.setBorder(new LineBorder(Color.red));
		jlblName.setBorder(new LineBorder(Color.red));
		jpfPw.setBorder(new LineBorder(Color.red));
		jpfPwConfirm.setBorder(new LineBorder(Color.red));
		jlEmail.setBorder(new LineBorder(Color.red));
		jcbChoiceEmail.setBorder(new LineBorder(Color.red));
		jldpt.setBorder(new LineBorder(Color.red));
		jlblDept.setBorder(new LineBorder(Color.red));
		jlMajor.setBorder(new LineBorder(Color.red));
		jlblMajor.setBorder(new LineBorder(Color.red));
		jlPhone.setBorder(new LineBorder(Color.red));
		jtfPhone.setBorder(new LineBorder(Color.red));
		jlAddr.setBorder(new LineBorder(Color.red));
		jtfAddr.setBorder(new LineBorder(Color.red));
		
		setLayout(null);
		
		//이벤트 연결
		StudentProfileEvt spe = new StudentProfileEvt(this);
		jbtnChangePw.addActionListener(spe);
		jbtnUpdateInfo.addActionListener(spe);
		jbtnEditPhoto.addActionListener(spe);
		addWindowListener(spe);
		
		bgLabel.add(jlblTitle);
		bgLabel.add(jlblMyImg);
		bgLabel.add(jlStuNo);
		bgLabel.add(jlblStuNo);
		bgLabel.add(jlName);
		bgLabel.add(jlblName);
		bgLabel.add(jlPw);
		bgLabel.add(jpfPw);
		bgLabel.add(jpfPwConfirm);
		bgLabel.add(jlEmail);
		bgLabel.add(golbaengi);
		bgLabel.add(jcbChoiceEmail);
		bgLabel.add(jldpt);
		bgLabel.add(jlblDept);
		bgLabel.add(jlMajor);
		bgLabel.add(jlblMajor);
		bgLabel.add(jlPhone);
		bgLabel.add(jtfPhone);
		bgLabel.add(jlAddr);
		bgLabel.add(jtfAddr);
		bgLabel.add(jbtnUpdateInfo);
		bgLabel.add(jbtnChangePw);
		bgLabel.add(jbtnEditPhoto);

		add(bgLabel);
		
		setBounds(150, 200, 1000, 700);
		setVisible(true);
	}
	
	
	
	public StudentMainFrame getSmf() {
		return smf;
	}

	public JButton getJbtnUpdateInfo() {
		return jbtnUpdateInfo;
	}

	public JLabel getJlblStuNo() {
		return jlblStuNo;
	}

	public JLabel getJlblName() {
		return jlblName;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}

	public JPasswordField getJpfPwConfirm() {
		return jpfPwConfirm;
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

	public JLabel getJlblDept() {
		return jlblDept;
	}

	public JLabel getJlblMajor() {
		return jlblMajor;
	}

	public JTextField getJtfPhone() {
		return jtfPhone;
	}

	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public JButton getJbtnEditPhoto() {
		return jbtnEditPhoto;
	}

	public JLabel getJlblMyImg() {
		return jlblMyImg;
	}

	public JButton getJbtnChangePw() {
		return jbtnChangePw;
	}

//	public static void main(String[] args) {
//		new StudentProfileDialog(smf);
//	}

}
