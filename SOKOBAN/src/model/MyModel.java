package model;

import java.util.Observable;

import common.Position;
import model.data.util.GameCharacter;
import model.data.util.Level;
import model.policy.LevelChanger;

public class MyModel extends Observable implements Model {

    Level myLevel = null;
    LevelChanger change = new LevelChanger();
    private int relevantPlayer;

    public MyModel() {
	myLevel = new Level();
	setRelevantPlayer(0); // default
    }

    public void setLevel(Level level) {
	this.myLevel = level;
    }

    public void setRelevantPlayer(int relevantPlayer) {
	this.relevantPlayer = relevantPlayer;
    }

    @Override
    public void notifyObservers(Object arg) {

	System.out.println(arg);

    }

    @Override
    public void load(String path) {

	LoadLevelFactory lvlLoad = new LoadLevelFactory();
	setLevel(lvlLoad.setFile(path));

    }

    @Override
    public void save(String path) {

	SaveLevelFactory lvlSav = new SaveLevelFactory();
	setLevel(lvlSav.setFile(path));

    }

    @Override
    public Level getCurrentLevel() {

	return myLevel;

    }

    @Override
    public void move(String direction) {

	change.setLevel(this.getCurrentLevel());
	GameCharacter player = myLevel.getCharacters().get(relevantPlayer);
	Position playerPos = player.getPosition();
	System.out.println("(" + player.getPosition().getX() + "," + player.getPosition().getY() + ")");
	switch (direction) {

	case "up":

	    change.pathUp(playerPos);
	    break;

	case "down":

	    change.pathDown(playerPos);
	    break;

	case "left":

	    change.pathLeft(playerPos);
	    break;

	case "right":

	    change.pathRight(playerPos);

	    break;

	default:
	    break;

	}

	change.LevelChange();
	setLevel(change.getLevel());
	if (myLevel.isComplete()) {
	    System.out.println("Level completed!");

	}

    }
}