package commandGroup;

import command.LifterBump;
import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDrive1 extends CommandGroup {
	public AutoDrive1() {
	
		
		addParallel(new LifterBump());
		addSequential(new TurnTo(90));
		addSequential(new TurnTo(90));
	}
}
