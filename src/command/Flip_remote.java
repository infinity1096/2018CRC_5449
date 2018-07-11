package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Flip_remote extends Command{
	 public Flip_remote() {
	 	// Use requires() here to declare subsystem dependencies
	     requires(Robot.flip);
	 }

	 // Called just before this Command runs the first time
	 protected void initialize() {
	 	
	 }

	 // Called repeatedly when this Command is scheduled to run
	 protected void execute() {
	 	//Robot.lifter.move(Robot.oi.stick1.getX() * 0.4);
	 	
	 }

	 // Make this return true when this Command no longer needs to run execute()
	 // Called once after isFinished returns true
	 protected void end() {
	 	Robot.flip.stop();
	 }

	 // Called when another command which requires one or more of the same
	 // subsystems is scheduled to run
	 protected void interrupted() {
	 	Robot.flip.stop();
	 }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	}
