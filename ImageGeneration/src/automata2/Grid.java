package automata2;

import java.awt.Toolkit;
import java.util.Random;

public class Grid {

	public static int neighbor = 5;
	public static int states = 8;
	public static int power = (int) Math.pow(states, neighbor);
	public static int h = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int w = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static double density=0.7;
	
	public static int[][] matrix = new int[h][w];
	
	public Grid(int[][] matrix){
		this.matrix=matrix;
	}
	
	public static int nAtPixel(int t, int x){
		int rulePos = 0;
		int f=(neighbor-1)/2;
		for(int i=0;i<neighbor;i++){
			rulePos +=matrix[t-1][Math.floorMod(x+i-f,w)]*Math.pow(states, i);
		}
		return Rule.r[rulePos];
	}

	public void initRand(){

		Random rand = new Random();
		
		for(int x=0;x<w;x++){
			if(Math.random()<density){
				matrix[0][x] = rand.nextInt(states);
			} else {
				matrix[0][x]=0;
			}
			
		}
		
	}
	public void initClump(){
		Random rand = new Random();
		
		for(int x=0;x<w;x++){
			if(Math.random()<density){
				matrix[0][x] = rand.nextInt(states);
			} else {
				matrix[0][x]=0;
			} if(matrix[0][x]==0){
				x+=rand.nextInt(neighbor*neighbor);
			}
			
		}
	}
	public void initSingle(){
		matrix[0][w/2]=states-1;
	}
	
	public void iterate(){
		for(int t=1;t<h;t++){
			for(int x=0;x<w;x++){
				matrix[t][x]=nAtPixel(t,x);
			}
		}
	}
	
	public static int getInt(int t, int x){
		return matrix[t][x];
	}
	
	
}
