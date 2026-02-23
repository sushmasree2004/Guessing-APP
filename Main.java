


/*

@author : B.Sushma Sree
@version: 4

*/

import java.util.*;
import java.lang.*;

public class Main 
{
   public static void main(String args[]) throws InvalidInputException
   {
	   System.out.println("Welcome To GUESSING APP ");
	   GameConfig game=new GameConfig();
	   game.showRules();
	   
	   
	   
	   Scanner sc = new Scanner(System.in);
	   int attempts=0;
	   
	   while(attempts<game.getMax_Attempts())
	   {
		   
		   System.out.print("Enter Your Guess : ");
		   int guess=ValidationService.validateInput(sc.nextLine());
		   attempts++;
		   
		   
		   
		   String result=GuessValidator.validateGuess(guess,game.getTargetNumber());
		   System.out.println(result);
		   
		   
		   
		   if(" CORRECT ".equals(result))
		   {
			   break;
			   
		   }
		   if(!" CORRECT ".equals(result)) 
		   {
               if(attempts <= game.getMax_Hints())
		       {
                  System.out.println(HintService.generateHint(game.getTargetNumber(), attempts));
              }
           }

	   }
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




class GuessValidator
{
	
	public static String validateGuess(int guess,int target)
	{
		if(guess==target)
		{
			return " CORRECT ";
		}
		else if(guess<target)
		{
			return " LOW ";
			
		}
		
		return " HIGH ";
	}
	
}


class HintService 
{
	
	public static String generateHint(int target,int hintCount)
	{
		if(hintCount==1)
		{
			return (target%2==0)? 
			"Hint : Number is EVEN " : 
			"Hint : Number is ODD  ";
			
		}
		
		else if(hintCount==2)
		{
			return (target>50) ?
			"Hint : Number is greater than 50 ":
			"Hint : Number is 50 or less ";			
			
		}
		
		return "NO More Hints Available";
		
	}
	
}


class ValidationService
{
	public static int validateInput(String input) throws InvalidInputException
	{
		try
		{
			int val=Integer.parseInt(input);
			if(val<1 || val>100)
			{
				throw new InvalidInputException("Number must be between 1 and 100");
			}
			
			
			return val;
		}
		
		catch(NumberFormatException e)
		{
			throw new InvalidInputException("Invalid inout .Please enter numbers only ..");
		}
		
	}
	
	
	
}

class InvalidInputException extends Exception 
{
    public InvalidInputException(String message) 
    {
        super(message);
    }
}
