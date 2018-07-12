package sensors;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem{
	private double gyro_angle;
	private ADXRS450_Gyro gyro;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public double read_gyro() {
		gyro_angle = gyro.getAngle();
		return 0;
		
	}
	
	public void calibrate_gyro() {
		Robot.gyro.calibrate();
	}
	
	
}
