package view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import controller.Command;
import controller.DisplayCommand;
import controller.ExitCommand;
import controller.LoadCommand;
import controller.MoveCommand;
import controller.SaveCommand;
import model.data.Level;
import model.policy.Policy;

public class CLI implements Invoker {

    private int relevantPlayer;
    private Level mylevel = new Level();
    private HashMap<String, Command> invoke;

    public CLI() {

	invoke = new HashMap<String, Command>();
	invoke.put("Display", new DisplayCommand());
	invoke.put("Move", new MoveCommand());
	invoke.put("Load", new LoadCommand());
	invoke.put("Exit", new ExitCommand());
	invoke.put("Save", new SaveCommand());

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
    public void CLIInvoke() throws ClassNotFoundException, IOException {
	String[] sa;
	String s;

	Scanner in = new Scanner(System.in);
	System.out.println("****Welcome to SoKoBan!****:");
	System.out.println("****Please choose option:****:");
	System.out.println("Load");
	System.out.println("Display");
	System.out.println("Move {up,down,left,right}:");
	System.out.println("Save");
	System.out.println("Exit\n");
	do {

	    System.out.println("Please choose option:");
	    s = in.nextLine();

	    sa = s.split(" ");
	    mylevel = invoke.get(sa[0]).execute(sa, mylevel);

	} while (true);

    }

}
