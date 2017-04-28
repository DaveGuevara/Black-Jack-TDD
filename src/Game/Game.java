package Game;

public class Game 
{
	public Player player;
	public Player dealer;
	public Deck deck;
	int BetPot;
	
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
	
	
	public Player DealHand(Player pl)
	{
		pl.addCard(deck.nextCard());
		return pl;
	}
	

	public void AjustBetPot(int potamount)
	{
		
	}

	public void CheckHands()
	{
		
	}
	
}
