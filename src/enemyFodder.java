import mayflower.*;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation; 
public class enemyFodder extends Enemy 
{
	
	//Health of the enemy
	private int health;
	//Damage of the enemy
	private int damage;
	//Animation for enemy
	//private Animation ani;
	//How long before the enemy can move again
	private Timer moveTimer = new Timer(50);
	private int time;
	//Path for enemy to move 
	List<coordinate> path;
	//Default Contructor 
	public enemyFodder()
	{
		//def.scale(64, 64);
		setImage(new MayflowerImage("enemy/fodder/jeep.png"));
		//Initialize the health , damage and speed
		health = 10;
		damage = 1;
		this.setSpeed(1);
		
	}
	/*
	 * Scale HP , Atk and Spd for enemy
	 * */
	public void scale(int hp , int dmg , double spd)
	{
		health += hp;
		damage += dmg;
	}
	/*
	 * Get the enemy damage
	 * */
	public int getDamage()
	{
		return damage;
	}
	/*
	 * Get Enemy HP
	 * */ 
	public int getHP() {
		// TODO Auto-generated method stub
		return health;
	}
	/*
	 * Make this take damage
	 * */
	public void takeDamage(double amount)
	{
		health-=amount;
	}
	
	public void setPath(List<coordinate> p)
	{
		path = p;
	}
	public void act() 
	{
		super.act();
		//If [HP] below
		if(health <= 0)
		{
			//Remove the enemy
			getWorld().removeObject(this);
			/*if(!getWorld().getObjects(userFund.class).isEmpty())
			{
				 getWorld().getObjects(userFund.class).get(0).increaseFund(5);
			}*/
		}
		//Set up move/moveTimer for enemy
		//if(moveTimer.isDone())
		time++;
		if(time >2)
		{
			time = 0;
			moveTimer.reset();
			if(null != path )
    		{
    			//Turn all the tiles on the path blue
    			if(path == null)
    			{
    				System.out.println("There no path");
    			}
    			//Tell enemy to follow the path
    			followPath(path);
    			//reset the path instance variable
    			path = null;
    		}
		}
		if(getWorld()!=null)
		if(!getWorld().getObjects(userBase.class).isEmpty())
		{
			if(isTouching(userBase.class))
			{
				getWorld().getObjects(userBase.class).get(0).removeHP(2);
				getWorld().removeObject(this);
			}
		}
	}
}
