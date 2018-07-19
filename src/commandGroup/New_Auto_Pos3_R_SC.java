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

public class New_Auto_Pos3_R_SC extends CommandGroup{
	public New_Auto_Pos3_R_SC(){
	addSequential(new DriveDistance(6.6));
	addSequential(new TurnTo(53.6));
	addSequential(new ScaleRelease());
	/*
	addSequential(new TurnTo(163.7));
	addSequential(new IntakeOut());
	addSequential(new DriveDistance(2.2,2,0.4));
	addSequential(new IntakeIn(2));
	addSequential(new DriveDistance(-1.2,2,0.5));
	addSequential(new TurnTo(-53.6));
	addSequential(new ScaleRelease(0.5));
	*/
	}
}
