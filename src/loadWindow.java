import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import mayflower.*;
public class loadWindow extends World
{
	public loadWindow()
	{
		try
    	{
    		File f = new File("maps/loadWindow.txt");
    		Scanner s = new Scanner(f);
    		//Read the width and height from the map file
    		int width = s.nextInt();
    		int height = s.nextInt();
    		//Read the ID for tile
    		int tileID = 0;
    		//Create a temp tile type
    		Actor tile;
    		//Loop through each row and column of the map
    		for(int h = 0 ; h < height; h++)
    		{	
    			for(int w = 0 ; w < width; w++)
    			{
    	    		tileID = s.nextInt();
    	    		//Initialize a tile
    				tile = new loadInterface(tileID);
    				//temp Height
    				int ht = h;
    				//temp Width
    				int wt = w;
    				//Add object to the world
    				addObject(tile,wt*32,ht*32);
    				//Get the next ID
    			}
    		}
    		if(s.next().equals("Load:"))
    		{
        		//Get button X cor
        		int bX = Integer.parseInt(s.next().split("=")[1]);
        		//Get button Y cor
        		int bY = Integer.parseInt(s.next().split("=")[1]);
        		//Add load button to the world
        		addObject(new loadButton() , bX, bY);
    		}	
			File[] saveList = new File("save/").listFiles();
			for(int i = 0 ; i < saveList.length ; i++)
			{
				addObject(new text(saveList[i].toString(),true),71,64+i*32);
			}
    	}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void act()
	{
		
	}
}
