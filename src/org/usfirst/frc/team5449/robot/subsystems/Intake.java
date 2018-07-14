package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	private TalonSRX LeftIntake;
	private TalonSRX RightIntake;
	private TalonSRX Flip;
	
	private Solenoid IntakeCylinder;
	public Compressor compressor;
	
	
	public Intake() {
		LeftIntake = new TalonSRX(RobotMap.INTAKE_LEFT_MOTOR_PORT);
		RightIntake = new TalonSRX(RobotMap.INTAKE_RIGHT_MOTOR_PORT);
		Flip = new TalonSRX(RobotMap.INTAKE_MOTOR_PORT);
		IntakeCylinder = new Solenoid(RobotMap.PCM_PORT,RobotMap.INTAKE_CYLINDER_PORT);
		compressor = new Compressor(RobotMap.PCM_PORT);
	}
	
	public void Close() {
		
	}
	
	public void Open() {
		
	}
	
	public void In() {
		
	}
	
	public void Out() {
		
	}
	
	public void Move_flip(double power) {
		Flip.set(ControlMode.PercentOutput, power);
	}
	
	public void Stop_flip() {
		Flip.set(ControlMode.PercentOutput, 0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	private double range(double val,double min,double max){
    	if (val < min){
    		return min;
    	}else if (val > max){
    		return max;
    	}else{
    		return val;
    	}
    }
	
}
