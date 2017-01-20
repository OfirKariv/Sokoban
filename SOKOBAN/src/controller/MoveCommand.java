package controller;

import model.Model;
import model.policy.LevelChanger;
import model.policy.Policy;

public class MoveCommand extends Command {

    private LevelChanger change = new LevelChanger();
    private Model model;
    private int relevantPlayer;

    public MoveCommand() {

	this.model = model;
    };

    public void setup(int relevantPlayer, Policy policy) {
	change.setPolicy(policy);
	this.relevantPlayer = relevantPlayer;

    }

    @Override

    public void execute() {

	String direction = params.get(1);
	model.move(direction);

    }
}