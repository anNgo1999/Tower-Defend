import mayflower.*;
public abstract class Button extends Actor
{
	public Button()
	{
		setImage("button/PH_button.png");
	}
	
	/*
	 * Function of button
	 * */
	public void buttonFunction()
	{
		System.out.println("Do something");
	}
	
	public void act()
	{
		
	}
}

