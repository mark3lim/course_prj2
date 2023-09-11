package kr.co.sist.course;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class StudentProfileEvt extends WindowAdapter implements ActionListener {
	
	private StudentProfileDialog spd;
	
	public StudentProfileEvt(StudentProfileDialog spd) {
		this.spd = spd;
		setEmailComboBox();
	}
	
	public void setEmailComboBox() {
		DefaultComboBoxModel<String> dcbm = spd.getDcbmEmail();
		dcbm.addElement("직접입력");
		dcbm.addElement("@gmail.com");
		dcbm.addElement("@naver.com");
		dcbm.addElement("@nate.com");
		dcbm.addElement("@daum.com");
		dcbm.addElement("@hotmail.com");
		
	}

	public void initMyProfile(StudentVO sVO) {
		System.out.println("초기화");
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
