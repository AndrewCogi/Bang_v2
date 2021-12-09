/* 
 * class name: RoleCard
 * purpose: have role card information
 */

package card;

public class RoleCard{
	// card name
	private String cardName;
	
	// constructor
	public RoleCard(String cardName){
		this.cardName = cardName;
	}

	// get card name
	public String getCardName(){
		return cardName;
	}
}
