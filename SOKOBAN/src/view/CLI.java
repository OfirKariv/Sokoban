package view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import controller.Command;
import controller.DisplayCommand;
import controller.MoveCommand;
import model.data.util.Level;
import model.policy.Policy;

public class CLI extends Observable implements View {

    private int relevantPlayer;
    private HashMap<String, Command> invoke;

    public CLI() {

	/*
	 * invoke = new HashMap<String, Command>(); invoke.put("Display", new
	 * DisplayCommand()); invoke.put("Move", new MoveCommand());
	 * invoke.put("Load", new LoadCommand()); invoke.put("Exit", new
	 * ExitCommand()); invoke.put("Save", new SaveCommand());
	 */
	relevantPlayer = 0;

    }

    /**
     * initialzer
     * 
     * @param policy
     * @param displayer
     */
    public void setup(Policy policy, Displayer displayer) {

	((MoveCommand) invoke.get("Move")).setup(relevantPlayer, policy);
	((DisplayCommand) invoke.get("Display")).setup(displayer);

    }

    @SuppressWarnings("resource")
    /**
     * Game manager - type work exactly as said. Move example: Move up Load/Save
     * example : Load c:/dir/file.txt
     */
    public void start() {
	Scanner in = new Scanner(System.in);
	Thread thread = new Thread(new Runnable() {

	    @Override
	    public void run() {
		System.out.println("****Welcome to SoKoBan!****:");
		System.out.println("****Please choose option:****:");
		System.out.println("Load");
		System.out.println("Display");
		System.out.println("Move {up,down,left,right}:");
		System.out.println("Save");
		System.out.println("Exit\n");
		while (true) {
		    String[] sa;
		    String commandline;

		    System.out.println("Please choose option:");
		    commandline = in.nextLine();

		    sa = commandline.split(" ");

		    List<String> params = new LinkedList<String>();

		    for (String s : sa) {
			params.add(s);
		    }

		    setChanged();
		    notifyObservers(params);
		}
	    }
	});
	thread.start();
    }

    @Override
    public void Display(Level myLevel) {

	TxtDisplayer dis = new TxtDisplayer();
	dis.display(myLevel);

    }

    @Override
    public void DisplayMess(String s) {
	System.out.println(s);

    }
}

// mylevel = invoke.get(sa[0]).execute(sa, mylevel);
