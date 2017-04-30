package Game;
import java.util.Scanner;

public class Main
{
	private static Game gm = new Game();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{		
		boolean outerloop = true;
		System.out.println("This is the the BLACK-JACK game!");
		
		while(outerloop){			
			System.out.println("Type 'start' for a new game or 'quit' to exit. \n");
			sc.hasNext();
						
			String option1 = "start";
			String option2 = "quit";
			
			String answer;
			answer = sc.next();
					
			if(answer.equalsIgnoreCase(option1))
			{
				boolean playagain = true;
				while(playagain){
					playagain = StartNewMatch();
				}
				outerloop = true;
			}
			else if (answer.equalsIgnoreCase(option2))
			{
				outerloop = false;
			}
			else
			{
				System.out.println(" I'm sorry, that's an invalid option.");
				outerloop = true;
			}
		}
		sc.close();
	}
	
	// Game Logic
	public static boolean StartNewMatch()
	{
		// loop through new 
		
		// Dealing the first 2 hands
		gm.DealHand();
		gm.DealHand();
		
		System.out.println("Player has " + gm.GetPlayerCardCount() + " cards.");
		PrintCards(gm.GetPlayerHoldingCards());
		
		System.out.println("Dealer has " + gm.GetDealerCardCount() + " cards.");
		PrintCards(gm.GetDealerHoldingCards());
		
		// Loop here
			// place bet!
			// decide if you hit, and draw a new card
		//
		
		
		// ---- PLAY AGAIN -----
		boolean rtn = false;
		System.out.println("Would you like to play again 'yes' or 'no'? \n");
		sc.hasNext();
					
		String option1 = "yes";
		String option2 = "no";
		
		String answer;
		answer = sc.next();
				
		if(answer.equalsIgnoreCase(option1))
		{
			rtn = true;
		}
		else if (answer.equalsIgnoreCase(option2))
		{
			rtn = false;
		}
		// ------------
		
		return rtn;
	}
	
	
	
	// HELPER methods
	public static void PrintCards(Card[] cards)
	{
		for(int x=0; x<cards.length; x++)
		{
			Card tmpCard = cards[x];
			if(tmpCard != null){ System.out.println(tmpCard.ToString()); }
		}
	}
}
