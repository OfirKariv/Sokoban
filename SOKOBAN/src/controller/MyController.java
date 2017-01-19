package controller;

import java.util.Observable;

import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class MyController implements Controller {

    Model model = new MyModel();
    View ui = new MyView();

    public void update(Observable o, Object arg) {

	System.out.println("update of controler");
	o.notifyObservers(arg);
    }

}
