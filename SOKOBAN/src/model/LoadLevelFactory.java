package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import model.data.LevelLoader;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;
import model.data.util.Level;

public class LoadLevelFactory {

    private HashMap<String, LevelLoader> fileType;

    public LoadLevelFactory() {

	fileType = new HashMap<String, LevelLoader>();
	fileType.put("txt", new MyTextLevelLoader());
	fileType.put("xml", new MyXMLLevelLoader());
	fileType.put("obj", new MyObjectLevelLoader());

    }

    public Level setFile(String path) {

	Level myLevel = new Level();
	String[] args = path.split("\\.");

	try {
	    myLevel = fileType.get(args[1]).loadLevel(new FileInputStream(path));
	} catch (ClassNotFoundException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return myLevel;

    }

}
