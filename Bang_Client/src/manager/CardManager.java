package manager;

import java.awt.Color;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import ui.Setter;
import ui.UI;

public class CardManager {
	// card ability implementation, return target
	public static void cardAbility(String cardName) {
		// bang
		if(cardName.equals("bang")) {
			// lock end button
			Setter.setPlayerButtonAvailable(false);
			// lock phase2 card use.
			UI.setCardUse2(false);
			// unlock set target (now, you can click other character cards)
			UI.setSetTarget(true);
			// notice change
			Setter.setTextNotice(1, "Select Target...");

			// check distance
			boolean[] canShoot = checkDistance();
			// set target (border painting)
			if(canShoot[0] == true) {
				// set targetCommand
				UI.targetCommand[0] = "bang";
				UI.player_A_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[0] = "";
			
			if(canShoot[1] == true) {
				// set targetCommand
				UI.targetCommand[1] = "bang";
				UI.player_B_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[1] = "";
			
			if(canShoot[2] == true) {
				// set targetCommand
				UI.targetCommand[2] = "bang";
				UI.player_C_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[2] = "";
			
			if(canShoot[3] == true) {
				// set targetCommand
				UI.targetCommand[3] = "bang";
				UI.player_D_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[3] = "";
			
			if(canShoot[4] == true) {
				// set targetCommand
				UI.targetCommand[4] = "bang";
				UI.player_E_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[4] = "";
			
			if(canShoot[5] == true) {
				// set targetCommand
				UI.targetCommand[5] = "bang";
				UI.player_F_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[5] = "";
			
			if(canShoot[6] == true) {
				// set targetCommand
				UI.targetCommand[6] = "bang";
				UI.player_G_character.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			} else UI.targetCommand[6] = "";
		}
		// barile
		// birra
		// ...
	}
	
	// check distance
	private static boolean[] checkDistance() {
		// {A,B,C,D,E,F,G}
		boolean[] canShoot = new boolean[] {true,false,false,false,false,false,false};
		int[] distance = new int[] {1,1,2,3,3,2,1};
		// set myRange (default = 1)
		int myRange = 1;
		// check my distance
		if(UI.player_A_gun.getText().equals("colt-45")) myRange = 1;
		// TODO : add guns (you should make gun card with gun name!)
		
		// calculate canShoot
		for(int i=1; i<7; i++) {
			if(distance[i] > myRange) canShoot[i] = false;
			else canShoot[i] = true;
		}
		
		return canShoot;
	}

	// add into main deck (old)
	public static void addIntoMainDeck_old(String cardColor, String cardName, char cardShape, int cardNum) {
		Setter.setMainDeckImageAvailable(false);
		UI.main_deck_old.setIcon(new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87.png"));
		Setter.setMainDeckImageAvailable(true);
	}

	// check dodge, mancato etc reservation
	public static void checkMancato(PrintWriter os, String targetCardName) {
		// check mancato
		if(!UI.mancatoRev.isEmpty()) {
			// TODO
			// 카드 손에서 없애기 (broadcast)
			// 메인 덱에 버려주기 (broadcast)
		}
		else {
			// hit 1 damage (broadcast)
			os.println("game/HPSET/"+targetCardName+"/-1");
			// check game over
			
		}
	}
	
	
}
