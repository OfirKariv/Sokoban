package view;

import model.data.util.Level;

public class TxtDisplayer implements Displayer {

    @Override
    public void display(Level myLevel) {

	char[][] mat = myLevel.getCharMat();

	for (int i = 0; i < mat.length; i++) {
	    for (int j = 0; j < mat[i].length; j++) {
		System.out.print(mat[i][j]);

	    }
	    System.out.println();
	}
    }

}
