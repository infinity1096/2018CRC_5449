package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem{

	TalonSRX left_front;
	
	Chassis() {
		left_front = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR_PORT);
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
