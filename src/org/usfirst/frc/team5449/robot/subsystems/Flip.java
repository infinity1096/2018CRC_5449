package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import command.Flip_remote;
import command.Lift_remote;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flip extends Subsystem{
    TalonSRX FlipMotor;
    
    private Encoder flip_encoder;
    private double power;
    private int current_status = 0;
    
	public Flip() {
		FlipMotor = new TalonSRX(RobotMap.FLIP_PORT);
		
		flip_encoder = new Encoder(RobotMap.FLIP_ENCODER_A,RobotMap.FLIP_ENCODER_B);
		
		
	}
	
	public void move(double power) {
		power = this.power;
		FlipMotor.set(ControlMode.PercentOutput,power);
		
		
	}
	
	public void stop() {
		power = this.power;
		FlipMotor.set(ControlMode.PercentOutput,0);
	}
	
	
	
	@Override
	protected void initDefaultCommand() {	
		this.setDefaultCommand(new Flip_remote());
	}
	

}
