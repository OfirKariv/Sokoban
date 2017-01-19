package commands;

import levels.GameCharacter;
import levels.Level;
import levels.Position;

public class MoveCommand implements Command {

    private LevelChanger change = new LevelChanger();
    private int relevantPlayer;

    public MoveCommand() {
    };

    public void setup(int relevantPlayer, Policy policy) {
	change.setPolicy(policy);
	this.relevantPlayer = relevantPlayer;

    }

    public Level execute(String[] args, Level myLevel) {

	GameCharacter player = myLevel.getCharacters().get(relevantPlayer);
	Position playerPos = player.getPosition();
	change.setLevel(myLevel);
	switch (args[1]) {

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
	myLevel = change.LevelChange();
	if (myLevel.isComplete()) {
	    System.out.println("Level completed!");

	}
	return myLevel;

    }
}