package kr.co.sist.course;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class StudentProfileEvt extends WindowAdapter implements ActionListener {
	
	private StudentProfileDialog spd;
	
	public StudentProfileEvt(StudentProfileDialog spd) {
		this.spd = spd;
		initMyProfile();
		setEmailComboBox();
	}
	
	public void setEmailComboBox() {
		DefaultComboBoxModel<String> dcbm = spd.getDcbmEmail();
		dcbm.addElement("직접입력");
		dcbm.addElement("@gmail.com");
		dcbm.addElement("@naver.com");
		dcbm.addElement("@nate.com");
		dcbm.addElement("@daum.net");
		dcbm.addElement("@hotmail.com");
		
	}

	public void initMyProfile() {
//		spd.getSmf();
		
		//이메일을 학생 이메일 도메인으로 설정
		String temp = StudentMainFrame.sVO.getEmail();
		String email = temp.substring(temp.indexOf("@")+1);
		spd.getDcbmEmail().setSelectedItem(email);
		
		//화면에 표시	
		spd.getJlblStuNo().setText(String.valueOf(StudentMainFrame.sVO.getId()));
		spd.getJlblName().setText(StudentMainFrame.sVO.getName());
		spd.getJtfEmail().setText(StudentMainFrame.sVO.getEmail());
		spd.getJlblDept().setText(StudentMainFrame.sVO.getDptName());
		spd.getJlblMajor().setText(StudentMainFrame.sVO.getMajorName());
		spd.getJtfPhone().setText(StudentMainFrame.sVO.getPhone());
		spd.getJtfAddr().setText(StudentMainFrame.sVO.getAddr());
	}
	
	public void changePw(StudentVO sVO) { 
		System.out.println("비밀번호 변경");
		
	}
	
	public void updateMyInfo(StudentVO sVO) {
		System.out.println("정보 수정");
		//다오 연결
		
		JOptionPane.showMessageDialog(spd, "내 정보가 수정되었습니다.");
		
		JOptionPane.showMessageDialog(spd, "수정 실패!\n다시 시도해주세요.");
		
	}
	public void changeImg() {
		System.out.println("사진 변경");
		FileDialog fd = new FileDialog(spd);
		fd.setVisible(true);
		
		if(fd.getFile() == null) {
			return;
		}
		System.out.println(fd.getFile());
		Image image = new ImageIcon(fd.getDirectory()+fd.getFile()).getImage();
		image.getScaledInstance(210, 240, Image.SCALE_SMOOTH);
		ImageIcon newImg = new ImageIcon(image);
		
		spd.getJlblMyImg().setIcon(newImg);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == spd.getJbtnChangePw()) {
			changePw(null);
		}
		if(ae.getSource() == spd.getJbtnUpdateInfo()) {
			updateMyInfo(null);
		}
		if(ae.getSource() == spd.getJbtnEditPhoto()) {
			changeImg();
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		spd.dispose();
	}

}
