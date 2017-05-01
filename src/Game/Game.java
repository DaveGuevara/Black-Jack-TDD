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
	public void ShuffleCurrentDeck()
	{
		this.deck.shuffle();
	}
	public void Restart()
	{
		this.player = new Player("Player 1", 1000);
		this.dealer = new Player("Dealer", 10000);
		this.deck = new Deck();
		this.BetPot = 0;
	}
	public void ClearHoldingCards()
	{
		player.emptyHand();
		dealer.emptyHand();
	}
	public void DealHand()
	{
		this.DealHand("");
	}
	public void DealHand(String selection)
	{
		switch(selection.toLowerCase())
		{
			case "player":
				if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
				this.player.addCard(deck.nextCard());
				break;
			case "dealer":
				if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
				this.dealer.addCard(deck.nextCard());
				break;
			default:
				if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
				this.player.addCard(deck.nextCard());
				this.dealer.addCard(deck.nextCard());
				break;		
		}
	}
	public void AddBetPot(int potamount)
	{
		this.player.adjustBetMoney(-potamount);
		this.BetPot += potamount;
		
		this.dealer.adjustBetMoney(-potamount);
		this.BetPot += potamount;
	}
	public void CheckHands()
	{
		//if(dealerSum > 21 || mySum > dealerSum && mySum <= 21 || mySum < dealerSum && mySum >= 21 && money > 0)
		//if(this.GetPlayerHandSum() > 
		
	}
	public boolean CheckPlayerWins()
	{
		return true;
	}
	public void PayOut(String seletion)
	{
		if(seletion == "dealer"){
			this.dealer.adjustBetMoney(this.BetPot);
			this.BetPot = 0;
		}
		else
		{
			this.player.adjustBetMoney(this.BetPot);
			this.BetPot = 0;
		}
	}
	
	
	
	// --------------------------- Not used in Junit, they only access already tested player controls ------------------
	// Player Accessibility
	public Card[] GetPlayerHoldingCards()
	{
		return player.getHoldingCards();
	}
	public int GetPlayerCardCount()
	{
		return player.getCardCount();
	}
	public int GetPlayerBetBalance()
	{
		return player.getBetMoneyBalance();
	}
	public int GetPlayerHandSum()
	{
		return player.getHandSum();
	}
	
	// Dealer Accessibility
	public Card[] GetDealerHoldingCards()
	{
		return dealer.getHoldingCards();
	}
	public int GetDealerCardCount()
	{
		return dealer.getCardCount();
	}
	public int GetDealerBetBalance()
	{
		return dealer.getBetMoneyBalance();
	}
	public int GetDealerHandSum()
	{
		return dealer.getHandSum();
	}
	
}
