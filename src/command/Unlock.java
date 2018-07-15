package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Unlock extends Command{
		 
		public Unlock(){
			
		}
			protected void initialize() {
				
		    }

		    // Called repeatedly when this Command is scheduled to run
		    protected void execute() {
		    	Robot.lifter.UnLock();
		    }

		    // Make this return true when this Command no longer needs to run execute()
		    protected boolean isFinished() {
		        return true;
		    }

		    // Called once after isFinished returns true
		    protected void end() {
		    }

		    // Called when another command which requires one or more of the same
		    // subsystems is scheduled to run
		    protected void interrupted() {
		    }

	}


