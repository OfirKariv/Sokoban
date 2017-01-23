package viewGUI;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import model.data.util.Level;
import view.Displayer;
import view.View;

public class MainWindowController extends Observable implements View {
    List<String> params;
    Displayer displayer = new LevelDisplayer();

    public void setParams(List<String> params) {

	this.params = params;

    }

    @FXML
    LevelDisplayer LevelDisplayer;
    /*
     * public void start() { Thread thread = new Thread(new Runnable() {
     * 
     * @Override public void run() {
     * 
     * List<String> params = new LinkedList<String>();
     * 
     * FileChooser fc = new FileChooser(); fc.setTitle("Open Level");
     * fc.setInitialDirectory(new File("./resources")); File choosen =
     * fc.showOpenDialog(null); if (choosen != null) {
     * System.out.println(choosen.getName()); params.add("Load");
     * params.add(choosen.getAbsolutePath()); }
     * 
     * setChanged(); notifyObservers(params);
     * 
     * } }); thread.start(); }
     * 
     * // }
     *
     */

    public void start() {
	{

	}

    }

    public void loadFile() {

	params = new LinkedList<String>();

	FileChooser fc = new FileChooser();
	fc.setTitle("Open Level");
	fc.setInitialDirectory(new File("./resources"));
	File choosen = fc.showOpenDialog(null);
	if (choosen != null) {
	    params.add("Load");
	    params.add(choosen.getAbsolutePath());
	    setParams(params);
	    setChanged();
	    notifyObservers(params);
	}

    }

    @Override
    public void Display(Level myLevel) {

	displayer.display(myLevel.getCharMat());

    }

    @Override
    public void DisplayMess(String s) {
	// TODO Auto-generated method stub

    }

    @Override
    public void stop() {
	// TODO Auto-generated method stub

    }
}
