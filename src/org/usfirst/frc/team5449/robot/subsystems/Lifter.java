package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;
import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import command.Lift_remote;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem{
	TalonSRX Liftmotor_LF,Liftmotor_LR,Liftmotor_RF,Liftmotor_RR;
	private int current_status = 0;//0 for down,1 for mid,2 for up
	private Encoder lifter_encoder;
	public Lifter(){
		Liftmotor_LF = new TalonSRX(RobotMap.CLIMBER_LEFT_FRONT_MOTOR_PORT);
		Liftmotor_LR = new TalonSRX(RobotMap.CLIMBER_LEFT_REAR_MOTOR_PORT);
		Liftmotor_RF = new TalonSRX(RobotMap.CLIMBER_RIGHT_FRONT_MOTOR_PORT);
		Liftmotor_RR = new TalonSRX(RobotMap.CLIMBER_RIGHT_REAR_MOTOR_PORT);
		Liftmotor_RF.setInverted(true);
		Liftmotor_RR.setInverted(true);
		
		lifter_encoder = new Encoder(RobotMap.LIFTER_ENCODER_A,RobotMap.LIFTER_ENCODER_B);
	}
	
	//moves lifter
	 public void move(double Power){
		Liftmotor_LF.set(ControlMode.PercentOutput,Power);
		Liftmotor_LR.set(ControlMode.PercentOutput,Power);
		Liftmotor_RF.set(ControlMode.PercentOutput,Power);
		Liftmotor_RR.set(ControlMode.PercentOutput,Power);
	}
	
	public void move(double Power,double delta_power){
		
		Liftmotor_LF.set(ControlMode.PercentOutput,range(Power - delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
		Liftmotor_LR.set(ControlMode.PercentOutput,range(Power - delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
		Liftmotor_RF.set(ControlMode.PercentOutput,range(Power + delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
		Liftmotor_RR.set(ControlMode.PercentOutput,range(Power + delta_power,-RobotMap.LIFTER_MAXIMUM_POWER,RobotMap.LIFTER_MAXIMUM_POWER));
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
		Liftmotor_LF.set(ControlMode.PercentOutput,0);
		Liftmotor_LR.set(ControlMode.PercentOutput,0);
		Liftmotor_RF.set(ControlMode.PercentOutput,0);
		Liftmotor_RR.set(ControlMode.PercentOutput,0);
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
	public int get_position(){
		int[] val = {lifter_encoder.get()};
		return val[0];
	}
	
	public int[] get_position2(){
		int[] val = {lifter_encoder.get()};
		return val;
	}
	
	//TODO
	public boolean is_down(){
		return (Math.abs(this.get_position() - RobotMap.LIFTER_DOWN_POSE) < RobotMap.LIFTER_MID_POSE * VariablesToBeDetermined.LIFTER_POSE_VALUE_1);
	}
	
	public void ResetEncoders(){
		this.lifter_encoder.reset();
	}
	
	
	@Override
	protected void initDefaultCommand() {	
		this.setDefaultCommand(new Lift_remote());
	}
	

}

