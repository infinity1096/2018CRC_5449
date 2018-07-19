package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	private TalonSRX LeftIntake;
	private TalonSRX RightIntake;
	private TalonSRX Flip;
	
	private Solenoid IntakeCylinder;
	public Compressor compressor;
	
	private Encoder FlipEncoder;
	
	public Intake() {
		LeftIntake = new TalonSRX(RobotMap.INTAKE_LEFT_MOTOR_PORT);
		RightIntake = new TalonSRX(RobotMap.INTAKE_RIGHT_MOTOR_PORT);
		RightIntake.setInverted(true);
		Flip = new TalonSRX(RobotMap.INTAKE_MOTOR_PORT);
		Flip.setInverted(true);
		IntakeCylinder = new Solenoid(RobotMap.PCM_PORT,RobotMap.INTAKE_CYLINDER_PORT);
		compressor = new Compressor(RobotMap.PCM_PORT);
		FlipEncoder = new Encoder(RobotMap.INTAKE_ENCODER_A,RobotMap.INTAKE_ENCODER_B);
	}
	
	
	public void reset() {
		this.FlipEncoder.reset();
	}
	
	public long get() {
		return this.FlipEncoder.get();
	}
	
	public void Close() {
		IntakeCylinder.set(false);
	}
	
	public void Open() {
		IntakeCylinder.set(true);
	}
	
	public void In() {
		LeftIntake.set(ControlMode.PercentOutput, RobotMap.INTAKE_INTAKE_IN_POWER);
		RightIntake.set(ControlMode.PercentOutput, RobotMap.INTAKE_INTAKE_IN_POWER);
		
	}
	
	public void stop() {
		LeftIntake.set(ControlMode.PercentOutput, 0);
		RightIntake.set(ControlMode.PercentOutput, 0);
		
	}
	
	public void Out() {
		LeftIntake.set(ControlMode.PercentOutput, -RobotMap.INTAKE_INTAKE_OUT_POWER);
		RightIntake.set(ControlMode.PercentOutput, -RobotMap.INTAKE_INTAKE_OUT_POWER);
		
	}
	
	public void HOLD() {
		LeftIntake.set(ControlMode.PercentOutput, RobotMap.INTAKE_INTAKE_HOLD_POWER);
		RightIntake.set(ControlMode.PercentOutput, RobotMap.INTAKE_INTAKE_HOLD_POWER);
		
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
