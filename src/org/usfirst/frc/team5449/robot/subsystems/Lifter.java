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
	TalonSRX Liftmotor_1,Liftmotor_2,Liftmotor_3,Liftmotor_4;
	Solenoid lock;
	private int current_status = 0;//0 for down,1 for mid,2 for up
	private Encoder encoder;
	//private Encoder lifter_encoder;
	public Lifter(){
		Liftmotor_1 = new TalonSRX(RobotMap.LIFTER_MOTOR_1_PORT);
		Liftmotor_2 = new TalonSRX(RobotMap.LIFTER_MOTOR_2_PORT);
		Liftmotor_3 = new TalonSRX(RobotMap.LIFTER_MOTOR_3_PORT);
		Liftmotor_4 = new TalonSRX(RobotMap.LIFTER_MOTOR_4_PORT);
		Liftmotor_1.setInverted(true);
		Liftmotor_2.setInverted(true);
		lock = new Solenoid(RobotMap.PCM_PORT,RobotMap.LIFTER_LOCK_PORT);
		encoder = new Encoder(RobotMap.LIFTER_ENCODER_A,RobotMap.LIFTER_ENCODER_B);		
	}
	
	//moves lifter
	 public void move(double Power){
		Liftmotor_1.set(ControlMode.PercentOutput,Power);
		Liftmotor_2.set(ControlMode.PercentOutput,Power);
		Liftmotor_3.set(ControlMode.PercentOutput,Power);
		Liftmotor_4.set(ControlMode.PercentOutput,Power);
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
		Liftmotor_1.set(ControlMode.PercentOutput,0);
		Liftmotor_2.set(ControlMode.PercentOutput,0);
		Liftmotor_3.set(ControlMode.PercentOutput,0);
		Liftmotor_4.set(ControlMode.PercentOutput,0);
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

