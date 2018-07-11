/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5449.robot;

import command.IntakeClose;
import command.IntakeOpen;
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
	public JoystickButton button0 = new JoystickButton(stick0,5);
	public JoystickButton button1 = new JoystickButton(stick0,3);
	public JoystickButton Climber_btn = new JoystickButton(stick1,7);
	
	public JoystickButton Lifter_UP = new JoystickButton(stick1,7);
	public JoystickButton Lifter_MID2 = new JoystickButton(stick1,8);
	public JoystickButton Lifter_MID = new JoystickButton(stick1,10);
	public JoystickButton Lifter_DOWN = new JoystickButton(stick1,12);
	
	public OI() {
		button0.whenPressed(new IntakeOpen());
		button1.whenPressed(new IntakeClose());
		//examplebutton.whenPressed(new command());
	}
	
	
	
	
	
	
	
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
}
