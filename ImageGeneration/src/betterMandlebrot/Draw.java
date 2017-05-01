package betterMandlebrot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import templates.SuperDraw;

public class Draw extends SuperDraw{

	public static int redMod,greenMod,blueMod;
	
	
	public static double xCentre = window.getWidth()/2;
	public static double yCentre = window.getHeight()/2;
	
	public static double zoom = 1;
	public static Draw drawing = new Draw();
	public static int maxIterations = 128;
	
	
	public void paint(Graphics g){	
		int[][] screenMatrix = new int[window.getWidth()][window.getHeight()];
		screenMatrix = Calculate.iterateToPlane();
		for(int x=0;x<window.getWidth();x++){
			for(int y=0;y<window.getHeight();y++){
				g.setColor(colorMod(screenMatrix[x][y]));
				g.drawLine(x, y, x, y);
				
			}
			
		}
		
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, 100, 200);
		//SuperDraw.drawToScreen();
	}
	
	public static Color colorMod(int n){
		return new Color((Math.floorMod((int)(redMod*n), 256)),Math.floorMod((int)(greenMod*n), 256),Math.floorMod((int)(blueMod*n), 256));
	}
	
	public void mouseClicked(MouseEvent arg0){
		double[] coords = new double[2];
		coords = Calculate.scale(arg0.getX(), arg0.getY());
		xCentre=coords[0];
		yCentre=coords[1];
		zoom=zoom*2;
		maxIterations = 128*(int)Math.log10(zoom*Math.sqrt(zoom)+10);
		repaint();
		
	}

	
	public static void main(String[] args){
		redMod = Integer.parseInt(args[0]);
		greenMod = Integer.parseInt(args[1]);
		blueMod = Integer.parseInt(args[2]);
		drawToScreen(drawing);
	}
}
