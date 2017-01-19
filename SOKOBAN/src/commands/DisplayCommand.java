package commands;

import displayer.Displayer;
import displayer.TxtDisplayer;
import levels.Level;

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
