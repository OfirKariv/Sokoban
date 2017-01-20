package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import model.data.Level;
import model.data.LevelLoader;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;

public class LoadCommand implements Command {

    HashMap<String, LevelLoader> fileType;

    public LoadCommand() {
	fileType = new HashMap<String, LevelLoader>();
	fileType.put("txt", new MyTextLevelLoader());
	fileType.put("xml", new MyXMLLevelLoader());
	fileType.put("obj", new MyObjectLevelLoader());
    }

    @Override
    public Level execute(String[] args, Level mylevel) {

	String s[] = null;
	s = args[1].split("\\.");

	System.out.println("--------------");

	try {
	    mylevel = fileType.get(s[1]).loadLevel(new FileInputStream(args[1]));
	} catch (ClassNotFoundException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();
	}
	System.out.println("--------------");

	return mylevel;

    }

}
