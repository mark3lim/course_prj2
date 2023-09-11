package kr.co.sist.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//돼라
public class EmployStuManageEvt extends WindowAdapter implements ActionListener, MouseListener {

	private EmployStuManageDialog esmd;
	
	public EmployStuManageEvt(EmployStuManageDialog esmd) {
		this.esmd = esmd;
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent we) {
		esmd.dispose();
	}
	
}
