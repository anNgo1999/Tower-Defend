import java.util.*;

import mayflower.*;

//This class uses the Depth First Search algorithm to find a path between two points
public class AStar extends Pathfinder
{
    public List<coordinate> getPath(World w, coordinate from, coordinate to)
    {
    	//Create a Map<Walkable, Walkable> to hold child->parent mappings
    	Map<coordinate, coordinate> childParent = new HashMap<coordinate, coordinate>();
    	//Create a Queue<Walkable> for the closed list
    	Queue<coordinate> close = new LinkedList<coordinate>();
    	//Create a PriorityQueue<Walkable> for te open list
    	PriorityQueue<coordinate> open = new PriorityQueue<coordinate>();
    	//Create a Map<Walkable, Integer> to store Walkable->gScore mappings
    	Map<coordinate, Integer> coordinateGscore = new HashMap<coordinate, Integer>();
    	//Add "from" to the open list
    	open.add(from);
    	//Set "from"'s gScore to 0 (in the map)
    	coordinateGscore.put(from,0);
    	//Use the getHScore method to determine "from"'s hScore
    	int hScore = getHScore(from, to);
    	//Set "from"'s FScore to 0+hScore using its getFScore method
    	from.setFScore(0+hScore);
    	//while the open list is not empty:
    	while(!open.isEmpty())
    	{
    		//Remove the Walkable with the smallest FScore from the open list, call it "current"
    		coordinate current = open.remove();
    		//if current is equal to "to", then break out of the loop
    		if(current.compareTo(to) == 0)
    		{
    			break;
    		}
    		close.add(current);
    		//Get a List<Walkable> of current's neighbors
    		List<coordinate> currentNeightbors = current.getNeighbors();
    		//for each neighbor:
    		for(coordinate neightbor : currentNeightbors)
    		{
    			//if the neighbor is in the closed list
    			if(close.contains(neightbor))
    			{	
    				//continue
    				continue;
    			}
    			
    			//Calculate the neighbors (possible) new gScore (1 + current's gScore)
    			int newGscore = coordinateGscore.get(current)+1;
    			int currentGscore = 0;
    			if(coordinateGscore.containsKey(neightbor))
    			{
        			//Get the neighbors current gScore from the gScore map
        			 currentGscore = coordinateGscore.get(neightbor);
    			}
    			//if the open list contains neighbor AND the calculated gScore is greater than or equal to its current gScore
    			if(open.contains(neightbor) && newGscore >= currentGscore)	
    			{
    				//continue
    				continue;
    			}
    			//Create a child->parent mapping between neighbor and current
    			childParent.put(neightbor, current);
    			//create a mapping between neighbor and the calculated gScore in the gScore map
    			coordinateGscore.put(neightbor, newGscore);
    			//Calculate neighbors HScore
    			int neighborHscore = getHScore( current ,neightbor);
    			//Set the neighbors fScore to (gScore + fScore) using its setFScore method
    			neightbor.setFScore(neighborHscore+newGscore);
    			//if the open list does not contain neighbor
    			if(!open.contains(neightbor))
    			{
    				//add neighbor to the open list
    				open.add(neightbor);
    			}
    		}
    	}  	
		//Return the List<coordinate> path
    	return listify(childParent,to);
    }
 
	//Helper method to calculate H Score using Distance Formula
	private int getHScore(coordinate from, coordinate to)
	{
		return (int)Math.sqrt(Math.pow((to.getX() - from.getX()), 2) + Math.pow((to.getY() - from.getY()), 2));
	}   
}