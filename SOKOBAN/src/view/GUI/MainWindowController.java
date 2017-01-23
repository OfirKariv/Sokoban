package view.GUI;

import java.io.File;
import java.io.FileInputStream;

import javafx.stage.FileChooser;

public class MainWindowController {
	
	public void start(){
		System.out.println("starting level...");
	}
	public void openFile(){
		FileChooser fc=new FileChooser();
		fc.setTitle("Open Level");
		fc.setInitialDirectory(new File("./resources"));
		//fc.setSelectedExtensionFilter(null);//change to xml filter
		File choosen= fc.showOpenDialog(null);
		if (choosen!=null)
			System.out.println(choosen.getName());
		
	}
   // public void Display(Level mylevel) {
    	
	
//}
}