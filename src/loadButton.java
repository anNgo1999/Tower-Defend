
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import mayflower.Mayflower;
import mayflower.Timer;
import mayflower.World;
public class loadButton extends Button
{
	String file;
	public loadButton()
	{
		setImage("button/load/load_no.png");
	}
	
	public void setLoadFile(String file)
	{
		this.file = file;
		setImage("button/load/load_able.png");
	}
	
	public void buttonFunction(String fileName)
	{
		StageLoader temp = new StageLoader(new File(fileName));
		Mayflower.setWorld(temp);
	}
	public void act()
	{
		if(Mayflower.mouseClicked(this))
		{
			buttonFunction(file);
		}
	}
}
