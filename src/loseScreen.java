import mayflower.World;

public class loseScreen extends World{

	public loseScreen()
	{
		//Set a temp pic to the button
		setBackground("interface/loseScreen.png");
		addObject(new returnMainButt(), 304, 400);
	}
	
	@Override
	public void act() 
	{
		// TODO Auto-generated method stub
		
		
	}

}
