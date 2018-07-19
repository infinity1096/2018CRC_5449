package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearRatioHigh extends Command{
	 
	public GearRatioHigh(){
		
	}
	protected void initialize() {
		Robot.chassis.ChangeGearRatio(false);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
	    return true;
	}
}
