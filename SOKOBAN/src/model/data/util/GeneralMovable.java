package model.data.util;

import common.Position;

public abstract class GeneralMovable extends GameObject implements movable {

	
	public void setNewPos(Position p)
	{
		this.setPosition(p);
		
	}
		
		


	@Override
	public abstract char getSign();

	

}
