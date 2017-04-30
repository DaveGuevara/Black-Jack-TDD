package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Game.Game;
import Game.Player;
import Game.Deck;
import Game.Card;

public class GameTest 
{
	private Game gm;

	@Before
	public void setUp() throws Exception
	{
		gm = new Game();
	}
	
	
	@Test
	public void GameStarts() throws Exception
	{	
		assertEquals(gm.GetPlayerCardCount(),gm.GetDealerCardCount());
	}
	@Test
	public void Restart() throws Exception
	{
		gm.DealHand();
		gm.DealHand();
		gm.DealHand();
		gm.Restart();
		assertEquals(0,gm.GetDealerCardCount());
	}
	@Test
	public void ClearHoldingCards() throws Exception
	{
		gm.DealHand();
		gm.DealHand();
		gm.ClearHoldingCards();
		assertEquals(0,gm.GetDealerCardCount());
	}
	@Test
	public void DealHand() throws Exception
	{
		gm.DealHand();
		assertEquals(1,gm.GetDealerCardCount());
	}
	
	

}
