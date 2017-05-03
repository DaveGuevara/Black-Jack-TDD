package Game;

public class Game 
{
	private Player player;
	private Player dealer;
	private Deck deck;
	private int BetPot;
	
	// Constructor
	public Game()
	{	
		this.player = new Player("Player 1", 1000);
		this.dealer = new Player("Dealer", 10000);
		this.deck = new Deck();
		this.BetPot = 0;
	}
	public Game(int p1, int dlr)
	{
		this.player = new Player("Player 1", p1);
		this.dealer = new Player("Dealer", dlr);
		this.deck = new Deck();
		this.BetPot = 0;
	}
	public Game(Player p1, Player dlr)
	{
		this.player = p1;
		this.dealer = dlr;
		this.deck = new Deck();
		this.BetPot = 0;
	}
	
	// Game Activities
	public void Restart()
	{
		this.player = new Player("Player 1", 1000);
		this.dealer = new Player("Dealer", 10000);
		this.deck = new Deck();
		this.BetPot = 0;
	}
	public void GetNewDeck()
	{
		this.deck = new Deck();
	}
	public void ShuffleCurrentDeck()
	{
		this.deck.shuffle();
	}
	public void ClearHoldingCards()
	{
		this.player.emptyHand();
		this.dealer.emptyHand();
	}
	public boolean DealHand()
	{
		return this.DealHand(Selector.Both);
	}
	public boolean DealHand(Selector Selection)
	{
		boolean rtn = true;
		
		switch(Selection)
		{
			case Player:
				if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
				this.player.addCard(deck.nextCard());
				break;
			case Dealer:
				if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
				this.dealer.addCard(deck.nextCard());
				break;
			case Both:
				if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
				this.player.addCard(deck.nextCard());
				this.dealer.addCard(deck.nextCard());
				break;
			default:
				rtn = false;
				break;
		}
		
		return rtn;
	}
	public void AddBetPot(int potamount)
	{
		this.player.adjustBetMoney(-potamount);
		this.BetPot += potamount;
		
		this.dealer.adjustBetMoney(-potamount);
		this.BetPot += potamount;
	}
	public Selector DecideWinner()
	{
		int Goal = 21;
		int playerSum = this.player.getHandSum();
		int dealerSum = this.dealer.getHandSum();
		
		// Declare a tie
		if (playerSum == dealerSum) { return Selector.Both;}			
		// Player has blackjack
		if (this.player.getHandSum() == 21) { return Selector.Player; }
		// Dealer has blackjack
		if (this.dealer.getHandSum() == 21)	{ return Selector.Dealer; }
		
		// Since none of the above options work, then Closest to 21 wins
		int playerMod = Goal % playerSum;
		int dealerMod = Goal % dealerSum;
		
		//smallest modulo wins
		return (playerMod<dealerMod)? Selector.Player : Selector.Dealer; 		
	}
	public void PayOut(Selector selection)
	{
		switch(selection)
		{
			case Player:
				this.player.adjustBetMoney(this.BetPot);
				this.BetPot = 0;
				break;
			case Dealer:
				this.dealer.adjustBetMoney(this.BetPot);
				this.BetPot = 0;
				break;
			case Both:
				int tiePot = this.BetPot/2;
				this.player.adjustBetMoney(tiePot);
				this.dealer.adjustBetMoney(tiePot);
				this.BetPot = 0;
				break;	
			default:				
				break;
		}	
	}

	
	
	// --------------------------- Not used in Junit, they only access already tested player controls ------------------
	// Player Accessibility
	public Card[] GetHoldingCards(Selector selection)
	{		
		switch(selection)
		{
			case Player:
				return this.player.getHoldingCards();				
			case Dealer:
				return this.dealer.getHoldingCards();				
			default:
				return null;				
		}		
	}
	public int GetCardCount(Selector selection)
	{
		switch(selection)
		{
			case Player:
				return this.player.getCardCount();				
			case Dealer:
				return this.dealer.getCardCount();				
			default:
				return 0;				
		}				
	}
	public int GetBetBalance(Selector selection)
	{
		switch(selection)
		{
			case Player:
				return this.player.getBetMoneyBalance();				
			case Dealer:
				return this.dealer.getBetMoneyBalance();				
			default:
				return 0;				
		}				
	}
	public int GetHandSum(Selector selection)
	{
		switch(selection)
		{
			case Player:
				return this.player.getHandSum();				
			case Dealer:
				return this.dealer.getHandSum();				
			default:
				return 0;				
		}			
	}
	public boolean GetBust(Selector selection)
	{
		switch(selection)
		{
			case Player:
				return this.player.getBust();				
			case Dealer:
				return this.dealer.getBust();				
			default:
				return false;				
		}	
	}
	public int GetBuyIn(Selector selection)
	{
		switch(selection)
		{
			case Player:
				return this.player.getBuyIn();				
			case Dealer:
				return this.dealer.getBuyIn();				
			default:
				return 0;				
		} 
	}
}
