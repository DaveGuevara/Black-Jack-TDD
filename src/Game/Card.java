package Game;

/**  
 * Creation of cards 
 * Created: April 20, 2017 
 * Author: Khaled & David
 * 
 */
public class Card {
	
	private Suit suit;
	private int CardNumber;
	private int CardValue;
	private boolean isAce;
	
	public Card(Suit suit, int cardnumber) 
	{	
		try
		{
			this.isAce = false;
			this.suit = suit;
			this.CardNumber = cardnumber;
			if(cardnumber == 1)
			{
				this.CardValue = 11;
				this.isAce = true;
			}
			else if (cardnumber > 9)
			{
				this.CardValue = 10;
			}
			else
			{
				this.CardValue = cardnumber;
			}
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}	
	
	// needs test
	public boolean isAce()
	{ 
		return this.isAce;
		}
	public int GetCardValue()
	{
		return this.CardValue;
	}
	public String ToString()
	{
		if (this.suit == null)
		{
			return "";
		}
		else
		{
			String rtn = "";
			switch(this.CardNumber)
			{
				case 1:
					rtn = "Ace";
					break;
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					rtn = String.valueOf(this.CardNumber).toString();
					break;
				case 11:
					rtn = "Jack";
					break;
				case 12:
					rtn = "Queen";
					break;
				case 13:
					rtn = "King";
					break;
			}
			return rtn + " of " + this.suit.toString();
		}
	}
	
}
