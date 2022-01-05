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
				// check
				System.out.println("[Gm][GameManager] > "+splitCmd[3]+" picked - "+splitCmd[4]+"/"+splitCmd[5]);
				// broadcast who select card without selecter
				server.App.broadcast_without(splitCmd[3],"game/PLAYERSELECT/ROLE/"+splitCmd[4]+"/"+splitCmd[5]);
				// +1 respond
				Gm.setRespond(Gm.getRespond()+1);
				// broadcast how many players picked
				// server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select your role...("+Gm.getRespond()+" | 7)");
			}
			
			// game/SELECT/LAST_SCENARIO/[cardNum]
			else if(splitCmd[2].equals("LAST_SCENARIO")){
				// add Gm.vote_last_scenario
				Gm.vote_last_scenario(Integer.parseInt(splitCmd[3]));
				// check
				System.out.println("[Gm][GameManager] > Someone picked - "+splitCmd[3]);
				// +1 respond
				Gm.setRespond(Gm.getRespond()+1);
				// broadcast how many players picked
				// server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select last scenario...("+
						// (Gm.getVote_last_scenario()[0]+Gm.getVote_last_scenario()[1])+" | 7)");
			}

			// game/SELECT/CHARACTER/[id]/[characterExtension]/[characterName]
			else if(splitCmd[2].equals("CHARACTER")){
				// add Gm.character
				Gm.getCharacter().put(splitCmd[3],splitCmd[4]+"/"+splitCmd[5]);
				// check
				System.out.println("[Gm][GameManager] > "+splitCmd[3]+" picked - "+splitCmd[4]+"/"+splitCmd[5]);
				// +1 respond
				Gm.setRespond(Gm.getRespond()+1);
				// broadcast how many players picked
				// server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select your character...("+Gm.getRespond()+" | 7)");
			}
		}

		// unknown message
		else{
			System.out.println("[Unknown_message]: "+cmd);
		}
	}
	
}
