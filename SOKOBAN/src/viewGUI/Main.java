package viewGUI;

import controller.MySokobanController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MyModel;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
	    FXMLLoader fxl = new FXMLLoader();
	    BorderPane root = fxl.load(getClass().getResource("MainWindow.fxml").openStream());
	    MainWindowController mwc = fxl.getController(); // view
	    MyModel m = new MyModel();
	    MySokobanController c = new MySokobanController(m, mwc);
	    mwc.addObserver(c);
	    m.addObserver(c);
	    Scene scene = new Scene(root, 400, 400);
	    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    primaryStage.setScene(scene);
	    primaryStage.show();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	launch(args);
    }
}
