package model;

import java.io.Serializable;
import java.util.HashMap;

public class GameObjectFactory implements  Serializable{

	
	HashMap<Character, Creator> gObjectCreator;
	
	
	public GameObjectFactory() {
	gObjectCreator = new HashMap<Character, Creator>();
	gObjectCreator.put('#', new WallCreator());
	gObjectCreator.put(' ', new FloorCreator());
	gObjectCreator.put('O', new TargetCreator());
	gObjectCreator.put('@', new BoxCreator());
	gObjectCreator.put('A', new ChararcterCreator());

	}
	private interface Creator{
		public GameObject create();
	}
	
	private class WallCreator implements Creator {
		public GameObject create() {
			return new Wall();
			
		}
	}
	private class FloorCreator implements Creator {
		public GameObject create() {
			return new Floor();
		}
	}
	private class TargetCreator implements Creator {
		public GameObject create() {
			return new Target();
		}
	}
	private class BoxCreator implements Creator {
		public GameObject create() {
			return new Box();
		}
	}
	private class ChararcterCreator implements Creator {
		public GameObject create() {
			return new GameCharacter();
		}
	}

	public GameObject createGameObject(char type){
		
		Creator c = gObjectCreator.get(type);
		if(c!=null) return c.create();
		return null;
		
	}
}
