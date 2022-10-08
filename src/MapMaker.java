import javax.swing.JOptionPane;
import mayflower.*;

public class MapMaker extends World
{
	public MapMaker()
	{
		//faddObject(new , ,);
	}
	public void act()
	{
		if(Mayflower.mouseClicked(getObjects(multiTaskButton.class)))
		{
			if(getObjects(userBase.class).size() > 1)
			{
				JOptionPane.showMessageDialog(null,"There can't be no more than one base. \n Please remove any extra");
			}
			if(getObjects(dirt.class).size() < 1)
			{
				JOptionPane.showMessageDialog(null, "Not enough road for enemy \n Please add more");
			}
			if(getObjects(deployZone.class).size() < 1)
			{
				JOptionPane.showConfirmDialog(null,"Are you sure you want 1 or less deploy zone");
			}
			if(getObjects(enemySpawner.class) == null)
			{
				JOptionPane.showMessageDialog(null ,  "No enemy spawner .\n Please add one !");
			}
		}
	}
}
