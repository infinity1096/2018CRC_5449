package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.RobotMap;
import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import command.Lift_remote;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem{
	TalonSRX Liftmotor_rightback,Liftmotor_leftback,Liftmotor_leftfront,Liftmotor_rightfront;
	public Solenoid lock;
	private int current_status = 0;//0 for down,1 for mid,2 for up
	private Encoder encoder;
	//private Encoder lifter_encoder;
	public Lifter(){
		Liftmotor_leftback = new TalonSRX(RobotMap.LIFTER_MOTOR_LEFTBACK_PORT);
		Liftmotor_rightback = new TalonSRX(RobotMap.LIFTER_MOTOR_RIGHTBACK_PORT);
		Liftmotor_leftfront = new TalonSRX(RobotMap.LIFTER_MOTOR_LEFTFRONT_PORT);
		Liftmotor_rightfront = new TalonSRX(RobotMap.LIFTER_MOTOR_RIGHTFRONT_PORT);
		Liftmotor_rightback.setInverted(true);
		Liftmotor_leftback.setInverted(true);
		lock = new Solenoid(RobotMap.PCM_PORT,RobotMap.LIFTER_LOCK_PORT);
		encoder = new Encoder(RobotMap.LIFTER_ENCODER_A,RobotMap.LIFTER_ENCODER_B);
		encoder.setReverseDirection(true);
	}
	
	//moves lifter
	 public void move(double Power){
		Liftmotor_leftfront.set(ControlMode.PercentOutput,Power);
		Liftmotor_rightfront.set(ControlMode.PercentOutput,Power);
		Liftmotor_leftback.set(ControlMode.PercentOutput,Power);
		Liftmotor_rightback.set(ControlMode.PercentOutput,Power);
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
	 
	public void stop(){
		Liftmotor_rightback.set(ControlMode.PercentOutput,0);
		Liftmotor_leftback.set(ControlMode.PercentOutput,0);
		Liftmotor_rightfront.set(ControlMode.PercentOutput,0);
		Liftmotor_leftfront.set(ControlMode.PercentOutput,0);
	}
	
	//change status
	public void setStatus(int Status){
		if (Status >=0 && Status <=3){
			this.current_status = Status;
		}
	}
	public int getStatus(){
		return this.current_status;
	}
	
	//read sensors
	
	public int getPosition(){
		int val = this.encoder.get();
		return val;
	}
	
	
	
	public boolean is_down(){
		return (Math.abs(this.getPosition() - RobotMap.LIFTER_DOWN_POSE) < 20);
	}
	
	
	public void ResetEncoders(){
		encoder.reset();
	}
	
	public void Lock() {
		this.lock.set(false);
	}
	
	public void UnLock() {
		this.lock.set(true);
	}
	
	
	@Override
	protected void initDefaultCommand() {	
		this.setDefaultCommand(new Lift_remote());
	}
	

}

