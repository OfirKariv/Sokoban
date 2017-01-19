
package levels;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyTextLevelSaver implements LevelSaver {

    @Override
    public OutputStream SaveLevel(Level outlevel, String s) {

	PrintWriter out;
	try {
	    out = new PrintWriter(new FileWriter(s));

	    for (ArrayList<GameObject> arr : outlevel.getStaticPattern()) {
		for (GameObject go : arr) {
		    GameObject temp = null;
		    Position p = go.getPosition();

		    if ((outlevel.getMovaObj(p)) == null) {

			temp = outlevel.getStaticObj(p);

		    } else {
			temp = outlevel.getMovaObj(p);

		    }
		    out.write(temp.getSign());

		}
		out.write("\n");
	    }

	    out.close();
	}

	catch (IOException e) {

	    e.printStackTrace();
	}
	return null;
    }

}