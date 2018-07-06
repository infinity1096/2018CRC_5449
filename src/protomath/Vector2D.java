package protomath;

public class Vector2D {
	private double x;
	private double y;
	
	public Vector2D(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public double[] getvals() {
		double[] val_ = {this.x,this.y};
		return val_;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double dot(Vector2D v2) {
		return x * v2.getX() + y * v2.getY();
	}
	
}
