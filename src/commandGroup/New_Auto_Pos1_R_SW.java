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

public class New_Auto_Pos1_R_SW extends CommandGroup{
	public New_Auto_Pos1_R_SW(){
		addSequential(new DriveDistance(1.2));//1.25,1.6
		addSequential(new TurnTo(-90));
		addSequential(new DriveDistance(4.2));//5.45,1.6
		addSequential(new TurnTo(0));
		addSequential(new SwitchRelease());//5.45,3.55
	}
}
