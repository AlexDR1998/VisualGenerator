package automata;

import java.awt.Color;
import java.awt.Graphics;

import templates.SuperDraw;

public class Draw extends SuperDraw{

	public static int rule;
	public static Draw drawing = new Draw();
	
	
	public void paint(Graphics g){
		
		boolean screenMatrix[][] = new boolean[window.getHeight()][window.getWidth()];
		screenMatrix = Rule.iterate();
		for(int x=0;x<window.getWidth();x++){
			for(int t=0;t<window.getHeight();t++){
				if(screenMatrix[t][x]){
					g.setColor(Color.RED);
				//} else if(screenMatrix[t-1][x]&&screenMatrix[t][Math.floorMod(x+1, window.getWidth())]){
				//	g.setColor(Color.BLUE);
				//} else if(screenMatrix[t-1][Math.floorMod(x+1, window.getHeight())]&&screenMatrix[t][Math.floorMod(x-1, window.getWidth())]){
				//	g.setColor(Color.RED);
				} else {
				
					g.setColor(Color.BLACK);
				}
			g.drawLine(x, t, x, t);
			
			}
		}
		
		//g.fillRect(0, 0, 100, 200);
	}
	public static void main(String[] args) {
		rule = Integer.parseInt(args[0]);
		
		
		drawToScreen(drawing);

	}

}
