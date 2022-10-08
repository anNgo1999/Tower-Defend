import mayflower.Actor;
public class loadInterface extends Actor
{
	public loadInterface(int id)
	{
		if(id == 0)
		{
			setImage("interface/loadUI/empty.png");
		}
		else if(id == 1)
		{
			setImage("interface/loadUI/topScreen.png");
		}
		else if(id == 2)
		{
			setImage("interface/loadUI/topEnd.png");
		}
		else if(id == 3)
		{
			setImage("interface/loadUI/leftScreen.png");
		}
		else if(id == 4)
		{
			setImage("interface/loadUI/bottomScreen.png");
		}
		else if(id == 5)
		{
			setImage("interface/loadUI/bottomEnd.png");
		}
	}
	public void act()
	{
		
	}
}
