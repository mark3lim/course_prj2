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

public class EmployProfileEvt extends WindowAdapter implements ActionListener {
	
	private EmployProfileDialog epf;
	
	public EmployProfileEvt(EmployProfileDialog epf) {
		this.epf = epf;
		initProfile();
		setEmailComboBox();
	}
	
	public void initProfile() {
		EmployVO eVO = EmployMainFrame.eVO;
		String[] email = eVO.getEmail().split("@");
		epf.getDcbmEmail().setSelectedItem(email[1]);
		
		epf.getJlblEmpno().setText(eVO.getEmpno());
		epf.getJtfName().setText(eVO.getName());
		epf.getJlblDpt().setText(eVO.getDptName());
		epf.getJlblMajor().setText(eVO.getMajorName());
		epf.getJtfPhone().setText(eVO.getPhone());
		epf.getJtfEmail().setText(email[0]);
		epf.getJlblMyImg().setIcon(epf.getEmf().getJlblMyPhoto().getIcon());
		
	}
	
	public void changePw() {
		String pw = new String(epf.getJpfPw().getPassword());
		
		try {
			int cnt = EmployDAO.getInstance().updatePw(EmployMainFrame.eVO.getEmpno(), pw);
			if(cnt == 0) {
				JOptionPane.showMessageDialog(epf, "비밀번호 업데이트 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(epf, "비밀번호가 변경되었습니다.");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(epf, "비밀번호 업데이트 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void updateProfile(EmployVO eVO) {
		//내 정보를 정말로 수정할 건지 확인
		int flag = JOptionPane.showConfirmDialog(epf, "내 정보를 수정하시겠습니까?", "내 정보 수정", JOptionPane.YES_NO_OPTION);
		if(flag != JOptionPane.OK_OPTION) {
			return;
		}
		
//		변경할 정보들을 저장하는 VO class
		//교수 UI로 만듬
		EmployVO tempVO = new EmployVO();
		
		String email = epf.getJtfEmail()+"@"+epf.getDcbmEmail().getSelectedItem(); //이메일을 서식에 맞게 대입
		tempVO.setName(epf.getJtfName().getText());
		tempVO.setEmail(email);
		tempVO.setPhone(epf.getJtfPhone().getText());
		tempVO.setImage(eVO.getImage());
		
		try {
			int cnt = EmployDAO.getInstance().updateProfile(tempVO);
			if(cnt == 0) {
				JOptionPane.showMessageDialog(epf, "정보 수정 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(epf, "내 정보가 수정되었습니다.");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(epf, "정보 수정 실패!\n나중에 시도해주세요.", "서버오류", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void changeImg() {
		FileDialog fd = new FileDialog(epf);
		fd.setVisible(true);
		
		if(fd.getFile() == null) {
			return;
		}
		
		System.out.println(fd.getFile());
		Image image = new ImageIcon(fd.getDirectory()+fd.getFile()).getImage();
		ImageIcon newImg = new ImageIcon(image.getScaledInstance(190, 250, Image.SCALE_SMOOTH));
		
		EmployMainFrame.eVO.setImage(fd.getFile()); //업데이트 하기 전까지는 서버에 저장되거나 하지 않음
		epf.getJlblMyImg().setIcon(newImg);
	}
	
	public void setEmailComboBox() {
		DefaultComboBoxModel<String> dcbm = epf.getDcbmEmail();
		dcbm.addElement("직접입력");
		dcbm.addElement("gmail.com");
		dcbm.addElement("naver.com");
		dcbm.addElement("nate.com");
		dcbm.addElement("daum.com");
		dcbm.addElement("hotmail.com");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == epf.getJbtnUpdatePw()) {
			changePw();
		}
		if(ae.getSource() == epf.getJbtnEdit()) {
			updateProfile(EmployMainFrame.eVO);
		}
		if(ae.getSource() == epf.getJbtnEditImg()) {
			changeImg();
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		epf.dispose();
	}

}
