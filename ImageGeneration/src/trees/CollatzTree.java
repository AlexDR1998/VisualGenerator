package trees;

public class CollatzTree {

	public static int xCoord, yCoord, n=1;
	
	
	public static void iterate(int n){
		if((n-1)%3==0){
			//Draw.xCoord = 
			iterate((n-1)/3);
		}
	}
}
