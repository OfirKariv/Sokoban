package model.data;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import model.data.util.Level;

public class MyXMLLevelSaver implements LevelSaver {

    @Override
    public OutputStream saveLevel(Level level, String s) {

	try {
	    XMLEncoder encod = new XMLEncoder(new FileOutputStream(s));
	    encod.writeObject(level);
	    encod.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	return null;
    }

}