package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeIn extends Command{

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	public IntakeIn() {
		Robot.intake.In();
	}
}
