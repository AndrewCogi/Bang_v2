/* 
 * class name: CardDeck
 * purpose: game multi-purpose card deck (character, role etc...)
 */

package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoleDeck{
	// deck
	private List<RoleCard> deck;

	// constructor
	public RoleDeck(){
		deck = new ArrayList<>();
	}

	// making role deck
	public void make_role_deck(){
		// re-init role deck
		deck = new ArrayList<>();
		// add informations
		deck.add(new RoleCard("sceriffo"));
		deck.add(new RoleCard("vice"));
		deck.add(new RoleCard("vice"));
		deck.add(new RoleCard("rinnegato"));
		deck.add(new RoleCard("fuorilegge"));
		deck.add(new RoleCard("fuorilegge"));
		deck.add(new RoleCard("fuorilegge"));
	}
	
	// shuffle role deck
	public void shuffle(){
		Collections.shuffle(deck);
	}

	// get [idx] element (== cardName)
	public String getCardName(int idx){
		return deck.get(idx).getCardName();
	}
}
