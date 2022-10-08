import java.util.ArrayList;
import java.util.List;
import mayflower.*;
public class coordinate extends Actor implements Comparable
{
	private int fScore;
	
	public List<coordinate> getNeighbors()
	{
		return getNeighbors(20, false, coordinate.class);//With true , slow load time so F**k it.
	}
	
	public int getFScore()
	{
		return fScore;
	}
	public void setFScore(int score)
	{
		fScore = score;
	}
	 public int compareTo(Object other)
    {
    	if(other == null)
    		return -1;
    		
    	if(other instanceof coordinate)
    		return fScore - ((coordinate)other).getFScore();
    		
    	return -1;
    }
	public coordinate getTileAt(int x , int y)
	{
		List<coordinate> actor = getObjectsAtOffset(x, y, coordinate.class);
		if(actor.size() > 0)
		{
			return actor.get(0);
		}
		return null;
	}

	public void act()
	{
		
	}
	
}
