package mandlebrot_Julia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MandlebrotMouse extends JComponent implements ActionListener, MouseListener {

	//Draws mandlebrot sets
	//click on a point with the mouse and it zooms in (by a factor of 2) on that point
	//As zoom increases, program may run slower
	//Feel free to optimize/improve
	
	//was created before OP course covered Object oriented stuff - hence somewhat ugly code at parts
	//feel free to fix this/improve
	
	
	public static double scaleToNX(int max,double offset,double zoom,int n){
		  return ((((double)n-(width/2))/scaleFactor))*(max/zoom)+offset; 
		}
	
	public static double scaleToNY(int max,double offset,double zoom,int n){
		  return ((((double)n-(height/2))/scaleFactor))*(max/zoom)+offset;
		}
	public static int iterations(double r, double im){
		  double xtemp,ytemp,x,y;
		  x=0;
		  y=0;
		  int i = 0;
		  for(i = 0;(x*x +y*y <4)&&(i<iterations);i++){
			  xtemp=x*x-y*y +r;
			  ytemp = 2*x*y + im;
			  if((xtemp==x)&&(ytemp==y)){
				  i = iterations;
				  return i;
			  }
		      x= xtemp;
		      y= ytemp;
			  }
			  return i;
			}
	public static double scale(int n){
	return ((double)n-256)/128;
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Mandlebrot Viewer");
		MandlebrotMouse animation = new MandlebrotMouse();
		window.setUndecorated(true);
		window.add(animation);
		window.pack();
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		window.addMouseListener(animation);

	}
	

	private double centreX = 0;
	private double centreY = 0;
	private static double zoom = 1;
	private static int iterations = 128;
	private static int width = 1366;
	private static int height = 768;
	private static int scaleFactor = Math.min(width, height)/2;

	//Consider using GPU to calculate for pixels - if successful, would be much faster.

	protected void paintComponent(Graphics g) {	
		double redMod = 3;
		double blueMod = 1;
		double greenMod = 4;
		
		int n;
		for (int x=0;x<width;x++){
			for (int y=0;y<height;y++){
				Color c = new Color(0,0,0);			
				n = iterations(scaleToNX(2,centreX,zoom,x),scaleToNY(2,centreY,zoom,y));
				if(n==iterations){
					g.setColor(Color.BLACK);
					g.drawLine(x,y,x,y);	
				} else {
					c = new Color((Math.floorMod((int)(redMod*n), 256)),Math.floorMod((int)(greenMod*n), 256),Math.floorMod((int)(blueMod*n), 256));
					g.setColor(c);
					g.drawLine(x,y,x,y);
				}
			}

	}
		
	}
		

	
		

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		centreX = scaleToNX(2,centreX,zoom,e.getX());
		centreY = scaleToNY(2,centreY,zoom,e.getY());
		zoom = zoom*2;
		iterations = 128*(int)Math.log10(zoom*Math.sqrt(zoom)+10);
		//displays zoom and number of iterations per pixel for testing
		//System.out.println(zoom + " " + iterations);
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


