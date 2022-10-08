import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import mayflower.*;

public class miniTower extends Tower
{	
	//Tower [cost]
	private int cost;
	//Tower [damage]
	private int dmg;
	//Tower [rate of fire]
	private Timer rof;
	//Tower [range] (in pixel)
	private int range;
	//Standby [image]
	private MayflowerImage standby;
	//Attack [image]
	private MayflowerImage attack;
	//Cool down after deploy 
	private Timer coolDown;
	//Animation
	private Animation ani;
	//Initialize standby animation
	MayflowerImage[] animation;
	//Initialize atk animation
	MayflowerImage[] atkAnimation;
	// Contructor
	public miniTower()
	{
		super();
		//Initialize standby image
		standby = new MayflowerImage("towers/minigun/minigun standby/1/standby-tier1-0.png");
		//Scale image
		standby.scale(32,32);
		//Set standby image
		setImage(standby);
		//Initialize attack image
		attack = new MayflowerImage("towers/minigun/minigun attack/1/attack-tier1.png");
		//Scale image to 32 by 32
		attack.scale(32,32);
		//Set image turn angle 
		turn(-90);
		//Initialize default :
		// [Cost]
		cost = 250;
		// [Damage]
		dmg = 1;
		// [Rof]
		rof = new Timer(400);
		// [Range]
		range = 35;
		//Create Standby animation
		animation = new MayflowerImage[4];
		for(int s = 0 ; s < animation.length ; s++)
		{
			animation[s] = new MayflowerImage("towers/minigun/minigun standby/1/standby-tier1-"+s+".png");
		}
		//Create Attack animation
	/*	atkAnimation = new MayflowerImage[4];
		for(int a = 0 ; a < atkAnimation.length ; a++)
		{
			atkAnimation[a] = new MayflowerImage("towers/minigun/minigun attack/1/attack-tier1-"+a+".png");
		}*/
		//Initialize animatoin actor
		ani = new Animation(this);
	}
	
	@Override
	public int getDMG() {
		// return damage of tower
		return dmg;
	}
	@Override
	public double getROF() {
		// return rate of fire
		return .2;
	}
	@Override
	public int getCost() {
		// return cost
		return cost;
	}
	
	
	@Override
	public double dmgModifier(Enemy enemy) 
	{
		// return dmg Modifier %
		if(enemy instanceof enemyFodder)
		{
			//Attack mult by 1.5
			return dmg*1.50;
		}
		else if(enemy instanceof enemyFlyer)
		{
			return dmg*.75;
		}
		//Return normal damage if not fit any enemy type
		return dmg;
	}
	
	@Override
	public String getExplain() {
		//Explaination of tower
		return "Minigun tower is the \n cheapest and effective again \n "
				+ "light armor vehicle like Humvee or APC";
	}
	//Attack enemy in range
	public void attack(Enemy enemy,int x , int y)
	{
		//Set the state
		setState("attack");
		//Apply attack to enemy
		enemy.takeDamage(dmgModifier(enemy));
		//Reset attack delay time .
		rof.reset();
	}
	
	//Show the upgrade and heal U.I
	public void showMod()
	{
		super.showMod();
	}
	
	//Call by upgrade class to upgrade the tower DMG , HP and Rof
	public void upgradeTower(int upgradeNum)
	{
		try
		{
			//Open file reading stream
			Scanner sc = new Scanner(new File("towers/minigun/minigunStat.txt"));
			//If upgrade to tier 1
			if(upgradeNum == 1)
			{
				cost = sc.nextInt();
				dmg = sc.nextInt();
				rof = new Timer(sc.nextInt());
				setCost(cost);
				standby =new MayflowerImage("towers/minigun/minigun standby/2/standby-tier2-0.png");
				attack = new MayflowerImage("towers/minigun/minigun attack/2/attack-tier2.png");
				ani.nextTierAnimation(upgradeNum , "minigun");
				cost = sc.nextInt();
			}
			//If upgrade to tier 2
			else if(upgradeNum == 2)
			{
				for(int i = 0 ; i < 4 ; i++)
				{
					sc.next();
				}
				cost = sc.nextInt();
				dmg = sc.nextInt();
				rof = new Timer(sc.nextInt());
				setCost(cost);
				standby =new MayflowerImage("towers/minigun/minigun standby/3/standby-tier3-0.png");
				attack = new MayflowerImage("towers/minigun/minigun attack/3/attack-tier3.png");
				ani.nextTierAnimation(upgradeNum , "minigun");
			}
			//If upgrade to tier 3
			else if(upgradeNum == 3)
			{
				for(int i = 0 ; i < 5 ; i++)
				{
					sc.next();
				}
				cost = sc.nextInt();
				dmg = sc.nextInt();
				rof = new Timer(sc.nextInt());
				standby = new MayflowerImage("towers/minigun/minigun standby/4/standby-tier4-0.png");
				attack = new MayflowerImage("towers/minigun/minigun attack/minigun_attack1-2up3.png");
				ani.nextTierAnimation(upgradeNum , "minigun");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void setDeployState(boolean state)
	{
		super.setDeployState(state);
		coolDown = new Timer(300);
	}
	
	public void act()
	{
		//If tower is deploy
		if(isDeploy())
		{	
			//If the tower is idle and deploy
			if(getState().equals("standby") && isDeploy())
			{
				//Do animation
				ani.act();
			}
			//If there a target in range
			if(!this.getObjectsInRange(range, enemyFodder.class).isEmpty() && isDeploy())
			{
				//Lock on to a enemy in range 
				List<Enemy> temp = this.getObjectsInRange(range, Enemy.class);
				Enemy enemy = temp.get(0);
				//Get enemy x coord
				int x = enemy.getX();
				//Get enemy y coord
				int y = enemy.getY();
				//Turn toward enemy
				turnTowards(enemy);
				//Set state to attack
				setState("attack");
				//Simulate the rate of fire by using timer . After timer done do
				//damge to the enemy that the tower lock on to 
				if(rof.isDone())
				{
					//Attack enemy at x,y
					attack(enemy,x,y);
				}
				if(enemy instanceof enemyFodder)
				{
					if(enemy.getHP() <= 0 )
					{
						getWorld().getObjects(userFund.class).get(0).increaseFund(50);
					}
				}
				if(enemy instanceof enemyFlyer)
				{
					if(enemy.getHP() <= 0)
					{
						getWorld().getObjects(userFund.class).get(0).increaseFund(60);
					}
				}
			}
			//If there are no enemy in range
			if(this.getObjectsInRange(range, enemyFodder.class).isEmpty())
			{
				//set the state to standby state
				setState("standby");
			}
			
			//If mouse click this object
			if(Mayflower.mouseClicked(this) && isDeploy())
			{
				//If the the cooldow is not null
				if(coolDown != null)
				{
					//Ifcool down is done 
					if(coolDown.isDone())
					{
						//Show tower upgrade and heal U.I
						showMod();
					}	
				}
			}
		}	
	}
}
