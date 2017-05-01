package sandpile;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Draw extends Component{
	
	
	
	public static JFrame window = new JFrame("Sandpile");
	public static int res = 1;
	public static double zoom = 2;
	public void paint(Graphics g){
		Date time1 = new Date();
		ScreenMatrix.Initialise();
		ScreenMatrix.Iterate(1000000);
		Date time2 = new Date();
		long timeDiff = time2.getTime() - time1.getTime();
		System.out.println("Time=" + timeDiff + "ms");
		long cnum;
		int xPoint,yPoint = 0;
		for(int i=0;i<Draw.window.getWidth();i++){
			for(int j=0;j<Draw.window.getHeight();j++){
				
				
				xPoint=scale(i,zoom,ScreenMatrix.x);
				yPoint=scale(j,zoom,ScreenMatrix.y);
				
				
				cnum = Math.floorMod((ScreenMatrix.screen[i][j]), 3);
				if(ScreenMatrix.screen[i][j]==0){
					g.setColor(Color.black);
					g.fillRect(xPoint, yPoint, res, res);
				} else if(cnum==0){
					g.setColor(Color.red);
					g.fillRect(xPoint, yPoint, res, res);
				} else if(cnum==1){
					g.setColor(Color.blue);
					g.fillRect(xPoint, yPoint, res, res);
				} else if(cnum==2){
					g.setColor(Color.green);
					g.fillRect(xPoint, yPoint, res, res);
				}
			}
		}
	}
	
	public static int scale(int n,double scale, int centre){
		res = (int)scale;
		if(res<1){
			res=1;
		}
		//return (n-centre/2)*scale+centre/2;
		return (int)(scale*n +(1-scale)*centre/2);
	}
	
	public int getWidth(){
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
	
	public int getHeight(){
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	
	
	public static void main(String[] args){
		
		
		Draw drawing = new Draw();
		window.add(drawing);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//System.out.println(window.getHeight());
		
		
	}
	
	
}