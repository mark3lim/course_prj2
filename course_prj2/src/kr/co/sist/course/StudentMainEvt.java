package kr.co.sist.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
//돼라
/* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 *//* 태균 */
public class StudentMainEvt extends WindowAdapter implements ActionListener {
	
	private StudentMainFrame smf;
	
	public StudentMainEvt(StudentMainFrame smf) {
		this.smf = smf;
		initInfo();
	}
	
	public void logout() {
		new LoginFrame();
		smf.dispose();
	}
	
	public void myPage() {
		System.out.println("my Profile");
	}
	
	public void mySubject() {
		System.out.println("수강과목");
	}
	
	public void courseApplication() {
		System.out.println("수강신청");
	}
	
	public void myGrade() {
		System.out.println("성적조회");
	}
	
	public void setLoginTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		smf.getJlblLoginTime().setText(sdf.format(new Date()));
	}
	
	public void initInfo() {
		StudentVO sVO = StudentMainFrame.getsVO();
		
		smf.getJlblMyName().setText(sVO.getName());
		smf.getJlblDept().setText(sVO.getDptName());
		smf.getJlblMajor().setText(sVO.getMajorName());
		smf.getJlblEmail().setText(sVO.getEmail());
		setLoginTime();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == smf.getJbtnMyProfile()) {
			myPage();
		}
		if(ae.getSource() == smf.getJbtnLogout()) {
			logout();
		}
		if(ae.getSource() == smf.getJbtnRegisterSubject()) {
			mySubject();
		}
		if(ae.getSource() == smf.getJbtnGradeSearch()) {
			myGrade();
		}
		if(ae.getSource() == smf.getJbtnCourseApply()) {
			courseApplication();
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		smf.dispose();
	}
	
}
