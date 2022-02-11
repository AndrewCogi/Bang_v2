package manager;

import javax.swing.ImageIcon;

import ui.Setter;
import ui.UI;

public class CardManager {
	// card ability implementation
	public static void cardAbility(String cardName) {
		// bang
		if(cardName.equals("bang")) {
			
		}
		// barile
		// birra
		// ...
	}

	// add into main deck (old)
	public static void addIntoMainDeck_old(String cardColor, String cardName, char cardShape, int cardNum) {
		Setter.setMainDeckImageAvailable(false);
		UI.main_deck_old.setIcon(new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87.png"));
		Setter.setMainDeckImageAvailable(true);
	}
}
