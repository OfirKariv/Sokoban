package controller;

import model.Model;

public class LoadCommand extends Command {

    private Model model;

    public LoadCommand() {

    }

    @Override
    public void execute() {
	model.load(params.get(0));

    }

}
