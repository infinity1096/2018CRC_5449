package commandGroup;

import org.usfirst.frc.team5449.robot.Robot;
import org.usfirst.frc.team5449.robot.subsystems.Intake;

import command.DriveDistance;
import command.FlipIn;
import command.FlipOut;
import command.FlipUp;
import command.IntakeIn;
import command.IntakeOut;
import command.LifterBump;
import command.LifterToDown;
import command.LifterToUp;
import command.TurnTo;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
  
public class Auto_test extends CommandGroup{
	public Auto_test() {

		addSequential(new DriveDistance(500));
		
		//addSequential(new TurnTo(-90));
}


	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
