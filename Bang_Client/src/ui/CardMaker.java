// card button maker

package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import client.App;

public class CardMaker {
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
			// set disable
			UI.player_G_role.setDisabledIcon(UI.player_G_role.getIcon());
			UI.player_G_role.setEnabled(false);
		}
	}
	
	// make hand & field card button (character card)
	public static void make_card_handField_character(String playerName, String cardPack, String cardName) {
		// seatLocation = player_A_character
		if(UI.player_A_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_A_character = new JButton(cardPack+"/"+cardName){
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_A_character.setBounds(3,3,87,135);
		}
		
		// seatLocation = player_B_character
		else if(UI.player_B_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_B_character = new JButton(cardPack+"/"+cardName) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_B_character.setBounds(3,3,87,135);
		}
		
		// seatLocation = player_C_character
		else if(UI.player_C_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_C_character = new JButton(cardPack+"/"+cardName) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_C.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_C_character.setBounds(139,3,135,87);
		}
		
		// seatLocation= player_D_character
		else if(UI.player_D_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_D_character = new JButton(cardPack+"/"+cardName) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_DE.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_D_character.setBounds(380,139,87,135);
		}
		
		// seatLocation = player_E_character
		else if(UI.player_E_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_E_character = new JButton(cardPack+"/"+cardName) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_DE.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_E_character.setBounds(380,139,87,135);
		}
		
		// seatLocation = player_F_character
		else if(UI.player_F_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_F_character = new JButton(cardPack+"/"+cardName) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87_player_F.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_F_character.setBounds(3,380,135,87);
		}
		
		// seatLocation = player_G_character
		else if(UI.player_G_name.getText().equals(playerName)) {
			// init select_panel_card image
			UI.player_G_character = new JButton(cardPack+"/"+cardName) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\character\\"+cardPack+"\\"+cardName+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set bounds
			UI.player_G_character.setBounds(3,3,87,135);
		}
	}
	
	// make hand & field card button (playing card)
	public static JButton make_card_handField_playing(char seatLocation, String cardColor, String cardName, char cardShape, char cardNum) {
		// temp card button
		JButton temp_card = null;
		
		// seatLocation = player_A hand & field
		if(seatLocation == 'A') {
			// set handField card image
			temp_card = new JButton(cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set size
			temp_card.setPreferredSize(new Dimension(87,135));
		}
		
		// seatLocation = player_B field
		else if(seatLocation == 'B') {
			// set field card image
			temp_card = new JButton(cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set size
			temp_card.setPreferredSize(new Dimension(87,135));
		}
		
		// seatLocation = player_C field
		else if(seatLocation == 'C') {
			// set field card image
			temp_card = new JButton(cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87_player_C.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set size
			temp_card.setPreferredSize(new Dimension(135,87));
		}
		
		
		
		
		
		
		
		// seatLocation = player_G field
		else if(seatLocation == 'G') {
			// set field card image
			temp_card = new JButton(cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum) {
				private static final long serialVersionUID = 1L;
				Image background = new ImageIcon(".\\.\\resources\\card\\playing\\"+cardColor+"\\"+cardName+"_"+cardShape+"_"+cardNum+"_87.png").getImage();
				// drawing background
				protected void paintComponent(Graphics g) {
					g.drawImage(background, 0, 0, null);
				}
			};
			// set size
			temp_card.setPreferredSize(new Dimension(87,135));
		}
		
		// return maked button
		return temp_card;
	}
	
	// make select panel card button (character card)
	public static Select_button make_card_select_panel_character(String myName, String cardPack, String cardName, PrintWriter os, int hp) {
		// init select_panel_card image
		Select_button select_temp_card = new Select_button(cardName+"/"+hp);
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
		Select_button select_temp_card = new Select_button(cardName+"/"+hp);
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
		Select_button select_temp_card = new Select_button(cardName+"/"+cardNum);
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
		Select_button select_temp_card = new Select_button(cardName+"/"+cardNum);
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
