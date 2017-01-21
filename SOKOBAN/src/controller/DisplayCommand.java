package controller;

import model.Model;
import view.Displayer;
import view.View;

public class DisplayCommand extends Command {

    Model model;
    View view;

    public DisplayCommand(Model model, View view) {

	this.model = model;
	this.view = view;

    }

    private Displayer displayer = null;

    public void setup(Displayer displayer) {

	this.displayer = displayer;

    }

    public void execute() {

	view.Display(model.getCurrentLevel());

    }

}
