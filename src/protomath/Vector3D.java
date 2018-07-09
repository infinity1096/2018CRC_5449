package protomath;


public class Vector3D {
	private double x,y,z;
	
	public Vector3D(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double[] getvals() {
		double[] val_ = {x,y,z};
		return val_;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double dot(Vector3D v2) {
		return x * v2.getX() + y * v2.getY() + z * v2.getZ();
	}
	
	public Vector3D cross(Vector3D v2) {
		return new Vector3D(
				y * v2.getZ() - z * v2.getY(),
				z * v2.getX() - x * v2.getZ(),
				x * v2.getY() - y * v2.getX());
	}
	
}
