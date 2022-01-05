/* 
 * class name: CharacterCard
 * purpose: have character card information
 */

package card;

public class CharactersCard{
	// card extension
	private String extension;
	// card name
	private String cardName;
	// character hp
	private int hp;

	// constructor
	public CharactersCard(String extension, String cardName){
		this.extension = extension;
		this.cardName = cardName;
		this.hp = init_hp(cardName);
	}

	// character init hp
	private int init_hp(String name){
		switch(name){
			// original card
			case "el_gringo":
			case "paul_regret":
				return 3;
			case "bart_cassidy":
			case "black_jack":
			case "calamity_janet":
			case "jesse_jones":
			case "jourdonnais":
			case "kit_carlson":
			case "lucky_duke":
			case "pedro_ramirez":
			case "rose_doolan":
			case "sid_ketchum":
			case "slab_the_killer":
			case "suzy_lafayette":
			case "vulture_sam":
			case "willy_the_kid":
				return 4;
			// dodge_city card
			case "apache_kid":
			case "elena_fuente":
			case "pixie_pete":
			case "sean_mallory":
			case "vera_custer":
				return 3;
			case "belle_star":
			case "bill_noface":
			case "chuck_wengam":
			case "doc_holiday":
			case "gregg_digger":
			case "herb_hunter":
			case "jose'_delgado":
			case "molly_stark":
			case "pat_brennan":
			case "tequila_joe":
				return 4;
		}
		// unknown
		return -1;
	}


	// get card name
	public String getCardName(){
		return cardName;
	}

	// get extension
	public String getExtension(){
		return extension;
	}

	// get hp
	public int getHp(){
		return hp;
	}
}
