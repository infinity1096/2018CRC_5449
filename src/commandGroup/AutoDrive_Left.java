package commandGroup;

import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import command.DriveDistance;
import command.LifterBump;
import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDrive_Left extends CommandGroup {
	public AutoDrive_Left() {
	
		
		addParallel(new LifterBump());
		//addSequential(new TurnTo(90));
		//addSequential(new TurnTo(90));
		//addSequential(new )
		addSequential(new DriveDistance(VariablesToBeDetermined.DISTANCE_1));
		
	}
}
