/* 
 * class name: GameManager
 * purpose: game input management
 */
package manager;

import java.io.PrintWriter;

import gm.Gm;

public class GameManager{
	// output stream
	private PrintWriter os;

	// constructor
	public GameManager(PrintWriter os){
		this.os = os;
	}

	public void request(String cmd){
		// game/[??]
		String[] splitCmd = cmd.split("/");
		// game/SELECT/[??]
		if(splitCmd[1].equals("SELECT")){
			// game/SELECT/ROLE/[id]/[role name]/[cardNum]
			if(splitCmd[2].equals("ROLE")){
				// add Gm.role
				Gm.getRole().put(splitCmd[3],splitCmd[4]);
				// broadcast who select card without selecter
				server.App.broadcast(splitCmd[3],"game/PLAYERSELECT/ROLE/"+splitCmd[4]+"/"+splitCmd[5]);
				// +1 respond
				Gm.setRespond(Gm.getRespond()+1);
				// broadcast how many players picked
				server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select your role...("+Gm.getRespond()+" | 7)");
			}
		}

		// unknown message
		else{
			System.out.println("[Unknown_message]: "+cmd);
		}
	}
	
}
