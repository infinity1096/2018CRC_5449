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
		left_middle = new TalonSRX(RobotMap.LEFT_MIDDLE_MOTOR_PORT);
		left_back = new TalonSRX(RobotMap.LEFT_BACK_MOTOR_PORT);
		right_front = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR_PORT);
		right_middle = new TalonSRX(RobotMap.RIGHT_MIDDLE_MOTOR_PORT);
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
	public void driver(double x,double y) {
		double lp=range((y+x)/2,-1,1);
		double rp=range((y-x)/2,-1,1);
		left_front.set(ControlMode.PercentOutput, lp);
		left_middle.set(ControlMode.PercentOutput, lp);
		left_back.set(ControlMode.PercentOutput, lp);
		right_front.set(ControlMode.PercentOutput, rp);
		right_middle.set(ControlMode.PercentOutput, rp);
		right_back.set(ControlMode.PercentOutput, rp);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
