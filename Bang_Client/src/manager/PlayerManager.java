package manager;

import ui.Setter;

public class PlayerManager {
	
	public PlayerManager() {
	}
	
	public void request(String cmd) {
		// player/[??]
		String[] splitCmd = cmd.split("/");
		
		// player/PLAYERNUM/[num]
		if(splitCmd[1].equals("PLAYERNUM")) {
			Setter.setTextNotice(2,"Waiting for players... ("+splitCmd[2]+"/7)");
		}
		else {
			System.out.println("[Unknown command]: "+cmd);
		}
	}
}
