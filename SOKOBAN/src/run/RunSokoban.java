
package run;

import java.io.IOException;

import commands.CLI;
import commands.MySokobanPolicy;
import commands.Policy;
import displayer.Displayer;
import displayer.TxtDisplayer;

public class RunSokoban {

    public static void main(String[] args)

    {
	Policy mySocPol = new MySokobanPolicy();
	Displayer TxtDisplayer = new TxtDisplayer();

	CLI cli = new CLI();
	cli.setup(mySocPol, TxtDisplayer);
	try {
	    cli.CLIInvoke();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println("===============================");
    }

}
