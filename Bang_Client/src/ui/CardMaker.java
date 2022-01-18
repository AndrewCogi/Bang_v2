// card button maker

package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.*;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import client.App;

public class CardMaker {
	// make hand & field card button (scenario card) (1: turn_back / 2: turn_front / 3: wild_back / 4: wild_front)
	public static void make_card_handField_scenario(int target, String extension, String cardName) {
		// target == 1 (turn_back)
		if(target == 1) {
			// remove already setting
			if(UI.scenario_turn_back != null) UI.mp.remove(UI.scenario_turn_back);
			// re-init
			UI.scenario_turn_back = new JButton();
			// set image "extension/cardName"
 			UI.scenario_turn_back.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_87.png"));
			// set bounds
			UI.scenario_turn_back.setBounds(460,435,87,135);
			// set size
			UI.scenario_turn_back.setPreferredSize(new Dimension(87,135));
			// set border null
			UI.scenario_turn_back.setBorder(null);
 			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.scenario_turn_back.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_turn_back.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_turn_back.setBorder(null);
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.scenario_turn_back.setDisabledIcon(UI.scenario_turn_back.getIcon());
			UI.scenario_turn_back.setEnabled(false);
		}
		// target == 2 (turn_front)
		else if(target == 2) {
			// remove already setting
			if(UI.scenario_turn_front != null) UI.mp.remove(UI.scenario_turn_front);
			// re-init
			UI.scenario_turn_front = new JButton();
			// set image "extension/cardName"
			UI.scenario_turn_front.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_87.png"));
			// set bounds
			UI.scenario_turn_front.setBounds(550,435,87,135);
			// set size
			UI.scenario_turn_front.setPreferredSize(new Dimension(87,135));
			// set border null
			UI.scenario_turn_front.setBorder(null);
 			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.scenario_turn_front.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_turn_front.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_turn_front.setBorder(null);
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.scenario_turn_front.setDisabledIcon(UI.scenario_turn_front.getIcon());
			UI.scenario_turn_front.setEnabled(false);
		}
		// target == 3 (wild_back)
		else if(target == 3) {
			// remove already setting
			if(UI.scenario_wild_back != null) UI.mp.remove(UI.scenario_wild_back);
			// re-init
			UI.scenario_wild_back = new JButton();
			// set image "extension/cardName"
			UI.scenario_wild_back.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_87.png"));
			// set bounds
			UI.scenario_wild_back.setBounds(640,435,87,135);
			// set size
			UI.scenario_wild_back.setPreferredSize(new Dimension(87,135));
			// set border null
			UI.scenario_wild_back.setBorder(null);
			// set mouse listener
			UI.scenario_wild_back.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_wild_back.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_wild_back.setBorder(null);
				}
			});
			// set disable
			UI.scenario_wild_back.setDisabledIcon(UI.scenario_wild_back.getIcon());
			UI.scenario_wild_back.setEnabled(false);
		}
		// target == 4 (wild_front)
		else if(target == 4) {
			// remove already setting
			if(UI.scenario_wild_front != null) UI.mp.remove(UI.scenario_wild_front);
			// re-init
			UI.scenario_wild_front = new JButton();
			// set image "extension/cardName"
			UI.scenario_wild_front.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_87.png"));
			// set bounds
			UI.scenario_wild_front.setBounds(730,435,87,135);
			// set size
			UI.scenario_wild_front.setPreferredSize(new Dimension(87,135));
			// set border null
			UI.scenario_wild_front.setBorder(null);
 			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.scenario_wild_front.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_wild_front.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_wild_front.setBorder(null);
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.scenario_wild_front.setDisabledIcon(UI.scenario_wild_front.getIcon());
			UI.scenario_wild_front.setEnabled(false);
		}
		// repaint
		UI.mp.repaint();
	}
	
	// make hand & field card button (last scenario card)
	public static void make_card_handField_scenario_last(String cardName) {
		if(cardName.equals("a_fistful_of_cards")) {
			// set image "a fistful of cards"
			UI.scenario_turn_back = new JButton();
			UI.scenario_turn_back.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\a_fistful_of_cards\\per_un_pugno_di_carte_87.png"));
			// set bounds
			UI.scenario_turn_back.setBounds(460,435,87,135);
			// set size
			UI.scenario_turn_back.setPreferredSize(new Dimension(87,135));
			// set mouse listener
			UI.scenario_turn_back.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_turn_back.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_turn_back.setBorder(null);
				}
			});
			// set disable
			UI.scenario_turn_back.setDisabledIcon(UI.scenario_turn_back.getIcon());
			UI.scenario_turn_back.setEnabled(false);
		}
		else if(cardName.equals("high_noon")) {
			// set image "high noon"
			UI.scenario_turn_back = new JButton();
			UI.scenario_turn_back.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\high_noon\\mezzogiorno_di_fuoco_87.png"));
			// set bounds
			UI.scenario_turn_back.setBounds(460,435,87,135);
			// set size
			UI.scenario_turn_back.setPreferredSize(new Dimension(87,135));
			// set mouse listener
			UI.scenario_turn_back.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_turn_back.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_turn_back.setBorder(null);
				}
			});
			// set disable
			UI.scenario_turn_back.setDisabledIcon(UI.scenario_turn_back.getIcon());
			UI.scenario_turn_back.setEnabled(false);
		}
		else if(cardName.equals("wild_west_show")) {
			// set image "wild west show"
			UI.scenario_wild_back = new JButton();
			UI.scenario_wild_back.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\wild_west_show\\wild_west_show_87.png"));
			// set bounds
			UI.scenario_wild_back.setBounds(640,435,87,135);
			// set size
			UI.scenario_wild_back.setPreferredSize(new Dimension(87,135));
			// set mouse listener
			UI.scenario_wild_back.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.scenario_wild_back.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.scenario_wild_back.setBorder(null);
				}
			});
			// set disable
			UI.scenario_wild_back.setDisabledIcon(UI.scenario_wild_back.getIcon());
			UI.scenario_wild_back.setEnabled(false);
		}
		// repaint
		UI.mp.repaint();
	}
	
	// make hand & field card button (init main card)
	public static void make_card_handField_main_deck_init() {
		// init buttons
		UI.main_deck_new = new JButton();
		UI.main_deck_old = new JButton();
		// set bounds
		UI.main_deck_new.setBounds(852,405,87,135);
		UI.main_deck_old.setBounds(955,405,87,135);
		// set button fill false
		UI.main_deck_new.setContentAreaFilled(false);
		UI.main_deck_old.setContentAreaFilled(false);
		// main_deck_new (back image)
		UI.main_deck_new.setIcon(new ImageIcon(".\\.\\resources\\card\\playing\\back_87.png"));
		// main_deck_old (empty image)
		UI.main_deck_old.setIcon(new ImageIcon(".\\.\\resources\\card\\empty_87.png"));
		// set invisible
		UI.main_deck_new.setVisible(false);
		UI.main_deck_old.setVisible(false);
		
		// repaint
		UI.mp.repaint();
	}
	
	// make hand & field card button (gold rush card)
	public static void make_card_handField_gold_rush(int target, String cardColor, String cardName, int cost) {
		// target == 1 && else -> null (new)
		if(target == 1) {
			// init button
			UI.gold_rush_new = new JButton();
			// set bounds
			UI.gold_rush_new.setBounds(1077,435,87,135);
			// set image
			UI.gold_rush_new.setIcon(new ImageIcon(".\\.\\resources\\card\\gold_rush\\back_87.png"));
			// set invisible
			UI.gold_rush_new.setVisible(false);
			// set border null
			UI.gold_rush_new.setBorder(null);
			// set Disable
			UI.gold_rush_new.setDisabledIcon(UI.gold_rush_new.getIcon());
			UI.gold_rush_new.setEnabled(false);
			// set mouse listener
			UI.gold_rush_new.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.gold_rush_new.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.gold_rush_new.setBorder(null);
				}
			});
		}
		// target == 2 (open1)
		else if(target == 2) {
			// init button
			UI.gold_rush_open_1= new JButton(cardColor+"/"+cardName+"/"+cost) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\gold_rush\\"+cardColor+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.gold_rush_open_1.setBounds(1166,435,87,135);
			// set invisible
			UI.gold_rush_open_1.setVisible(false);
			// set border null
			UI.gold_rush_open_1.setBorder(null);
			// set Disable
			UI.gold_rush_open_1.setDisabledIcon(UI.gold_rush_open_1.getIcon());
			UI.gold_rush_open_1.setEnabled(false);
 			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\gold_rush\\"+cardColor+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.gold_rush_open_1.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.gold_rush_open_1.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.gold_rush_open_1.setBorder(null);
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// target == 3 (open2)
		else if(target == 3) {
			// init button
			UI.gold_rush_open_2= new JButton(cardColor+"/"+cardName+"/"+cost) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\gold_rush\\"+cardColor+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.gold_rush_open_2.setBounds(1255,435,87,135);
			// set invisible
			UI.gold_rush_open_2.setVisible(false);
			// set border null
			UI.gold_rush_open_2.setBorder(null);
			// set Disable
			UI.gold_rush_open_2.setDisabledIcon(UI.gold_rush_open_2.getIcon());
			UI.gold_rush_open_2.setEnabled(false);
 			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\gold_rush\\"+cardColor+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.gold_rush_open_2.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.gold_rush_open_2.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.gold_rush_open_2.setBorder(null);
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// target == 4 (open3)
		else if(target == 4) {
			// init button
			UI.gold_rush_open_3= new JButton(cardColor+"/"+cardName+"/"+cost) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\gold_rush\\"+cardColor+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.gold_rush_open_3.setBounds(1344,435,87,135);
			// set invisible
			UI.gold_rush_open_3.setVisible(false);
			// set border null
			UI.gold_rush_open_3.setBorder(null);
			// set Disable
			UI.gold_rush_open_3.setDisabledIcon(UI.gold_rush_open_3.getIcon());
			UI.gold_rush_open_3.setEnabled(false);
 			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\gold_rush\\"+cardColor+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.gold_rush_open_3.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// add border painting
					UI.gold_rush_open_3.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove border painting
					UI.gold_rush_open_3.setBorder(null);
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
	}
	
	// make hand & field card button (init gun card)
	public static void make_card_handField_gun_init(String userName) {
		// find seat (A)
		if(UI.player_A_name.getText().equals(userName)) {
			// init player_A_gun image
			UI.player_A_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_A_gun.setBounds(90,3,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_A_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// find seat (B)
		else if(UI.player_B_name.getText().equals(userName)) {
			// init player_B_gun image
			UI.player_B_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_B_gun.setBounds(90,3,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_B_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// find seat (C)
		else if(UI.player_C_name.getText().equals(userName)) {
			// init player_C_gun image
			UI.player_C_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87_player_C.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_C_gun.setBounds(138,90,135,87);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_C_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// find seat (D)
		else if(UI.player_D_name.getText().equals(userName)) {
			// init player_D_gun image
			UI.player_D_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87_player_DE.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_D_gun.setBounds(293,138,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_D_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// find seat (E)
		else if(UI.player_E_name.getText().equals(userName)) {
			// init player_E_gun image
			UI.player_E_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87_player_DE.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_E_gun.setBounds(293,138,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_E_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// find seat (F)
		else if(UI.player_F_name.getText().equals(userName)) {
			// init player_F_gun image
			UI.player_F_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87_player_F.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_F_gun.setBounds(3,293,135,87);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_F_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		// find seat (G)
		else if(UI.player_G_name.getText().equals(userName)) {
			// init player_G_gun image
			UI.player_G_gun = new JButton("colt-45") {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			
			// set bounds
			UI.player_G_gun.setBounds(90,3,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\colt-45_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_G_gun.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
	}
	
	// make hand & field card button (role card)
	public static void make_card_handField_role(String userName, String roleName, boolean isForward) {
		// find seat (seat is 'A')
		if(UI.player_A_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_A_role image
				UI.player_A_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_A_role image
				UI.player_A_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}

			// set bounds
			UI.player_A_role.setBounds(90,138,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_A_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();	
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_A_role.setDisabledIcon(UI.player_A_role.getIcon());
			UI.player_A_role.setEnabled(false);
		}
		
		// find seat (seat is 'B')
		else if(UI.player_B_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_B_role image
				UI.player_B_role = new JButton(roleName) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_B_role image
				UI.player_B_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			
			// set bounds
			UI.player_B_role.setBounds(90,138,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_B_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();	
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_B_role.setDisabledIcon(UI.player_B_role.getIcon());
			UI.player_B_role.setEnabled(false);
		}
		
		// find seat (seat is 'C')
		else if(UI.player_C_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_C_role image
				UI.player_C_role = new JButton(roleName) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87_player_C.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_C_role image
				UI.player_C_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87_player_C.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			
			// set bounds
			UI.player_C_role.setBounds(3,90,135,87);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_C_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();	
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_C_role.setDisabledIcon(UI.player_C_role.getIcon());
			UI.player_C_role.setEnabled(false);
		}
		
		// find seat (seat is 'D')
		else if(UI.player_D_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_D_role image
				UI.player_D_role = new JButton(roleName) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_D_role image
				UI.player_D_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			
			// set bounds
			UI.player_D_role.setBounds(293,4,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_D_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();	
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_D_role.setDisabledIcon(UI.player_D_role.getIcon());
			UI.player_D_role.setEnabled(false);
		}
		
		// find seat (seat is 'E')
		else if(UI.player_E_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_E_role image
				UI.player_E_role = new JButton(roleName) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_E_role image
				UI.player_E_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			
			// set bounds
			UI.player_E_role.setBounds(293,4,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_E_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();	
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_E_role.setDisabledIcon(UI.player_E_role.getIcon());
			UI.player_E_role.setEnabled(false);
		}
		
		// find seat (seat is 'F')
		else if(UI.player_F_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_F_role image
				UI.player_F_role = new JButton(roleName) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87_player_F.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_F_role image
				UI.player_F_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87_player_F.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			
			// set bounds
			UI.player_F_role.setBounds(138,293,135,87);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_F_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_F_role.setDisabledIcon(UI.player_F_role.getIcon());
			UI.player_F_role.setEnabled(false);
		}
		
		// find seat (seat is 'G')
		else if(UI.player_G_name.getText().equals(userName)) {
			// forward?
			if(isForward == true) {
				// init player_G_role image
				UI.player_G_role = new JButton(roleName) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// init player_G_role image
				UI.player_G_role = new JButton(roleName){
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			
			// set bounds
			UI.player_G_role.setBounds(90,138,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\role\\"+roleName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_G_role.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// isForward == true, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);
						UI.mp.repaint();
					}
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
			// set disable
			UI.player_G_role.setDisabledIcon(UI.player_G_role.getIcon());
			UI.player_G_role.setEnabled(false);
		}
	}
	
	// make hand & field card button (character card)
	public static void make_card_handField_character(String playerName, String cardPack, String cardName, int cardHp) {
		// seatLocation = player_A_character
		if(UI.player_A_name.getText().equals(playerName)) {
			// init player_A_character image
			UI.player_A_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_A_character.setBounds(3,3,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_A_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// seatLocation = player_B_character
		else if(UI.player_B_name.getText().equals(playerName)) {
			// init player_B_character image
			UI.player_B_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_B_character.setBounds(3,3,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_B_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// seatLocation = player_C_character
		else if(UI.player_C_name.getText().equals(playerName)) {
			// init player_C_character image
			UI.player_C_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_C.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_C_character.setBounds(139,3,135,87);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_C_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// seatLocation= player_D_character
		else if(UI.player_D_name.getText().equals(playerName)) {
			// init player_D_character image
			UI.player_D_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_DE.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_D_character.setBounds(380,139,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_D_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// seatLocation = player_E_character
		else if(UI.player_E_name.getText().equals(playerName)) {
			// init player_E_character image
			UI.player_E_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_DE.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_E_character.setBounds(380,139,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_E_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// seatLocation = player_F_character
		else if(UI.player_F_name.getText().equals(playerName)) {
			// init player_F_character image
			UI.player_F_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_F.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_F_character.setBounds(3,380,135,87);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_F_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// seatLocation = player_G_character
		else if(UI.player_G_name.getText().equals(playerName)) {
			// init player_G_character image
			UI.player_G_character = new JButton(cardPack+"/"+cardName+"/"+cardHp) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_G_character.setBounds(3,3,87,135);
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			UI.player_G_character.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// show details
					show.setBounds(1730,690,155,240);
					UI.mp.add(show);
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					UI.mp.repaint();
				}
			});
		}
		
		// repaint
		UI.mp.repaint();
	}
	
	// make hand & field card button (playing card)
	public static Select_button make_card_handField_playing(String id, String cardColor, String cardName, char cardShape, int cardNum, boolean isForward) {
		// temp card button
		Select_button temp_card = null;
		
		// id = player_A hand & field
		if(UI.player_A_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_87.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(87,135));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()-30, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()+30, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// id = player_B hand & field
		if(UI.player_B_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_70.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_70.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(70,108));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()-20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()+20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// id = player_C hand & field
		if(UI.player_C_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_70_player_C.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_70_player_C.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(108,70));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX()+20, this_card.getY(), this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX()-20, this_card.getY(), this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// id = player_D hand & field
		if(UI.player_D_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_70_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_70_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(70,108));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()+20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()-20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// id = player_E hand & field
		if(UI.player_E_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_70_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_70_player_DE.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(70,108));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()+20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()-20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// id = player_F hand & field
		if(UI.player_F_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_70_player_F.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_70_player_F.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(108,70));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX()-20, this_card.getY(), this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX()+20, this_card.getY(), this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// id = player_G hand & field
		if(UI.player_G_name.getText().equals(id)) {
			// forward?
			if(isForward == true) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_70.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// backward?
			else if(isForward == false) {
				// set handField card image
				temp_card = new Select_button(cardColor, cardName, cardShape, cardNum) {
					private static final long serialVersionUID = 1L;
					Image background = new ImageIcon(".\\.\\resources\\card\\playing\\back_70.png").getImage();
					// drawing background
					protected void paintComponent(Graphics g) {
						g.drawImage(background, 0, 0, null);
					}
				};
			}
			// set size
			temp_card.setPreferredSize(new Dimension(70,108));
			// set show
			JPanel show = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set mouse listener
			temp_card.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					// only card is open, show details
					if(isForward == true) {
						show.setBounds(1730,690,155,240);
						UI.mp.add(show);	
					}
					// card up
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()-20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
				public void mouseExited(MouseEvent e) {
					// remove details
					UI.mp.remove(show);
					// card down
					Select_button this_card = (Select_button)e.getComponent();
					e.getComponent().setBounds(this_card.getX(), this_card.getY()+20, this_card.getWidth(), this_card.getHeight());
					UI.mp.repaint();
				}
			});
		}
		
		// return made button
		return temp_card;
	}
	
	// make fake card for player_C_hand, player_F_hand
	public static Select_button make_card_handField_playing_fake() {
		Select_button temp_card = new Select_button() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\card\\empty_70.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set size
		temp_card.setPreferredSize(new Dimension(70,108));
		// set invisible
		temp_card.setEnabled(false);
		temp_card.setBorderPainted(false);
		temp_card.setContentAreaFilled(false);
		temp_card.setFocusPainted(false);
		temp_card.setEnabled(false);
		
		// return made button
		return temp_card;
	}
	
	// make select panel card button (character card)
	public static Select_button make_card_select_panel_character(String myName, String cardPack, String cardName, PrintWriter os, int hp) {
		// init select_panel_card image
		Select_button select_temp_card = new Select_button(cardName, hp);
		select_temp_card.setIcon(new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png"));
		
		// set click event
		select_temp_card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// no chance
				if(UI.select_chance == 0) {
					System.out.println("You already picked.");
					return;
				}
				
				// if you clicked, select_chance--, send result
				UI.select_chance--;
				os.println("game/SELECT/CHARACTER/"+myName+"/"+cardPack+"/"+cardName);
				// highlighting my choice
				select_temp_card.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
				// repaint
				UI.mp.repaint();
				App.u.setVisible(true);
			}
		});
		
		// set size
		select_temp_card.setPreferredSize(new Dimension(155,240));
		// return card
		return select_temp_card;
	}
	
	// make select panel card button (character question card)
	public static Select_button make_card_select_panel_character_question(String myName, String cardPack, String cardName, PrintWriter os, int hp) {
		// init select_panel_card image
		Select_button select_temp_card = new Select_button(cardName, hp);
		select_temp_card.setIcon(new ImageIcon(".\\.\\resources\\card\\question_155.png"));
		
		// set click event
		select_temp_card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// no chance
				if(UI.select_chance == 0) {
					System.out.println("You already picked.");
					return;
				}
				
				// if you clicked, select_chance--, send result
				UI.select_chance--;
				os.println("game/SELECT/CHARACTER/"+myName+"/"+cardPack+"/"+cardName);
				// change image
				select_temp_card.setIcon(new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_155.png"));
				// highlighting my choice
				select_temp_card.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
				// repaint
				UI.mp.repaint();
				App.u.setVisible(true);
			}
		});
		
		// set size
		select_temp_card.setPreferredSize(new Dimension(155,240));
		// set button filled false
		select_temp_card.setContentAreaFilled(false);
		// return card
		return select_temp_card;
	}
	
	// make select panel card button (role card)
	public static Select_button make_card_select_panel_role(String myName, String cardName, PrintWriter os, int cardNum) {
		// init select_panel_card image
		Select_button select_temp_card = new Select_button(cardName, cardNum);
		select_temp_card.setIcon(new ImageIcon(".\\.\\resources\\card\\role\\"+"role_back"+"_155.png"));
		
		// set click event
		select_temp_card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// no chance
				if(UI.select_chance == 0) {
					System.out.println("You already picked.");
					return;
				}
				// already picked
				if(select_temp_card.isEnabled() == false) {
					System.out.println("This card is already picked.");
					return;
				}
				
				// if you clicked, select_chance--, send result
				UI.select_chance--; 
				os.println("game/SELECT/ROLE/"+myName+"/"+cardName+"/"+cardNum);
				// change image
				select_temp_card.setIcon(new ImageIcon(".\\.\\resources\\card\\role\\"+cardName+"_155.png"));
				// highlighting my choice
				select_temp_card.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
				// repaint
				UI.mp.repaint();
				App.u.setVisible(true);
			}
		});
		
		// set size
		select_temp_card.setPreferredSize(new Dimension(155,240));
		// return button
		return select_temp_card;
	}
	
	// make select panel card button (last scenario card)
	public static Select_button make_card_select_panel_last_scenario(String extension, String cardName, PrintWriter os, int cardNum) {
		// init select_panel_card image
		Select_button select_temp_card = new Select_button(cardName, cardNum);
		select_temp_card.setIcon(new ImageIcon(".\\.\\resources\\card\\scenario\\"+extension+"\\"+cardName+"_155.png"));
		
		// set click event
		select_temp_card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// no change
				if(UI.select_chance == 0) {
					System.out.println("You already picked.");
					return;
				}
				
				// if you clicked, select_chance--, send result
				UI.select_chance--;
				os.println("game/SELECT/LAST_SCENARIO/"+cardNum);
				// highlighting my choice
				select_temp_card.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
				// repaint
				UI.mp.repaint();
				App.u.setVisible(true);
			}
		});
		
		// set size
		select_temp_card.setPreferredSize(new Dimension(155,240));
		// return button
		return select_temp_card;
	}
	
	// make select panel card button (playing card)
	public static JButton make_card_select_panel_playing(String cardColor, String cardName, char cardShape, char cardNum) {
		// init select_panel_card image
		JButton select_temp_card = new JButton(cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum){
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_155.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set size
		select_temp_card.setPreferredSize(new Dimension(155,240));
		// return card
		return select_temp_card;
	}
	
}
