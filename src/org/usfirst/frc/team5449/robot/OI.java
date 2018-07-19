/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5449.robot;


import org.usfirst.frc.team5449.robot.subsystems.Lifter;

import command.LifterStop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Joysticks
	public Joystick stick0 = new Joystick(0);
	public Joystick stick1 = new Joystick(1);
	//Buttons
	

	public JoystickButton intakein = new JoystickButton(stick1,1);
	public JoystickButton intakeout = new JoystickButton(stick1,2);
//	public Joystic
	public JoystickButton FlipOut = new JoystickButton(stick1,8);
	public JoystickButton FlipUp = new JoystickButton(stick1,10);
	public JoystickButton FlipIn = new JoystickButton(stick1,12); 
	public JoystickButton compressoron = new JoystickButton(stick1, 9);
	public JoystickButton compressoroff = new JoystickButton(stick1, 11);
	public JoystickButton LifterToMid = new JoystickButton(stick1,3);
	public JoystickButton Lock = new JoystickButton(stick1,6);
    public JoystickButton Unlock = new JoystickButton(stick1,4);
    public JoystickButton ChangeGearRatioHigh = new JoystickButton(stick0,11);
    public JoystickButton ChangeGearRatioLow = new JoystickButton(stick0,12);
    
	//public 
	
	public OI() {
		FlipOut.whenPressed(new command.FlipOut());
		FlipUp.whenPressed(new command.FlipUp());
		FlipIn.whenPressed(new command.FlipIn());
		//LifterToMid.whenPressed(new command.LifterToMid());
		compressoron.whenPressed(new command.CompressorOn());
		compressoroff.whenPressed(new command.CompressorOff());
		Lock.whenPressed(new command.lift_lock());
		Unlock.whenPressed(new command.lift_unlock());
		ChangeGearRatioHigh.whenPressed(new command.GearRatioHigh());
		ChangeGearRatioLow.whenPressed(new command.GearRatioLow());
	}
	
	
	
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
}
