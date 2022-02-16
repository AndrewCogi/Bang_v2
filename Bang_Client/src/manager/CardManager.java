package manager;

import java.awt.Color;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import ui.Setter;
import ui.UI;

public class CardManager {
	// card ability implementation, return target
	public static void cardAbility(PrintWriter os, String id, String cardColor, String cardName, char cardShape, int cardNum) {
		// bang
		if(cardName.equals("bang")) {
			// useBangCount--
			UI.useBangCount--;
			// useBang = true
			UI.useBang = true;
			// if you have willy_the_kid, set 1
			if(UI.player_A_character.getText().split("/")[1].equals("willy_the_kid")) {
				UI.useBangCount = 1;
			}
			// if you have volcanic, set 1
			if(UI.player_A_gun.getText().split("/")[1].equals("volcanic")){
				UI.useBangCount = 1;
			}
			
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
		// volcanic
		else if(cardName.equals("volcanic")) {
			// set 1
			UI.useBangCount = 1;
			// broadcast "add this card in gun field"
			os.println("game/CARDABILITY/VOLCANIC/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
		}
		// schofield
		else if(cardName.equals("schofield")) {
			// if you used <Bang!> this turn, useBangCount = 0
			if(UI.useBang == true) UI.useBangCount = 0;
			// broadcast "add this card in gun field"
			os.println("game/CARDABILITY/SCHOFIELD/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
		}
		// remington
		else if(cardName.equals("remington")) {
			// if you used <Bang!> this turn, useBangCount = 0
			if(UI.useBang == true) UI.useBangCount = 0;
			// broadcast "add this card in gun field"
			os.println("game/CARDABILITY/REMINGTON/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
		}
		// rev_carbine
		else if(cardName.equals("rev_carbine")) {
			// if you used <Bang!> this turn, useBangCount = 0
			if(UI.useBang == true) UI.useBangCount = 0;
			// broadcast "add this card in gun field"
			os.println("game/CARDABILITY/REV_CARBINE/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
		}
		// winchester
		else if(cardName.equals("winchester")) {
			// if you used <Bang!> this turn, useBangCount = 0
			if(UI.useBang == true) UI.useBangCount = 0;
			// broadcast "add this card in gun field"
			os.println("game/CARDABILITY/WINCHESTER/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
		}
	}
	
	// check distance
	private static boolean[] checkDistance() {
		// {A,B,C,D,E,F,G}
		boolean[] canShoot = new boolean[] {true,false,false,false,false,false,false};
		int[] distance = new int[] {1,1,2,3,3,2,1};
		// set myRange (default = 1)
		int myRange = 1;
		// check my distance
		if(UI.player_A_gun.getText().split("/")[1].equals("colt-45")) myRange = 1;
		if(UI.player_A_gun.getText().split("/")[1].equals("volcanic")) myRange = 1;
		if(UI.player_A_gun.getText().split("/")[1].equals("schofield")) myRange = 2;
		if(UI.player_A_gun.getText().split("/")[1].equals("remington")) myRange = 3;
		if(UI.player_A_gun.getText().split("/")[1].equals("rev_carbine")) myRange = 4;
		if(UI.player_A_gun.getText().split("/")[1].equals("winchester")) myRange = 5;
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
	public static void checkDefensive(PrintWriter os, String targetCardName) {
		// check barile TODO
		
		// check mancato
		if(!UI.mancatoRev.isEmpty()) {
			// TODO
			// 카드 손에서 없애기 (broadcast)
			// 메인 덱에 버려주기 (broadcast)
		}
		else {
			// hit 1 damage (broadcast)
			os.println("game/HPSET/"+targetCardName+"/-1");
		}
	}
	
	
}
