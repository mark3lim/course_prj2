package kr.co.sist.course;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	public Main() {
		super("메인");
		
		setBounds(400,100,1200,800);
		setVisible(true);
		
		//E - 관리자, P - 교수
		//나중에 VO로 받아와서 수정 !!
		String emp = "E";
		if(emp.equals("E")) {
			new EmployStuManageDialog(this);			
		}else if(emp.equals("P")) {
			new EmployStuProfManageDialog(this);
		}
		
		setResizable(false);
		
		//임시 window closing
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
	}

}
