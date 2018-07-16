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
  
public class Auto_LeftToLeft extends CommandGroup{
	public Auto_LeftToLeft() {
		addSequential(new LifterBump());
		addParallel(new LifterToUp());
		addSequential(new DriveDistance(727));
		
		addSequential(new TurnTo(-90));
		addParallel(new FlipIn());
	    addSequential(new IntakeOut());
	    addParallel(new LifterToDown());
		//addSequential(new TurnTo(132.337));
	    addSequential(new TurnTo(180-42.337));
	    addSequential(new DriveDistance(334.8231));
	    //addParallel(new TurnTo(-42.337));
	    addParallel(new TurnTo(180));
	    addParallel(new FlipOut());
	    addSequential(new DriveDistance(60));
	    addSequential(new IntakeIn());
	    addSequential(new FlipIn());
	    addSequential(new TurnTo(0));
	    addSequential(new DriveDistance(60));
	    //addParallel(new TurnTo(42.337));
	    addParallel(new TurnTo(360-42.337));
	    addSequential(new DriveDistance(334.8231));
	    addParallel(new LifterToUp());
	    //addSequential(new TurnTo(90-42.337));
	    addSequential(new TurnTo(270));
	    addSequential(new IntakeOut());
	    addSequential(new LifterToDown());
	    }


	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
