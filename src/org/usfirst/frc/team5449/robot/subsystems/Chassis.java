package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem{

	TalonSRX left_front;
	TalonSRX left_middle;
	TalonSRX left_back;
	TalonSRX right_middle;
	TalonSRX right_front;
	TalonSRX right_back;
	
	public Chassis() {
		left_front = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR_PORT);
		left_middle = new TalonSRX(RobotMap.LEFT_MID_MOTOR_PORT);
		left_back = new TalonSRX(RobotMap.LEFT_BACK_MOTOR_PORT);
		right_front = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR_PORT);
		right_middle = new TalonSRX(RobotMap.RIGHT_MID_MOTOR_PORT);
		right_back = new TalonSRX(RobotMap.RIGHT_BACK_MOTOR_PORT);
	}
	
	public double range(double value,double min, double max) {
		if (value>=max)
			return max;
		else if (value<=min)
			return min;
		else
			return value;
	}
	
	public void ArcadeDrive(double x,double y) {
		double leftpower = range((y+x)/2,-1,1);
		double rightpower = range((y-x)/2,-1,1);
		
		left_front.set(ControlMode.PercentOutput, leftpower);
		left_middle.set(ControlMode.PercentOutput, leftpower);
		left_back.set(ControlMode.PercentOutput, leftpower);
		right_front.set(ControlMode.PercentOutput, rightpower);
		right_middle.set(ControlMode.PercentOutput, rightpower);
		right_back.set(ControlMode.PercentOutput, rightpower);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
