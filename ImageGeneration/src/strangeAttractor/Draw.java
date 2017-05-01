package strangeAttractor;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Draw extends Component{
	
	
	
	
	public void paint(Graphics g){
		g.fillRect(0, 0, 100, 100);
	}
	
	//note to self, use java 3D libraries
	
	public static JFrame window = new JFrame("Strange Attractor");
	
	public static void main(String[] args){
		
		Draw drawing = new Draw();
		window.add(drawing);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
	}
	
	
}
