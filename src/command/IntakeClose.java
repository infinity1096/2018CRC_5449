package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeClose extends Command{

	public IntakeClose(){
		//requires(Robot.intake);
	}
	
	protected void initialize() {
		//Robot.intake.Close();
	}
	
	protected void execute() {
    	
    }
	
	protected void end() {
  	
    }
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
		return true;
	}

}
