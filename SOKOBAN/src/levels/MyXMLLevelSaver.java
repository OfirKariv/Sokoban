package levels;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MyXMLLevelSaver implements LevelSaver {

    @Override
    public OutputStream SaveLevel(Level level, String s) {

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