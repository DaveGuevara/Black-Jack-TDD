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
		// refresh the game 
		//gm.Restart();
		
		// Dealing the first 2 hands
		gm.DealHand();
		gm.DealHand();
		
		System.out.println("Player has " + gm.GetPlayerCardCount() + " cards.");
		PrintCards(gm.GetPlayerHoldingCards(), true);
		
		System.out.println("Dealer has " + gm.GetDealerCardCount() + " cards.");
		PrintCards(gm.GetDealerHoldingCards(), false );
		
		
		// collect bet
		int betamount;
		System.out.println("\nYour current balance is $ " + gm.GetPlayerBetBalance() + "\nDealer's balance is $ " + gm.GetDealerBetBalance() +"\n");
		System.out.println("How much would you like to bet?");
		betamount = sc.nextInt();
		gm.AddBetPot(betamount);
		
		// Loop for adding another card
		boolean addcard = true;
		String inputchoice = "";
		while(addcard)
		{			
			System.out.print("Add A Card 'YES' Or 'NO'?");
			inputchoice = sc.next();
			System.out.println();
			
			// request additional card
			if(inputchoice.compareToIgnoreCase("YES") == 0) 
			{
				gm.DealHand("player");
				addcard = true;
				// Print Cards
				System.out.println("Player has " + gm.GetPlayerCardCount() + " cards.");
				PrintCards(gm.GetPlayerHoldingCards(), true);
				
				System.out.println("Dealer has " + gm.GetDealerCardCount() + " cards.");
				PrintCards(gm.GetDealerHoldingCards(), false );
			}
			else if(inputchoice.compareToIgnoreCase("NO") == 0)
			{
				addcard = false;
			}
			
			// check if dealer needs card?
			if (gm.GetDealerHandSum() < 17)
			{
				gm.DealHand("dealer");
				
			}
			else
			{
				System.out.println("Dealer dose not want to play");
			}
		}
		
		
		// Print Cards showing dealers total hands
		System.out.println("Player has " + gm.GetPlayerCardCount() + " cards.");
		PrintCards(gm.GetPlayerHoldingCards(), true);
		
		System.out.println("Dealer has " + gm.GetDealerCardCount() + " cards.");
		PrintCards(gm.GetDealerHoldingCards(), true );
		
		// decide on winner
		if(gm.CheckPlayerWins())
		{
			//player wins
			gm.PayOut("player");
			System.out.println("\nCongratulations, you won!! ");
		}
		else
		{
			//dealer wins
			gm.PayOut("dealer");
			System.out.println("\nDealer won!! ");
		}
		
		// print balance after selecting winner
		System.out.println("\nAfter this game your balance is $ " + gm.GetPlayerBetBalance() + "\nand Dealer's balance is $ " + gm.GetDealerBetBalance() +"\n");
		
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
			//rest deck ==> shuffle
			// clear holding hands from players
			//
		}
		else if (answer.equalsIgnoreCase(option2))
		{
			rtn = false;
		}
		// ------------
		
		return rtn;
	}
	
	
	
	// HELPER methods
	public static void PrintCards(Card[] cards, boolean printfirstcard)
	{
		for(int x=0; x<cards.length; x++)
		{
			boolean print = (x == 0 && !printfirstcard)? false: true;
			
			Card tmpCard = cards[x];
			if(tmpCard != null && print){ System.out.println(tmpCard.ToString()); }
			if(!print){ System.out.println("FOLDED CARD");}
		}
	}
}
