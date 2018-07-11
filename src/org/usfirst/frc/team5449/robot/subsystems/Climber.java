package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;
import command.Climb_remote;
//import command.Lift_remote;
//import command.Move;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	
	private TalonSRX Climbmotor_LF,Climbmotor_LR,Climbmotor_RF,Climbmotor_RR;
	//parameters
	private double power = RobotMap.CLIMBER_POWER;
	
	public Climber(){
		Climbmotor_LF = new TalonSRX(RobotMap.CLIMBER_LEFT_FRONT_MOTOR_PORT);
		Climbmotor_LR = new TalonSRX(RobotMap.CLIMBER_LEFT_REAR_MOTOR_PORT);
		Climbmotor_RF = new TalonSRX(RobotMap.CLIMBER_RIGHT_FRONT_MOTOR_PORT);
		Climbmotor_RR = new TalonSRX(RobotMap.CLIMBER_RIGHT_REAR_MOTOR_PORT);
		Climbmotor_RF.setInverted(true);
		Climbmotor_RR.setInverted(true);
	}
	
	public void move(double Power){
		Climbmotor_LF.set(ControlMode.PercentOutput,Power);
		Climbmotor_LR.set(ControlMode.PercentOutput,Power);
		Climbmotor_RF.set(ControlMode.PercentOutput,Power);
		Climbmotor_RR.set(ControlMode.PercentOutput,Power);
	}
	
	public void stop(){
		Climbmotor_LF.set(ControlMode.PercentOutput,0);
		Climbmotor_LR.set(ControlMode.PercentOutput,0);
		Climbmotor_RF.set(ControlMode.PercentOutput,0);
		Climbmotor_RR.set(ControlMode.PercentOutput,0);
	}
	
	
	//set power
	public void setPower(double power){
		this.power = power;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		this.setDefaultCommand(new Climb_remote());
	}
	

}
