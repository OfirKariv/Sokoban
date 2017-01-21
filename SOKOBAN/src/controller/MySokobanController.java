package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class MySokobanController implements Observer {

    private Model model;
    private View view;
    private Controller controller;
    private Map<String, Command> invoke;

    public MySokobanController(Model model, View view) {
	this.model = model;
	this.view = view;

	initCommands();
	controller = new Controller() {
	};
	controller.start();// to do the start method in controller
    }

    protected void initCommands() {
	invoke = new HashMap<String, Command>();
	invoke.put("Display", new DisplayCommand());
	invoke.put("Move", new MoveCommand());
	invoke.put("Load", new LoadCommand());
	invoke.put("Exit", new ExitCommand());
	invoke.put("Save", new SaveCommand());
    }

    public void update(Observable o, Object arg) {

	System.out.println("update of controler");
	List<String> params = (List<String>) arg;
	String commandKey = params.remove(0);
	Command c = invoke.get(commandKey);
	/*
	 * if (c == null) { view.displayError("Command " + commandKey +
	 * " not found"); return; }
	 */
	c.setParams(params);
	controller.insertCommand(c);
	// o.notifyObservers(arg);
    }

}
