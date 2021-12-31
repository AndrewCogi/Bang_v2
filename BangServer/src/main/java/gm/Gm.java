/* 
 * class name: Gm
 * purpose: game dealer
 */

package gm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import card.RoleDeck;

public class Gm{
	// player's turn(== init seat)
	private List<String> turn;
	// player's role(== init role) <ID,Role>
	private static HashMap<String,String> role;
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
		select_scenario();
		// select character
		select_character();
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
	}

	// setting seat
	private void setting_seat(){
		// broadcasting "Allocating seats..." & ENABLE TOP_NOTICE
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Allocating seats...");
		server.App.broadcast("game/ENABLE/TOP_NOTICE");
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
		try{ Thread.sleep(7000); } catch(InterruptedException e){}
		// broadcasting disable TOP_NOTICE
		// server.App.broadcast("game/DISABLE/TOP_NOTICE");
	}

	// select role
	private void select_role(){
		// re-init respond
		setRespond(0);
		// re-init role
		role = new HashMap<String,String>();
		// broadcasting "Select your role..." & ENABLE TOP_NOTICE
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select your role...(0 | 7)");
		// server.App.broadcast("game/ENABLE/TOP_NOTICE");
		// make role deck
		RoleDeck roleDeck = new RoleDeck();
		// make & shuffle role deck
		roleDeck.make_role_deck();
		roleDeck.shuffle();
		// broadcasting SELECT/ROLE/[0]/[1]/[2]/[3]/[4]/[5]/[6]
		server.App.broadcast("game/SELECT/ROLE/"+
				roleDeck.getCardName(0)+"/"+roleDeck.getCardName(1)+"/"+
				roleDeck.getCardName(2)+"/"+roleDeck.getCardName(3)+"/"+
				roleDeck.getCardName(4)+"/"+roleDeck.getCardName(5)+"/"+roleDeck.getCardName(6));
		// wait until everyone respond
		while(getRespond() != 7){}
		// everyone picked, allocating their roles
		for(int cnt=5; cnt>0; cnt--){
			server.App.broadcast("game/SETTEXT/TOP_NOTICE/Allocating roles in "+cnt+"...");
			try{ Thread.sleep(1000); } catch(InterruptedException e){};
		}
		// allocating roles...
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/ ");
		server.App.broadcast("game/DISABLE/SELECT_PANEL");
		server.App.broadcast("game/SETTEXT/TOP_NOTICE/Allocating roles...");
		// broadcasting their roles
		for(String name : role.keySet()){
			String roleName = role.get(name);
			// game/INIT/ROLE/[name]/[roleName]
			server.App.broadcast("game/INIT/ROLE/"+name+"/"+roleName);
			try{ Thread.sleep(1000); } catch(InterruptedException e){};
		}
	}

	// select scenario
	private void select_scenario(){

	}

	// select_character
	private void select_character(){

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
}
