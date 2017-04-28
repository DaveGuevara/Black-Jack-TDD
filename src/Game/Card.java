package Game;
import java.util.*;

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
	
	public Card(Suit suit, int cardnumber) 
	{	
		try
		{
			this.suit = suit;
			if(cardnumber == 1)
			{
				this.CardValue = 11;	
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
				case 2-10:
					rtn = String.valueOf(this.CardNumber);
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
			return rtn += " of " + this.suit.toString();
		}
	}
	
}
