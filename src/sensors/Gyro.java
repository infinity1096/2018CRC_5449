package sensors;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem{
	private static double gyro_angle;
	private static ADXRS450_Gyro gyro;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public static double getAngle() {
		gyro_angle = gyro.getAngle();
		return gyro_angle;
		
	}
	
	public void calibrate_gyro() {
		Robot.gyro.calibrate();
	}
	
	
}
