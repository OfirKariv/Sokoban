
package controller;

import java.util.HashMap;

import model.Model;
import model.MyModel;
import model.data.LevelSaver;

public class SaveCommand extends Command {
    private Model model;
    HashMap<String, LevelSaver> filetype;

    public SaveCommand() {

	model = new MyModel();
    }

    @Override
    public void execute() {
	model.save(params.get(0));
    }

}