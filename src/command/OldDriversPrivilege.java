package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OldDriversPrivilege extends Command{
	
	public OldDriversPrivilege() {
		requires(Robot.chassis);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		Robot.chassis.arcade_drive(Robot.oi.stick1.getRawAxis(1),Robot.oi.stick1.getRawAxis(2));
    }
	
	protected void end() {
    	
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
