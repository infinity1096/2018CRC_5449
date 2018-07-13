/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5449.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import sensors.Encoder_Module;

import org.usfirst.frc.team5449.robot.subsystems.Chassis;
import org.usfirst.frc.team5449.robot.subsystems.Climber;
import org.usfirst.frc.team5449.robot.subsystems.Flip;
import org.usfirst.frc.team5449.robot.subsystems.Holder;
import org.usfirst.frc.team5449.robot.subsystems.Intake;
import org.usfirst.frc.team5449.robot.subsystems.Lifter;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Chassis chassis = new Chassis();
	public static Intake intake = new Intake();
	public static OI oi = new OI();
	private static Timer timer = new Timer();
	public static Encoder lifter_encoder = new Encoder(RobotMap.LIFTER_ENCODER_A,RobotMap.LIFTER_ENCODER_B);
	public static Encoder flip_encoder = new Encoder(RobotMap.FLIP_ENCODER_A,RobotMap.FLIP_ENCODER_B);

	public static Lifter lifter = new Lifter();
	public static Climber climber = new Climber();
	public static Flip flip = new Flip();
	//public static Holder holder = new Holder();
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	//public static Encoder_Module e1;
	
	public static boolean[] Game_data = {false,false,false};
    
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		timer.reset();
		timer.start();
		lifter.ResetEncoders();
		gyro.calibrate();
		gyro.reset();
		
		Scheduler.getInstance().removeAll();
		//flip.ResetEncoders();
		
		
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
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}
    //play hearthstone
	@Override
	public void teleopInit() {
		
		lifter_encoder.reset();
		flip_encoder.reset();
		gyro.calibrate();
		gyro.reset();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		Scheduler.getInstance().removeAll();
		String gamedata;
		gamedata = DriverStation.getInstance().getGameSpecificMessage();
		Robot.Game_data[0] = gamedata.charAt(0) == 'R';
		Robot.Game_data[1] = gamedata.charAt(1) == 'R';
		Robot.Game_data[2] = gamedata.charAt(2) == 'R';

		this.chassis.reset();

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//ONLY FOR TESTING
		SmartDashboard.putNumber("enc_larm",Robot.lifter.get_position2()[0]);
		SmartDashboard.putNumber("enc_rarm",Robot.lifter.get_position2()[1]);
		
		SmartDashboard.putNumber("lifter_encoder_angle", lifter_encoder.get());
		SmartDashboard.putNumber("flip_encoder_angle", flip_encoder.get());
		SmartDashboard.putNumber("gyro_angle", gyro.getAngle());
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}
	

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
