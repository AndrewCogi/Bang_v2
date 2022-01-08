/* 
 * class name: ScenarioCard
 * purpose: have scenario card information
 */

package card;

public class ScenarioCard{
	// card name
	private String cardName;
	// card extension
	private String cardExtension;

	// constructor
	public ScenarioCard(String cardExtension, String cardName){
		this.cardExtension = cardExtension;
		this.cardName = cardName;
	}

	// get card name
	public String getCardName(){
		return cardName;
	}

	// get card extension
	public String getCardExtension(){
		return cardExtension;
	}
}
