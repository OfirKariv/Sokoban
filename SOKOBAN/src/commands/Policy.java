package commands;

import java.util.ArrayList;

import levels.GameObject;

public interface Policy {
	public boolean isPathValid(ArrayList<GameObject> arr);
	

}
