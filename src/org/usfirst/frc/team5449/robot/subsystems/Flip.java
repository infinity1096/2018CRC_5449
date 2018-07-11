package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class Flip extends Command{
    TalonSRX FlipMotor;
    
    private double FlipEncoder;
	public Flip() {
		FlipMotor = new TalonSRX(RobotMap.FLIP_PORT);
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
