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
			// if [num] == 7, add ready button
			if(Integer.parseInt(splitCmd[2]) == 7) Setter.setReadyButtonAvailable(true);
			// if [num] != 7, remove ready button
			else Setter.setReadyButtonAvailable(false);
		}
		else {
			System.out.println("[Unknown command]: "+cmd);
		}
	}
}