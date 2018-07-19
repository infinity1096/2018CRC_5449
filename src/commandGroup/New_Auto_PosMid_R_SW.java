package commandGroup;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.subsystems.Intake;

import command.DriveDistance;
import command.FlipIn;
import command.FlipOut;
import command.FlipUp;
import command.IntakeIn;
import command.IntakeOut;
import command.LifterBump;
import command.LifterToDown;
import command.LifterToUp;
import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class New_Auto_PosMid_R_SW extends CommandGroup{
	public New_Auto_PosMid_R_SW(){
		addSequential(new DriveDistance(0.5));
		addSequential(new TurnTo(-40));
		addSequential(new DriveDistance(2.20));
		addSequential(new TurnTo(0));
		addSequential(new SwitchRelease());
		/*
		addSequential(new TurnTo(-90));
		addSequential(new DriveDistance(1.63));
		addSequential(new TurnTo(0));
		addSequential(new DriveDistance(2.50,9,1));
		*/
	}
}
