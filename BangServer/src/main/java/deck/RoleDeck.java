/* 
 * class name: RoleDeck
 * purpose: game role card deck for allocate players' role
 * (sceriffo(1),vice(2),fuorilegge(3),rinnegato(1))
 */

package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.RoleCard;

public class RoleDeck{
	// deck
	private List<RoleCard> deck;

	// constructor
	public RoleDeck(){
		deck = new ArrayList<>();
	}

	// making role deck
	public void make_init_deck(){
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

	// get [idx] element name (== cardName)
	public String getCardName(int idx){
		return deck.get(idx).getCardName();
	}
}
