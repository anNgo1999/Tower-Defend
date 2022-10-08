import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mayflower.*;

public class multiTaskButton extends Actor
{
	private String function;
	public multiTaskButton(String task)
	{
		function = task;
		if(task.equals("save"))
		{
			setImage("button/save/save_able.bmp");
		}
		else if(task.equals("load"))
		{
			setImage("button/Load.bmp");
		}
		else if(task.equals("loadWindow"))
		{
			setImage("button/loadButton.png");
		}
		else if(task.equals("pause"))
		{
			setImage("button/pauseButton.bmp");
		}
		else if(task.equals("start"))
		{
			setImage("button/start.png");
		}
		else if(task.equals("startSpawn"))
		{
			setImage("button/startButton.png");
		}
	}
	
	//Enter load file screen
	public void enterLoadWindow()
	{
		Mayflower.setWorld(new loadWindow());
	}
	
	@Override
	public void act() 
	{
		// TODO Auto-generated method stub
		if(Mayflower.mouseClicked(this))
		{
			if(function.equals("loadWindow"))
			{
				enterLoadWindow();
			}
			else if(function.equals("start"))
			{
				String mapName = "maps/map1.txt";
				World temp = new StageLoader(mapName);
				Mayflower.setWorld(temp);
			}
			else if(function.equals("pause"))
			{
				World w = getWorld();
				w.addObject(new pauseScreen(), 0, 0);
				Mayflower.stop();
			}
			else if(function.equals("startSpawn"))
			{	
				if(getWorld().getObjects(Enemy.class).isEmpty())
				{ 
					for(int i = 0 ; i < getWorld().getObjects(enemySpawner.class).size() ; i++)
					{
						getWorld().getObjects(enemySpawner.class).get(i).spawnState(true);
					}
				}
			}
		}
	}
}
