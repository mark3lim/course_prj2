package kr.co.sist.course;

import javax.swing.JFrame;
//돼라
public class Main extends JFrame{
	
	public Main() {
		super("메인");
		
		setBounds(400,100,1200,800);
		setVisible(true);
		new EmployStuManageDialog(this);
		
		setResizable(false);
		
		//임시 window closing
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
	}

}
