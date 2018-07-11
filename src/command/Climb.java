package command;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.VariablesToBeDetermined;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb extends Command {

	@Override 
	protected void initialize(){
		requires(Robot.climber);
	}
	
	
	@Override
	protected void execute(){
		SmartDashboard.putString("CLIMB", "CLIMBING");
		Robot.climber.move(VariablesToBeDetermined.CLIMBER_MOVE_POWER);
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
