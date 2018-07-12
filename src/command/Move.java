package command;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Move extends Command {

    public Move() {
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    		Robot.chassis.arcade_drive2(-Robot.oi.stick1.getRawAxis(1)*VariablesToBeDetermined.JOYSTICK_HANDLER_CHASSIS_1, Robot.oi.stick1.getRawAxis(2) * VariablesToBeDetermined.JOYSTICK_HANDLER_CHASSIS_2);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.stop();
    }
}