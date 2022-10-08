import mayflower.*;

public class buyMinigun extends buyTower 
{
	//Count the number of click
	public buyMinigun()
	{
		//Create a new image variable
		MayflowerImage buy = new MayflowerImage("button/buy Minigun.png");
		//Scale it
		buy.scale(32, 32);
		//Set image
		setImage(buy);
		//Set the tower cost
		setCost(250);
	}
	
	public Tower getTowerType()
	{
		return new miniTower();
	}
	
	public void act()
	{
		super.act();
	}
}