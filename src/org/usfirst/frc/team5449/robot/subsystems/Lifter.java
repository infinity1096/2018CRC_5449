package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.RobotMap;
import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import command.Lift_remote;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem{
	TalonSRX Liftmotor_1,Liftmotor_2,Liftmotor_3,Liftmotor_4;
	private int current_status = 0;//0 for down,1 for mid,2 for up
	//private Encoder lifter_encoder;
	public Lifter(){
		Liftmotor_1 = new TalonSRX(RobotMap.LIFTER_MOTOR_1_PORT);
		Liftmotor_2 = new TalonSRX(RobotMap.LIFTER_MOTOR_2_PORT);
		Liftmotor_3 = new TalonSRX(RobotMap.LIFTER_MOTOR_3_PORT);
		Liftmotor_4 = new TalonSRX(RobotMap.LIFTER_MOTOR_4_PORT);
		Liftmotor_1.setInverted(true);
		Liftmotor_2.setInverted(true);
		
		
		//lifter_encoder = new Encoder(RobotMap.LIFTER_ENCODER_A,RobotMap.LIFTER_ENCODER_B);
	}
	
	//moves lifter
	 public void move(double Power){
		Liftmotor_1.set(ControlMode.PercentOutput,Power);
		Liftmotor_2.set(ControlMode.PercentOutput,Power);
		Liftmotor_3.set(ControlMode.PercentOutput,Power);
		Liftmotor_4.set(ControlMode.PercentOutput,Power);
	}
	
	public void move(double Power,double delta_power){
		
		Liftmotor_1.set(ControlMode.PercentOutput,range(Power - delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
		Liftmotor_2.set(ControlMode.PercentOutput,range(Power - delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
		Liftmotor_3.set(ControlMode.PercentOutput,range(Power + delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
		Liftmotor_4.set(ControlMode.PercentOutput,range(Power + delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
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
		if (Status >=0 && Status <=2){
			this.current_status = Status;
		}
	}
	
	
	
	
	//whatever
	public int getStatus(){
		return this.current_status;
	}
	
	//read sensors
	/*public int[] get_position2(){
		int[] val = {lifter_encoder.get()};
		return val;
	}
	
	public int get_position(){
		int val = (int)(lifter_encoder_l.get() + lifter_encoder_r.get()) / 2;
		return val;
	}*/
	/*
	public int get_position(){
		int[] val = {Robot.lifter_encoder.get()};
		return val[0];
	}
	*/
	
	/*
	public boolean is_down(){
		return (Math.abs(this.get_position() - RobotMap.LIFTER_DOWN_POSE) < RobotMap.LIFTER_MID_POSE * VariablesToBeDetermined.LIFTER_POSE_VALUE_1);
	}
	*/
	/*
	public void ResetEncoders(){
		Robot.lifter_encoder.reset();
	}
	*/
	
	@Override
	protected void initDefaultCommand() {	
		this.setDefaultCommand(new Lift_remote());
	}
	

}

