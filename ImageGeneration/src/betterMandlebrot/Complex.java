package betterMandlebrot;

public class Complex {

	
	public double[] ns = new double[2];
	public Complex(double[] ns){
		this.ns=ns;
	}
	
	public void setRect(double re, double im){
		this.setRe(re);
		this.setIm(im);
	}
	public void setRe(double re){
		ns[0]=re;
	}
	public void setIm(double input){
		ns[1]=input;
	}
	public void setPolar(double arg, double mod){
		this.setRe(Math.cos(arg)*mod);
		this.setIm(Math.sin(arg)*mod);
	}
	
	public double getReal(){
		return ns[0];
	}
	public double getImaginary(){
		return ns[1];
	}
	public double[] getComponents(){
		return ns;
	}
	public double getArg(){
		return Math.tan(ns[1]/ns[0]);
	}
	public double getMod(){
		return Math.sqrt(ns[0]*ns[0]+ns[1]*ns[1]);
	}
	
	
	
	public void square(){
		double temp;
		temp = ns[0]*ns[0]-ns[1]*ns[1];
		ns[1] = 2*ns[0]*ns[1];
		ns[0] = temp;
	}
	public void add(Complex a){
		this.ns[0] += a.getReal();
		this.ns[1] += a.getImaginary();
	}
	public void addR(double re){
		this.ns[0] += re;
	}
	public void addIm(double im){
		this.ns[1] += im;
	}
	public void exp(){
		double temp;
		temp = Math.exp(ns[0])*Math.cos(ns[0]);
		ns[1]= Math.exp(ns[0])*Math.sin(ns[1]);
		ns[0]= temp;
	}
	
	
}
