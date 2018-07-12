package command;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.RobotMap;
import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FlipMid extends Command{
	private double error[] = {0,0};//{error,prev_error}
	private double balance_error[] = {0,0};
	private double Kp = RobotMap.FLIP_KP;
	private double Kd = RobotMap.FLIP_KD;
	private double last_time;
	private Timer timer = new Timer();
	private boolean is_down = false;
	private double time = 9999;
	 public FlipMid() {
	 	// Use requires() here to declare subsystem dependencies
	     requires(Robot.flip);
	 }
	 public FlipMid(double time) {
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
	    error[1] = RobotMap.FLIP_MID_POSE - Robot.lifter.get_position();
	    is_down = (Robot.flip.get_position_flip() - RobotMap.FLIP_MID_POSE)>=0;
	 	
	 }

	 // Called repeatedly when this Command is scheduled to run
	 protected void execute() {
		 double P_output,D_output,dt,output;
	    	double balance_output;
	    	error[0] = RobotMap.FLIP_MID_POSE - Robot.flip.get_position_flip();
	    	P_output = error[0] * Kp;
	    	dt = timer.get() - last_time;
	    	D_output = Kd * (error[0] - error[1])/dt;
	    	
	    	last_time = timer.get();
	    	output = P_output + D_output;
	    	output = range2(output,RobotMap.FLIP_MINIMUM_POWER,RobotMap.FLIP_MAXIMUM_POWER);
	    	balance_error[0] = (Robot.lifter.get_position2()[0] - Robot.flip.get_position_flip());
	    	
	    	if (is_down){
	    		output *= VariablesToBeDetermined.FLIP_MOVE_OUTPUT_2;;
	    	}
	    	error[1] = error[0];
	    	balance_output = RobotMap.FLIP_BALANCE_KP * balance_error[0];
	    	balance_output -= RobotMap.FLIP_BALANCE_KD * (balance_error[0] - balance_error[1]);
	    	//Robot.lifter.move(output,balance_output);
	    	balance_error[1] = balance_error[0];
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
	private double range2(double val,double min,double max){
		max = Math.abs(max);
		min = Math.abs(min);
		if (Math.abs(val)<min){
			return Math.signum(val) * min;
		} else if (Math.abs(val) > max){
			return Math.signum(val) * max;
		}else{
			return Math.signum(val) * Math.abs(val);
		}
	}

	}
