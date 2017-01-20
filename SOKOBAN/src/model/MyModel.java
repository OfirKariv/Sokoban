package model;

import java.util.Observable;

import model.data.Level;

public class MyModel extends Observable implements Model {

    @Override
    public void notifyObservers(Object arg) {

	System.out.println(arg);

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

    @Override
    public Level move() {
	// TODO Auto-generated method stub
	return null;
    }

}