package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CompressorOn extends Command{
	 
	public CompressorOn(){
		
	}
	protected void initialize() {
		Robot.intake.compressor.start();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
	    return true;
	}
}
