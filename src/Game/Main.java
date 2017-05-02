package Game;
import java.util.InputMismatchException;
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
				gm.Restart();
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
		System.out.println("\nNew BlackJack table created for you.");
		
		// refresh the game 
		//gm.GetNewDeck();
		System.out.println("Dealer gets a new deck.");
		//gm.ShuffleCurrentDeck();
		System.out.println("Dealer shuffles the deck.");
		
		
		// Dealing the first 2 hands to Player One at a time
		gm.DealHand(Selector.Player);
		gm.DealHand(Selector.Player);
		
		// Dealing the first 2 hands to Player One at a time
		gm.DealHand(Selector.Dealer);
		gm.DealHand(Selector.Dealer);
		
		
		System.out.println("Cards have been dealt, here are the playing cards:\n");
		// print current cards
		PrintCards(Selector.Player, true);						
		PrintCards(Selector.Dealer, false);
		
		
		// collect bet
		int betamount = 0;
		int max = gm.GetBetBalance(Selector.Player);
		boolean goingBet = true;
		
		
		PrintBalance(Selector.Player);
		PrintBalance(Selector.Dealer);
		
		while(goingBet == true)
		{
			boolean imputTest = true;
			
			while(imputTest)
			{
				System.out.println("\nHow much would you like to bet?");
				
				String temp = sc.next();
				
				try
				{
					betamount = Integer.parseInt(temp);
					imputTest = false;
				}
				catch (Exception e)
				{
					System.out.println("Please Enter A Valid Amount");
					imputTest =true;
				}
			}
			
			if(betamount <= max) // && betamount <= 2000 && max < 2000)
			{
				gm.AddBetPot(betamount);
				goingBet = false; 
			}
			else if (betamount >= max) // && betamount >= 2000)
			{
				System.out.println("No Sufficent Funds, Please Enter Less Than $" + gm.GetBetBalance(Selector.Player));
				goingBet = true;
			}
		}
	
	
		// Loop for adding another card
		boolean addcard = true;
		String inputchoice = "";
		while(addcard)
		{			
			System.out.print("\nAdd A Card 'YES' Or 'NO'?");
			inputchoice = sc.next();
			System.out.println();
			
			// request additional card
			if(inputchoice.compareToIgnoreCase("YES") == 0) 
			{
				gm.DealHand(Selector.Player);
				addcard = true;
				// Print Cards
				PrintCards(Selector.Player, true);											
				PrintCards(Selector.Dealer, false );
			}
			else if(inputchoice.compareToIgnoreCase("NO") == 0)
			{
				addcard = false;
			}			
		}
				
		////////////////////// ------  DECIDING WINNER -------///////////
		// if player busts then dealer wins
		if(gm.GetBust(Selector.Player))
		{
			PrintWinner(Selector.Dealer);
			gm.PayOut(Selector.Dealer); 			
		}
		else 
		{		
			// check if dealer needs card?
			if (gm.GetHandSum(Selector.Dealer) < 17)
			{
				gm.DealHand(Selector.Dealer);				
			}
			else
			{
				System.out.println("Dealer dose not want to play");
			}
		}
		
		// if dealer busts then player wins
		if (gm.GetBust(Selector.Dealer))
		{
			PrintWinner(Selector.Player);
			gm.PayOut(Selector.Player); 
		}
		else 
		{
			// Neither busts (sum is <= 21) Decide who is the closest to 21
			Selector handwinner = gm.DecideWinner();
			PrintWinner(handwinner);
			gm.PayOut(handwinner);
		}		
		////////////---------------------------------//////////
		
		// print balance after selecting winner
		PrintBalance(Selector.Player);
		PrintBalance(Selector.Dealer);
		
		
		// check if player current balance > (2Xbuy in) then no option to play again.
		
		// ---- PLAY AGAIN -----
		boolean rtn = false;
		boolean askplayagain = true;
		if (gm.GetBetBalance(Selector.Player) ==0 ) 
		{
			// print sorry, you lost all your money. you can start a news game.
			System.out.println("SORRY!! You've lost all your bet money.  Feel free to start a new game.");
			return false;
			
		}

		if ( gm.GetBetBalance(Selector.Player) >= (2 * gm.GetBuyIn(Selector.Player)))
		{
			// print .. you've doubled your initial buy it.  you can cash out and start a new game
			System.out.println("Congratulations! you've doubled your initial buy in.  You must start a new game.");
			PrintCashOut(Selector.Player);
			askplayagain = false;
		}
		
		if (askplayagain)
		{
			System.out.println("\nWould you like to play again 'yes' or 'no'? \n");
			sc.hasNext();
						
			String option1 = "yes";
			String option2 = "no";
			
			String answer;
			answer = sc.next();
					
			if(answer.equalsIgnoreCase(option1))
			{
				rtn = true;
				gm.ClearHoldingCards();
			}
			else if (answer.equalsIgnoreCase(option2))
			{
				rtn = false;
				// CASHOUT
				PrintCashOut(Selector.Player);
			}
		}
		// ------------
		
		return rtn;
	}
	
	
	
	// HELPER methods
	public static void PrintCards(Selector selection, boolean printfirstcard)
	{
		System.out.println(selection.toString() + " has " + gm.GetCardCount(selection) + " cards.");
		
		Card[] cards = gm.GetHoldingCards(selection);
		for(int x=0; x<cards.length; x++)
		{
			boolean print = (x == 0 && !printfirstcard)? false: true;
			
			Card tmpCard = cards[x];
			if(tmpCard != null && print){ System.out.println(tmpCard.ToString()); }
			if(!print){ System.out.println("HOLE CARD");}
		}
	}
	public static void PrintBalance(Selector selection)
	{
		System.out.println(selection.toString() + " current balance is $ " + gm.GetBetBalance(selection));
	}
	public static void PrintWinner(Selector selection)
	{
		// Print Cards showing dealers total hands		
		PrintCards(Selector.Player, true);				
		PrintCards(Selector.Dealer, true );
		
		switch(selection)
		{
			case Player:
				System.out.println("\n\nYou WIN!!!");
				break;
			case Dealer:
				System.out.println("\n\nDealer WINS!!!");
				break;
			case Both:
				System.out.println("\n\nIt's a TIE!!!");
				break;
			case Unknown:
				break;
			default:
				break;
		}
		
	}
	public static void PrintCashOut(Selector selection)
	{
		System.out.println("You have elected not to play again and CASH OUT.  Your $ " + gm.GetBetBalance(selection) + " will be paid to you at the door.");
	}
}
