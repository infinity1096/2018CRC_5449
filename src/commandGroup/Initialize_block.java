package commandGroup;

/*import command.Delay;
import command.IntakeIn2;
import command.IntakeOut;
import command.LifterBump;
//import command.IntakeStop;
import command.LifterToDown;*/

import command.Delay;
import command.IntakeIn2;
import command.IntakeStop;
import command.LifterToDown;
import command.LifterBump;
import command.IntakeOut;
import command.IntakeIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Initialize_block extends CommandGroup{
	public Initialize_block(){
		addParallel(new LifterBump());
		addSequential(new IntakeOut());
        addSequential(new IntakeStop());
        addSequential(new Delay(0.4));
        addSequential(new LifterToDown());
        addSequential(new Delay(0.4));
        addSequential(new IntakeIn2());
	}
	
	public Initialize_block(double time){
		addParallel(new LifterBump(time));
		addSequential(new IntakeOut());
        addSequential(new IntakeStop());
        addSequential(new Delay(time));
        addSequential(new LifterToDown());
        addSequential(new Delay(time));
        addSequential(new IntakeIn2());
	}
	
	
	
}
