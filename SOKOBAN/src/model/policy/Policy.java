package model.policy;

import java.util.ArrayList;

import model.data.util.GameObject;

public interface Policy {
	public boolean isPathValid(ArrayList<GameObject> arr);
	

}
