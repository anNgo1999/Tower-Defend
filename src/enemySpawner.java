//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import mayflower.Actor;
//import mayflower.Mayflower;
import mayflower.Timer;
import mayflower.World;

public class enemySpawner extends Actor
{
	//Count number have spawn
	private int enemyCount;
	//scale number for enemy spawn
	private int scaleSpawn;
	//Count number of waves
	private int wave;
	//Game state
	private boolean stateGame;
	//Timer for spawn
	private Timer enemySpawnTime;
	//Path for enemy
	private List<coordinate> path;
	//Store copy of path
	private List<List<coordinate>> routes;
	
	//Contructor
	public enemySpawner()
	{
		//A collection of copy for path
		routes = new ArrayList<List<coordinate>>();
		//Set the image for enemy
		setImage("enemy/spawner.png");
		//Count number of enemy have been spawn
		enemyCount = 0;
		//Keep track of how many wave have pass
		wave = 0;
		//Timer to spawn enemy after 1000 milisecond
		enemySpawnTime = new Timer(1000);
		//Number of enemy spawn per wave , increase each wave
		scaleSpawn = 10;
		//Set spawn state to stop
		stateGame = false;
	}
	
	/*
	 * Get the wave count 
	 * */
	public int getWave()
	{
		return wave;
	}
	public void setWave(int wave)
	{
		this.wave = wave;
	}
	/*
	 * Create a path for enemy 
	 * */
	private void makePath()
	{
		AStar a = new AStar();
		coordinate from = getWorld().getObjectsAt(getX(), getY(),coordinate.class).get(0);
		coordinate to = getWorld().getObjectsAt(32, 14*32, coordinate.class).get(0);
		path = a.getPath(getWorld(), from, to);
	}
	
	/*
	*Scale spawing enemy's [HP] by their type , scale base on waves have pass
	* */
	public  int getScaleHP(Enemy enemy , int wave)
	{
		if(enemy instanceof enemyFodder)
		{
			return 5;
		}
		if(enemy instanceof enemyFlyer)
		{
			return 4;
		}
		return 0;
	}//BROKEN . FIX IT AN . Scale reset after first turn of every 5 wave . Same for the other scaling method
	
	/*
	 * Scale spawing enemy's [Damage] by their type , scale base on waves have pass
	 * */
	public void spawnState(boolean state)
	{
		stateGame = state;
	}
	public boolean getState()
	{
		return stateGame;
	}
	public void act()
	{
		
		
		//If there no path for enemy to move
		if(path == null)
		{
			//Make one
			makePath();
		}
		
		//If no more path copy
		if(routes.isEmpty())
		{
			//For one hundred enemy
			for(int i = 0; i < 10; i++)
			{
				//Add copy of main path
				routes.add(new ArrayList<coordinate>());
				//Add path coordinate to each routes copy
				for(int j =0; j< path.size(); j++)
				{
					routes.get(i).add(path.get(j));
				}
			}
		}
		//Start the spawning process
		if(stateGame)
		{
			//After 1 second
			if(enemySpawnTime.isDone())
			{
				//If less than 10[PH] enemy haven been spawn
				if(enemyCount < scaleSpawn)
				{				
					//Increase enemy spawn count by 1 
					enemyCount++;
					Enemy enemy ;
					if(enemyCount % 5 == 0)
					{
						enemy = new enemyFlyer();
					}
					else
					{
						enemy =  new enemyFodder();
					}
					//Add it to the world
					getWorld().addObject(enemy, getX(), getY());
					//Set the path for enemy
					enemy.setPath(routes.remove(0));
					//Reset enemy spawn timer
					enemySpawnTime.reset();
				}
			}
		}	
		
		// If there no more enemy on the field and 10[PH] already spawn
		if(enemyCount == scaleSpawn)
		{
			//Reset enemy spawn timer
			enemyCount = 0;
			//Increase the wave count
			wave++;
			//Increase the number of enemy spawn every wave
			scaleSpawn+=4;
			//Set the spawn state to stop
			stateGame = false;
		}
	}
}
