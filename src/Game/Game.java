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
		this.dealer = new Player("Dealer", 1000);
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
		this.dealer = new Player("Dealer", 1000);
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
		if (this.deck.CardsOnDeck() < 2) { this.deck.RefillDeck(true); }
		
		this.player.addCard(deck.nextCard());
		this.dealer.addCard(deck.nextCard());
	}
	public void AddBetPot(int potamount)
	{	
		this.BetPot += potamount;  
	}
	public void CheckHands()
	{
		
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
		return player.getBetMoneyBalance();
	}
	
}
