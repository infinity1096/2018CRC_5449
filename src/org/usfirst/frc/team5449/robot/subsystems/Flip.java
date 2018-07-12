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
    private int current_status = 0;//0 for front, 1 for mid, 2 for back
    
	public Flip() {
		FlipMotor = new TalonSRX(RobotMap.FLIP_PORT);
		
		flip_encoder = new Encoder(RobotMap.FLIP_ENCODER_A,RobotMap.FLIP_ENCODER_B);
		
		
	}
	
	public void move(double power) {
		power = this.power;
		FlipMotor.set(ControlMode.PercentOutput,power);
		
		
	}
	
	public void stop() {
		FlipMotor.set(ControlMode.PercentOutput,0);
	}
	
	public int get_position_flip(){
		int val = flip_encoder.get();
		return val;
	}

	public int[] get_position_flip2(){
		int[] val = {flip_encoder.get()};
		return val;
	}
	
	@Override
	protected void initDefaultCommand() {	
		this.setDefaultCommand(new Flip_remote());
	}
	

}
