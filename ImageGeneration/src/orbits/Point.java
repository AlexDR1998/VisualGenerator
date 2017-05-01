package orbits;

public class Point {

	public static int[] e = new int[5];
	public Point(int[] e){
		this.e=e;
	}
	public int getX(){
		return e[0];
	}
	public int getY(){
		return e[1];
	}
	public int getdX(){
		return e[2];
	}
	public int getdY(){
		return e[3];
	}
	public int getd2y(){
		return e[4];
	}
	public int getd2x(){
		return e[5];
		
	}
	
	public void setLocation(int x, int y){
		e[0]=x;
		e[1]=y;
	}
	public void setSpeed(int dx, int dy){
		e[2]=dx;
		e[3]=dy;
	}
	public void setAcceleration(int ddx, int ddy){
		e[4]=ddx;
		e[5]=ddy;
	}
	
	public void move(){
		e[2]+=e[4];
		e[3]+=e[5];
		e[0]+=e[2];
		e[1]+=e[3];
		
	}
}
