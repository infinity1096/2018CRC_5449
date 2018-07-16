package commandGroup;

import command.DriveDistance;
import command.IntakeOut;
import command.LifterToDown;
import command.LifterToUp;
import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto_RightToRight extends CommandGroup{
	public Auto_RightToRight() {
		addSequential(new DriveDistance(410));
		addSequential(new TurnTo(-90));
		addParallel(new LifterToUp());
		addSequential(new DriveDistance(111));
		addSequential(new IntakeOut());
		addParallel(new LifterToDown());
		addSequential(new TurnTo(180));
		addSequential(new DriveDistance(190));
		addSequential(new TurnTo(270));
		addParallel(new IntakeOut());
		addSequential(new DriveDistance(60));
		
		
		
		
		
		
		

	}

}
