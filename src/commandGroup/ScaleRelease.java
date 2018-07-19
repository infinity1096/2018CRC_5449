package commandGroup;

import org.usfirst.frc.team5449.robot.Robot;

import command.LifterToDown;
import command.LifterToUp;
import command.Release_Cube;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScaleRelease extends CommandGroup {

    public ScaleRelease() {
        addSequential(new LifterToUp());
        addSequential(new Release_Cube());
        addSequential(new LifterToDown());
    }

}
