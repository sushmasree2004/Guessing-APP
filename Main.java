


/*

@author : B.Sushma Sree
@version: 1

*/

import java.util.*;
public class Main 
{
   public static void main(String args[])
   {
	   System.out.println("Welcome To GUESSING APP ");
	   GameConfig game=new GameConfig();
	   game.showRules();
   }
}


class GameConfig
{
	
	private final int MIN=1;
	private final int MAX=100;
	private final int MAX_ATTEMPTS=7;
	private final int MAX_HINTS=3;
	
	
	int targetNumber;
	
	
	public GameConfig()
	{
		Random rd=new Random();
		this.targetNumber=rd.nextInt(MAX-MIN+1)+MIN;
		
	}
	
	public int getTargetNumber()
	{
		return targetNumber;
	}
	
	public int getMax_Attempts()
	{
		return MAX_ATTEMPTS;
	}
	
	public int getMax_Hints()
	{
		return MAX_HINTS;
	}
	
	
	
	public void showRules()
	{
		System.out.println("Guess a number between "+MIN+" and "+MAX);
		System.out.println("You have "+MAX_ATTEMPTS+"  attempts . ");
		System.out.println("Hints will be provided after wrong gueeses.\n ");
		
	}
}