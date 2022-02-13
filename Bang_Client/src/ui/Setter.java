package ui;

import java.awt.Color;
import java.awt.Component;
import java.io.PrintWriter;

import javax.swing.BorderFactory;

import client.App;

public class Setter {
	// set ready button available
	public static void setReadyButtonAvailable(boolean activate) {
		// reset button
		UI.game_ready_button.setBackground(Color.GRAY);
		UI.game_ready_button.setText("Ready?");
		// available
		UI.game_ready_button.setVisible(activate);
		// repaint
		UI.mp.repaint();
		// force repaint
		App.u.setVisible(true);
	}
	// set select_panel_role available
	public static void setSelectPanelRoleAvailable(boolean activate) {
		UI.select_panel_role.setVisible(activate);
		// repaint
		UI.mp.repaint();
		// force repaint
		App.u.setVisible(true);
	}
	
	// set select_panel_character available
	public static void setSelectPanelCharacterAvailable(boolean activate) {
		UI.select_panel_character.setVisible(activate);
		// repaint
		UI.mp.repaint();
		// force repaint
		App.u.setVisible(true);
	}
	
	// set select_panel_scenario available
	public static void setSelectPanelScenarioAvailable(boolean activate) {
		UI.select_panel_scenario.setVisible(activate);
		// repaint
		UI.mp.repaint();
		// force repaint
		App.u.setVisible(true);
	}
	
	// set player_character image available(userName, activate) (A:me)
	// (B:bottom-left, C:middle-left, D: top-left)
	// (E:top-right, F:middle-right, G:bottom-right)
	public static void setPlayerCharacterImageAvailable(String userName, boolean activate) {
		// find seat (A)
		if(UI.player_A_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_A_character");
				UI.player_A.add(UI.player_A_character);
			} else if(activate == false) {
				System.out.println("Remove player_A_character");
				UI.player_A.remove(UI.player_A_character);
			}
		}
		// inf seat (B)
		else if(UI.player_B_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_B_character");
				UI.player_B.add(UI.player_B_character);
			} else if(activate == false) {
				System.out.println("Remove player_B_character");
				UI.player_B.remove(UI.player_B_character);
			}
		}
		// inf seat (C)
		else if(UI.player_C_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_C_character");
				UI.player_C.add(UI.player_C_character);
			} else if(activate == false) {
				System.out.println("Remove player_C_character");
				UI.player_C.remove(UI.player_C_character);
			}
		}
		// inf seat (D)
		else if(UI.player_D_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_D_character");
				UI.player_D.add(UI.player_D_character);
			} else if(activate == false) {
				System.out.println("Remove player_D_character");
				UI.player_D.remove(UI.player_D_character);
			}
		}
		// inf seat (E)
		else if(UI.player_E_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_E_character");
				UI.player_E.add(UI.player_E_character);
			} else if(activate == false) {
				System.out.println("Remove player_E_character");
				UI.player_E.remove(UI.player_E_character);
			}
		}
		// inf seat (F)
		else if(UI.player_F_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_F_character");
				UI.player_F.add(UI.player_F_character);
			} else if(activate == false) {
				System.out.println("Remove player_F_character");
				UI.player_F.remove(UI.player_F_character);
			}
		}
		// inf seat (G)
		else if(UI.player_G_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_G_character");
				UI.player_G.add(UI.player_G_character);
			} else if(activate == false) {
				System.out.println("Remove player_G_character");
				UI.player_G.remove(UI.player_G_character);
			}
		}

		// repaint
		UI.mp.repaint();
	}
	
	// set player character ability button available
	public static void setPlayerButtonAvailable(boolean activate) {
		UI.player_multi_button.setEnabled(activate);
		UI.player_multi_button.setVisible(activate);
		if(activate == true) UI.player_A.add(UI.player_multi_button);
		else if(activate == false) UI.player_A.remove(UI.player_multi_button);
		
		// repaint
		UI.mp.repaint();
	}
	
	// set main_deck image available (both of new, old)
	public static void setMainDeckImageAvailable(boolean activate) {
		UI.main_deck_new.setVisible(activate);
		UI.main_deck_old.setVisible(activate);
		if(activate == true) {
			UI.mp.add(UI.main_deck_new);
			UI.mp.add(UI.main_deck_old);
		}
		else if(activate == false) {
			UI.mp.remove(UI.main_deck_new);
			UI.mp.remove(UI.main_deck_old);
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set player_hp image available
	public static void setPlayerHpImageAvailable(boolean activate) {
		UI.player_A_hp_icon.setVisible(activate);
		UI.player_B_hp_icon.setVisible(activate);
		UI.player_C_hp_icon.setVisible(activate);
		UI.player_D_hp_icon.setVisible(activate);
		UI.player_E_hp_icon.setVisible(activate);
		UI.player_F_hp_icon.setVisible(activate);
		UI.player_G_hp_icon.setVisible(activate);
		if(activate == true) {
			UI.player_A.add(UI.player_A_hp_icon);
			UI.player_B.add(UI.player_B_hp_icon);
			UI.player_C.add(UI.player_C_hp_icon);
			UI.player_D.add(UI.player_D_hp_icon);
			UI.player_E.add(UI.player_E_hp_icon);
			UI.player_F.add(UI.player_F_hp_icon);
			UI.player_G.add(UI.player_G_hp_icon);
		}
		else if(activate == false) {
			UI.player_A.remove(UI.player_A_hp_icon);
			UI.player_B.remove(UI.player_B_hp_icon);
			UI.player_C.remove(UI.player_C_hp_icon);
			UI.player_D.remove(UI.player_D_hp_icon);
			UI.player_E.remove(UI.player_E_hp_icon);
			UI.player_F.remove(UI.player_F_hp_icon);
			UI.player_G.remove(UI.player_G_hp_icon);
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set player_gold image available
	public static void setPlayerGoldImageAvailable(boolean activate) {
		UI.player_A_gold_icon.setVisible(activate);
		UI.player_B_gold_icon.setVisible(activate);
		UI.player_C_gold_icon.setVisible(activate);
		UI.player_D_gold_icon.setVisible(activate);
		UI.player_E_gold_icon.setVisible(activate);
		UI.player_F_gold_icon.setVisible(activate);
		UI.player_G_gold_icon.setVisible(activate);
		if(activate == true) {
			UI.player_A.add(UI.player_A_gold_icon);
			UI.player_B.add(UI.player_B_gold_icon);
			UI.player_C.add(UI.player_C_gold_icon);
			UI.player_D.add(UI.player_D_gold_icon);
			UI.player_E.add(UI.player_E_gold_icon);
			UI.player_F.add(UI.player_F_gold_icon);
			UI.player_G.add(UI.player_G_gold_icon);
		}
		else if(activate == false) {
			UI.player_A.remove(UI.player_A_gold_icon);
			UI.player_B.remove(UI.player_B_gold_icon);
			UI.player_C.remove(UI.player_C_gold_icon);
			UI.player_D.remove(UI.player_D_gold_icon);
			UI.player_E.remove(UI.player_E_gold_icon);
			UI.player_F.remove(UI.player_F_gold_icon);
			UI.player_G.remove(UI.player_G_gold_icon);
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set player_hp text available
	public static void setPlayerHpTextAvailable(boolean activate) {
		UI.player_A_hp_text.setVisible(activate);
		UI.player_B_hp_text.setVisible(activate);
		UI.player_C_hp_text.setVisible(activate);
		UI.player_D_hp_text.setVisible(activate);
		UI.player_E_hp_text.setVisible(activate);
		UI.player_F_hp_text.setVisible(activate);
		UI.player_G_hp_text.setVisible(activate);
		if(activate == true) {
			UI.player_A.add(UI.player_A_hp_text);
			UI.player_B.add(UI.player_B_hp_text);
			UI.player_C.add(UI.player_C_hp_text);
			UI.player_D.add(UI.player_D_hp_text);
			UI.player_E.add(UI.player_E_hp_text);
			UI.player_F.add(UI.player_F_hp_text);
			UI.player_G.add(UI.player_G_hp_text);
		}
		else if(activate == false) {
			UI.player_A.remove(UI.player_A_hp_text);
			UI.player_B.remove(UI.player_B_hp_text);
			UI.player_C.remove(UI.player_C_hp_text);
			UI.player_D.remove(UI.player_D_hp_text);
			UI.player_E.remove(UI.player_E_hp_text);
			UI.player_F.remove(UI.player_F_hp_text);
			UI.player_G.remove(UI.player_G_hp_text);
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set player_gold text available
	public static void setPlayerGoldTextAvailable(boolean activate) {
		UI.player_A_gold_text.setVisible(activate);
		UI.player_B_gold_text.setVisible(activate);
		UI.player_C_gold_text.setVisible(activate);
		UI.player_D_gold_text.setVisible(activate);
		UI.player_E_gold_text.setVisible(activate);
		UI.player_F_gold_text.setVisible(activate);
		UI.player_G_gold_text.setVisible(activate);
		if(activate == true) {
			UI.player_A.add(UI.player_A_gold_text);
			UI.player_B.add(UI.player_B_gold_text);
			UI.player_C.add(UI.player_C_gold_text);
			UI.player_D.add(UI.player_D_gold_text);
			UI.player_E.add(UI.player_E_gold_text);
			UI.player_F.add(UI.player_F_gold_text);
			UI.player_G.add(UI.player_G_gold_text);
		}
		else if(activate == false) {
			UI.player_A.remove(UI.player_A_gold_text);
			UI.player_B.remove(UI.player_B_gold_text);
			UI.player_C.remove(UI.player_C_gold_text);
			UI.player_D.remove(UI.player_D_gold_text);
			UI.player_E.remove(UI.player_E_gold_text);
			UI.player_F.remove(UI.player_F_gold_text);
			UI.player_G.remove(UI.player_G_gold_text);
		}
		
		// repaint
		UI.mp.repaint();
	}

	// set player_role image available(userName, activate) (A:me)
	// (B:bottom-left, C:middle-left, D: top-left)
	// (E:top-right, F:middle-right, G:bottom-right)
	public static void setPlayerRoleImageAvailable(String userName, boolean activate) {
		// find seat (A(me))
		if(UI.player_A_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_A_role");
				UI.player_A.add(UI.player_A_role);
			} else if(activate == false) {
				System.out.println("Remove player_A_role");
				UI.player_A.remove(UI.player_A_role);
			}
		}
		// find seat (B)
		else if(UI.player_B_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_B_role");
				UI.player_B.add(UI.player_B_role);
			} else if(activate == false) {
				System.out.println("Remove player_B_role");
				UI.player_B.remove(UI.player_B_role);
			}
		}
		// find seat (C)
		else if(UI.player_C_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_C_role");
				UI.player_C.add(UI.player_C_role);
			} else if(activate == false) {
				System.out.println("Remove player_C_role");
				UI.player_C.remove(UI.player_C_role);
			}
		}
		// find seat (D)
		else if(UI.player_D_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_D_role");
				UI.player_D.add(UI.player_D_role);
			} else if(activate == false) {
				System.out.println("Remove player_D_role");
				UI.player_D.remove(UI.player_D_role);
			}
		}
		// find seat (E)
		else if(UI.player_E_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_E_role");
				UI.player_E.add(UI.player_E_role);
			} else if(activate == false) {
				System.out.println("Remove player_E_role");
				UI.player_E.remove(UI.player_E_role);
			}
		}
		// find seat (F)
		else if(UI.player_F_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_F_role");
				UI.player_F.add(UI.player_F_role);
			} else if(activate == false) {
				System.out.println("Remove player_F_role");
				UI.player_F.remove(UI.player_F_role);
			}
		}
		// find seat (G)
		else if(UI.player_G_name.getText().equals(userName)) {
			if(activate == true) {
				System.out.println("Setting player_G_role");
				UI.player_G.add(UI.player_G_role);
			} else if(activate == false) {
				System.out.println("Remove player_G_role");
				UI.player_G.remove(UI.player_G_role);
			}
		}

		// repaint
		UI.mp.repaint();
	}
	
	// set player_gun image available (name, activate) (A:me)
	// (B:bottom-left, C:middle-left, D: top-left)
	// (E:top-right, F:middle-right, G:bottom-right)
	public static void setPlayerGunImageAvailable(String name, boolean activate) {
		// find seat (A)
		if(UI.player_A_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_A_gun");
				UI.player_A.add(UI.player_A_gun);
			} else if(activate == false) {
				System.out.println("Remove player_A_gun");
				UI.player_A.remove(UI.player_A_gun);
			}
		}
		// find seat (B)
		if(UI.player_B_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_B_gun");
				UI.player_B.add(UI.player_B_gun);
			} else if(activate == false) {
				System.out.println("Remove player_B_gun");
				UI.player_B.remove(UI.player_B_gun);
			}
		}
		// find seat (C)
		if(UI.player_C_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_C_gun");
				UI.player_C.add(UI.player_C_gun);
			} else if(activate == false) {
				System.out.println("Remove player_C_gun");
				UI.player_C.remove(UI.player_C_gun);
			}
		}
		// find seat (D)
		if(UI.player_D_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_D_gun");
				UI.player_D.add(UI.player_D_gun);
			} else if(activate == false) {
				System.out.println("Remove player_D_gun");
				UI.player_D.remove(UI.player_D_gun);
			}
		}
		// find seat (E)
		if(UI.player_E_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_E_gun");
				UI.player_E.add(UI.player_E_gun);
			} else if(activate == false) {
				System.out.println("Remove player_E_gun");
				UI.player_E.remove(UI.player_E_gun);
			}
		}
		// find seat (F)
		if(UI.player_F_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_F_gun");
				UI.player_F.add(UI.player_F_gun);
			} else if(activate == false) {
				System.out.println("Remove player_F_gun");
				UI.player_F.remove(UI.player_F_gun);
			}
		}
		// find seat (G)
		if(UI.player_G_name.getText().equals(name)) {
			if(activate == true) {
				System.out.println("Setting player_G_gun");
				UI.player_G.add(UI.player_G_gun);
			} else if(activate == false) {
				System.out.println("Remove player_G_gun");
				UI.player_G.remove(UI.player_G_gun);
			}
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set player_name available (name, seatLocation, activate) (A:me)
	// (B:bottom-left, C:middle-left, D: top-left)
	// (E:top-right, F:middle-right, G:bottom-right)
	public static void setPlayerNameAvailable(String name, char seatLocation, boolean activate) {
		switch (seatLocation) {
		case 'A':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at A");
				UI.player_A_name.setText(name);
				UI.mp.add(UI.player_A_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at A");
				UI.mp.remove(UI.player_A_name);
			}
			break;
		case 'B':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at B");
				UI.player_B_name.setText(name);
				UI.mp.add(UI.player_B_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at B");
				UI.mp.remove(UI.player_B_name);
			}
			break;
		case 'C':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at C");
				UI.player_C_name.setText(name);
				UI.mp.add(UI.player_C_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at C");
				UI.mp.remove(UI.player_C_name);
			}
			break;
		case 'D':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at D");
				UI.player_D_name.setText(name);
				UI.mp.add(UI.player_D_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at D");
				UI.mp.remove(UI.player_D_name);
			}
			break;
		case 'E':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at E");
				UI.player_E_name.setText(name);
				UI.mp.add(UI.player_E_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at E");
				UI.mp.remove(UI.player_E_name);
			}
			break;
		case 'F':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at F");
				UI.player_F_name.setText(name);
				UI.mp.add(UI.player_F_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at F");
				UI.mp.remove(UI.player_F_name);
			}
			break;
		case 'G':
			if(activate == true) {
				System.out.println("Setting player_name ["+name+"] at G");
				UI.player_G_name.setText(name);
				UI.mp.add(UI.player_G_name);
			} else if(activate == false){
				System.out.println("Remove player_name ["+name+"] at G");
				UI.mp.remove(UI.player_G_name);
			}
			break;
		default:
			System.out.println("[Unknown][setPlayerNameAvailable] > Unknown player_name. ("+seatLocation+")");
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set seat available (name, seatName, activate) (A:me)
	// (B:bottom-left, C:middle-left, D: top-left)
	// (E:top-right, F:middle-right, G:bottom-right)
	public static void setSeatAvailable(String name, char seatLocation, boolean activate) {
		switch (seatLocation) {
		case 'A':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at A");
				UI.mp.add(UI.player_A);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at A");
				UI.mp.remove(UI.player_A);
			}
//			UI.player_A.setVisible(activate);
			break;
		case 'B':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at B");
				UI.mp.add(UI.player_B);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at B");
				UI.mp.remove(UI.player_B);
			}
//			UI.player_B.setVisible(activate);
			break;
		case 'C':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at C");
				UI.mp.add(UI.player_C);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at C");
				UI.mp.remove(UI.player_C);
			}
//			UI.player_C.setVisible(activate);
			break;
		case 'D':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at D");
				UI.mp.add(UI.player_D);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at D");
				UI.mp.remove(UI.player_D);
			}
//			UI.player_D.setVisible(activate);
			break;
		case 'E':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at E");
				UI.mp.add(UI.player_E);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at E");
				UI.mp.remove(UI.player_E);
			}
//			UI.player_E.setVisible(activate);
			break;
		case 'F':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at F");
				UI.mp.add(UI.player_F);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at F");
				UI.mp.remove(UI.player_F);
			}
//			UI.player_F.setVisible(activate);
			break;
		case 'G':
			if(activate == true) {
				System.out.println("Setting seat ["+name+"] at G");
				UI.mp.add(UI.player_G);
			} else if(activate == false){
				System.out.println("Remove seat ["+name+"] at G");
				UI.mp.remove(UI.player_G);
			}
//			UI.player_G.setVisible(true);
			break;
		default:
			System.out.println("[Unknown][setSeatAvailable] > Unknown seat. ("+seatLocation+")");
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set notice available (top:1 / middle:2)
	public static void setNoticeAvailable(int target, boolean activate) {
		if(target == 1) {
			if(activate == true) UI.mp.add(UI.notice_top);
			else UI.mp.remove(UI.notice_top);
		}
		else if(target == 2) {
			if(activate == true) UI.mp.add(UI.notice_middle);
			else UI.mp.remove(UI.notice_middle);
		}
		else {
			System.out.println("[Unknown][setNoticeAvailable] > Unknown notice.");
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set scenario available (1: turn_back / 2: turn_front / 3: wild_back / 4: wild_front)
	public static void setScenarioImageAvailable(int target, boolean activate) {
		if(target == 1) {
			UI.scenario_turn_back.setVisible(activate);
			if(activate == true) UI.mp.add(UI.scenario_turn_back);
			else UI.mp.remove(UI.scenario_turn_back);
			// set scenario_turn_next available
			UI.scenario_turn_next.setVisible(activate);
			if(activate == true) UI.mp.add(UI.scenario_turn_next);
			else UI.mp.remove(UI.scenario_turn_next);
		}
		else if(target == 2) {
			UI.scenario_turn_front.setVisible(activate);
			if(activate == true) UI.mp.add(UI.scenario_turn_front);
			else UI.mp.remove(UI.scenario_turn_front);
			// set scenario_turn_now available
			UI.scenario_turn_now.setVisible(activate);
			if(activate == true) UI.mp.add(UI.scenario_turn_now);
			else UI.mp.remove(UI.scenario_turn_now);
		}
		else if(target == 3) {
			UI.scenario_wild_back.setVisible(activate);
			if(activate == true) UI.mp.add(UI.scenario_wild_back);
			else UI.mp.remove(UI.scenario_wild_back);
		}
		else if(target == 4) {
			UI.scenario_wild_front.setVisible(activate);
			if(activate == true) UI.mp.add(UI.scenario_wild_front);
			else UI.mp.add(UI.scenario_wild_front);
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set gold rush available (1: new / 2: open_1 / 3: open_2 / 4: open_3)
	public static void setGoldRushImageAvailable(int target, boolean activate) {
		if(target == 1) {
			UI.gold_rush_new.setVisible(activate);
			if(activate == true) UI.mp.add(UI.gold_rush_new);
			else UI.mp.remove(UI.gold_rush_new);
		}
		else if(target == 2) {
			UI.gold_rush_open_1.setVisible(activate);
			if(activate == true) UI.mp.add(UI.gold_rush_open_1);
			else UI.mp.remove(UI.gold_rush_open_1);
		}
		else if(target == 3) {
			UI.gold_rush_open_2.setVisible(activate);
			if(activate == true) UI.mp.add(UI.gold_rush_open_2);
			else UI.mp.remove(UI.gold_rush_open_2);
		}
		else if(target == 4) {
			UI.gold_rush_open_3.setVisible(activate);
			if(activate == true) UI.mp.add(UI.gold_rush_open_3);
			else UI.mp.remove(UI.gold_rush_open_3);
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set player hand available
	public static void setPlayerHandImageAvailable(String id, boolean activate) {
		if(UI.player_A_name.getText().equals(id)) {
			UI.player_A_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_A_hand);
			else UI.mp.remove(UI.player_A_hand);
		}
		else if(UI.player_B_name.getText().equals(id)) {
			UI.player_B_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_B_hand);
			else UI.mp.remove(UI.player_B_hand);			
		}
		else if(UI.player_C_name.getText().equals(id)) {
			UI.player_C_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_C_hand);
			else UI.mp.remove(UI.player_C_hand);
		}
		else if(UI.player_D_name.getText().equals(id)) {
			UI.player_D_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_D_hand);
			else UI.mp.remove(UI.player_D_hand);
		}
		else if(UI.player_E_name.getText().equals(id)) {
			UI.player_E_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_E_hand);
			else UI.mp.remove(UI.player_E_hand);
		}
		else if(UI.player_F_name.getText().equals(id)) {
			UI.player_F_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_F_hand);
			else UI.mp.remove(UI.player_F_hand);
		}
		else if(UI.player_G_name.getText().equals(id)) {
			UI.player_G_hand.setVisible(activate);
			if(activate == true) UI.mp.add(UI.player_G_hand);
			else UI.mp.remove(UI.player_G_hand);
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set player_hp text
	public static void setPlayerHpText(String name, int hp, boolean isSceriffo) {
		// find seat (A)
		if(UI.player_A_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_A_hp_text.setText(" x "+(hp+1));
			else UI.player_A_hp_text.setText(" x "+hp);
		}
		// find seat (B)
		else if(UI.player_B_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_B_hp_text.setText(" x "+(hp+1));
			else UI.player_B_hp_text.setText(" x "+hp);
		}
		// find seat (C)
		else if(UI.player_C_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_C_hp_text.setText(" x "+(hp+1));
			else UI.player_C_hp_text.setText(" x "+hp);
		}
		// find seat (D)
		else if(UI.player_D_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_D_hp_text.setText(" x "+(hp+1));
			else UI.player_D_hp_text.setText(" x "+hp);
		}
		// find seat (E)
		else if(UI.player_E_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_E_hp_text.setText(" x "+(hp+1));
			else UI.player_E_hp_text.setText(" x "+hp);
		}
		// find seat (F)
		else if(UI.player_F_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_F_hp_text.setText(" x "+(hp+1));
			else UI.player_F_hp_text.setText(" x "+hp);
		}
		// find seat (G)
		else if(UI.player_G_name.getText().equals(name)) {
			if(isSceriffo == true) UI.player_G_hp_text.setText(" x "+(hp+1));
			else UI.player_G_hp_text.setText(" x "+hp);
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set player_hp update (+@), if hp <= 0 send message to server <- TODO
	public static void setPlayerHpTextUpdate(PrintWriter os, String name, int size) {
		// find seat (A)
		if(UI.player_A_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_A_hp_text.getText().charAt(3)))+size;
			UI.player_A_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_A_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_A_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
				// if deadACK == false, 
				if(UI.deadACK == false) {
					// send message to server
					os.println("game/DIED/"+UI.player_A_role.getText());
					// set deadACK == true
					UI.deadACK = true;	
				}
			}
		}
		// find seat (B)
		else if(UI.player_B_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_B_hp_text.getText().charAt(3)))+size;
			UI.player_B_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_B_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_B_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
			}
		}
		// find seat (C)
		else if(UI.player_C_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_C_hp_text.getText().charAt(3)))+size;
			UI.player_C_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_C_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_C_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
			}
		}
		// find seat (D)
		else if(UI.player_D_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_D_hp_text.getText().charAt(3)))+size;
			UI.player_D_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_D_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_D_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
			}
		}
		// find seat (E)
		else if(UI.player_E_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_E_hp_text.getText().charAt(3)))+size;
			UI.player_E_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_E_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_E_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
			}
		}
		// find seat (F)
		else if(UI.player_F_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_F_hp_text.getText().charAt(3)))+size;
			UI.player_F_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_F_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_F_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
			}
		}
		// find seat (G)
		else if(UI.player_G_name.getText().equals(name)) {
			int updateHp = Integer.parseInt(Character.toString(UI.player_G_hp_text.getText().charAt(3)))+size;
			UI.player_G_hp_text.setText(" x "+updateHp);
			// if hp <= 0, send message to server
			if(updateHp <= 0) {
				// setting hp = 0
				UI.player_G_hp_text.setText(" x "+0);
				// set role card open
				Setter.setPlayerRoleImageAvailable(name, false);
				CardMaker.make_card_handField_role(name, UI.player_G_role.getText(), true);
				Setter.setPlayerRoleImageAvailable(name, true);
			}
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set player_gold text
	public static void setPlayerGoldText(String name, int gold) {
		// find seat (A)
		if(UI.player_A_name.getText().equals(name)) {
			UI.player_A_gold_text.setText(" x "+gold);
		}
		// find seat (B)
		else if(UI.player_B_name.getText().equals(name)) {
			UI.player_B_gold_text.setText(" x "+gold);
		}
		// find seat (C)
		else if(UI.player_C_name.getText().equals(name)) {
			UI.player_C_gold_text.setText(" x "+gold);
		}
		// find seat (D)
		else if(UI.player_D_name.getText().equals(name)) {
			UI.player_D_gold_text.setText(" x "+gold);
		}
		// find seat (E)
		else if(UI.player_E_name.getText().equals(name)) {
			UI.player_E_gold_text.setText(" x "+gold);
		}
		// find seat (F)
		else if(UI.player_F_name.getText().equals(name)) {
			UI.player_F_gold_text.setText(" x "+gold);
		}
		// find seat (G)
		else if(UI.player_G_name.getText().equals(name)) {
			UI.player_G_gold_text.setText(" x "+gold);
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// set text in notice (top:1 / middle:2)
	public static void setTextNotice(int target, String text) {
		if(target == 1) {
			UI.notice_top.setText(text);
		}
		else if(target == 2) {
			UI.notice_middle.setText(text);
		}
		else {
			System.out.println("[Unknown][setTextNotice] > Unknown notice.");
		}
		// repaint
		UI.mp.repaint();
	}
	
	// refresh player's field cards
	public static void setFieldRefresh(String id) {
		// find seat
		if(UI.player_A_name.getText().equals(id)) {
			// extract cards
			Component[] cards = UI.player_A_field.getComponents();
			// delete all components
			UI.player_A_field.removeAll();
			// re-add
			int idx = 0;
			for(Component c : cards) {
				Select_button card = (Select_button)c;
				// re-set bounds
				card.setBounds(67*(idx/2),(idx%2==0)?0:135,87,135);
				UI.player_A_field.add(card);
				idx++;
			}
		}
		// repaint
		UI.mp.repaint();
	}
	
	// set turn player painting
	public static void setPhasePainter(String name, int phase) {
		// remove all border
		UI.player_A.setBorder(null);
		UI.player_B.setBorder(null);
		UI.player_C.setBorder(null);
		UI.player_D.setBorder(null);
		UI.player_E.setBorder(null);
		UI.player_F.setBorder(null);
		UI.player_G.setBorder(null);
		// find seat (A)
		if(UI.player_A_name.getText().equals(name)) {
			if(phase == 0) UI.player_A.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_A.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_A.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_A.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// find seat (B)
		else if(UI.player_B_name.getText().equals(name)) {
			if(phase == 0) UI.player_B.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_B.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_B.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_B.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// find seat (C)
		else if(UI.player_C_name.getText().equals(name)) {
			if(phase == 0) UI.player_C.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_C.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_C.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_C.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// find seat (D)
		else if(UI.player_D_name.getText().equals(name)) {
			if(phase == 0) UI.player_D.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_D.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_D.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_D.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// find seat (E)
		else if(UI.player_E_name.getText().equals(name)) {
			if(phase == 0) UI.player_E.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_E.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_E.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_E.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// find seat (F)
		else if(UI.player_F_name.getText().equals(name)) {
			if(phase == 0) UI.player_F.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_F.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_F.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_F.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// find seat (G)
		else if(UI.player_G_name.getText().equals(name)) {
			if(phase == 0) UI.player_G.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),3));
			if(phase == 1) UI.player_G.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3));
			if(phase == 2) UI.player_G.setBorder(BorderFactory.createLineBorder(new Color(0,255,255),3));
			if(phase == 3) UI.player_G.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),3));
		}
		// repaint
		UI.mp.repaint();
	}
	
	// main panel re-initialize for game start & end
	public static void reInit_mainPanel() {
		// card info label & panel clear
		UI.show_detail_panel.removeAll();
		UI.show_detail_label.setText(null);
		// player_[A~G] panel border clear
		UI.player_A.setBorder(null);
		UI.player_B.setBorder(null);
		UI.player_C.setBorder(null);
		UI.player_D.setBorder(null);
		UI.player_E.setBorder(null);
		UI.player_F.setBorder(null);
		UI.player_G.setBorder(null);
		// player_[A~G] panel clear
		UI.player_A.removeAll();
		UI.player_B.removeAll();
		UI.player_C.removeAll();
		UI.player_D.removeAll();
		UI.player_E.removeAll();
		UI.player_F.removeAll();
		UI.player_G.removeAll();
		// player_[A~G] hand panel clear
		UI.player_A_hand.removeAll();
		UI.player_B_hand.removeAll();
		UI.player_C_hand.removeAll();
		UI.player_D_hand.removeAll();
		UI.player_E_hand.removeAll();
		UI.player_F_hand.removeAll();
		UI.player_G_hand.removeAll();
		// add fake card (C,F)
		UI.player_C_hand.add(CardMaker.make_card_handField_playing_fake());
		UI.player_F_hand.add(CardMaker.make_card_handField_playing_fake());
		// main_panel clear
		UI.mp.removeAll();
		// disable (select_panel_role)
		UI.mp.add(UI.select_panel_role);
		UI.select_panel_role.setVisible(false);
		// disable (select_panel_character)
		UI.mp.add(UI.select_panel_character);
		UI.select_panel_character.setVisible(false);
		// disable (select_panel_scenario)
		UI.mp.add(UI.select_panel_scenario);
		UI.select_panel_scenario.setVisible(false);
		// add detail label
		UI.mp.add(UI.show_detail_label);
		// add detail panel
		UI.mp.add(UI.show_detail_panel);
		// card use = false, setTarget = false, attacked = false
		// targetCommand = {"",}, attackedCommand = null, deadACK = false
		UI.setCardUse2(false);
		UI.setCardUse3(false);
		UI.setSetTarget(false);
		UI.setAttacked(false);
		UI.targetCommand = new String[] {"","","","","","",""};
		UI.attackedCommand = null;
		UI.deadACK = false;
		// repaint
		UI.mp.repaint();
		App.u.setVisible(true);
	}
}
