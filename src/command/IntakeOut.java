package command;

import org.usfirst.frc.team5449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command{

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	public IntakeOut() {
		Robot.intake.Out();
	}
}
