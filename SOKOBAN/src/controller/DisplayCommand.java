package controller;

import model.Model;
import model.MyModel;
import view.Displayer;
import view.MyView;
import view.View;

public class DisplayCommand extends Command {

    View view = new MyView();
    Model model = new MyModel();

    public DisplayCommand(Model model) {

	this.model = model;

    }

    private Displayer displayer = null;

    public void setup(Displayer displayer) {

	this.displayer = displayer;

    }

    public void execute() {

	view.Display(model.getCurrentLevel());

    }

}
