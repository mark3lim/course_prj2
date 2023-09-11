package kr.co.sist.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
//돼라
public class LoginEvt extends WindowAdapter implements ActionListener {
	
	private LoginFrame lf;
	
	public LoginEvt(LoginFrame lf) {
		this.lf = lf;
	}
	
	public void accountCheck(String id, char[] pw) {
		String pass = String.valueOf(pw);
		
		try {
			if(isAdmin()) {
				new EmployMainFrame(LoginDAO.getInstnace().selectEmp(id, pass));
		
			} else {
				new StudentMainFrame(LoginDAO.getInstnace().selectStu(id, pass));
			}
			lf.dispose();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(lf, "서버 오류!\n잠시 후에 다시 시도해 주세요.");
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			JOptionPane.showMessageDialog(lf, "아이디를 올바르게 입력해주세요.");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			JOptionPane.showMessageDialog(lf, "아이디를 올바르게 입력해주세요.");
		}
		
	}
	
	public boolean isAdmin() {
		boolean flag = lf.getJcbChangeAdmin().isSelected();
		return flag;
	}
	
	public void idSave(String id) {
		System.out.println(id);
		
		if(lf.getJcbIdSave().isSelected()) {
			System.out.println("아이디 저장");
		} else {
			System.out.println("아이디 저장 안 함");
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//로그인 버튼 하나만 구분하여 작동
		if(ae.getSource() == lf.getJbtnLogin()) {
			accountCheck(lf.getJtfId().getText(), lf.getJpPw().getPassword());
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		lf.dispose();
	}

}
