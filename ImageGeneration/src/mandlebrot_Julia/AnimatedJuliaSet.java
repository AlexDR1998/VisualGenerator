package mandlebrot_Julia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Date;

import javax.swing.*;


//The x and y coordinates of the mouse pointer feed into the julia set generating algorithm.
//Movement of the mouse results in pretty moving patterns

//was created before OP course covered Object oriented stuff - hence somewhat ugly code at parts
//feel free to fix this/improve


public class AnimatedJuliaSet extends JComponent implements ActionListener, MouseMotionListener {

	public static double scaleToNX(int max,double offset,double zoom,int n){
		  return ((((double)n-683)/384))*(max/zoom)+offset; 
		}
	
	public static double scaleToNY(int max,double offset,double zoom,int n){
		  return ((((double)n-384)/384))*(max/zoom)+offset;
		}
	public static int iterationsJ(double r, double im, double rSeed, double imSeed) {
		double xNext, yNext, x, y;
		x = r;
		y = im;
		int i = 0;
		for (i = 0; (x * x + y * y < 4) && (i < iterations); i++) {
			xNext = x * x - y * y + rSeed;
			yNext = 2 * y * x + imSeed;
			if ((xNext == x) && (yNext == y)) {
				return i;
			}
			x = xNext;
			y = yNext;
		}
		return i;
	}

	public static double scale(int n){
	return ((double)n-256)/128;
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Moving Fractals");
		AnimatedJuliaSet animation = new AnimatedJuliaSet();
		window.setUndecorated(true);
		window.add(animation);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		window.addMouseMotionListener(animation);

	}
	

	private double centreX = 0;
	private double centreY = 0;
	private double zoom = 2;
	private double rSeed = 0;
	private double imSeed = 0;
	private static int iterations = 100;

	protected void paintComponent(Graphics g) {	
		double redMod = 3;
		double blueMod = 9;
		double greenMod = 5;
		
		int n;
		Color c = new Color(0,0,0);	
		Date time1 = new Date();
		for (int x=0;x<1366;x++){
			for (int y=0;y<768;y++){
						
				n = iterationsJ(scaleToNX(2,centreX,zoom,x),scaleToNY(2,centreY,zoom,y),rSeed,imSeed);	
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
		Date time2 = new Date();
		long timeDiff = time2.getTime() - time1.getTime();
		System.out.println("Time=" + timeDiff + "ms");
		
	}
		

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		rSeed = scaleToNX(2,centreX,zoom,e.getX());
		imSeed = scaleToNY(2,centreY,zoom,e.getY());
		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
