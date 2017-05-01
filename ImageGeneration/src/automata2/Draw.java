package automata2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import templates.SuperDraw;

public class Draw extends SuperDraw{

	
	public static Draw drawing = new Draw();
	public void paint(Graphics g){
		int [] ns = new int[Grid.power];
		Rule r = new Rule(ns);
		r.randomRule();
		
		
		int [][] xy = new int[(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()][(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()];
		Grid m = new Grid(xy);
		//m.initSingle();
		//m.initRand();
		m.initClump();
		m.iterate();
		for(int t=0;t<window.getHeight();t++){
			for(int x=0;x<window.getWidth();x++){		
				g.setColor(colorSelector(m.getInt(window.getHeight()-1-t, x)));
				
				//if(m.getInt(t, x)==0){
				//	g.setColor(Color.BLACK);
				//} else {
				//	g.setColor(Color.WHITE);
				//}
				
				g.drawLine(x, t, x, t);
			}
		}
		
		//g.fillRect(0, 0, 200, 200);
	}
	
	public static Color colorSelector(int n){
		if(n==0){
			return Color.BLACK;
		} else if(n==1){
			return Color.WHITE;
		} else if(n==2){
			return Color.RED;
		} else if(n==3){
			return Color.GREEN;
		} else if(n==4){
			return Color.BLUE;
		} else if(n==5){
			return Color.ORANGE;
		} else if(n==6){
			return Color.YELLOW;
		} else if(n==7){
			return Color.MAGENTA;
		} else if(n==8){
			return Color.GRAY;
		} else if(n==9){
			return Color.CYAN;
		} else if(n==10){
			return Color.PINK;
		} else{
			return Color.BLACK;
		}
		
	}
	
	public static void main(String[] args) {
		
		//g.matrix[3][0]=1;
		//g.matrix[3][1]=1;
		//g.matrix[3][2]=1;
		//g.matrix[3][3]=1;
		//g.matrix[3][4]=1;
		
		//for(int i=0;i<4;i++){
		//System.out.println(Grid.nAtPixel(4, 2));
		//}
		//System.out.print(r.toString());
		drawToScreen(drawing);

	}

}
