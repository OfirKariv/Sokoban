package viewGUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import view.Displayer;

public class LevelDisplayer extends Canvas implements Displayer {

    int[][] levelData = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
	    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
	    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
	    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
	    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
	    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },

    };
    private StringProperty wallFileName;
    private StringProperty charaFileName;

    public LevelDisplayer() {

	wallFileName = new SimpleStringProperty();
	charaFileName = new SimpleStringProperty();

    }

    public String getWallFileName() {
	return wallFileName.get();
    }

    public void setWallFileName(String wallFileName) {
	this.wallFileName.set(wallFileName);
    }

    public String getCharaFileName() {
	return charaFileName.get();
    }

    public void setCharaFileName(String charaFileName) {
	this.charaFileName.set(charaFileName);
    }

    @Override
    public void display(char[][] mat) {
	double W = getWidth();
	double H = getHeight();
	double w = W / levelData[0].length;
	double h = H / levelData.length;

	GraphicsContext gc = getGraphicsContext2D();
	Image wall = null;
	Image chara = null;
	try {
	    wall = new Image(new FileInputStream(wallFileName.get()));
	    chara = new Image(new FileInputStream(charaFileName.get()));

	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	gc.clearRect(0, 0, W, H);

	for (int i = 0; i < levelData.length; i++)
	    for (int j = 0; j < levelData[i].length; j++) {
		if (levelData[i][j] != 0)
		    if (wall == null)
			gc.fillRect(w * j, h * i, w, h);
		    else
			gc.drawImage(wall, w * j, h * i, w, h);

	    }

	gc.drawImage(chara, 0 * w, 1 * h, w, h);
	gc.setFill(Color.BLUE);
	gc.fillOval(9 * w, 6 * h, w, h);
    }

}
