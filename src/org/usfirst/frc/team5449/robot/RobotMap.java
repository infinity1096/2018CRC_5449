package org.usfirst.frc.team5449.robot;

public class RobotMap {
//TalonSRXs
	//chassis motors
	public static final int LEFT_FRONT_MOTOR_PORT = 7;
	public static final int LEFT_MID_MOTOR_PORT = 6;
	public static final int LEFT_REAR_MOTOR_PORT = 8;
	public static final int RIGHT_FRONT_MOTOR_PORT = 4;
	public static final int RIGHT_MID_MOTOR_PORT = 5;
	public static final int RIGHT_REAR_MOTOR_PORT = 1;
	//Intake motors
	public static final int INTAKE_LEFT_MOTOR_PORT = 2;
	public static final int INTAKE_RIGHT_MOTOR_PORT = 10;
	public static final int INTAKE_MOTOR_PORT = 9;
	//Lifter motors
	public static final int LIFTER_MOTOR_RIGHTBACK_PORT = 13;//1
	public static final int LIFTER_MOTOR_LEFTBACK_PORT = 12;// 2
	public static final int LIFTER_MOTOR_RIGHTFRONT_PORT = 3;//3
	public static final int LIFTER_MOTOR_LEFTFRONT_PORT = 11;//4
//Pneumatics
	//PCM module
	public static final int PCM_PORT = 16;
	//Solenoids 
	public static final int CHASSIS_CLUTCH_SLOENOID_PORT = 2;
	public static final int INTAKE_CYLINDER_PORT = 1;
	public static final int LIFTER_LOCK_PORT = 0;
	
	public static final int LIFTER_ENCODER_A = 8;
	public static final int LIFTER_ENCODER_B = 9;
	public static final int CHASSIS_ENCODER_LEFT_PORT_A = 4;
	public static final int CHASSIS_ENCODER_LEFT_PORT_B = 5;
	public static final int CHASSIS_ENCODER_RIGHT_PORT_A = 6;
	public static final int CHASSIS_ENCODER_RIGHT_PORT_B = 7;
	public static final int INTAKE_ENCODER_A = 2;
	public static final int INTAKE_ENCODER_B = 3;
//Parameters
	//Chassis
	public static final double INTAKE_INTAKE_IN_POWER = 0.50;
	public static final double INTAKE_INTAKE_OUT_POWER = 0.70;
	public static final double INTAKE_INTAKE_HOLD_POWER = 0.2;
	
	
	public static final double CHASSIS_TURNING_DEADZONE = 0.05;
	public static final double CHASSIS_MAX_PASSING_ERROR = 0.1;
	public static final double CHASSIS_TURNING_P = 0.005;
	public static final double CHASSIS_TURNING_D = 1.0;
	public static final double CHASSIS_TURNING_ALLOWED_ERROR = 0.50;
	//lifter
	public static final long LIFTER_UP_POSE = 680;
	public static final long LIFTER_MID2_POSE = 453;
	public static final long LIFTER_MID_POSE = 226;
	public static final long LIFTER_DOWN_POSE = 0;
	
	public static final double LIFTER_MAXIMUM_PASSING_ERROR = 4;
	
	public static final double LIFTER_MAXIMUM_POWER = 0.9;
	public static final double LIFTER_MINIMUM_POWER = 0.1;
	
	public static final double LIFTER_KP = 0.012;
	
	public static final double INTAKE_HOLDER_DELAY = 0.500;//sec
	
	//Climber
	public static final double CLIMBER_POWER = 1.000;
	
	//Flip
	public static final double INTAKE_FLIP_KP = 0.005;
	public static final double INTAKE_FLIP_KD = 0.10;
	public static final double INTAKE_FLIP_KI = 0.004;
	public static final double INTAKE_FLIP_IN_POSE = 0;
	//public static final double INTAKE_FLIP_UP_POSE = 72;
	public static final double INTAKE_FLIP_UP_POSE = 72;
	//public static final double INTAKE_FLIP_OUT_POSE = 148;
	public static final double INTAKE_FLIP_OUT_POSE = 130;
	public static final double INTAKE_FLIP_MAXIMUM_POWER = 0.9;
	//gravity offset for lifter is aboout 0.05
	public static final int INFRARED = 1;

	
		
}
