import mayflower.*;
public class mapMakerMultiButton extends Actor
{
	String type;
	public mapMakerMultiButton()
	{
		
	}
	public mapMakerMultiButton(String button)
	{
		type = button;
		if(button.equals("dirt"))
		{
			setImage("button/dirtButton.png");
		}
		else if(button.equals("wall"))
		{
			setImage("button/wallButton.png");
		}
		else if(button.equals("deploy zone"))
		{
			setImage("button/deployButton.png");
		}
		else if(button.equals("spawner"))
		{
			setImage("button/spawnerButton.png");
		}
		else
		{
			setImage("button/userBaseButton.png");
		}
	}
	public void act()
	{
		if(Mayflower.mouseClicked(this))
		{
			Actor temp ;
			boolean isDeploy = false;
			if(type.equals("dirt"))
			{
				temp = new dirt();
				getWorld().addObject(temp, getX() , getY());
				while(!isDeploy)
				{
					getWorld().addObject(temp, Mayflower.getMouseInfo().getX(), Mayflower.getMouseInfo().getY());
				}
			}
			else if(type.equals("wall"))
			{
				temp = new wall();
				getWorld().addObject(temp ,  getX (),  getY());
				while(!isDeploy)
				{
					getWorld().addObject(temp, Mayflower.getMouseInfo().getX(), Mayflower.getMouseInfo().getY());
				}
			}
			else if(type.equals("deploy zone"))
			{
				temp = new deployZone();
				getWorld().addObject(temp ,  getX (),  getY());
				while(!isDeploy)
				{
					getWorld().addObject(temp, Mayflower.getMouseInfo().getX(), Mayflower.getMouseInfo().getY());
				}
			}
			else if(type.equals("spawner"))
			{
				temp = new enemySpawner();
				getWorld().addObject(temp ,  getX (),  getY());
				while(!isDeploy)
				{
					getWorld().addObject(temp, Mayflower.getMouseInfo().getX(), Mayflower.getMouseInfo().getY());
				}
			}
			else
			{
				temp = new userBase();
				getWorld().addObject(temp ,  getX (),  getY());
				while(!isDeploy)
				{
					getWorld().addObject(temp, Mayflower.getMouseInfo().getX(), Mayflower.getMouseInfo().getY());
				}
			}
		}
	}
}
