package commandGroup;

import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDrive1 extends CommandGroup {
	public AutoDrive1() {
	addSequential(new TurnTo(90));
		
	}
}
