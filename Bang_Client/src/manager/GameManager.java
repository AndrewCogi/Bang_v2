package manager;

import java.awt.Color;
import java.awt.Component;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import ui.CardMaker;
import ui.Select_button;
import ui.Setter;
import ui.UI;

public class GameManager {
	private String myName;
	private PrintWriter os;
	// check send (i'm dead!) message
	private boolean deadACK;
	
	public GameManager(String myName, PrintWriter os) {
		this.myName = myName;
		this.os = os;
		this.deadACK = false;
	}
	
	public void request(String cmd) {
		// game/[??]
		String[] splitCmd = cmd.split("/");
		
		// game/STATE/[game state]
		if(splitCmd[1].equals("STATE")) {
			// game/STATE/[START|END]
			if(splitCmd[2].equals("START")) {
				Setter.reInit_mainPanel();
				//re-init variables
				deadACK = false;
			}
			else if(splitCmd[2].equals("END")) {
				Setter.reInit_mainPanel();
				// add ready button
				UI.mp.add(UI.game_ready_button);
				//re-init variables
				deadACK = false;
			}
		}
		
		// game/SETTEXT/[location]/[message]
		else if(splitCmd[1].equals("SETTEXT")) {
			// game/SETTEXT/TOP_NOTICE/[message]
			if(splitCmd[2].equals("TOP_NOTICE")) {
				Setter.setTextNotice(1,splitCmd[3]);
			}
			// game/SETTEXT/MIDDLE_NOTICE/[message]
			else if(splitCmd[2].equals("MIDDLE_NOTICE")) {
				Setter.setTextNotice(2,splitCmd[3]);
			}
		}
		
		// game/ENABLE/[target]
		else if(splitCmd[1].equals("ENABLE")) {
			// game/ENABLE/TOP_NOTICE
			if(splitCmd[2].equals("TOP_NOTICE")) {
				Setter.setNoticeAvailable(1,true);
			}
			// game/ENABLE/MIDDLE_NOTICE
			else if(splitCmd[2].equals("MIDDLE_NOTICE")) {
				Setter.setNoticeAvailable(2,true);
			}
			// game/ENABLE/PLAYER_HAND/[id]
			else if(splitCmd[2].equals("PLAYER_HAND")) {
				String id = splitCmd[3];
				Setter.setPlayerHandImageAvailable(id, true);
			}
		}
		
		// game/DISABLE/[target]
		else if(splitCmd[1].equals("DISABLE")) {
			// game/DISABLE/READYBUTTON
			if(splitCmd[2].equals("READYBUTTON")) {
				Setter.setReadyButtonAvailable(false);
				// reset button
				UI.game_ready_button.setBackground(Color.GRAY);
				UI.game_ready_button.setText("Ready?");
			}
			// game/DISABLE/TOP_NOTICE
			else if(splitCmd[2].equals("TOP_NOTICE")) {
				Setter.setNoticeAvailable(1,false);
			}
			// game/DISABLE/MIDDLE_NOTICE
			else if(splitCmd[2].equals("MIDDLE_NOTICE")) {
				Setter.setNoticeAvailable(2,false);
			}
			// game/DISABLE/SELECT_PANEL/[target]
			else if(splitCmd[2].equals("SELECT_PANEL")) {
				// game/DISABLE/SELECT_PANEL/ROLE
				if(splitCmd[3].equals("ROLE")) {
					Setter.setSelectPanelRoleAvailable(false);
				}
				// game/DISABLE/SELECT_PANEL/CHARACTER
				else if(splitCmd[3].equals("CHARACTER")) {
					Setter.setSelectPanelCharacterAvailable(false);
				}
				// game/DISABLE/SELECT_PANEL/SCENARIO
				else if(splitCmd[3].equals("SCENARIO")) {
					Setter.setSelectPanelScenarioAvailable(false);
				}
			}
		}
		
		// game/INIT/[??]
		else if(splitCmd[1].equals("INIT")) {
			// game/INIT/SEAT/[SEAT_INFO]->[3~9]
			if(splitCmd[2].equals("SEAT")) {
				List<String> seat = new LinkedList<>();
				// add SEAT_INFO into List
				for(int i=3; i<=9; i++) { seat.add(splitCmd[i]); }
				// find my seat
				while(!seat.get(0).equals(myName)) {
					// first member -> last member
					String moveName = seat.get(0); 
					seat.remove(0);
					seat.add(moveName);
				}
				// check
				System.out.print("[THIS SEAT]: ");
				for(String s : seat) { System.out.print(" > "+s); }
				System.out.println();
				// add seats & playerName into mainUI
				// with 0.7 second delay
				char alphabet = 'A';
				for(String s : seat) {
					// set playerName
					Setter.setPlayerNameAvailable(s,alphabet,true);
					// set seat
					Setter.setSeatAvailable(s,alphabet,true); alphabet++;
					try{Thread.sleep(700);}catch(InterruptedException e) {};
				}
			}
			// game/INIT/ROLE/[id]/[roleName]
			else if(splitCmd[2].equals("ROLE")) {
				// if id==myName or roleName==sceriffo, setting role forward
				if(splitCmd[3].equals(myName) || splitCmd[4].equals("sceriffo")) {
					System.out.println("[GameManager][forward]: Setting "+splitCmd[4]+" at "+splitCmd[3]+". ");
					// make card
					CardMaker.make_card_handField_role(splitCmd[3], splitCmd[4], true);
					// available(->true) card
					Setter.setPlayerRoleImageAvailable(splitCmd[3], true);
				}
				// if not my name, setting role backward
				else {
					System.out.println("[GameManager][backward]: Setting "+splitCmd[4]+" at "+splitCmd[3]+". ");
					// make card
					CardMaker.make_card_handField_role(splitCmd[3], splitCmd[4], false);
					// available(->true) card
					Setter.setPlayerRoleImageAvailable(splitCmd[3], true);
				}
			}
			// game/INIT/CHARACTER/[id]/[characterExtension]/[characterName]/[characterHp]
			else if(splitCmd[2].equals("CHARACTER")) {
//				// if [id] == myName, activate ability button
//				if(splitCmd[3].equals(myName)) {
//					Setter.setPlayerButtonAvailable(true);
//				}
				// make card
				CardMaker.make_card_handField_character(splitCmd[3], splitCmd[4], splitCmd[5],Integer.parseInt(splitCmd[6]));
				// available(->true) card
				Setter.setPlayerCharacterImageAvailable(splitCmd[3], true);
			}
			// game/INIT/GUN/[id]
			else if(splitCmd[2].equals("GUN")) {
				// make card
				CardMaker.make_card_handField_gun_init(splitCmd[3]);
				// available(->true) card
				Setter.setPlayerGunImageAvailable(splitCmd[3],true);
			}
			// game/INIT/SCENAIO/[extension]/[scenarioName]
			else if(splitCmd[2].equals("SCENAIO")) {
				// make scenario init setting
				String scenarioExtension = splitCmd[3];
				String scenarioName = splitCmd[4];
				// [first scenario],[empty],[wild-west(back)],[empty]
				Setter.setScenarioImageAvailable(1, false);
				Setter.setScenarioImageAvailable(3, false);
				CardMaker.make_card_handField_scenario(1, scenarioExtension, scenarioName);
				CardMaker.make_card_handField_scenario(3, "back", "wild_west_show");
				Setter.setScenarioImageAvailable(1, true);
				Setter.setScenarioImageAvailable(3, true);
			}
			// game/INIT/MAIN_DECK
			else if(splitCmd[2].equals("MAIN_DECK")) {
				// make main deck [back], [empty]
				CardMaker.make_card_handField_main_deck_init();
				Setter.setMainDeckImageAvailable(true);
			}
			// game/INIT/GOLD_RUSH/[cardColor1]/[cardName1]/[cardCost1]/[cardColor2]/[cardName2]/[cardCost2]/[cardColor3]/[cardName3]/[cardCost3]
			else if(splitCmd[2].equals("GOLD_RUSH")) {
				// make gold rush store
				String cardColor1 = splitCmd[3];
				String cardColor2 = splitCmd[6];
				String cardColor3 = splitCmd[9];
				String cardName1 = splitCmd[4];
				String cardName2 = splitCmd[7];
				String cardName3 = splitCmd[10];
				int cardCost1 = Integer.parseInt(splitCmd[5]);
				int cardCost2 = Integer.parseInt(splitCmd[8]);
				int cardCost3 = Integer.parseInt(splitCmd[11]);
				CardMaker.make_card_handField_gold_rush(1, null, null, -1);
				CardMaker.make_card_handField_gold_rush(2, cardColor1, cardName1, cardCost1);
				CardMaker.make_card_handField_gold_rush(3, cardColor2, cardName2, cardCost2);
				CardMaker.make_card_handField_gold_rush(4, cardColor3, cardName3, cardCost3);
				Setter.setGoldRushImageAvailable(1, true);
				Setter.setGoldRushImageAvailable(2, true);
				Setter.setGoldRushImageAvailable(3, true);
				Setter.setGoldRushImageAvailable(4, true);
			}
			// game/INIT/HP_GOLD
			else if(splitCmd[2].equals("HP_GOLD")) {
				// setting hp
				Setter.setPlayerHpText(UI.player_A_name.getText(), Integer.parseInt(UI.player_A_character.getText().split("/")[2]), UI.player_A_role.getText().equals("sceriffo"));
				Setter.setPlayerHpText(UI.player_B_name.getText(), Integer.parseInt(UI.player_B_character.getText().split("/")[2]), UI.player_B_role.getText().equals("sceriffo"));
				Setter.setPlayerHpText(UI.player_C_name.getText(), Integer.parseInt(UI.player_C_character.getText().split("/")[2]), UI.player_C_role.getText().equals("sceriffo"));
				Setter.setPlayerHpText(UI.player_D_name.getText(), Integer.parseInt(UI.player_D_character.getText().split("/")[2]), UI.player_D_role.getText().equals("sceriffo"));
				Setter.setPlayerHpText(UI.player_E_name.getText(), Integer.parseInt(UI.player_E_character.getText().split("/")[2]), UI.player_E_role.getText().equals("sceriffo"));
				Setter.setPlayerHpText(UI.player_F_name.getText(), Integer.parseInt(UI.player_F_character.getText().split("/")[2]), UI.player_F_role.getText().equals("sceriffo"));
				Setter.setPlayerHpText(UI.player_G_name.getText(), Integer.parseInt(UI.player_G_character.getText().split("/")[2]), UI.player_G_role.getText().equals("sceriffo"));
				// hp image & text available -> true
				Setter.setPlayerHpImageAvailable(true);
				Setter.setPlayerHpTextAvailable(true);
				// setting gold
				Setter.setPlayerGoldText(UI.player_A_name.getText(), 0);
				Setter.setPlayerGoldText(UI.player_B_name.getText(), 0);
				Setter.setPlayerGoldText(UI.player_C_name.getText(), 0);
				Setter.setPlayerGoldText(UI.player_D_name.getText(), 0);
				Setter.setPlayerGoldText(UI.player_E_name.getText(), 0);
				Setter.setPlayerGoldText(UI.player_F_name.getText(), 0);
				Setter.setPlayerGoldText(UI.player_G_name.getText(), 0);
				// gold image & text available -> true
				Setter.setPlayerGoldImageAvailable(true);
				Setter.setPlayerGoldTextAvailable(true);
			}
			// game/INIT/PLAYER_HAND/[id]/[cardColor]/[cardName]/[cardShape]/[cardNumber]
			else if(splitCmd[2].equals("PLAYER_HAND")) {
				String id = splitCmd[3];
				String cardColor = splitCmd[4];
				String cardName = splitCmd[5];
				char cardShape = splitCmd[6].charAt(0);
				int cardNumber = Integer.parseInt(splitCmd[7]);
				// make hand card, add into [id]'s card (if myName -> forward / not myName ->backward)
				if(myName.equals(id)) UI.player_A_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, true));	
				else if(UI.player_B_name.getText().equals(id)) UI.player_B_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_C_name.getText().equals(id)) UI.player_C_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_D_name.getText().equals(id)) UI.player_D_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_E_name.getText().equals(id)) UI.player_E_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_F_name.getText().equals(id)) UI.player_F_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_G_name.getText().equals(id)) UI.player_G_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				// repaint
				UI.mp.repaint();
			}
		}
		
		// game/SELECT/[??]
		else if(splitCmd[1].equals("SELECT")) {
			// game/SELECT/ROLE/roles[3~9]
			if(splitCmd[2].equals("ROLE")) {
				// re-init select_panel
				UI.select_panel_role.removeAll();
				// make role cards
				for(int i=3; i<=9; i++) {
					System.out.println("splitCmd["+i+"]: "+splitCmd[i]);
					// make temp_role_button & add this into select_panel
					UI.select_panel_role.add(CardMaker.make_card_select_panel_role(myName,splitCmd[i],os,i-2));
				}
				// show select_panel
				Setter.setSelectPanelRoleAvailable(true);
				// init remain select chance
				UI.select_chance = 1;
			}
			// game/SELECT/LAST_SCENARIO
			else if(splitCmd[2].equals("LAST_SCENARIO")) {
				// re-init select_panel
				UI.select_panel_scenario.removeAll();
				// make last_scenario cards
				UI.select_panel_scenario.add(CardMaker.make_card_select_panel_last_scenario("a_fistful_of_cards","per_un_pugno_di_carte",os,1));
				UI.select_panel_scenario.add(CardMaker.make_card_select_panel_last_scenario("high_noon","mezzogiorno_di_fuoco",os,2));
				// show select_panel
				Setter.setSelectPanelScenarioAvailable(true);
				// init remain select chance
				UI.select_chance = 1;
			}
			// game/SELECT/CHARACTER/[ex1]/[ch1]/[hp1]/[ex2]/[ch2]/[hp2]/[ex3]/[ch3]/[hp3]
			else if(splitCmd[2].equals("CHARACTER")) {
				String extension1 = splitCmd[3];
				String extension2 = splitCmd[6];
				String extension3 = splitCmd[9];
				String questionExtension = splitCmd[12];
				String characterName1 = splitCmd[4];
				String characterName2 = splitCmd[7];
				String characterName3 = splitCmd[10];
				String questionCharacterName = splitCmd[13];
				int hp1 = Integer.parseInt(splitCmd[5]);
				int hp2 = Integer.parseInt(splitCmd[8]);
				int hp3 = Integer.parseInt(splitCmd[11]);
				int questionHp = Integer.parseInt(splitCmd[14]);
				// re-init select_panel
				UI.select_panel_character.removeAll();
				// make character cards
				UI.select_panel_character.add(CardMaker.make_card_select_panel_character(myName, extension1, characterName1, os, hp1));
				UI.select_panel_character.add(CardMaker.make_card_select_panel_character(myName, extension2, characterName2, os, hp2));
				UI.select_panel_character.add(CardMaker.make_card_select_panel_character(myName, extension3, characterName3, os, hp3));
				UI.select_panel_character.add(CardMaker.make_card_select_panel_character_question(myName, questionExtension, questionCharacterName, os, questionHp));
				// show select_panel
				Setter.setSelectPanelCharacterAvailable(true);
				// init remain select chance
				UI.select_chance = 1;
			}
		}
		
		// game/PLAYERSELECT/[??]
		else if(splitCmd[1].equals("PLAYERSELECT")) {
			// game/PLAYERSELECT/ROLE/[roleName]/[cardNum]
			if(splitCmd[2].equals("ROLE")) {
				String cardName = splitCmd[3];
				int cardNum = Integer.parseInt(splitCmd[4]);
				// find picked card
				Component[] componentList = UI.select_panel_role.getComponents();
				for(Component c : componentList) {
					if(c instanceof Select_button) {
						Select_button btn = (Select_button)c;
						if(btn.getName().equals(cardName) && btn.getNum() == cardNum) {
							// set disabled image
							btn.setDisabledIcon(new ImageIcon(".\\.\\resources\\card\\role\\role_back_155_gray.png"));
							// disable button
							btn.setEnabled(false);
						}
					}
				}
			}
			// game/PLSYERSELECT/SCENARIO/[cardName]
			else if(splitCmd[2].equals("SCENARIO")) {
				// make card last scenario
				String cardName = splitCmd[3];
				CardMaker.make_card_handField_scenario_last(cardName);
				CardMaker.make_card_handField_scenario_last("wild_west_show");
				// available
				Setter.setScenarioImageAvailable(1, true);
				Setter.setScenarioImageAvailable(3, true);
			}
		}
		
		// game/PHASE/[number]/[player]
		else if(splitCmd[1].equals("PHASE")) {
			String playerName = splitCmd[3];
			// painting phase border
			Setter.setPhasePainter(playerName, Integer.parseInt(splitCmd[2]));
			// set text topNotice
			Setter.setTextNotice(1, "playing - phase "+splitCmd[2]+"...");
			
			// test
			// if phase 0, hp--;
			if(splitCmd[2].equals("0")) Setter.setPlayerHpTextUpdate(playerName,-1);
			// if hp <= 0 send message, send message to server
			if(Character.toString(UI.player_A_hp_text.getText().charAt(3)).equals("0") && deadACK == false) {
				os.println("game/DIED/"+UI.player_A_role.getText());
				deadACK = true;
			}
		}
		
		// game/ADD/[??]
		else if(splitCmd[1].equals("ADD")) {
			// game/ADD/PLAYER_HAND/[id]/[cardColor]/[cardName]/[cardShape]/[cardNumber]
			if(splitCmd[2].equals("PLAYER_HAND")) {
				String id = splitCmd[3];
				String cardColor = splitCmd[4];
				String cardName = splitCmd[5];
				char cardShape = splitCmd[6].charAt(0);
				int cardNumber = Integer.parseInt(splitCmd[7]);
				// make hand card, add into [id]'s card (if myName -> forward / not myName ->backward)
				if(myName.equals(id)) UI.player_A_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, true));	
				else if(UI.player_B_name.getText().equals(id)) UI.player_B_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_C_name.getText().equals(id)) UI.player_C_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_D_name.getText().equals(id)) UI.player_D_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_E_name.getText().equals(id)) UI.player_E_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_F_name.getText().equals(id)) UI.player_F_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				else if(UI.player_G_name.getText().equals(id)) UI.player_G_hand.add(CardMaker.make_card_hand_playing(os, id, cardColor, cardName, cardShape, cardNumber, false));
				// repaint
				UI.mp.repaint();
			}
			// game/ADD/MAIN_DECK_OLD/[cardColor]/[cardName]/[cardShape]/[cardNumber]
			else if(splitCmd[2].equals("MAIN_DECK_OLD")) {
				String cardColor = splitCmd[3];
				String cardName = splitCmd[4];
				char cardShape = splitCmd[5].charAt(0);
				int cardNumber = Integer.parseInt(splitCmd[6]);
				// add into main deck (old)
				Setter.setMainDeckImageAvailable(false);
				UI.main_deck_old.setIcon(new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNumber+"_87.png"));
				Setter.setMainDeckImageAvailable(true);
			}
		}
		
		// game/REMOVE/[??]
		else if(splitCmd[1].equals("REMOVE")) {
			// game/REMOVE/PLAYER_HAND/[id]/[cardColor]/[cardName]/[cardShape]/[cardNumber]
			if(splitCmd[2].equals("PLAYER_HAND")) {
				String id = splitCmd[3];
				String cardColor = splitCmd[4];
				String cardName = splitCmd[5];
				char cardShape = splitCmd[6].charAt(0);
				int cardNumber = Integer.parseInt(splitCmd[7]);
				// remove hand card in [id]'s card (except myName)
				if(UI.player_B_name.getText().equals(id)) {
					// find card, remove that card
					for(Component card : UI.player_B_hand.getComponents()) {
						if(((Select_button)card).getColor().equals(cardColor) && 
								((Select_button)card).getName().equals(cardName) && 
								((Select_button)card).getShape() == cardShape && 
								((Select_button)card).getNum() == cardNumber) {
							UI.player_B_hand.remove(card);
							break;
						}
					}
				}
				else if(UI.player_C_name.getText().equals(id)) {
					// find card, remove that card
					for(Component card : UI.player_C_hand.getComponents()) {
						if(((Select_button)card).getColor().equals(cardColor) && 
								((Select_button)card).getName().equals(cardName) && 
								((Select_button)card).getShape() == cardShape && 
								((Select_button)card).getNum() == cardNumber) {
							UI.player_C_hand.remove(card);
							break;
						}
					}
				}
				else if(UI.player_D_name.getText().equals(id)) {
					// find card, remove that card
					for(Component card : UI.player_D_hand.getComponents()) {
						if(((Select_button)card).getColor().equals(cardColor) && 
								((Select_button)card).getName().equals(cardName) && 
								((Select_button)card).getShape() == cardShape && 
								((Select_button)card).getNum() == cardNumber) {
							UI.player_D_hand.remove(card);
							break;
						}
					}
				}
				else if(UI.player_E_name.getText().equals(id)) {
					// find card, remove that card
					for(Component card : UI.player_E_hand.getComponents()) {
						if(((Select_button)card).getColor().equals(cardColor) && 
								((Select_button)card).getName().equals(cardName) && 
								((Select_button)card).getShape() == cardShape && 
								((Select_button)card).getNum() == cardNumber) {
							UI.player_E_hand.remove(card);
							break;
						}
					}
				}
				else if(UI.player_F_name.getText().equals(id)) {
					// find card, remove that card
					for(Component card : UI.player_F_hand.getComponents()) {
						if(((Select_button)card).getColor().equals(cardColor) && 
								((Select_button)card).getName().equals(cardName) && 
								((Select_button)card).getShape() == cardShape && 
								((Select_button)card).getNum() == cardNumber) {
							UI.player_F_hand.remove(card);
							break;
						}
					}
				}
				else if(UI.player_G_name.getText().equals(id)) {
					// find card, remove that card
					for(Component card : UI.player_G_hand.getComponents()) {
						if(((Select_button)card).getColor().equals(cardColor) && 
								((Select_button)card).getName().equals(cardName) && 
								((Select_button)card).getShape() == cardShape && 
								((Select_button)card).getNum() == cardNumber) {
							UI.player_G_hand.remove(card);
							break;
						}
					}
				}
				// repaint
				UI.mp.repaint();
			}
		}
		
		// game/USECARD/[TRUE | FALSE]
		else if(splitCmd[1].equals("USECARD")) {
			if(splitCmd[2].equals("TRUE")) {
				// accept phase2 card use
				UI.cardUse2 = true;
				// enable phase2 end button
				Setter.setPlayerButtonAvailable(true);
			}
			else if(splitCmd[2].equals("FALSE")) {
				// lock phase2 card use
				UI.cardUse2 = false;
				// disable phase2 end button
				Setter.setPlayerButtonAvailable(false);
			}
		}
		
		// game/DISCARDCARD/[TRUE | FALSE]
		else if(splitCmd[1].equals("DISCARDCARD")) {
			if(splitCmd[2].equals("TRUE")) {
				// accept phase3 card use
				UI.cardUse3 = true;
				// set discard number
				UI.discardNum = UI.player_A_hand.getComponentCount() - (UI.player_A_hp_text.getText().charAt(3)-48);
				// if discardNum <= 0 show end button
				if(UI.discardNum <= 0) Setter.setPlayerButtonAvailable(true);
			}
			else if(splitCmd[2].equals("FALSE")) {
				// lock phase3 card use
				UI.cardUse3 = false;
				// init discardNum = 0
				UI.discardNum = 0;
				// disable phase3 end button
				Setter.setPlayerButtonAvailable(false);
			}
		}
		
		else {
			System.out.println("[Unknown command]: "+cmd);
		}
	}
}
