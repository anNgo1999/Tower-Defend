import mayflower.*;
public class Animation extends Actor
{
	private MayflowerImage[] standby;
	private MayflowerImage[] attack;
	private MayflowerImage[] ani;
	private Timer fps;
	private int frame;
	private Tower parent;
	public Animation(Tower parent)
	{	
		standby = new MayflowerImage[5];
		for(int s = 0 ; s < standby.length ; s++)
		{
			standby[s] = new MayflowerImage("towers/minigun/minigun standby/1/standby-tier1-"+s+".png");
		}
		attack = new MayflowerImage[5];
	//	for(int a = 0 ; a < attack.length ; a++)
	//	{
			//attack[a] = new MayflowerImage("towers/minigun/minigun attack/1/attack-tier1-"+a+".png");
	//	}
		//Set the animation tower parent
		this.parent = parent;
		//How long each before switch frame
		fps = new Timer(500);
		//Start at frame 0
		frame = 0;
	}
	private void setStandbyAnimation()
	{
		ani = standby;
	}
	
	private void setAttackAnimation()
	{
		ani = attack;
	}
	
	public void nextTierAnimation(int tier , String tower)
	{
		for(int i = 0 ; i < ani.length ; i++)
		{
			ani[i] = new MayflowerImage("towers/"+tower+"/"+tower+" standby/"+(tier+1)+"/standby-tier"+(tier+1)+"-"+i+".png");
		}
	}
	
	public void act()
	{
			//Play standby animation
		if(parent.getState().equals("standby"))
		{
			setStandbyAnimation();
		}
		else
		{
			setAttackAnimation();
		}
		if(ani != null)
		{
			if(fps.isDone())
			{
				if(frame < ani.length-1)
				{
					parent.setImage(ani[frame]);
					frame++;
				}
				else
				{
					frame = 0;
				}
				fps.reset();
			}
		}
	}
}
