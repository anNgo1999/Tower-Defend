import java.util.List;

public class Enemy extends PathFollower 
{
	/*
	 * Get Enemy HP
	 * */ 
	public int getHP(){
		return 10;
	}
	
	/*
	 * Get the enemy damage
	 * */
	public int getDamage(){
		return 1;
	}
	
	/*
	 * Make this take damage
	 * */
	public void takeDamage(double amount){
		
	}
	
	/*
	 * Scale HP , Atk and Spd for enemy
	 * */
	public void scale(int hp , int atk , double spd){
		
	}

	public void setPath(List<coordinate> remove) {
		// TODO Auto-generated method stub
		
	}

}
