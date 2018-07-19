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

import edu.wpi.first.wpilibj.command.CommandGroup;

public class New_Auto_Pos3_L_SC extends CommandGroup{
	public New_Auto_Pos3_L_SC(){
		addSequential(new DriveDistance(5.30));
		addSequential(new TurnTo(90));
		addSequential(new DriveDistance(5.0));
		addSequential(new TurnTo(-5,1));
		addSequential(new ScaleRelease());
	}
}
