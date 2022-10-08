import mayflower.*;
public class infoBox extends Actor
{
	public infoBox(String facing)
	{
		if(facing.equals("Tright"))
		{
			setImage("interface/infoBox/infoBox_Tright.bmp");
		}
		else if(facing.equals("Tleft"))
		{
			setImage("interface/infoBox/infoBox_TLeft.bmp");
		}
		else if(facing.equals("Bright"))
		{
			setImage("interface/infoBox/infoBox_Bright.bmp");
		}
		else if(facing.equals("Bleft"))
		{
			setImage("interface/infoBox/infoBox_BLeft.bmp");
		}
		else if(facing.equals("Bmid"))
		{
			setImage("interface/infoBox/infoBox_Tmid.bmp");
		}
		else if(facing.equals("Tmid"))
		{
			setImage("interface/infoBox/infoBox_Bmid.bmp");
		}	
		
		
		
	}
	@Override
	public void act() {
		// TODO Auto-generated method stub
	}

}
