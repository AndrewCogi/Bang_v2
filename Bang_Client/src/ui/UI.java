package ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI {
	// output stream
	private PrintWriter os;
	// user name
	private String userName;
	// main frame
	public static JFrame mf;
	// main panel
	public static JPanel mp;
	// notice label (top)
	public static JLabel notice_top;
	// notice label (middle)
	public static JLabel notice_middle;
	// player seat (A~G)
	public static JPanel player_A; // me
	public static JPanel player_B; // bottom-left
	public static JPanel player_C; // middle-left
	public static JPanel player_D; // top-left
	public static JPanel player_E; // top-right
	public static JPanel player_F; // middle-right
	public static JPanel player_G; // bottom-right
	// playerNames in each seat
	public static JLabel player_A_name;
	public static JLabel player_B_name;
	public static JLabel player_C_name;
	public static JLabel player_D_name;
	public static JLabel player_E_name;
	public static JLabel player_F_name;
	public static JLabel player_G_name;
	// playerCharacter in each seat
	public static JButton player_A_character;
	public static JButton player_B_character;
	public static JButton player_C_character;
	public static JButton player_D_character;
	public static JButton player_E_character;
	public static JButton player_F_character;
	public static JButton player_G_character;
	// playerRole in each seat
	public static JButton player_A_role;
	public static JButton player_B_role;
	public static JButton player_C_role;
	public static JButton player_D_role;
	public static JButton player_E_role;
	public static JButton player_F_role;
	public static JButton player_G_role;
	// playerGun in each seat
	public static JButton player_A_gun;
	public static JButton player_B_gun;
	public static JButton player_C_gun;
	public static JButton player_D_gun;
	public static JButton player_E_gun;
	public static JButton player_F_gun;
	public static JButton player_G_gun;
	// playerHp (text) in each seat
	public static JLabel player_A_hp_text;
	public static JLabel player_B_hp_text;
	public static JLabel player_C_hp_text;
	public static JLabel player_D_hp_text;
	public static JLabel player_E_hp_text;
	public static JLabel player_F_hp_text;
	public static JLabel player_G_hp_text;
	// playerHp (icon) in each seat
	public static JButton player_A_hp_icon;
	public static JButton player_B_hp_icon;
	public static JButton player_C_hp_icon;
	public static JButton player_D_hp_icon;
	public static JButton player_E_hp_icon;
	public static JButton player_F_hp_icon;
	public static JButton player_G_hp_icon;
	// playerGold (text) in each seat
	public static JLabel player_A_gold_text;
	public static JLabel player_B_gold_text;
	public static JLabel player_C_gold_text;
	public static JLabel player_D_gold_text;
	public static JLabel player_E_gold_text;
	public static JLabel player_F_gold_text;
	public static JLabel player_G_gold_text;
	// playerGold (icon) in each seat
	public static JButton player_A_gold_icon;
	public static JButton player_B_gold_icon;
	public static JButton player_C_gold_icon;
	public static JButton player_D_gold_icon;
	public static JButton player_E_gold_icon;
	public static JButton player_F_gold_icon;
	public static JButton player_G_gold_icon;
	// playerHand in each seat
	public static JPanel player_A_hand;
	public static JPanel player_B_hand;
	public static JPanel player_C_hand;
	public static JPanel player_D_hand;
	public static JPanel player_E_hand;
	public static JPanel player_F_hand;
	public static JPanel player_G_hand;
	// player field in each seat
	public static JPanel player_A_field;
	public static JPanel player_B_field;
	public static JPanel player_C_field;
	public static JPanel player_D_field;
	public static JPanel player_E_field;
	public static JPanel player_F_field;
	public static JPanel player_G_field;
	// scenario(turn/wildWest)
	public static JButton scenario_turn_back;
	public static JButton scenario_turn_front;
	public static JButton scenario_wild_back;
	public static JButton scenario_wild_front;
	// scenario notice (next,now)
	public static JLabel scenario_turn_next;
	public static JLabel scenario_turn_now;
	// gold rush button (1: new, 2~4: opened)
	public static JButton gold_rush_new;
	public static JButton gold_rush_open_1;
	public static JButton gold_rush_open_2;
	public static JButton gold_rush_open_3;
	// main deck (playing card) (new, old)
	public static JButton main_deck_new;
	public static JButton main_deck_old;
	// character multi button
	public static JButton player_multi_button;
	// select panel (role)
	public static JPanel select_panel_role;
	// select panel (character)
	public static JPanel select_panel_character;
	// select panel (scenario)
	public static JPanel select_panel_scenario;
	// show detail (text)
	public static JLabel show_detail_label;
	// show detail (image)
	public static JPanel show_detail_panel;
	// game ready button
	public static JButton game_ready_button;
	// select remain
	public static int select_chance = 0;
	
	// card use checker (phase2 card use)
	// 2페이즈 카드사용가능 확인변수
	private static boolean cardUse2 = false;
	// card use checker (phase3 card use)
	// 3페이즈 카드사용가능 확인변수
	private static boolean cardUse3 = false;
	// set target card (ex: you shoot bang! someone)
	// 타겟을 설정할 수 있도록 허용해주는 변수 (예: 뱅! 을 쓰고 사용할 타겟을 고를 때 true)
	private static boolean setTarget = false;
	// you attacked someone (ex: you get bang! someone, you can use missed!..)
	// 누군가에게 공격을 당했을 때 카드가용가능 확인변수 (뱅! 관련 공격은 제외함. 자동처리됨.) (예: 결투, 인디언 등을 받았을 때 true)
	private static boolean attacked = false;
	// command string (which card you use with target)
	// [?]에게 어떠한 카드가 사용가능한지 체크해주는 변수들 (예: 뱅! 사정거리 안 변수:"bang" / 밖 변수:"")
	// "" = can't use, {A,B,C,D,E,F,G}
	public static String[] targetCommand = new String[]{"","","","","","",""};
	// command string (which card you attacked)
	// 누군가에게 어떠한 공격을 받았는지 저장해두는 변수 (예: 뱅!:"bang", 강탈!:"panico")
	public static String attackedCommand = ""; // TODO
	// mancato reservation counting
	// 빗나감, 회피, 철판 등 예약해놓는 배열
	public static List<String> mancatoRev = new LinkedList<>();
	// how many card you must discard
	public static int discardNum = 0;
	// check send (i'm dead!) message / false = not dead, true = dead!
	public static boolean deadACK = false;
	// how many <Bang!> you can use
	public static int useBangCount = 1;
	// check you already use <bang!>
	public static boolean useBang = false;
	
	public UI(String userName, PrintWriter os) {
		// init variables
		this.userName = userName;
		this.os = os;
		// init main frame & main panel
		init_main(userName);
		// init notices
		init_notices();
		// init seats
		init_seats();
		// init select panel
		init_select_panel_role();
		init_select_panel_character();
		init_select_panel_scenario();
		// init scenario_notice
		init_scenario_notice();
		// init player multi button
		init_player_multi_button();
		// init character hp & gold icon
		init_character_hp_gold_icon();
		// init character hp & gold text
		init_character_hp_gold_text();
		// init players' hand panel
		init_hand_panel();
		// init show detail label
		init_show_detail_label();
		// init show detail panel
		init_show_detail_panel();
		// init player field panel
		init_player_field_panel();
		// init game ready button
		init_game_ready_button();
		
		// test function TODO
		// test_func();
	}
	
	// init game ready button
	private void init_game_ready_button() {
		// init
		game_ready_button = new JButton("Ready?");
		// set background color
		game_ready_button.setBackground(Color.GRAY);
		// add mouse listener
		game_ready_button.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
					// if ready on, set color, set text, send ready on
					if(((JButton)e.getComponent()).getText().equals("Ready?")) {
						((JButton)e.getComponent()).setBackground(Color.GREEN);
						((JButton)e.getComponent()).setText("Ready!");
						os.println("game/READYBUTTON/ON/"+userName);
					}
					// if ready off, set color, send ready off
					else if(((JButton)e.getComponent()).getText().equals("Ready!")) {
						((JButton)e.getComponent()).setBackground(Color.GRAY);
						((JButton)e.getComponent()).setText("Ready?");
						os.println("game/READYBUTTON/OFF/"+userName);
					}
			}
		});
		// set bounds
		game_ready_button.setBounds(mf.getWidth()/2-50,mf.getHeight()/2+100,100,50);
		// set invisible
		game_ready_button.setVisible(false);
		// add into main panel
		mp.add(game_ready_button);
	}
	
	// init player field panel
	private void init_player_field_panel() {
		// init fields
		player_A_field = new JPanel();
		player_B_field = new JPanel();
		player_C_field = new JPanel();
		player_D_field = new JPanel();
		player_E_field = new JPanel();
		player_F_field = new JPanel();
		player_G_field = new JPanel();
		// set background empty
		player_A_field.setBackground(new Color(0,0,0,0));
		player_B_field.setBackground(new Color(0,0,0,0));
		player_C_field.setBackground(new Color(0,0,0,0));
		player_D_field.setBackground(new Color(0,0,0,0));
		player_E_field.setBackground(new Color(0,0,0,0));
		player_F_field.setBackground(new Color(0,0,0,0));
		player_G_field.setBackground(new Color(0,0,0,0));
		// set bounds
		player_A_field.setBounds(180,3,287,270);
		player_B_field.setBounds(180,3,287,270);
		player_C_field.setBounds(3,180,270,287);
		player_D_field.setBounds(3,3,287,270);
		player_E_field.setBounds(3,3,287,270);
		player_F_field.setBounds(3,3,270,287);
		player_G_field.setBounds(180,3,287,270);
		// set layout null
		player_A_field.setLayout(null);
		player_B_field.setLayout(null);
		player_C_field.setLayout(null);
		player_D_field.setLayout(null);
		player_E_field.setLayout(null);
		player_F_field.setLayout(null);
		player_G_field.setLayout(null);
		// add fields into each seat
		player_A.add(player_A_field);
		player_B.add(player_B_field);
		player_C.add(player_C_field);
		player_D.add(player_D_field);
		player_E.add(player_E_field);
		player_F.add(player_F_field);
		player_G.add(player_G_field);
	}
	
	// init show detail panel
	private void init_show_detail_panel() {
		show_detail_panel = new JPanel();
		show_detail_panel.setBounds(1730,670,155,250);
		show_detail_panel.setBackground(new Color(0,0,0,0));
		mp.add(show_detail_panel);
	}
	
	// init show detail label
	private void init_show_detail_label() {
		show_detail_label = new JLabel();
		show_detail_label.setFont(new Font(null,1,16));
		show_detail_label.setForeground(Color.WHITE);
		show_detail_label.setVerticalAlignment(JLabel.CENTER);
		show_detail_label.setBounds(1730,630,155,300);
		mp.add(show_detail_label);
	}
	
	// init main frame & main panel
	private void init_main(String userName) {
		// set title
		mf = new JFrame("Bang! - Board Game ("+userName+")");
		// set close operation
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set main icon
		mf.setIconImage(new ImageIcon(".\\.\\resources\\icon\\bang_org.png").getImage());
		// set screen size
		mf.setSize(1920,1040);
		// set resize false
		// mf.setResizable(false);
		// if mouse moved, repaint
		mf.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mf.repaint();
			}
		});
		
		// set main panel
		mp = new JPanel(){
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\main\\background_sample1.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set no layout
		mp.setLayout(null);
		// set custom cursor
		mp.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(".\\.\\resources\\cursor\\main_panel_cursor.png").getImage(),
				new Point(0,0),"custom cursor"));
		// add main panel into main frame
		mf.setContentPane(mp);
	}
	
	// init notices label properties
	private void init_notices() {
		// top
		// set notice label
		notice_top = new JLabel();
		// set font
		notice_top.setFont(new Font("Serif",1,50));
		// set text color
		notice_top.setForeground(Color.BLACK);
		// set bound
		notice_top.setBounds(460,170,1000,100);
		// set text center
		notice_top.setHorizontalAlignment(SwingConstants.CENTER);
		
		// middle
		// set notice label
		notice_middle = new JLabel();
		// set font
		notice_middle.setFont(new Font("Serif",1,50));
		// set text color
		notice_middle.setForeground(Color.BLACK);
		// set bound
		notice_middle.setBounds(460,440,1000,100);
		// set text center
		notice_middle.setHorizontalAlignment(SwingConstants.CENTER);
		
		// set notice available (middle) -> That is default
		Setter.setNoticeAvailable(2,true);
	}
	
	// init seats things
	private void init_seats() {
		// seats image
		init_seats_image();
		// player name label
		init_playerName();
	}
	
	// init hand panel
	private void init_hand_panel() {
		// init panel (A)
		player_A_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_A_hand.setBounds(678,830,560,170);
		// set layout
		player_A_hand.setLayout(new FlowLayout(FlowLayout.CENTER, -40, 30));
		
		// init panel (B)
		player_B_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand_player_BDEG.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_B_hand.setBounds(205,868,470,133);
		// set layout
		player_B_hand.setLayout(new FlowLayout(FlowLayout.CENTER, -40, 20));
		
		// init panel (C)
		player_C_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand_player_CF.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_C_hand.setBounds(0,130,150,470);
		// set layout
		player_C_hand.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -40));
		// set add a fake card
		player_C_hand.add(CardMaker.make_card_handField_playing_fake());
		
		// init panel (D)
		player_D_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand_player_BDEG.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_D_hand.setBounds(440,0,470,133);
		// set layout
		player_D_hand.setLayout(new FlowLayout(FlowLayout.CENTER, -40, 0));
		
		// init panel (E)
		player_E_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand_player_BDEG.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_E_hand.setBounds(995,0,470,133);
		// set layout
		player_E_hand.setLayout(new FlowLayout(FlowLayout.CENTER, -40, 0));
		
		// init panel (F)
		player_F_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand_player_CF.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_F_hand.setBounds(1755,130,150,470);
		// set layout
		player_F_hand.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -40));
		// set add a fake card
		player_F_hand.add(CardMaker.make_card_handField_playing_fake());
		
		// init panel (G)
		player_G_hand = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\hand\\background_hand_player_BDEG.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bounds
		player_G_hand.setBounds(1240,868,470,133);
		// set layout
		player_G_hand.setLayout(new FlowLayout(FlowLayout.CENTER, -40, 20));
	}
	
	// init character hp & gold icon
	private void init_character_hp_gold_icon() {
		// init buttons
		player_A_hp_icon = new JButton();
		player_B_hp_icon = new JButton();
		player_C_hp_icon = new JButton();
		player_D_hp_icon = new JButton();
		player_E_hp_icon = new JButton();
		player_F_hp_icon = new JButton();
		player_G_hp_icon = new JButton();
		player_A_gold_icon = new JButton();
		player_B_gold_icon = new JButton();
		player_C_gold_icon = new JButton();
		player_D_gold_icon = new JButton();
		player_E_gold_icon = new JButton();
		player_F_gold_icon = new JButton();
		player_G_gold_icon = new JButton();
		// set bounds
		player_A_hp_icon.setBounds(15,200,30,30);
		player_B_hp_icon.setBounds(15,165,30,30);
		player_C_hp_icon.setBounds(40,10,30,30);
		player_D_hp_icon.setBounds(390,25,30,30);
		player_E_hp_icon.setBounds(390,25,30,30);
		player_F_hp_icon.setBounds(170,385,30,30);
		player_G_hp_icon.setBounds(15,165,30,30);
		player_A_gold_icon.setBounds(15,240,30,30);
		player_B_gold_icon.setBounds(15,220,30,30);
		player_C_gold_icon.setBounds(40,55,30,30);
		player_D_gold_icon.setBounds(390,80,30,30);
		player_E_gold_icon.setBounds(390,80,30,30);
		player_F_gold_icon.setBounds(170,430,30,30);
		player_G_gold_icon.setBounds(15,220,30,30);
		// set button fill false
		player_A_hp_icon.setContentAreaFilled(false);
		player_B_hp_icon.setContentAreaFilled(false);
		player_C_hp_icon.setContentAreaFilled(false);
		player_D_hp_icon.setContentAreaFilled(false);
		player_E_hp_icon.setContentAreaFilled(false);
		player_F_hp_icon.setContentAreaFilled(false);
		player_G_hp_icon.setContentAreaFilled(false);
		player_A_gold_icon.setContentAreaFilled(false);
		player_B_gold_icon.setContentAreaFilled(false);
		player_C_gold_icon.setContentAreaFilled(false);
		player_D_gold_icon.setContentAreaFilled(false);
		player_E_gold_icon.setContentAreaFilled(false);
		player_F_gold_icon.setContentAreaFilled(false);
		player_G_gold_icon.setContentAreaFilled(false);
		// set focus painted false
		player_A_hp_icon.setFocusPainted(false);
		player_B_hp_icon.setFocusPainted(false);
		player_C_hp_icon.setFocusPainted(false);
		player_D_hp_icon.setFocusPainted(false);
		player_E_hp_icon.setFocusPainted(false);
		player_F_hp_icon.setFocusPainted(false);
		player_G_hp_icon.setFocusPainted(false);
		player_A_gold_icon.setFocusPainted(false);
		player_B_gold_icon.setFocusPainted(false);
		player_C_gold_icon.setFocusPainted(false);
		player_D_gold_icon.setFocusPainted(false);
		player_E_gold_icon.setFocusPainted(false);
		player_F_gold_icon.setFocusPainted(false);
		player_G_gold_icon.setFocusPainted(false);
		// set border painted false
		player_A_hp_icon.setBorderPainted(false);
		player_B_hp_icon.setBorderPainted(false);
		player_C_hp_icon.setBorderPainted(false);
		player_D_hp_icon.setBorderPainted(false);
		player_E_hp_icon.setBorderPainted(false);
		player_F_hp_icon.setBorderPainted(false);
		player_G_hp_icon.setBorderPainted(false);
		player_A_gold_icon.setBorderPainted(false);
		player_B_gold_icon.setBorderPainted(false);
		player_C_gold_icon.setBorderPainted(false);
		player_D_gold_icon.setBorderPainted(false);
		player_E_gold_icon.setBorderPainted(false);
		player_F_gold_icon.setBorderPainted(false);
		player_G_gold_icon.setBorderPainted(false);
		// set image icon
		player_A_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_B_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_C_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_D_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_E_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_F_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_G_hp_icon.setIcon(new ImageIcon(".\\.\\resources\\hp.png"));
		player_A_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		player_B_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		player_C_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		player_D_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		player_E_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		player_F_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		player_G_gold_icon.setIcon(new ImageIcon(".\\.\\resources\\gold.png"));
		// set invisible
		player_A_hp_icon.setVisible(false);
		player_B_hp_icon.setVisible(false);
		player_C_hp_icon.setVisible(false);
		player_D_hp_icon.setVisible(false);
		player_E_hp_icon.setVisible(false);
		player_F_hp_icon.setVisible(false);
		player_G_hp_icon.setVisible(false);
		player_A_gold_icon.setVisible(false);
		player_B_gold_icon.setVisible(false);
		player_C_gold_icon.setVisible(false);
		player_D_gold_icon.setVisible(false);
		player_E_gold_icon.setVisible(false);
		player_F_gold_icon.setVisible(false);
		player_G_gold_icon.setVisible(false);
	}
	
	// init character hp & gold text
	private void init_character_hp_gold_text() {
		// init labels
		player_A_hp_text = new JLabel();
		player_B_hp_text = new JLabel();
		player_C_hp_text = new JLabel();
		player_D_hp_text = new JLabel();
		player_E_hp_text = new JLabel();
		player_F_hp_text = new JLabel();
		player_G_hp_text = new JLabel();
		player_A_gold_text = new JLabel();
		player_B_gold_text = new JLabel();
		player_C_gold_text = new JLabel();
		player_D_gold_text = new JLabel();
		player_E_gold_text = new JLabel();
		player_F_gold_text = new JLabel();
		player_G_gold_text = new JLabel();
		// set bounds
		player_A_hp_text.setBounds(48,200,50,30);
		player_B_hp_text.setBounds(48,165,50,30);
		player_C_hp_text.setBounds(75,10,50,30);
		player_D_hp_text.setBounds(425,25,50,30);
		player_E_hp_text.setBounds(425,25,50,30);
		player_F_hp_text.setBounds(205,385,50,30);
		player_G_hp_text.setBounds(48,165,50,30);
		player_A_gold_text.setBounds(48,240,50,30);
		player_B_gold_text.setBounds(48,220,50,30);
		player_C_gold_text.setBounds(75,55,50,30);
		player_D_gold_text.setBounds(425,80,50,30);
		player_E_gold_text.setBounds(425,80,50,30);
		player_F_gold_text.setBounds(205,430,50,30);
		player_G_gold_text.setBounds(48,220,50,30);
		// set font
		player_A_hp_text.setFont(new Font("Serif",1,20));
		player_B_hp_text.setFont(new Font("Serif",1,20));
		player_C_hp_text.setFont(new Font("Serif",1,20));
		player_D_hp_text.setFont(new Font("Serif",1,20));
		player_E_hp_text.setFont(new Font("Serif",1,20));
		player_F_hp_text.setFont(new Font("Serif",1,20));
		player_G_hp_text.setFont(new Font("Serif",1,20));
		player_A_gold_text.setFont(new Font("Serif",1,20));
		player_B_gold_text.setFont(new Font("Serif",1,20));
		player_C_gold_text.setFont(new Font("Serif",1,20));
		player_D_gold_text.setFont(new Font("Serif",1,20));
		player_E_gold_text.setFont(new Font("Serif",1,20));
		player_F_gold_text.setFont(new Font("Serif",1,20));
		player_G_gold_text.setFont(new Font("Serif",1,20));
		// set color
		player_A_hp_text.setForeground(Color.WHITE);
		player_B_hp_text.setForeground(Color.WHITE);
		player_C_hp_text.setForeground(Color.WHITE);
		player_D_hp_text.setForeground(Color.WHITE);
		player_E_hp_text.setForeground(Color.WHITE);
		player_F_hp_text.setForeground(Color.WHITE);
		player_G_hp_text.setForeground(Color.WHITE);
		player_A_gold_text.setForeground(Color.WHITE);
		player_B_gold_text.setForeground(Color.WHITE);
		player_C_gold_text.setForeground(Color.WHITE);
		player_D_gold_text.setForeground(Color.WHITE);
		player_E_gold_text.setForeground(Color.WHITE);
		player_F_gold_text.setForeground(Color.WHITE);
		player_G_gold_text.setForeground(Color.WHITE);
		// set invisible
		player_A_hp_text.setVisible(false);
		player_B_hp_text.setVisible(false);
		player_C_hp_text.setVisible(false);
		player_D_hp_text.setVisible(false);
		player_E_hp_text.setVisible(false);
		player_F_hp_text.setVisible(false);
		player_G_hp_text.setVisible(false);
		player_A_gold_text.setVisible(false);
		player_B_gold_text.setVisible(false);
		player_C_gold_text.setVisible(false);
		player_D_gold_text.setVisible(false);
		player_E_gold_text.setVisible(false);
		player_F_gold_text.setVisible(false);
		player_G_gold_text.setVisible(false);
	}
	
	// init player multi button
	private void init_player_multi_button() {
		// init button
		player_multi_button = new JButton();
		// set bounds
		player_multi_button.setBounds(3,138,87,50);
		// set visible = false
		player_multi_button.setVisible(false);
		// set enable = false
		player_multi_button.setEnabled(false);
		// add mouse listener
		player_multi_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// is enabled, do it
				if(player_multi_button.isEnabled() == true) {
					// if phase2 == true
					if(getCardUse2() == true) {
						os.println("game/ENDPHASE/"+userName+"/"+2);
						Setter.setPlayerButtonAvailable(false);
						
						// lock phase2 card use
						setCardUse2(false);
						// disable phase2 end button
						Setter.setPlayerButtonAvailable(false);
					}
					// if phase3 == true
					else if(getCardUse3() == true) {
						os.println("game/ENDPHASE/"+userName+"/"+3);
						Setter.setPlayerButtonAvailable(false);
						
						// lock phase3 card use
						UI.setCardUse3(false);
						// init discardNum = 0
						UI.discardNum = 0;
						// disable phase3 end button
						Setter.setPlayerButtonAvailable(false);
					}
				}
			}
		});
	}
	
	// init scenario notice
	private void init_scenario_notice() {
		// init
		scenario_turn_next = new JLabel("Next(+12)");
		scenario_turn_now = new JLabel("Now");
		// set font
		scenario_turn_next.setFont(new Font("Serif",1,25));
		scenario_turn_now.setFont(new Font("Serif",1,25));
		// set text color
		scenario_turn_next.setForeground(Color.WHITE);
		scenario_turn_now.setForeground(Color.WHITE);
		// set bound
		scenario_turn_next.setBounds(439,395,130,50);
		scenario_turn_now.setBounds(545,395,100,50);
		// set text center
		scenario_turn_next.setHorizontalAlignment(SwingConstants.CENTER);
		scenario_turn_now.setHorizontalAlignment(SwingConstants.CENTER);
		// set invisible
		scenario_turn_next.setVisible(false);
		scenario_turn_now.setVisible(false);
	}
	
	// init select role panel
	private void init_select_panel_role() {
		// set select_panel image
		select_panel_role = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\select_panel\\background_select_panel_role.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		select_panel_role.setBounds(300,180,1300,553);
		// set border
		// select_panel_role.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout (flow layout) & align center & hgap & vgap
		select_panel_role.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 284));
		// add select_panel into main_panel
		mp.add(select_panel_role);
		// disable select_panel
		select_panel_role.setVisible(false);
	}
	
	// init select character panel
	private void init_select_panel_character() {
		// set select_panel_character image
		select_panel_character = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\select_panel\\background_select_panel_character.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		select_panel_character.setBounds(451,93,1002,753);
		// set border
		// select_panel_character.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout (flow layout) & align center & hgap & vgap
		select_panel_character.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 284));
		// add select_panel_character into main_panel
		mp.add(select_panel_character);
		// disable select_panel_character
		select_panel_character.setVisible(false);
	}
	
	// init select scenario panel
	private void init_select_panel_scenario() {
		// set select_panel image
		select_panel_scenario = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\select_panel\\background_select_panel_scenario.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		select_panel_scenario.setBounds(300,180,1300,553);
		// set border
		// select_panel_scenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout (flow layout) & align center & hgap & vgap
		select_panel_scenario.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 284));
		// add select_panel into main_panel
		mp.add(select_panel_scenario);
		// disable select_panel
		select_panel_scenario.setVisible(false);
	}
	
	
	// init seats image
	private void init_seats_image() {
		// set player_A image(me)
		player_A = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_A.setBounds(722,585,470,277);
		// set border
		// player_A.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_A.setLayout(null);
		
		// set player_B image(bottom-left)
		player_B = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_B.setBounds(205,615,470,277);
		// set border
		// player_B.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_B.setLayout(null);
		
		// set player_C image(middle-left)
		player_C = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player_C.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_C.setBounds(150,130,277,470);
		// set border
		// player_C.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_C.setLayout(null);

		// set player_D image(top-left)
		player_D = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player_DE.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_D.setBounds(440,120,470,277);
		// set border
		// player_D.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_D.setLayout(null);

		// set player_E image(top-right)
		player_E = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player_DE.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_E.setBounds(995,120,470,277);
		// set border
		// player_E.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_E.setLayout(null);
		
		// set player_F image(middle-right)
		player_F = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player_F.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_F.setBounds(1480,130,277,470);
		// set border
		// player_F.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_F.setLayout(null);
		
		// set player_G image(bottom-right)
		player_G = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\player\\background_player.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_G.setBounds(1240,615,470,277);
		// set border
		// player_G.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_G.setLayout(null);
	}
	
	private void init_playerName() {
		// set playerName_A label
		player_A_name = new JLabel();
		// set font
		player_A_name.setFont(new Font("Serif",1,25));
		// set text color
		player_A_name.setForeground(Color.WHITE);
		// set bound
		player_A_name.setBounds(808,690,300,50);
		// set text align center
		player_A_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_A_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_B label
		player_B_name = new JLabel();
		// set font
		player_B_name.setFont(new Font("Serif",1,25));
		// set text color
		player_B_name.setForeground(Color.WHITE);
		// set bound
		player_B_name.setBounds(290,725,300,50);
		// set text align center
		player_B_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_B_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_C label
		player_C_name = new JLabel();
		// set font
		player_C_name.setFont(new Font("Serif",1,25));
		// set text color
		player_C_name.setForeground(Color.WHITE);
		// set bound
		player_C_name.setBounds(135,340,300,50);
		// set text align center
		player_C_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_C_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_D label
		player_D_name = new JLabel();
		// set font
		player_D_name.setFont(new Font("Serif",1,25));
		// set text color
		player_D_name.setForeground(Color.WHITE);
		// set bound
		player_D_name.setBounds(525,230,300,50);
		// set text align center
		player_D_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_D_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_E label
		player_E_name = new JLabel();
		// set font
		player_E_name.setFont(new Font("Serif",1,25));
		// set text color
		player_E_name.setForeground(Color.WHITE);
		// set bound
		player_E_name.setBounds(1080,230,300,50);
		// set text align center
		player_E_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_E_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_F label
		player_F_name = new JLabel();
		// set font
		player_F_name.setFont(new Font("Serif",1,25));
		// set text color
		player_F_name.setForeground(Color.WHITE);
		// set bound
		player_F_name.setBounds(1465,340,300,50);
		// set text align center
		player_F_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_F_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_G label
		player_G_name = new JLabel();
		// set font
		player_G_name.setFont(new Font("Serif",1,25));
		// set text color
		player_G_name.setForeground(Color.WHITE);
		// set bound
		player_G_name.setBounds(1325,725,300,50);
		// set text align center
		player_G_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_G_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	// set visible
	public void setVisible(boolean b) {
		mf.setVisible(b);
	}
	
	// test function
	private void test_func() {
		// test (show players panels)
		mp.add(player_A);
		mp.add(player_B);
		mp.add(player_C);
		mp.add(player_D);
		mp.add(player_E);
		mp.add(player_F);
		mp.add(player_G);
		mp.repaint();
		// test (이름넣어주기)
		player_A_name.setText("A");
		player_B_name.setText("B");
		player_C_name.setText("C");
		player_D_name.setText("D");
		player_E_name.setText("E");
		player_F_name.setText("F");
		player_G_name.setText("G");
		
		// test (체력 및 골드 이미지, 텍스트 확인)
		Setter.setPlayerHpText("A", 1, false);
		Setter.setPlayerHpText("B", 2, false);
		Setter.setPlayerHpText("C", 3, false);
		Setter.setPlayerHpText("D", 4, false);
		Setter.setPlayerHpText("E", 5, false);
		Setter.setPlayerHpText("F", 6, false);
		Setter.setPlayerHpText("G", 7, false);
		Setter.setPlayerHpImageAvailable(true);
		Setter.setPlayerHpTextAvailable(true);
		Setter.setPlayerGoldText("A", 1);
		Setter.setPlayerGoldText("B", 2);
		Setter.setPlayerGoldText("C", 3);
		Setter.setPlayerGoldText("D", 4);
		Setter.setPlayerGoldText("E", 5);
		Setter.setPlayerGoldText("F", 6);
		Setter.setPlayerGoldText("G", 7);
		Setter.setPlayerGoldImageAvailable(true);
		Setter.setPlayerGoldTextAvailable(true);
	
		// test (직업 선택 완료)
		CardMaker.make_card_handField_role(player_A_name.getText(), "fuorilegge", true, true);
		CardMaker.make_card_handField_role(player_B_name.getText(), "fuorilegge", true, true);
		CardMaker.make_card_handField_role(player_C_name.getText(), "fuorilegge", true, true);
		CardMaker.make_card_handField_role(player_D_name.getText(), "fuorilegge", true, true);
		CardMaker.make_card_handField_role(player_E_name.getText(), "fuorilegge", true, true);
		CardMaker.make_card_handField_role(player_F_name.getText(), "fuorilegge", true, true);
		CardMaker.make_card_handField_role(player_G_name.getText(), "fuorilegge", true, true);
		// test (직업 이미지 보이게)
		Setter.setPlayerRoleImageAvailable(player_A_name.getText(), true);
		Setter.setPlayerRoleImageAvailable(player_B_name.getText(), true);
		Setter.setPlayerRoleImageAvailable(player_C_name.getText(), true);
		Setter.setPlayerRoleImageAvailable(player_D_name.getText(), true);
		Setter.setPlayerRoleImageAvailable(player_E_name.getText(), true);
		Setter.setPlayerRoleImageAvailable(player_F_name.getText(), true);
		Setter.setPlayerRoleImageAvailable(player_G_name.getText(), true);
		
		// test (기본 총 세팅)
		CardMaker.make_card_field_gun_init(player_A_name.getText());
		CardMaker.make_card_field_gun_init(player_B_name.getText());
		CardMaker.make_card_field_gun_init(player_C_name.getText());
		CardMaker.make_card_field_gun_init(player_D_name.getText());
		CardMaker.make_card_field_gun_init(player_E_name.getText());
		CardMaker.make_card_field_gun_init(player_F_name.getText());
		CardMaker.make_card_field_gun_init(player_G_name.getText());
		// test (총 보이게)
		Setter.setPlayerGunImageAvailable(player_A_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_B_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_C_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_D_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_E_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_F_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_G_name.getText(), true);
		
		// test (총 교체)
		Setter.setPlayerGunImageAvailable(player_A_name.getText(), false);
		CardMaker.make_card_field_gun(player_A_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_A_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_B_name.getText(), false);
		CardMaker.make_card_field_gun(player_B_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_B_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_C_name.getText(), false);
		CardMaker.make_card_field_gun(player_C_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_C_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_D_name.getText(), false);
		CardMaker.make_card_field_gun(player_D_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_D_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_E_name.getText(), false);
		CardMaker.make_card_field_gun(player_E_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_E_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_F_name.getText(), false);
		CardMaker.make_card_field_gun(player_F_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_F_name.getText(), true);
		Setter.setPlayerGunImageAvailable(player_G_name.getText(), false);
		CardMaker.make_card_field_gun(player_G_name.getText(),"blue","winchester",'S',8);
		Setter.setPlayerGunImageAvailable(player_G_name.getText(), true);
		
		// test (캐릭터 선택 완료)
		CardMaker.make_card_handField_character(player_A_name.getText(), "wild_west_show", "big_spencer", 4, os);
		CardMaker.make_card_handField_character(player_B_name.getText(), "wild_west_show", "big_spencer", 4, os);
		CardMaker.make_card_handField_character(player_C_name.getText(), "wild_west_show", "big_spencer", 4, os);
		CardMaker.make_card_handField_character(player_D_name.getText(), "wild_west_show", "big_spencer", 4, os);
		CardMaker.make_card_handField_character(player_E_name.getText(), "wild_west_show", "big_spencer", 4, os);
		CardMaker.make_card_handField_character(player_F_name.getText(), "wild_west_show", "big_spencer", 4, os);
		CardMaker.make_card_handField_character(player_G_name.getText(), "wild_west_show", "big_spencer", 4, os);
		// test (캐릭터 이미지 보이게)
		Setter.setPlayerCharacterImageAvailable(player_A_name.getText(), true);
		Setter.setPlayerCharacterImageAvailable(player_B_name.getText(), true);
		Setter.setPlayerCharacterImageAvailable(player_C_name.getText(), true);
		Setter.setPlayerCharacterImageAvailable(player_D_name.getText(), true);
		Setter.setPlayerCharacterImageAvailable(player_E_name.getText(), true);
		Setter.setPlayerCharacterImageAvailable(player_F_name.getText(), true);
		Setter.setPlayerCharacterImageAvailable(player_G_name.getText(), true);
		
		// test (플레이어 핸드 넣어보기)(A) (max: 11)
		player_A_hand.add(CardMaker.make_card_hand_playing(os, player_A_name.getText(), "blue", "barile", 'S', 12, true));
		player_A_hand.add(CardMaker.make_card_hand_playing(os, player_A_name.getText(), "blue", "barile", 'S', 13, true));
		player_A_hand.add(CardMaker.make_card_hand_playing(os, player_A_name.getText(), "brown", "bang", 'S', 1, true));
		Setter.setPlayerHandImageAvailable(UI.player_A_name.getText(),true);
		// player_A_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		// test (플레이어 핸드 넣어보기)(B) (max: 14)
		player_B_hand.add(CardMaker.make_card_hand_playing(os, player_B_name.getText(), "brown", "bang", 'C', 2, false));
		Setter.setPlayerHandImageAvailable(UI.player_B_name.getText(),true);
		// player_B_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));

		// test (플레이어 핸드 넣어보기)(C) (max: 13)
		player_C_hand.add(CardMaker.make_card_hand_playing(os, player_C_name.getText(), "brown", "bang", 'C', 2, false));
		Setter.setPlayerHandImageAvailable(player_C_name.getText(), true);
		// player_C_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		// test (플레이어 핸드 넣어보기)(D) (max: 14)
		player_D_hand.add(CardMaker.make_card_hand_playing(os, player_D_name.getText(), "brown", "bang", 'C', 2, false));
		Setter.setPlayerHandImageAvailable(player_D_name.getText(),true);
		// player_D_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		// test (플레이어 핸드 넣어보기)(E) (max: 14)
		player_E_hand.add(CardMaker.make_card_hand_playing(os, player_E_name.getText(), "brown", "bang", 'C', 2, false));
		Setter.setPlayerHandImageAvailable(player_E_name.getText(),true);
		// player_E_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		// test (플레이어 핸드 넣어보기)(F) (max: 13)
		player_F_hand.add(CardMaker.make_card_hand_playing(os, player_F_name.getText(), "brown", "bang", 'C', 2, false));
		Setter.setPlayerHandImageAvailable(player_F_name.getText(), true);
		// player_F_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		// test (플레이어 핸드 넣어보기)(G) (max: 14)
		player_G_hand.add(CardMaker.make_card_hand_playing(os, player_G_name.getText(), "brown", "bang", 'C', 2, false));
		Setter.setPlayerHandImageAvailable(player_G_name.getText(),true);
		// player_G_hand.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		// test (시나리오 칸 만들기)
		CardMaker.make_card_handField_scenario(4, "wild_west_show", "bavaglio");
		Setter.setScenarioImageAvailable(4, true);
		CardMaker.make_card_handField_scenario(3, "back", "wild_west_show");
		Setter.setScenarioImageAvailable(3, true);
		CardMaker.make_card_handField_scenario(2, "high_noon", "sete");
		Setter.setScenarioImageAvailable(2, true);
		CardMaker.make_card_handField_scenario(1, "a_fistful_of_cards", "per_un_pugno_di_carte");
		Setter.setScenarioImageAvailable(1, true);
		Setter.setScenarioImageAvailable(1, false);
		CardMaker.make_card_handField_scenario(1, "a_fistful_of_cards", "vendetta");
		Setter.setScenarioImageAvailable(1, true);
		
//		// test (시나리오 라스트 만들기)
//		CardMaker.make_card_handField_scenario_last("high_noon");
//		Setter.setScenarioImageAvailable(1, true);
//		CardMaker.make_card_handField_scenario_last("wild_west_show");
//		Setter.setScenarioImageAvailable(3, true);
		
		// test (골드러시 칸 만들기)
		CardMaker.make_card_handField_gold_rush(1, null, null, -1);
		CardMaker.make_card_handField_gold_rush(2, "black", "cinturone", 3);
		CardMaker.make_card_handField_gold_rush(3, "brown", "union_pacific", 2);
		CardMaker.make_card_handField_gold_rush(4, "black", "setaccio", 3);
		Setter.setGoldRushImageAvailable(1, true);
		Setter.setGoldRushImageAvailable(2, true);
		Setter.setGoldRushImageAvailable(3, true);
		Setter.setGoldRushImageAvailable(4, true);
		
//		// test (카드 바꾸는 방법임) ***
//		Setter.setGoldRushImageAvailable(4, false);
//		CardMaker.make_card_handField_gold_rush(4, "black", "calumet", 3);
//		Setter.setGoldRushImageAvailable(4, true);
		
		// test (필드 넣어보기)(A) (최대 8장 고정)
		player_A_field.add(CardMaker.make_card_field_playing(UI.player_A_field.getComponentCount(),UI.player_A_name.getText(), "blue", "barile", 'S', 13));
		player_A_field.add(CardMaker.make_card_field_playing(UI.player_A_field.getComponentCount(),UI.player_A_name.getText(), "blue", "barile", 'S', 13));
		player_A_field.add(CardMaker.make_card_field_playing(UI.player_A_field.getComponentCount(),UI.player_A_name.getText(), "blue", "barile", 'S', 13));
		
		// test (필드 넣어보기)(B)
		player_B_field.add(CardMaker.make_card_field_playing(UI.player_B_field.getComponentCount(), UI.player_B_name.getText(), "blue", "barile", 'S', 12));
		player_B_field.add(CardMaker.make_card_field_playing(UI.player_B_field.getComponentCount(), UI.player_B_name.getText(), "blue", "barile", 'S', 12));
		player_B_field.add(CardMaker.make_card_field_playing(UI.player_B_field.getComponentCount(), UI.player_B_name.getText(), "blue", "barile", 'S', 12));
		
		// test (필드 넣어보기)(C)
		player_C_field.add(CardMaker.make_card_field_playing(UI.player_C_field.getComponentCount(), UI.player_C_name.getText(), "blue", "barile", 'S', 12));
		player_C_field.add(CardMaker.make_card_field_playing(UI.player_C_field.getComponentCount(), UI.player_C_name.getText(), "blue", "barile", 'S', 12));
		player_C_field.add(CardMaker.make_card_field_playing(UI.player_C_field.getComponentCount(), UI.player_C_name.getText(), "blue", "barile", 'S', 12));
		
		// test (필드 넣어보기)(D)
		player_D_field.add(CardMaker.make_card_field_playing(UI.player_D_field.getComponentCount(), UI.player_D_name.getText(), "blue", "barile", 'S', 12));
		player_D_field.add(CardMaker.make_card_field_playing(UI.player_D_field.getComponentCount(), UI.player_D_name.getText(), "blue", "barile", 'S', 12));
		player_D_field.add(CardMaker.make_card_field_playing(UI.player_D_field.getComponentCount(), UI.player_D_name.getText(), "blue", "barile", 'S', 12));

		// test (필드 넣어보기)(E)
		player_E_field.add(CardMaker.make_card_field_playing(UI.player_E_field.getComponentCount(), UI.player_E_name.getText(), "blue", "barile", 'S', 12));
		player_E_field.add(CardMaker.make_card_field_playing(UI.player_E_field.getComponentCount(), UI.player_E_name.getText(), "blue", "barile", 'S', 12));
		player_E_field.add(CardMaker.make_card_field_playing(UI.player_E_field.getComponentCount(), UI.player_E_name.getText(), "blue", "barile", 'S', 12));
		
		// test (필드 넣어보기)(F)
		player_F_field.add(CardMaker.make_card_field_playing(UI.player_F_field.getComponentCount(), UI.player_F_name.getText(), "blue", "barile", 'S', 12));
		player_F_field.add(CardMaker.make_card_field_playing(UI.player_F_field.getComponentCount(), UI.player_F_name.getText(), "blue", "barile", 'S', 12));
		player_F_field.add(CardMaker.make_card_field_playing(UI.player_F_field.getComponentCount(), UI.player_F_name.getText(), "blue", "barile", 'S', 12));
		
		// test (필드 넣어보기)(G)
		player_G_field.add(CardMaker.make_card_field_playing(UI.player_G_field.getComponentCount(), UI.player_G_name.getText(), "blue", "barile", 'S', 12));
		player_G_field.add(CardMaker.make_card_field_playing(UI.player_G_field.getComponentCount(), UI.player_G_name.getText(), "blue", "barile", 'S', 12));
		player_G_field.add(CardMaker.make_card_field_playing(UI.player_G_field.getComponentCount(), UI.player_G_name.getText(), "blue", "barile", 'S', 12));
		
	}

	// get cardUse2
	public static synchronized boolean getCardUse2() {
		return cardUse2;
	}
	// get cardUse3
	public static synchronized boolean getCardUse3() {
		return cardUse3;
	}
	// get attacked
	public static synchronized boolean getAttacked() {
		return attacked;
	}
	// get setTarget
	public static synchronized boolean getSetTarget() {
		return setTarget;
	}
	// set cardUse2
	public static synchronized void setCardUse2(boolean b) {
		cardUse2 = b;
	}
	// set cardUse3
	public static synchronized void setCardUse3(boolean b) {
		cardUse3 = b;
	}
	// set attacked
	public static synchronized void setAttacked(boolean b) {
		attacked = b;
	}
	// set setTarget
	public static synchronized void setSetTarget(boolean b) {
		setTarget = b;
	}
}
