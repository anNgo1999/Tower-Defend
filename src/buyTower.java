import mayflower.*;
public class buyTower extends Actor
{
	private int cost;
	private Tower tower ;
	private boolean haveTower;
	public buyTower()
	{
		cost = 0;
		haveTower = false;
	}
	
	/**
	 * Set the cost depend on type of towers
	 * */
	public void setCost(int amount)
	{
		//Set the cost
		cost = amount;
	}
	/**
	 * Return tower type to initialize
	 * */
	public Tower getTowerType()
	{
		return null;
	}
	/**
	 * Allow to buy tower after set down one
	 * */
	public void setState(boolean state)
	{
		haveTower = state;
	}
	
	public void act()
	{
		//If the button is click
		if(Mayflower.mouseClicked(this))
		{
			//If have enough fund to buy and not having any hover tower
			if(getWorld().getObjects(userFund.class).get(0).getFund() >= cost && haveTower != true )
			{
				//Initialize a new tower type
				 tower = getTowerType();
				//Decrease fund
				getWorld().getObjects(userFund.class).get(0).decreaseFund(cost);
				//Get the stage/world
				StageLoader stage = (StageLoader)getWorld();
				//Add tower to the stage/world
				stage.buyTower(tower);
				//Allow user to buy a new tower 
				haveTower = true;
			}
		}
	}
}
