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
		addSequential(new DriveDistance(736));
		addSequential(new TurnTo(-90));
		addParallel(new FlipIn());
	    addSequential(new IntakeOut());
		addParallel(new TurnTo(132.337));
	    addParallel(new LifterToDown());
	    addSequential(new DriveDistance(334.8231));
	    addParallel(new TurnTo(-42.337));
	    addParallel(new FlipOut());
	    addSequential(new DriveDistance(60));
	    addSequential(new IntakeIn());
	    
	    	    
	}


	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
