package manager;

import java.io.PrintWriter;
import java.util.Scanner;

public class InputManager {
	private GameManager gm; // game command manager
	private PlayerManager pm; // player login|out manager
	private SessionManager sm; // session manager (check server is online)
	
	public InputManager(Scanner is, PrintWriter os, String id) {
		this.gm = new GameManager(id,os);
		this.pm = new PlayerManager();
		this.sm = new SessionManager(os);
	}
	
	public void request(String cmd) {
		if(!cmd.equals("session/SESSIONACK")) System.out.println("[InputManager][get]: "+cmd);
		
		// player/[??]
		if(cmd.startsWith("player")) {
			pm.request(cmd);
		}
		// session/[??]
		else if(cmd.startsWith("session")) {
			sm.request(cmd);
		}
		// game/[??]
		else if(cmd.startsWith("game")) {
			gm.request(cmd);
		}
		else {
			System.out.println("[Unknown command]: "+cmd);
		}
	}
}
