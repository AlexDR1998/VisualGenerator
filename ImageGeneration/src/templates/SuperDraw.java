package templates;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class SuperDraw extends Component implements ActionListener, MouseMotionListener, MouseListener{
	
	
	
	@Override
	public void paint(Graphics ga){
		ga.drawRect(0, 0, 100, 100);
	}
	public static JFrame window = new JFrame("insert name here");
	public static SuperDraw drawing = new SuperDraw();
	
	public static void drawToScreen(SuperDraw drawing){
		
		window.setUndecorated(true);
		window.add(drawing);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		window.addMouseListener(drawing);
		
	}
	public static void main(String[] args){
		drawToScreen(drawing);
		
		
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}