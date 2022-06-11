/* 
 * class name: GoldRushDeck
 * purpose: gold rush card deck
 */

package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.GoldRushCard;

public class GoldRushDeck{
	// deck
	private List<GoldRushCard> deck;

	// constructor
	public GoldRushDeck(){
		deck = new ArrayList<>();
	}

	// making gold rush deck
	public void make_init_deck(){
		// re-init gold rush deck
		deck = new ArrayList<>();
		// add informations
		deck.add(new GoldRushCard("brown","bicchierino",1));
		deck.add(new GoldRushCard("brown","bicchierino",1));
		deck.add(new GoldRushCard("brown","bicchierino",1));
		deck.add(new GoldRushCard("brown","bottiglia",2));
		deck.add(new GoldRushCard("brown","bottiglia",2));
		deck.add(new GoldRushCard("brown","bottiglia",2));
		deck.add(new GoldRushCard("brown","complice",2));
		deck.add(new GoldRushCard("brown","complice",2));
		deck.add(new GoldRushCard("brown","complice",2));
		deck.add(new GoldRushCard("brown","corsa_all'oro",5));
		deck.add(new GoldRushCard("brown","rum",3));
		deck.add(new GoldRushCard("brown","rum",3));
		deck.add(new GoldRushCard("brown","union_pacific",4));
		deck.add(new GoldRushCard("black","calumet",3));
		deck.add(new GoldRushCard("black","cinturone",2));
		deck.add(new GoldRushCard("black","ferro_di_cavallo",2));
		deck.add(new GoldRushCard("black","piccone",4));
		deck.add(new GoldRushCard("black","ricercato",2));
		deck.add(new GoldRushCard("black","ricercato",2));
		deck.add(new GoldRushCard("black","ricercato",2));
		deck.add(new GoldRushCard("black","setaccio",3));
		deck.add(new GoldRushCard("black","stivali",3));
		deck.add(new GoldRushCard("black","talismano",3));
		deck.add(new GoldRushCard("black","zaino",3));
	}

	// shuffle gold rush deck
	public void shuffle(){
		Collections.shuffle(deck);
	}

	// pop card
	public GoldRushCard pop(){
		GoldRushCard result = deck.get(0);
		deck.remove(0);
		return result;
	}

	// add card
	public void add(GoldRushCard newCard){
		deck.add(newCard);
	}
}
