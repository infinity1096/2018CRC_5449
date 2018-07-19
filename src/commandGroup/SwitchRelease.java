package commandGroup;

import org.usfirst.frc.team5449.robot.Robot;

import command.LifterToDown;
import command.LifterToMid;
import command.Release_Cube;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchRelease extends CommandGroup {

    public SwitchRelease() {
        addSequential(new LifterToMid());
        addSequential(new Release_Cube());
        addSequential(new LifterToDown());
    }

}
