
package boot;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class RunSokoban {

    public static void main(String[] args)

    {

	MyView ui = new MyView();
	MyModel m = new MyModel();
	MyController c = new MyController();
	ui.addObserver(c);
	m.addObserver(c);
	c.update(m, "Load c:/level3.txt");

	/*
	 * Policy mySocPol = new MySokobanPolicy(); Displayer TxtDisplayer = new
	 * TxtDisplayer();
	 * 
	 * CLI cli = new CLI(); cli.setup(mySocPol, TxtDisplayer); try {
	 * cli.CLIInvoke(); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * System.out.println("===============================");
	 */
    }

}
