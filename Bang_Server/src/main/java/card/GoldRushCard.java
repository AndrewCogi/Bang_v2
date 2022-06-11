/* 
 * class name: GoldRushCard
 * purpose: have gold rush card information
 */

package card;

public class GoldRushCard{
	// card color
	private String cardColor;
	// card name
	private String cardName;
	// card cost
	private int cost;

	// constructor
	public GoldRushCard(String cardColor, String cardName, int cost){
		this.cardColor = cardColor;
		this.cardName = cardName;
		this.cost = cost;
	}

	// get card name
	public String getCardName(){
		return cardName;
	}

	// get card color
	public String getCardColor(){
		return cardColor;
	}

	// get card cost
	public int getCost(){
		return cost;
	}
}
