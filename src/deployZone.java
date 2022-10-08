import java.util.List;

import mayflower.*;
public class deployZone extends Actor
{
	//State of zone : 1 = use 
	//0 = empty
	private int state = 0;
	public deployZone()
	{
		MayflowerImage dZone = new MayflowerImage("field/zone.png");
		dZone.scale(32,32);
		setImage(dZone);
		//setImage("towers/minigun/minigun standby/bipod.png");
	}
	
	//Use to set check the tile to be put onto the dZone
	public boolean isCorrectContact()
	{
		// the list consists of actors touching the class
		List<Tower> touching = getObjectsInRange(12, Tower.class);
		if(!touching.isEmpty())
		{
			return true;
		}
		return false;
	}
	public void placeTower()
	{
		state = 1;
	}
	public void act() 
	{
		// TODO Auto-generated method stub
		if(isCorrectContact() && state == 0)
		{
			setImage("field/zoneGreen.png");
		}
		else
		{
			setImage("field/zone.png");
		}
	}

}
