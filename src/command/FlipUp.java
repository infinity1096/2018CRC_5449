package command;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FlipUp extends Command {

	private double error[] = { 0, 0 };// {error,prev_error}
	private double error_acc = 0;
	private double Kp = RobotMap.INTAKE_FLIP_KP;
	private double Kd = RobotMap.INTAKE_FLIP_KD;
	private double Ki = RobotMap.INTAKE_FLIP_KI;
	private double last_time;
	private Timer timer = new Timer();
	private boolean is_down = false;
	private double time = 9999;

	public FlipUp() {
		requires(Robot.intake);
	}

	public FlipUp(double time) {
		requires(Robot.intake);
		this.time = time;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();
		timer.start();
		last_time = timer.get();
		error_acc = 0;
		error[0] = 0;
		error[1] = RobotMap.INTAKE_FLIP_UP_POSE - Robot.intake.get();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double P_output, D_output,I_output , dt, output,gravity_offset;
		error[0] = RobotMap.INTAKE_FLIP_UP_POSE - Robot.intake.get();
		SmartDashboard.putNumber("ERROR", error[0]);
		P_output = error[0] * Kp;
		dt = timer.get() - last_time;
		D_output = range(Kd * (error[0] - error[1]),-0.5,0.5);
		last_time = timer.get();
		I_output = Ki * error_acc;
		gravity_offset = 0.34 * Math.cos(Math.PI/72.0d * Robot.intake.get());
		output = P_output + D_output + I_output + gravity_offset;
		SmartDashboard.putNumber("ERROR_ACC", error_acc);
		output = range(output, -RobotMap.INTAKE_FLIP_MAXIMUM_POWER, RobotMap.INTAKE_FLIP_MAXIMUM_POWER);
		
		
		SmartDashboard.putNumber("INTAKE OUTPUT", output);
		
		error_acc += error[0] * dt;
		if (error_acc >= 10) {
			error_acc = 10;
		}
		
		if (error_acc <= -10) {
			error_acc = -10;
		}
		
		error[1] = error[0];		
		Robot.intake.Move_flip(output);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.Stop_flip();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.intake.Stop_flip();
	}

	private double range(double val, double min, double max) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}

	private double range2(double val, double min, double max) {
		max = Math.abs(max);
		min = Math.abs(min);
		if (Math.abs(val) < min) {
			return Math.signum(val) * min;
		} else if (Math.abs(val) > max) {
			return Math.signum(val) * max;
		} else {
			return Math.signum(val) * Math.abs(val);
		}

	}

}
