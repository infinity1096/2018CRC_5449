package sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class InfraRed{
	public static DigitalInput d1;
	
	public InfraRed(int port)
	{
		d1 = new DigitalInput(port);
	}
	
	public static int get() {
		if(d1.get() == false)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	
	
}