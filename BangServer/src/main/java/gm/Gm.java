/* 
 * class name: Gm
 * purpose: game dealer
 */

package gm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import card.CharactersCard;
import card.GoldRushCard;
import deck.CharacterDeck;
import deck.GoldRushDeck;
import deck.MainDeck;
import deck.RoleDeck;
import deck.ScenarioDeck;

public class Gm{
	// player's turn(== init seat)
	private List<String> turn;
	// player's role(== init role) <ID,Role>
	private static HashMap<String,String> role;
	// player's character(== init character) <ID,character>
	private static HashMap<String,CharactersCard> character;
	// vote last scenario
	private static int[] vote_last_scenario;
	// scenario deck
	private static ScenarioDeck scenarioTurnDeck;
	private static ScenarioDeck scenarioWildDeck;
	// main deck (playing deck)
	private static MainDeck mainDeck_new;
	private static MainDeck mainDeck_old;
	// respond members
	private static int respond = 0;

	public Gm(){
		this.turn = new LinkedList<>();
	}

	// init (setting seat, select role, select scenario, select character)
	public void init(){
		// setting seat
		setting_seat();
		// select role
		select_role();
		// select scenario
		select_last_scenario();
		// select character
		select_character();
		// setting remains
		setting_remains();
	}

	public void start(){
		System.out.println("[System][Gm] > start Bang.");
		// test
		for(int i=10; i>0; i--){
			System.out.println("[Testing] > Bang end in "+i+"...");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println(e.getMessage());}
		}
		System.out.println("[System][Gm] > end Bang.");
		// disable TOP_NOTICE
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/ ");
	}

	// setting seat
	private void setting_seat(){
		// broadcasting "Allocating seats..." & ENABLE TOP_NOTICE & MIDDLE_NOTICE
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Allocating seats...");
		server.App.broadcast("game/ENABLE/TOP_NOTICE");
		server.App.broadcast("game/SETTEXT/MIDDLE_NOTICE/ ");
		server.App.broadcast("game/ENABLE/MIDDLE_NOTICE");
		// re-init turn list
		this.turn = new LinkedList<>();
		// make turn list & shuffle
		for(String s : server.App.getClientsPrintWriter().values()){ this.turn.add(s); }
		Collections.shuffle(this.turn);
		// check
		System.out.print("[System][Gm] > SEAT(TURN): ");
		for(String s : this.turn){ System.out.print(" > "+s); }
		System.out.println();
		// broadcasting turn
		StringBuilder turns = new StringBuilder("");
		for(String s : this.turn){ turns.append(s+"/"); }
		turns.deleteCharAt(turns.length()-1);
		server.App.broadcast("game/INIT/SEAT/"+turns);
		// waiting for setting seats
		try{ Thread.sleep(700*7); } catch(InterruptedException e){}
		// broadcasting disable TOP_NOTICE
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/ ");
	}

	// select role
	private void select_role(){
		// re-init respond
		setRespond(0);
		// re-init role
		role = new HashMap<String,String>();
		// broadcasting "Select your role..."
		// server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select your role...(0 | 7)");
		// make role deck
		RoleDeck roleDeck = new RoleDeck();
		// make & shuffle role deck
		roleDeck.make_init_deck();
		roleDeck.shuffle();
		// broadcasting SELECT/ROLE/[0]/[1]/[2]/[3]/[4]/[5]/[6]
		server.App.broadcast("game/SELECT/ROLE/"+
				roleDeck.getCardName(0)+"/"+roleDeck.getCardName(1)+"/"+
				roleDeck.getCardName(2)+"/"+roleDeck.getCardName(3)+"/"+
				roleDeck.getCardName(4)+"/"+roleDeck.getCardName(5)+"/"+roleDeck.getCardName(6));
		// wait until everyone respond
		while(getRespond() != 7){}
		// wait for socket IO
		try{ Thread.sleep(1000); } catch(InterruptedException e){};
		// allocating roles...
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/ ");
		server.App.broadcast("game/DISABLE/SELECT_PANEL/ROLE");
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Allocating roles...");
		// broadcasting their roles
		for(String name : role.keySet()){
			String roleName = role.get(name);
			// game/INIT/ROLE/[name]/[roleName]
			server.App.broadcast("game/INIT/ROLE/"+name+"/"+roleName);
			try{ Thread.sleep(1000/2); } catch(InterruptedException e){};
		}
	}

	// select last scenario
	private void select_last_scenario(){
		// re-init respond
		setRespond(0);
		// re-init last_scenario
		vote_last_scenario = new int[]{0,0};
		// broadcasting SELECT/LAST_SCENARIO
		server.App.broadcast("game/SELECT/LAST_SCENARIO");
		// wait until everyone respond
		while(getRespond() != 7){}
		// delay for socket IO
		try{ Thread.sleep(1000); } catch(InterruptedException e){};
		// everyone picked, broadcast result
		if(vote_last_scenario[0] > vote_last_scenario[1]){
			server.App.broadcast("game/SETTEXT/MIDDLE_NOTICE/a_fistful_of_cards");
			server.App.broadcast("game/PLAYERSELECT/SCENARIO/a_fistful_of_cards");
		}
		else if(vote_last_scenario[0] < vote_last_scenario[1]){
			server.App.broadcast("game/SETTEXT/MIDDLE_NOTICE/high_noon");
			server.App.broadcast("game/PLAYERSELECT/SCENARIO/high_noon");
		}
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Result");
		server.App.broadcast("game/DISABLE/SELECT_PANEL/SCENARIO");
		// waiting 5 seconds
		try{ Thread.sleep(5000); } catch(InterruptedException e){};
		// delete middle notice
		server.App.broadcast("game/SETTEXT/MIDDLE_NOTICE/ ");
	}

	// select_character
	private void select_character(){
		// re-init respond
		setRespond(0);
		// re-init character
		character = new HashMap<String,CharactersCard>();
		// make character deck
		CharacterDeck characterDeck = new CharacterDeck();
		characterDeck.make_init_deck();
		// broadcasting SELECT/CHARACTER/[ex1]/[ch1]/[hp1]/
		// [ex2]/[ch2]/[hp2]/[ex3]/[ch3]/[hp3]/[ex4]/[ch4]/[hp4]
		for(String playerID : server.App.getClientsPrintWriter().values()){
			// extract 4 characters
			String characterInfo1 = characterDeck.extract();
			String characterInfo2 = characterDeck.extract();
			String characterInfo3 = characterDeck.extract();
			String characterInfo4 = characterDeck.extract();
			server.App.broadcast_within(playerID,"game/SELECT/CHARACTER/"+
					characterInfo1+"/"+characterInfo2+"/"+characterInfo3+"/"+characterInfo4);
		}
		// wait until eveone respond
		while(getRespond() != 7){}
		// delay for socket IO
		try{ Thread.sleep(1000); } catch(InterruptedException e){};
		// allocating characters...
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/ ");
		server.App.broadcast("game/DISABLE/SELECT_PANEL/CHARACTER");
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Allocating characters...");
		// broadcasting their characters
		for(String playerID : character.keySet()){
			String characterExtension = character.get(playerID).getExtension();
			String characterName = character.get(playerID).getCardName();
			int characterHp = character.get(playerID).getHp();
			// game/INIT/CHARACTER/[playerName]/[characterExtension]/[characterName]/[characterHp]
			server.App.broadcast("game/INIT/CHARACTER/"+playerID+"/"+characterExtension+"/"+characterName+"/"+characterHp);
			try{ Thread.sleep(1000/2); } catch(InterruptedException e){};
		}
		// disable top notice
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/ ");
	}

	// setting remains
	private void setting_remains(){
		// broadcast top notice
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Setting remains...");
		// setting scenario
		setting_scenario();
		// setting main deck
		setting_main_deck();
		// setting gold rush
		setting_gold_rush();
		// setting guns
		setting_init_gun();
		// setting hp & gold
		setting_init_hp_gold();
		// setting players' hand
		setting_init_player_hand();
		// broadcast top notice
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Game Start!");
	}

	// setting scenario (making scenario deck)
	private void setting_scenario(){
		// make scenario deck
		scenarioTurnDeck = new ScenarioDeck();
		scenarioTurnDeck.make_init_deck(1,vote_last_scenario[0] > vote_last_scenario[1]);
		scenarioWildDeck = new ScenarioDeck();
		scenarioWildDeck.make_init_deck(2,true);
		// check
		for(int i=0; i<scenarioTurnDeck.getSize(); i++){
			System.out.println("[ScenarioTurnDeck]: "+scenarioTurnDeck.getCardName(i));
		}
		System.out.println();
		for(int i=0; i<scenarioWildDeck.getSize(); i++){
			System.out.println("[ScenarioWildDeck]: "+scenarioWildDeck.getCardName(i));
		}
		System.out.println();
		// broadcasting game/INIT/SCENARIO/[extension]/[turn-first scenario]
		server.App.broadcast("game/INIT/SCENAIO/"+
				scenarioTurnDeck.getCardExtension(0)+"/"+scenarioTurnDeck.getCardName(0));
	}

	// setting main deck
	private void setting_main_deck(){
		// make main deck
		mainDeck_new = new MainDeck();
		mainDeck_old = new MainDeck();
		mainDeck_new.make_init_deck();
		mainDeck_new.shuffle();
		// broadcast game/INIT/MAIN_DECK
		server.App.broadcast("game/INIT/MAIN_DECK");
	}

	// setting gold rush
	private void setting_gold_rush(){
		// makd gold_rush deck
		GoldRushDeck goldRushDeck_new = new GoldRushDeck();
		GoldRushDeck goldRushDeck_old = new GoldRushDeck();
		goldRushDeck_new.make_init_deck();
		goldRushDeck_new.shuffle();
		// get 3 cards & add openCards into goldRushDeck_old
		GoldRushCard openCard1 = goldRushDeck_new.pop();
		GoldRushCard openCard2 = goldRushDeck_new.pop();
		GoldRushCard openCard3 = goldRushDeck_new.pop();
		goldRushDeck_old.add(openCard1);
		goldRushDeck_old.add(openCard2);
		goldRushDeck_old.add(openCard3);

		// broadcast game/INIT/GOLD_RUSH/[color1]/[name1]/[cost1]/[color2]/[name2]/[cost2]/[color3]/[name3]/[cost3]
		server.App.broadcast("game/INIT/GOLD_RUSH/"+openCard1.getCardColor()+"/"+openCard1.getCardName()+"/"+openCard1.getCost()+
				"/"+openCard2.getCardColor()+"/"+openCard2.getCardName()+"/"+openCard2.getCost()+
				"/"+openCard3.getCardColor()+"/"+openCard3.getCardName()+"/"+openCard3.getCost());
	}

	// setting init hp & gold
	private void setting_init_hp_gold(){
		// broadcast game/INIT/HP_GOLD
		server.App.broadcast("game/INIT/HP_GOLD");
	}

	// setting init player hand
	private void setting_init_player_hand(){
		for(String playerID : server.App.getClientsPrintWriter().values()){
			// check player hp
			int isSceriffo = 0;
			if(role.get(playerID).equals("sceriffo")) isSceriffo = 1;
			int characterHp = character.get(playerID).getHp();
			int playerHp = isSceriffo+characterHp;
			// broadcast game/INIT/PLAYER_HAND_ENABLE
			server.App.broadcast("game/ENABLE/PLAYER_HAND/"+playerID);
			// broadcast game/INIT/PLAYER_HAND/[playerID]/[cardColor]/[cardName]/[cardShape]/[cardNumber]
			for(int i=0; i<playerHp; i++){
				// extract card info & add cardInfo into mainDeck_old
				String cardInfo = mainDeck_new.pop();
				String cardColor = cardInfo.split("/")[0];
				String cardName = cardInfo.split("/")[1];
				String cardShape = cardInfo.split("/")[2];
				String cardNumber = cardInfo.split("/")[3];
				mainDeck_old.add(cardInfo);
				server.App.broadcast("game/INIT/PLAYER_HAND/"+playerID+"/"+cardColor+"/"+cardName+"/"+
						cardShape+"/"+cardNumber);
			}
		}
	}

	// setting init gun
	private void setting_init_gun(){
		// broadcasting guns...
		for(String playerID : server.App.getClientsPrintWriter().values()){
			server.App.broadcast("game/INIT/GUN/"+playerID);
			try{ Thread.sleep(500/2); } catch(InterruptedException e){};
		}
	}





	// get respond
	public static synchronized int getRespond(){
		return respond;
	}
	// set respond
	public static synchronized void setRespond(int n){
		respond = n;
	}
	// get role
	public static synchronized HashMap<String,String> getRole(){
		return role;
	}
	// get character
	public static synchronized HashMap<String,CharactersCard> getCharacter(){
		return character;
	}
	// get vote_last_scenario
	public static synchronized int[] getVote_last_scenario(){
		return vote_last_scenario;
	}
	// vote last scenario card
	public static synchronized void vote_last_scenario(int cardNum){
		// cardNum == 1 (a fistful of cards)
		// cardNum == 2 (high noon)
		vote_last_scenario[cardNum-1]++;
	}
}
