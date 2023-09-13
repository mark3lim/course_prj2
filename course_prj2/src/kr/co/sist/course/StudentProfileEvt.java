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
		dcbm.addElement("gmail.com");
		dcbm.addElement("naver.com");
		dcbm.addElement("nate.com");
		dcbm.addElement("daum.net");
		dcbm.addElement("hotmail.com");
		
	}

	public void initMyProfile() {
		//이메일을 학생 이메일 도메인으로 설정
		StudentVO sVO = StudentMainFrame.sVO;
		String[] email = sVO.getEmail().split("@");
		spd.getDcbmEmail().setSelectedItem(email[1]);
		
		//화면에 표시	
		spd.getJlblStuNo().setText(String.valueOf(sVO.getId()));
		spd.getJlblName().setText(sVO.getName());
		spd.getJtfEmail().setText(email[0]);
		spd.getJlblDept().setText(sVO.getDptName());
		spd.getJlblMajor().setText(sVO.getMajorName());
		spd.getJtfPhone().setText(sVO.getPhone());
		spd.getJtfAddr().setText(sVO.getAddr());
		spd.getJlblMyImg().setIcon(spd.getSmf().getJlblMyPhoto().getIcon());
	}
	
	public void changePw(StudentVO sVO) { 
		String pw = new String(spd.getJpfPw().getPassword());
		
		try {
			int cnt = StudentDAO.getInstance().updatePw(StudentMainFrame.sVO.getId(), pw);
			if(cnt == 0) {
				JOptionPane.showMessageDialog(spd, "비밀번호 업데이트 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(spd, "비밀번호가 변경되었습니다.");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(spd, "비밀번호 업데이트 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
	}
	
	public void updateMyInfo(StudentVO sVO) {
		//내 정보를 정말로 수정할 건지 확인
		int flag = JOptionPane.showConfirmDialog(spd, "내 정보를 수정하시겠습니까?", "내 정보 수정", JOptionPane.YES_NO_OPTION);
		if(flag != JOptionPane.OK_OPTION) {
			return;
		}
		
//		변경할 정보들을 저장하는 VO class
		StudentVO tempVO = new StudentVO();
		
		String email = spd.getJtfEmail()+"@"+spd.getDcbmEmail().getSelectedItem(); //이메일을 서식에 맞게 대입
		tempVO.setEmail(email);
		tempVO.setPhone(spd.getJtfPhone().getText());
		tempVO.setAddr(spd.getJtfAddr().getText());
		tempVO.setImg(sVO.getImg());
		
		try {
			int cnt = StudentDAO.getInstance().updateMyInfo(tempVO);
			if(cnt == 0) {
				JOptionPane.showMessageDialog(spd, "정보 수정 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(spd, "내 정보가 수정되었습니다.");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(spd, "정보 수정 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
	}
	public void changeImg() {
		FileDialog fd = new FileDialog(spd);
		fd.setVisible(true);
		
		if(fd.getFile() == null) {
			return;
		}
		System.out.println(fd.getFile());
		Image image = new ImageIcon(fd.getDirectory()+fd.getFile()).getImage();
		ImageIcon newImg = new ImageIcon(image);
		
		StudentMainFrame.sVO.setImg(fd.getFile()); //업데이트 하기 전까지는 서버에 저장되거나 하지 않음
		spd.getJlblMyImg().setIcon(newImg);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == spd.getJbtnChangePw()) {
			changePw(StudentMainFrame.sVO);
		}
		if(ae.getSource() == spd.getJbtnUpdateInfo()) {
			updateMyInfo(StudentMainFrame.sVO);
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
