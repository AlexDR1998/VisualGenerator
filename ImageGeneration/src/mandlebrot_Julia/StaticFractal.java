package mandlebrot_Julia;
import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class StaticFractal extends Component {
	
	public static double scaleToNX(int max,double offset,double zoom,int n){
		  double nd;
		  nd = ((((double)n-683)/384))*(max/zoom)+offset;
		  return nd;
		}
	
	public static double scaleToNY(int max,double offset,double zoom,int n){
		  double nd;
		  nd = ((((double)n-384)/384))*(max/zoom)+offset;
		  return nd;
		}
		
		
		
	//Code for iterations using complex class

	public static int iterationsC(Complex c, double rSeed, double imSeed){  
	  Complex z = new Complex(0,0);
	  int i = 0;
	  for(i = 0;(z.abs()<2)&&(i<512);i++){
		  z = (z.times(z)).plus(c);		  
		  }
		  return i;
		}
	
	//Code for iterations without using complex class
	
	public static int iterations(double r, double im, double rSeed, double imSeed){
		  double xtemp,ytemp,x,y;
		  x=0;
		  y=0;
		  int i = 0;
		  for(i = 0;(x*x +y*y <4)&&(i<1024);i++){
			  xtemp=x*x-y*y +r;
			  ytemp = 2*x*y + im;
			  if((xtemp==x)&&(ytemp==y)){
				  return i;
			  }
		      x= xtemp;
		      y= ytemp;
			  }
			  return i;
			}	
	
	public static int iterationsJ(double r, double im, double rSeed, double imSeed){
		  double xNext,yNext,x,y;
		  x=r;
		  y=im;
		  int i = 0;
		  for(i = 0;(x*x +y*y <4)&&(i<1024);i++){
			  xNext = x*x-y*y +rSeed;
			  yNext = 2*y*x +imSeed;
			  if((xNext==x)&&(yNext==y)){
				  return i;
			  }
			  x = xNext;
			  y = yNext;
			  }
			  return i;
			}	
	public static int iterationsJC(Complex z, double rSeed, double imSeed){
		  
		  Complex c = new Complex(rSeed, imSeed);
		  int i = 0;
		  for(i = 0;(z.abs()<2)&&(i<512);i++){
			  z = (((z.times(z)).cos()).times(z)).plus(c);		  
			  }
			  return i;
			}
		public void paint(Graphics g) {
			
			//code that calls the iterations function for each pixel
			//number of iterations determines colour of pixel
			Graphics2D g2d = (Graphics2D) g;
			double zoom = 30;
			double centreX = -0.54;		//-0.492;		
			double centreY = 0.095;		
			double rSeed = -0.7269;			
			double imSeed = 0.1889;		
			double redMod = -0.25;
			double blueMod = 0;
			double greenMod = 0;
			int n;
			Complex a = new Complex(0,0);
			for (int x=0;x<1366;x++){
				for (int y=0;y<768;y++){
					Color c = new Color(0,0,0);
					//edit the following lines to change which function is iterated.
					//functions ending in C use a complex number class, and take significantly longer to run
				    
					a.re = scaleToNX(2,centreX,zoom,x);
				    a.im = scaleToNY(2,centreY,zoom,y);
				    //(scaleToN(2,centreX,zoom,x),scaleToN(2,centreY,zoom,y))
				    //n = iterationsC(a,rSeed,imSeed);
					n = iterationsJ(scaleToNX(2,centreX,zoom,x),scaleToNY(2,centreY,zoom,y),rSeed,imSeed);
					
					//if(n==512){
					//	g.setColor(Color.BLACK);
					//	g.drawLine(x,y,x,y);	
					//} else {
						c = new Color((Math.floorMod((int)(redMod*n), 256)),Math.floorMod((int)(greenMod*n), 256),Math.floorMod((int)(blueMod*n), 256));
						g.setColor(c);
						g.drawLine(x,y,x,y);
					//}
				}
			}
			
			
			}

	public static void main(String[] args) {
		
		int frameWidth = 1366;
		int frameHeight = 768;
		javax.swing.JFrame frame = new javax.swing.JFrame(); 
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.getContentPane().add(new StaticFractal());
		
	}

}
