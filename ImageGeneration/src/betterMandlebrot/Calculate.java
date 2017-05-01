package betterMandlebrot;

public class Calculate {

	//performs necessary arithmetic to draw a mandlebrot set
	
	public static int h = Draw.window.getHeight();
	public static int w = Draw.window.getWidth();
	
	
	public static int iterations(double[] ns, double[] c){
		
		//Method for iterating a single pixel to see how many iterations are necessary to escape beyond r=2
		//If a pixel does not escape within this finite number of iterations, it is treated as if in the Mandelbrot set
		
		int i;
		double temp0, temp1;
		double past0, past1;
		for(i=0;i<Draw.maxIterations;i++){
			//double temp;
			
			
			temp0 = ns[0]*ns[0]-ns[1]*ns[1] +c[0];
			temp1 = 2*ns[0]*ns[1] +c[1];
			
			if((ns[0]==temp0)&&(ns[1]==temp1)){
				return 256;
			}
			
			
			ns[0] = temp0;
			ns[1] = temp1;
			if(Math.sqrt(ns[0]*ns[0]+ns[1]*ns[1])>2){
				return i;
			}
		}
		return 256;
	}
	
	public static int[][] iterateToPlane(){
		
		//Iterates the pixel iteration method over every pixel
		//converts pixel x and y coordinates into suitable numbers first, using the scale method
		int[][] screen = new int[w][h];
		double[] z = new double[2];
		double[] c = new double[2];
		for(int x=0;x<w;x++){
			for(int y=0;y<h;y++){
				c = scale(x,y);
				z[0]=0;
				z[1]=0;
				screen[x][y] = iterations(z,c);
			}
		}
		return screen;
	}
	
	public static double[] scale(int x, int y){
		
		//takes a pair of coordinates (of a pixel) and scales it appropriately to numbers on the complex plain where r<2
		//Also takes into account zoom and translation
		double[] n = new double[2];
		int scaleFactor = Math.min(w, h);
		n[0] = ((double)x*2-w)*2/(scaleFactor*Draw.zoom)+Draw.xCentre;
		n[1] = ((double)y*2-h)*2/(scaleFactor*Draw.zoom)+Draw.yCentre;
		return n;
		//return ((doublen-width/2)/scaleFactor)*(max/zoom)+offset;
		//return ((((double)n-(height/2))/scaleFactor))*(max/zoom)+offset;
	}
	
}
