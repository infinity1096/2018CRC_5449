package commandGroup;

import command.DriveDistance;
import command.LifterToUp;
import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto_RightToRight extends CommandGroup{
	public Auto_RightToRight() {
		addSequential(new DriveDistance(410));
		addSequential(new TurnTo(-90));
		addParallel(new LifterToUp());
		addSequential(new DriveDistance(111));
	}

}
