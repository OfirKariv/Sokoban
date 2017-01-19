
package boot;

import java.io.IOException;

import model.MySokobanPolicy;
import model.Policy;
import view.CLI;
import view.Displayer;
import view.TxtDisplayer;

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
