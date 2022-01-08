/* 
 * class name: CharacterDeck
 * purpose: game character card deck for allocate players' character
 */

package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.CharactersCard;

public class CharacterDeck{
	// deck
	private List<CharactersCard> deck;

	// constructor
	public CharacterDeck(){
		deck = new ArrayList<>();
	}

	// making character deck
	public void make_init_deck(){
		// re-init character deck
		deck = new ArrayList<>();
		// add informations
		// original
		deck.add(new CharactersCard("original","bart_cassidy"));
		deck.add(new CharactersCard("original","black_jack"));
		deck.add(new CharactersCard("original","calamity_janet"));
		deck.add(new CharactersCard("original","el_gringo"));
		deck.add(new CharactersCard("original","jesse_jones"));
		deck.add(new CharactersCard("original","jourdonnais"));
		deck.add(new CharactersCard("original","kit_carlson"));
		deck.add(new CharactersCard("original","lucky_duke"));
		deck.add(new CharactersCard("original","paul_regret"));
		deck.add(new CharactersCard("original","pedro_ramirez"));
		deck.add(new CharactersCard("original","rose_doolan"));
		deck.add(new CharactersCard("original","sid_ketchum"));
		deck.add(new CharactersCard("original","slab_the_killer"));
		deck.add(new CharactersCard("original","suzy_lafayette"));
		deck.add(new CharactersCard("original","vulture_sam"));
		deck.add(new CharactersCard("original","willy_the_kid"));
		// dodge_city
		deck.add(new CharactersCard("dodge_city","apache_kid"));
		deck.add(new CharactersCard("dodge_city","belle_star"));
		deck.add(new CharactersCard("dodge_city","bill_noface"));
		deck.add(new CharactersCard("dodge_city","chuck_wengam"));
		deck.add(new CharactersCard("dodge_city","doc_holiday"));
		deck.add(new CharactersCard("dodge_city","elena_fuente"));
		deck.add(new CharactersCard("dodge_city","gregg_digger"));
		deck.add(new CharactersCard("dodge_city","herb_hunter"));
		deck.add(new CharactersCard("dodge_city","jose'_delgado"));
		deck.add(new CharactersCard("dodge_city","molly_stark"));
		deck.add(new CharactersCard("dodge_city","pat_brennan"));
		deck.add(new CharactersCard("dodge_city","pixie_pete"));
		deck.add(new CharactersCard("dodge_city","sean_mallory"));
		deck.add(new CharactersCard("dodge_city","tequila_joe"));
		deck.add(new CharactersCard("dodge_city","vera_custer"));
	}

	// shuffle character deck
	public void shuffle(){
		Collections.shuffle(deck);
	}

	// extract character info
	public String extract(){
		// shuffle & extract one of card
		shuffle();
		CharactersCard picked = deck.get(0); deck.remove(0);
		String characterInfo = picked.getExtension()+"/"+picked.getCardName()+"/"+picked.getHp();
		return characterInfo;
	}
}
