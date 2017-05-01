package sandpile;

import java.awt.Window;

public class ScreenMatrix {
	
	
	public static int x = (int) (Draw.window.getWidth());
	public static int y = (int) (Draw.window.getHeight());
	public static long[][] screen = new long[x][y];
	
	public ScreenMatrix(long[][] screen){
		this.screen=screen;
	}
	
	public static void Initialise(){
		//edit this code to adjust the initial conditions for the sandpile
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				screen[i][j]=0;
			}
		}
		screen[x/2][y/2]=100000;
		//screen[x/2+100][y/2]=20000;
		//screen[x/2-100][y/2]=20000;
		
	}
	public static void Iterate(long iterations){
		for(int n=0;n<iterations;n++){
			for(int i=1;i<x-1;i++){
				for(int j=1;j<y-1;j++){
					if(screen[i][j]>3){
						screen[i][j] = screen[i][j]-5;
						screen[i+1][j] += 1;//screen[i][j];
						screen[i-1][j] += 1;//screen[i][j];
						screen[i][j+1] += 1;//screen[i][j];
						screen[i][j-1] += 1;//screen[i][j];
					}				
				}
			}		
		}
	}
	
	
	
	

}
