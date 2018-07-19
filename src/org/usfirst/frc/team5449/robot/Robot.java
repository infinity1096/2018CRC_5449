/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5449.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import sensors.Encoder_Module;
import sensors.InfraRed;

import org.usfirst.frc.team5449.robot.subsystems.Camera;
import org.usfirst.frc.team5449.robot.subsystems.Chassis;
import org.usfirst.frc.team5449.robot.subsystems.Intake;
import org.usfirst.frc.team5449.robot.subsystems.Lifter;

import command.FlipIn;
import command.FlipOut;
import command.FlipUp;
import commandGroup.Auto_test;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	//public static Camera camera = new Camera();
	public static Chassis chassis = new Chassis();
	public static Intake intake = new Intake();
	public static Lifter lifter = new Lifter();
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static Camera camera = new Camera();
	public static OI oi = new OI();
	public static InfraRed infrared = new InfraRed(RobotMap.INFRARED);
	public static boolean[] Game_data = { false, false, false };// false = left
    public int a = 100;
    public static CameraServer server = CameraServer.getInstance();
	
	/*** Select Auto Mode ***/
	public static int auto_mode = 0;
	/*** Select Auto Mode ***/
	
	Command AutonomousCommand;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		Scheduler.getInstance().removeAll();
		server.startAutomaticCapture();
		}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Scheduler.getInstance().removeAll();// cancel all commands
		String gamedata;// get game data, false for left
		gamedata = DriverStation.getInstance().getGameSpecificMessage();
		Robot.Game_data[0] = gamedata.charAt(0) == 'R';
		Robot.Game_data[1] = gamedata.charAt(1) == 'R';
		Robot.Game_data[2] = gamedata.charAt(2) == 'R';
		
		AutonomousCommand = new Auto_test();
		AutonomousCommand.start();
		/***
		switch (auto_mode) {
		case 0:// slow auto for switch
			SmartDashboard.putString("CURRENT_MODE", "Switch");
			if (Game_data[0]) {
				AutonomousCommand = new New_Auto_Pos1_R_SW();
			} else {
				AutonomousCommand = new New_Auto_Pos1_L_SW();
			}
			break;
		case 1:// slow auto for scale
			SmartDashboard.putString("CURRENT_MODE", "Scale");
			if (Game_data[1]) {
				AutonomousCommand = new New_Auto_Pos1_R_SC();
			} else {
				AutonomousCommand = new New_Auto_Pos1_L_SC();
			}
			break;
		case 2:// fast auto for switch
			SmartDashboard.putString("CURRENT_MODE", "Switch_Fast");
			if (Game_data[0]) {
				AutonomousCommand = new New_Auto_Pos1_R_SW();
			} else {
				AutonomousCommand = new New_Auto_Pos1_L_SW();
			}
			break;
		case 3:// fast auto for scale
			SmartDashboard.putString("CURRENT_MODE", "Scale_Fast");
			if (Game_data[1]) {
				AutonomousCommand = new New_Auto_Pos1_R_SC();
			} else {
				AutonomousCommand = new New_Auto_Pos1_L_SC();
			}
			break;
		case 4:
			if (Game_data[0]) {
				AutonomousCommand = new New_Auto_PosMid_R_SW();
			} else {
				AutonomousCommand = new New_Auto_PosMid_L_SW();
			}
			break;
		case 5:
			if (Game_data[0]) { 
			  
				AutonomousCommand = new New_Auto_Pos3_R_SC();
			} else {
				AutonomousCommand = new New_Auto_Pos3_L_SC();
			}
			break;
		case 6:
				AutonomousCommand = new Go_Straight();
			break;
				
		}

		if (AutonomousCommand != null) {
			AutonomousCommand.start();// start auto command.
		}
		***/
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		double[] Pos = this.chassis.get();
		SmartDashboard.putNumber("X", Pos[0] * 0.1);
		SmartDashboard.putNumber("Y", Pos[1] * 0.1);
		Scheduler.getInstance().run();
		
	}
    //play hearthstone
	@Override
	public void teleopInit() {
		this.intake.reset();
		
		this.lifter.ResetEncoders();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		this.chassis.reset();
		this.lifter.UnLock();

	}

	/**
	 * This function is called periodically during operator control.
	 */
	private double range(double val,double min,double max){
    	if (val < min){
    		return min;
    	}else if (val > max){
    		return max;
    	}else{
    		return val;
    	}
    }
	@Override
	public void teleopPeriodic() {
		if (oi.intakein.get()) {
			if (oi.intakeout.get()) {
			}else {
				this.intake.In();
			}		
		}else {
			if (oi.intakeout.get()) {
				this.intake.Out();
			}else {
				this.intake.stop();
			}
		}
		
		this.lifter.move(-oi.stick0.getRawAxis(1));
		SmartDashboard.putNumber("LIFTER POWER", -oi.stick0.getRawAxis(1));
		
		
		SmartDashboard.putData(new FlipOut());
		SmartDashboard.putData(new FlipUp());
		SmartDashboard.putData(new FlipIn());
		//final String string = "BlockIn?";
	    SmartDashboard.putNumber(/*string*/"Infrared",this.infrared.get());
		SmartDashboard.putNumber("FLIP Encoder_reading", this.intake.get());	
		SmartDashboard.putNumber("LIFTER Encoder_reading", this.lifter.getPosition());	
		SmartDashboard.putNumber("CHASSIS RIGHT Encoder_reading",this.chassis.get()[0]);
		SmartDashboard.putNumber("CHASSIS LEFT Encoder_reading",this.chassis.get()[1]);
		Scheduler.getInstance().run();
	}
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
