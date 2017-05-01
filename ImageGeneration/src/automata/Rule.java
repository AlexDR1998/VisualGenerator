package automata;

import java.util.Random;

public class Rule {

	public static boolean[][] screen = new boolean[Draw.window.getHeight()][Draw.window.getWidth()];
	public static double density = 0.01;
	
	private static void initialiseRand(){
		double rand;
		for(int i=0;i<Draw.window.getWidth();i++){
			rand=Math.random();
			screen[0][i]=(rand<density);
		}
	}
	private static void initialiseOrdered(){
		for(int i=0;i<Draw.window.getWidth();i++){
			screen[0][i] = (Math.floorMod(i, 100)==0);
		}
	}

	private static void initialiseSingle(){
		screen[0][Draw.window.getWidth()/2]=true;
	}
	
	
	public static boolean[][] iterate(){
		//initialiseSingle();
		initialiseRand();
		//initialiseOrdered();
		boolean[] rule = new boolean[7];
		rule = toBinary(Draw.rule);
		//rule[0] -> 111
		//rule[1] -> 110
		//rule[2] -> 101
		//rule[3] -> 100
		//rule[4] -> 011
		//rule[5] -> 010
		//rule[6] -> 001
		//rule[7] -> 000
		
		int w = Draw.window.getWidth();
		for(int t=1;t<Draw.window.getHeight();t++){
			for(int x=0;x<w;x++){
				
				
				if(screen[t-1][Math.floorMod(x-1, w)]){
					if(screen[t-1][x]){
						if(screen[t-1][Math.floorMod(x+1, w)]){
							screen[t][x]=rule[0];
						} else {
							screen[t][x]=rule[1];
						}
					} else {
						if(screen[t-1][Math.floorMod(x+1, w)]){
							screen[t][x]=rule[2];
						} else {
							screen[t][x]=rule[3];
						}
					} 
				} else {
					if(screen[t-1][x]){
						if(screen[t-1][Math.floorMod(x+1, w)]){
							screen[t][x]=rule[4];
						} else {
							screen[t][x]=rule[5];
						}
					} else {
						if(screen[t-1][Math.floorMod(x+1, w)]){
							screen[t][x]=rule[6];
						} else {
							screen[t][x]=rule[7];
						}
					} 		
				}
			}
		}
		return screen;
	}
	

	
		
	
	
	private static boolean[] toBinary(int n){
		boolean[] b2 = new boolean[8];
	
		for(int i=0;i<8;i++){
			b2[7-i]=(1 << i & n) != 0;
		}
		return b2;
		
		
		
	}
	
	
	
	public static void main(String[] args){
		//boolean[] b = new boolean[7];
		//b = toBinary(90);
		//for(int i=0;i<8;i++){
		//	if(b[i]){
		//	System.out.print("1");
		//	} else {
		//		System.out.print("0");
		//	}
		//}
		
		
		//System.out.println(b.toString());
	}

	
}
