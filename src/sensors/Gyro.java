package sensors;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro{
	private static double gyro_angle;

	
	public Gyro() {
		
	}
	
	public static double getAngle() {
		gyro_angle = Robot.gyro.getAngle();
		return gyro_angle;
		
	}
	
	public void calibrate_gyro() {
		Robot.gyro.calibrate();
	}
	
	
	
}
