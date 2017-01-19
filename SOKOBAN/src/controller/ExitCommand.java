package controller;

import model.Level;

public class ExitCommand implements Command {

    @Override
    public Level execute(String[] args, Level mylevel) {
	System.out.println("Exit Game");
	System.exit(0);
	return mylevel;
    }

}
