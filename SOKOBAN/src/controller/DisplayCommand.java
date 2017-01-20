package controller;

import model.data.Level;
import view.Displayer;
import view.TxtDisplayer;

public class DisplayCommand implements Command {

    private Displayer displayer = null;

    public void setup(Displayer displayer) {

	this.displayer = displayer;

    }

    public Level execute(String[] args, Level mylevel) {
	TxtDisplayer dis = new TxtDisplayer();
	dis.display(mylevel);
	return mylevel;
    }

}
