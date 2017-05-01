package automata2;

import java.util.Random;

public class Rule {

	public static int[] r = new int[Grid.power];
	public static double density=0.35;
	
	
	public Rule(int[] r){
		this.r=r;
	}
	public void randomRule(){
		Random ran = new Random();
		for(int i=0;i<r.length;i++){
			if(Math.random()<density){
				this.r[i]=ran.nextInt(Grid.states);
			} else {
				this.r[i]=0;
			}
			
		}
	}
	

	public String toString(){
		String s = "";
		for(int i=0;i<r.length;i++){
			s = s+this.r[i];
		}
		return s;
	}

}
