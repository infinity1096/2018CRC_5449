
package org.usfirst.frc.team5449.robot.subsystems;

import org.usfirst.frc.team5449.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import command.Move;
import command.OldDriversPrivilege;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	
	//initiate 
	//Talons
	private TalonSRX LeftMotorA;
	private TalonSRX LeftMotorB;
	private TalonSRX LeftMotorC;
	private TalonSRX RightMotorA;
	private TalonSRX RightMotorB;
	private TalonSRX RightMotorC;
	//Solenoids
	private Solenoid ClutchCylinder;
	
	private Encoder encoder_l;
	private Encoder encoder_r;
	
	public double TargetHeading = 0;
	public boolean is_target_set = false;
	
	public Chassis(){
		LeftMotorA = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR_PORT);
		LeftMotorB = new TalonSRX(RobotMap.LEFT_MID_MOTOR_PORT);
		LeftMotorC = new TalonSRX(RobotMap.LEFT_REAR_MOTOR_PORT);
		RightMotorA = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR_PORT);
		RightMotorB = new TalonSRX(RobotMap.RIGHT_MID_MOTOR_PORT);
		RightMotorC = new TalonSRX(RobotMap.RIGHT_REAR_MOTOR_PORT);
		//reverse right side
		RightMotorA.setInverted(true);
    	RightMotorB.setInverted(true);
    	RightMotorC.setInverted(true);
    	//Encoder
    	encoder_l = new Encoder(RobotMap.CHASSIS_ENCODER_LEFT_PORT_A,RobotMap.CHASSIS_ENCODER_LEFT_PORT_B);
    	encoder_r = new Encoder(RobotMap.CHASSIS_ENCODER_RIGHT_PORT_A,RobotMap.CHASSIS_ENCODER_RIGHT_PORT_B);
    	encoder_l.setReverseDirection(true);
    	//Solenoid
    	ClutchCylinder = new Solenoid(RobotMap.PCM_PORT,RobotMap.CHASSIS_CLUTCH_SLOENOID_PORT);
    
    	TargetHeading = 0;
    	is_target_set = false;
    	reset();
    	
	}
	
	public void ChangeGearRatio(boolean is_low) {
		ClutchCylinder.set(is_low);
	}
	
	public void arcade_drive(double Power, double Rotate){
		double leftPower,rightPower;
		Rotate = deadzone(Rotate,0.12);
		Rotate /= 1.5;
		leftPower = range(Power + Rotate,-1,1);
		rightPower = range(Power - Rotate,-1,1);
		LeftMotorA.set(ControlMode.PercentOutput, leftPower);
		LeftMotorB.set(ControlMode.PercentOutput, leftPower);
		LeftMotorC.set(ControlMode.PercentOutput, leftPower);
		
		RightMotorA.set(ControlMode.PercentOutput, rightPower);
		RightMotorB.set(ControlMode.PercentOutput, rightPower);
		RightMotorC.set(ControlMode.PercentOutput, rightPower);
	}	
	
	public double[] getCurrent(){
		double[] val = {0,0};
		val[0] = this.LeftMotorA.getOutputCurrent() + this.LeftMotorB.getOutputCurrent() + this.LeftMotorC.getOutputCurrent();
		val[1] = this.RightMotorA.getOutputCurrent() + this.RightMotorB.getOutputCurrent() + this.RightMotorC.getOutputCurrent();
		val[0] *= Math.signum(this.LeftMotorA.getMotorOutputPercent());
		val[1] *= Math.signum(this.RightMotorA.getMotorOutputPercent());
		return val;
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
	private double deadzone(double val,double deadzone){
		if (Math.abs(val) >= deadzone){
			return val;
		}else{
			return 0;
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Move());
    }
    
    public double[] get(){
		double[] val = {0,0};
		val[0] = this.encoder_l.get();
		val[1] = this.encoder_r.get();
		return val;
	}
    
    public void reset(){
    	this.encoder_l.reset();
    	this.encoder_r.reset();
    	}
    
    public void stop(){
    	LeftMotorA.set(ControlMode.PercentOutput,0);
    	LeftMotorB.set(ControlMode.PercentOutput, 0);
    	LeftMotorC.set(ControlMode.PercentOutput,0);
    	RightMotorA.set(ControlMode.PercentOutput,0);
    	RightMotorB.set(ControlMode.PercentOutput, 0);
    	RightMotorC.set(ControlMode.PercentOutput,0);
	}
    
}

