package viewGUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.data.util.Level;
import view.Displayer;

public class LevelDisplayer extends Canvas implements Displayer {

    private char[][] levelData = { { 0, 0, 1, 1, 0, 1 } };
    private StringProperty wallFileName = new SimpleStringProperty();
    private StringProperty boxFileName = new SimpleStringProperty();
    private StringProperty charaFileName = new SimpleStringProperty();
    private StringProperty targetFileName = new SimpleStringProperty();
    private StringProperty floorFileName = new SimpleStringProperty();

    public LevelDisplayer() {

    }

    public void setWallFileName(String wallFileName) {
	this.wallFileName.set(wallFileName);
    }

    public void setBoxFileName(String boxFileName) {
	this.boxFileName.set(boxFileName);
    }

    public void setCharaFileName(String charaFileName) {
	this.charaFileName.set(charaFileName);
    }

    public void setFloorFileName(String floorFileName) {
	this.floorFileName.set(floorFileName);
    }

    public void setTargetFileName(String targetFileName) {
	this.targetFileName.set(targetFileName);
    }

    public String getWallFileName() {
	return wallFileName.get();
    }

    public String getBoxFileName() {
	return boxFileName.get();
    }

    public String getCharaFileName() {
	return charaFileName.get();
    }

    public String getTargetFileName() {
	return targetFileName.get();
    }

    public String getFloorFileName() {
	return floorFileName.get();
    }

    public void display(Level outLevel) {

	// levelData = outLevel.getCharMat();

	if (levelData != null) {

	    double W = getWidth();
	    double H = getHeight();
	    double h = H / levelData.length;
	    double w = W / levelData[0].length;

	    GraphicsContext gc = getGraphicsContext2D();
	    Image wall = null;
	    Image box = null;
	    Image chara = null;
	    Image target = null;
	    Image floor = null;

	    try {
		wall = new Image(new FileInputStream(wallFileName.get()));
		box = new Image(new FileInputStream(boxFileName.get()));
		chara = new Image(new FileInputStream(charaFileName.get()));
		target = new Image(new FileInputStream(targetFileName.get()));
		floor = new Image(new FileInputStream(floorFileName.get()));
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
	    // gc.setFill(Color.RED);
	    // gc.fillOval(cCol * w, cRow * h, w, h);
	    // gc.setFill(Color.BLUE);
	    // gc.fillOval(bCol * w, bRow * h, w, h);
	}

    }

}
