package Game;

public enum Selector 
{
	//player - 0, dealer - 1, tie - 2, Unknown - 3
	Player("Player"),	Dealer("Dealer"), Both("Both"), Unknown("Unknown");
	
	private String Selector;

	private Selector(String selector) {
		Selector = selector;
	}
	
	@Override
	public String toString() {		
		return Selector;
	}
	
}

