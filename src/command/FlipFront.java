package command;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FlipFront extends Command{
	private double error[] = {0,0};//{error,prev_error}
	private double balance_error[] = {0,0};
	private double Kp = RobotMap.FLIP_KP;
	private double Kd = RobotMap.FLIP_KD;
	private double last_time;
	private Timer timer = new Timer();
	private boolean is_down = false;
	private double time = 9999;
	
	 public FlipFront() {
	 	// Use requires() here to declare subsystem dependencies
	     requires(Robot.flip);
	 }
	 
	 public FlipFront(double time) {
	        // Use requires() here to declare subsystem dependencies
	        requires(Robot.flip);
	        this.time = time;
	        
	    }

	 // Called just before this Command runs the first time
	 protected void initialize() {
	    	timer.reset();
	    	timer.start();
	    	last_time = timer.get();
	    	error[0] = 0;
	    	error[1] = RobotMap.FLIP_FRONT_POSE - Robot.flip.get_position_flip();
	    	is_down = (Robot.flip.get_position_flip() - RobotMap.FLIP_FRONT_POSE)>=0;
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
