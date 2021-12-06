/* 
 * class name: Gm
 * purpose: game dealer
 */

package gm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Gm{
	// player's turn(== init seat)
	private List<String> turn;

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
		// broadcasting disable TOP_NOTICE
		server.App.broadcast("game/DISABLE/TOP_NOTICE");
	}

	// select role
	private void select_role(){

	}

	// select scenario
	private void select_scenario(){

	}

	// select_character
	private void select_character(){

	}
}
