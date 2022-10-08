import mayflower.*;

public class buyRock extends buyTower 
{
	public buyRock()
	{
		//Create a new image variable
		MayflowerImage buy = new MayflowerImage("button/buy Rocket.png");
		//Scale it
		buy.scale(32, 32);
		//Set image
		setImage(buy);
		//set the tower cost
		setCost(350);
		//Set type of tower to generate when buy
	}
	
	public Tower getTowerType()
	{
		return new rockTower();
	}
	
	
	public void act()
	{
		super.act();
	}
}