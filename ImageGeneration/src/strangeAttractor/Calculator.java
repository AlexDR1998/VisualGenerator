package strangeAttractor;



public class Calculator {

	
	double x,y,z;

	public static double dx,dy,dz;
	public static double P = 10;
	public static double R = 28;
	public static double B = 8/3;
	
	
	
	
	

	
	public static double[] xs = {1,2,3};
	public static double[] ys = {2,4,6};
	
	public static Vector v = new Vector(xs);
	public static Vector w = new Vector(ys);
	//public Vector q = new Vector(1,1,0);
	
	
	
	
	
	
	
	public static void main(String[] args){
	
		v.setVectorProduct(w);
		System.out.println(v.magnitude());
		
		
	
		
	}
	
}
