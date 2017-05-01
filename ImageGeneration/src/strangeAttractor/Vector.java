package strangeAttractor;

public class Vector {

	double[] e = new double[2];
	public Vector (double[] e){
		this.e=e;
	}
	public double getX(){
		return e[0];
	}
	public double getY(){
		return e[1];
	}
	public double getZ(){
		return e[2];
	}
	public void setVector(double x, double y, double z){
		e[0]=x;
		e[1]=y;
		e[2]=z;
	}
	public void incrementVector(double x, double y, double z){
		e[0]+=x;
		e[1]+=y;
		e[2]+=z;		
	}
	public double scalarProduct(Vector v){
		return e[0]*v.getX() +e[1]*v.getY() +e[2]*v.getZ();
	}
	public void setVectorProduct(Vector v){
		this.setVector(e[1]*v.getZ()-e[2]*v.getY(), e[2]*v.getX()-e[0]*v.getZ(), e[0]*v.getY()-e[1]*v.getX());
	}
	public static Vector returnVectorProduct(Vector w, Vector v){
		double[] p = new double[2];
		p[0] = w.getY()*v.getZ()-w.getZ()*v.getY();
		p[1] = w.getZ()*v.getX()-w.getX()*v.getZ();
		p[2] = w.getX()*v.getY()-w.getY()*v.getX();
		Vector product = new Vector(p);
		return product;
	}
	public void add(Vector v){
		e[0]+=v.getX();
		e[1]+=v.getY();
		e[2]+=v.getZ();
	}
	public void minus(Vector v){
		e[0]-=v.getX();
		e[1]-=v.getY();
		e[2]-=v.getZ();
	}
		
	public double magnitude(){
		return Math.sqrt(e[0]*e[0]+e[1]*e[1]+e[2]*e[2]);
	}
	public void normalize(){
		double m = this.magnitude();
		if(m!=0){
			e[0] = e[0]/m;
			e[1] = e[1]/m;
			e[2] = e[2]/m;
		}
		
	}
	
	public void attract(double p, double r, double b){
	
		//code used for attractors
		double dx,dy,dz;
		dx = p*(e[1]-e[0]);
		dy = r*e[0]-e[1]-e[0]*e[2];
		dz = e[0]*e[1]-b*e[1];
		this.incrementVector(dx, dy, dz);
	}

}
