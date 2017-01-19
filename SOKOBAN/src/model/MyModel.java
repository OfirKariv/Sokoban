package model;

import java.util.Observable;

public class MyModel extends Observable implements Model {
    @Override
    public void notifyObservers(Object arg) {

	System.out.println(arg);

	super.notifyObservers(arg);

    }

    @Override
    public Level load() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void save() {
	// TODO Auto-generated method stub

    }

    @Override
    public Level getCurrentLevel() {
	// TODO Auto-generated method stub
	return null;
    }
}