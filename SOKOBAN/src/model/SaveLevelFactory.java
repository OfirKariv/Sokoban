package model;

import java.util.HashMap;

import model.data.LevelSaver;
import model.data.MyObjectLevelSaver;
import model.data.MyTextLevelSaver;
import model.data.MyXMLLevelSaver;
import model.data.util.Level;

public class SaveLevelFactory {

    private HashMap<String, LevelSaver> fileType;

    public SaveLevelFactory() {

	fileType = new HashMap<String, LevelSaver>();

	fileType.put("txt", new MyTextLevelSaver());
	fileType.put("xml", new MyXMLLevelSaver());
	fileType.put("obj", new MyObjectLevelSaver());

    }

    public Level setFile(String path) {

	Level myLevel = new Level();
	String[] args = path.split("\\.");

	String s[] = args[1].split("\\.");
	fileType.get(s[1]).saveLevel(myLevel, args[1]);
	return myLevel;

    }

}
