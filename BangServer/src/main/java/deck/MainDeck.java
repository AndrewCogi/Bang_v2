/* 
 * class name: MainDeck (playing deck)
 * purpose: game main(playing) card deck for playing game
 */

package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.MainCard;

public class MainDeck{
	// deck
	private List<MainCard> deck;

	// constructor
	public MainDeck(){
		deck = new ArrayList<>();
	}

	// making main deck
	public void make_init_deck(){
		// re-init main deck
		deck = new ArrayList<>();
		// add informations
		// original
		deck.add(new MainCard("brown","bang",'C',2));
		deck.add(new MainCard("brown","bang",'C',3));
		deck.add(new MainCard("brown","bang",'C',4));
		deck.add(new MainCard("brown","bang",'C',5));
		deck.add(new MainCard("brown","bang",'C',6));
		deck.add(new MainCard("brown","bang",'C',7));
		deck.add(new MainCard("brown","bang",'C',8));
		deck.add(new MainCard("brown","bang",'C',9));
		deck.add(new MainCard("brown","bang",'D',1));
		deck.add(new MainCard("brown","bang",'D',2));
		deck.add(new MainCard("brown","bang",'D',3));
		deck.add(new MainCard("brown","bang",'D',4));
		deck.add(new MainCard("brown","bang",'D',5));
		deck.add(new MainCard("brown","bang",'D',6));
		deck.add(new MainCard("brown","bang",'D',7));
		deck.add(new MainCard("brown","bang",'D',8));
		deck.add(new MainCard("brown","bang",'D',9));
		deck.add(new MainCard("brown","bang",'D',10));
		deck.add(new MainCard("brown","bang",'D',11));
		deck.add(new MainCard("brown","bang",'D',12));
		deck.add(new MainCard("brown","bang",'D',13));
		deck.add(new MainCard("brown","bang",'H',1));
		deck.add(new MainCard("brown","bang",'H',12));
		deck.add(new MainCard("brown","bang",'H',13));
		deck.add(new MainCard("brown","bang",'S',1));
		// original
		deck.add(new MainCard("brown","bang",'C',2));
		deck.add(new MainCard("brown","bang",'C',3));
		deck.add(new MainCard("brown","bang",'C',4));
		deck.add(new MainCard("brown","bang",'C',5));
		deck.add(new MainCard("brown","bang",'C',6));
		deck.add(new MainCard("brown","bang",'C',7));
		deck.add(new MainCard("brown","bang",'C',8));
		deck.add(new MainCard("brown","bang",'C',9));
		deck.add(new MainCard("brown","bang",'D',1));
		deck.add(new MainCard("brown","bang",'D',2));
		deck.add(new MainCard("brown","bang",'D',3));
		deck.add(new MainCard("brown","bang",'D',4));
		deck.add(new MainCard("brown","bang",'D',5));
		deck.add(new MainCard("brown","bang",'D',6));
		deck.add(new MainCard("brown","bang",'D',7));
		deck.add(new MainCard("brown","bang",'D',8));
		deck.add(new MainCard("brown","bang",'D',9));
		deck.add(new MainCard("brown","bang",'D',10));
		deck.add(new MainCard("brown","bang",'D',11));
		deck.add(new MainCard("brown","bang",'D',12));
		deck.add(new MainCard("brown","bang",'D',13));
		deck.add(new MainCard("brown","bang",'H',1));
		deck.add(new MainCard("brown","bang",'H',12));
		deck.add(new MainCard("brown","bang",'H',13));
		deck.add(new MainCard("brown","bang",'S',1));
		// original
		deck.add(new MainCard("brown","bang",'C',2));
		deck.add(new MainCard("brown","bang",'C',3));
		deck.add(new MainCard("brown","bang",'C',4));
		deck.add(new MainCard("brown","bang",'C',5));
		deck.add(new MainCard("brown","bang",'C',6));
		deck.add(new MainCard("brown","bang",'C',7));
		deck.add(new MainCard("brown","bang",'C',8));
		deck.add(new MainCard("brown","bang",'C',9));
		deck.add(new MainCard("brown","bang",'D',1));
		deck.add(new MainCard("brown","bang",'D',2));
		deck.add(new MainCard("brown","bang",'D',3));
		deck.add(new MainCard("brown","bang",'D',4));
		deck.add(new MainCard("brown","bang",'D',5));
		deck.add(new MainCard("brown","bang",'D',6));
		deck.add(new MainCard("brown","bang",'D',7));
		deck.add(new MainCard("brown","bang",'D',8));
		deck.add(new MainCard("brown","bang",'D',9));
		deck.add(new MainCard("brown","bang",'D',10));
		deck.add(new MainCard("brown","bang",'D',11));
		deck.add(new MainCard("brown","bang",'D',12));
		deck.add(new MainCard("brown","bang",'D',13));
		deck.add(new MainCard("brown","bang",'H',1));
		deck.add(new MainCard("brown","bang",'H',12));
		deck.add(new MainCard("brown","bang",'H',13));
		deck.add(new MainCard("brown","bang",'S',1));
		// deck.add(new MainCard("blue","barile",'S',12));
		// deck.add(new MainCard("blue","barile",'S',13));
		// deck.add(new MainCard("brown","birra",'H',6));
		// deck.add(new MainCard("brown","birra",'H',7));
		// deck.add(new MainCard("brown","birra",'H',8));
		// deck.add(new MainCard("brown","birra",'H',9));
		// deck.add(new MainCard("brown","birra",'H',10));
		// deck.add(new MainCard("brown","birra",'H',11));
		// deck.add(new MainCard("brown","cat_balou",'D',9));
		// deck.add(new MainCard("brown","cat_balou",'D',10));
		// deck.add(new MainCard("brown","cat_balou",'D',11));
		// deck.add(new MainCard("brown","cat_balou",'H',10));
		// deck.add(new MainCard("brown","diligenza",'S',9));
		// deck.add(new MainCard("brown","diligenza",'S',9));
		// deck.add(new MainCard("blue","dinamite",'H',2));
		// deck.add(new MainCard("brown","duello",'C',8));
		// deck.add(new MainCard("brown","duello",'D',12));
		// deck.add(new MainCard("brown","duello",'S',11));
		// deck.add(new MainCard("brown","emporio",'C',9));
		// deck.add(new MainCard("brown","emporio",'S',12));
		// deck.add(new MainCard("brown","gatling",'H',10));
		// deck.add(new MainCard("brown","indian",'D',1));
		// deck.add(new MainCard("brown","indian",'D',13));
		// deck.add(new MainCard("brown","mancato",'C',1));
		// deck.add(new MainCard("brown","mancato",'C',10));
		// deck.add(new MainCard("brown","mancato",'C',11));
		// deck.add(new MainCard("brown","mancato",'C',12));
		// deck.add(new MainCard("brown","mancato",'C',13));
		// deck.add(new MainCard("brown","mancato",'S',2));
		// deck.add(new MainCard("brown","mancato",'S',3));
		// deck.add(new MainCard("brown","mancato",'S',4));
		// deck.add(new MainCard("brown","mancato",'S',5));
		// deck.add(new MainCard("brown","mancato",'S',6));
		// deck.add(new MainCard("brown","mancato",'S',7));
		// deck.add(new MainCard("brown","mancato",'S',8));
		// deck.add(new MainCard("blue","mirino",'S',1));
		// deck.add(new MainCard("blue","mustang",'H',8));
		// deck.add(new MainCard("blue","mustang",'H',9));
		// deck.add(new MainCard("brown","panico",'D',8));
		// deck.add(new MainCard("brown","panico",'H',1));
		// deck.add(new MainCard("brown","panico",'H',11));
		// deck.add(new MainCard("brown","panico",'H',12));
		// deck.add(new MainCard("blue","prigione",'H',4));
		// deck.add(new MainCard("blue","prigione",'S',10));
		// deck.add(new MainCard("blue","prigione",'S',11));
		deck.add(new MainCard("blue","remington",'C',13));
		deck.add(new MainCard("blue","remington",'C',13));
		deck.add(new MainCard("blue","remington",'C',13));
		deck.add(new MainCard("blue","remington",'C',13));
		deck.add(new MainCard("blue","remington",'C',13));
		deck.add(new MainCard("blue","rev_carbine",'C',1));
		deck.add(new MainCard("blue","rev_carbine",'C',1));
		deck.add(new MainCard("blue","rev_carbine",'C',1));
		deck.add(new MainCard("blue","rev_carbine",'C',1));
		// deck.add(new MainCard("brown","saloon",'H',5));
		deck.add(new MainCard("blue","schofield",'C',11));
		deck.add(new MainCard("blue","schofield",'C',12));
		deck.add(new MainCard("blue","schofield",'S',13));
		deck.add(new MainCard("blue","schofield",'C',11));
		deck.add(new MainCard("blue","schofield",'C',12));
		deck.add(new MainCard("blue","schofield",'S',13));
		deck.add(new MainCard("blue","schofield",'C',11));
		deck.add(new MainCard("blue","schofield",'C',12));
		deck.add(new MainCard("blue","schofield",'S',13));
		deck.add(new MainCard("blue","schofield",'C',11));
		deck.add(new MainCard("blue","schofield",'C',12));
		deck.add(new MainCard("blue","schofield",'S',13));
		deck.add(new MainCard("blue","volcanic",'C',10));
		deck.add(new MainCard("blue","volcanic",'S',10));
		deck.add(new MainCard("blue","volcanic",'C',10));
		deck.add(new MainCard("blue","volcanic",'S',10));
		deck.add(new MainCard("blue","volcanic",'C',10));
		deck.add(new MainCard("blue","volcanic",'S',10));
		deck.add(new MainCard("blue","volcanic",'C',10));
		deck.add(new MainCard("blue","volcanic",'S',10));
		// deck.add(new MainCard("brown","wells_fargo",'H',3));
		deck.add(new MainCard("blue","winchester",'S',8));
		deck.add(new MainCard("blue","winchester",'S',8));
		deck.add(new MainCard("blue","winchester",'S',8));
	}

	// shuffle main deck
	public void shuffle(){
		Collections.shuffle(deck);
	}

	// pop card
	public String pop(){
		MainCard picked = deck.get(0); deck.remove(0);
		String cardInfo = picked.getCardColor()+"/"+picked.getCardName()+
			"/"+picked.getCardShape()+"/"+picked.getCardNumber();
		System.out.println("[MainDeck][picked card]: "+cardInfo);
		return cardInfo;
	}

	// add card
	public void add(String cardInfo){
		deck.add(new MainCard(cardInfo.split("/")[0], cardInfo.split("/")[1], 
					cardInfo.split("/")[2].charAt(0), Integer.parseInt(cardInfo.split("/")[3])));
	}
}
