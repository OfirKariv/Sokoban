
package controller;

import java.util.HashMap;

import model.Level;
import model.LevelSaver;
import model.MyObjectLevelSaver;
import model.MyTextLevelSaver;
import model.MyXMLLevelSaver;

public class SaveCommand implements Command {
    HashMap<String, LevelSaver> filetype;

    public SaveCommand() {
	filetype = new HashMap<String, LevelSaver>();
	filetype.put("txt", new MyTextLevelSaver());
	filetype.put("xml", new MyXMLLevelSaver());
	filetype.put("obj", new MyObjectLevelSaver());
    }

    @Override
    public Level execute(String[] args, Level mylevel) {

	String s[] = args[1].split("\\.");
	filetype.get(s[1]).SaveLevel(mylevel, args[1]);

	return mylevel;
    }

}