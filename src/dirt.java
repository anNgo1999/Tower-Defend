import mayflower.*;
public class dirt extends coordinate
{
	public dirt()
	{
		MayflowerImage ground = new MayflowerImage("field/dirt.png");
		ground.scale(32, 32);
		setImage(ground);
	}
	
	public void act()
	{
		
	}
}
