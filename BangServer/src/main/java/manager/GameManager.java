/* 
 * class name: GameManager
 * purpose: game input management
 */
package manager;

import java.io.PrintWriter;

import card.CharactersCard;
import gm.Gm;

public class GameManager{
	// output stream
	private PrintWriter os;
	// ready player number
	private static int readyPlayer = 0;

	// constructor
	public GameManager(PrintWriter os){
		this.os = os;
	}

	public void request(String cmd){
		// game/[??]
		String[] splitCmd = cmd.split("/");
		// check
		System.out.println("[System][GameManager][Get] > "+cmd);
		// game/READYBUTTON/[ON|OFF]/[who]
		if(splitCmd[1].equals("READYBUTTON")){
			// add(remove) readyPlayer
			if(splitCmd[2].equals("ON")) setReadyPlayer(getReadyPlayer()+1);
			else if(splitCmd[2].equals("OFF")) setReadyPlayer(getReadyPlayer()-1);
			System.out.println("[System][GameManager] > Ready "+splitCmd[2].toUpperCase()+" ["+splitCmd[3]+"], ("+getReadyPlayer()+" / 7)");
		}
		// game/SELECT/[??]
		else if(splitCmd[1].equals("SELECT")){
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
				Gm.getCharacter().put(splitCmd[3], new CharactersCard(splitCmd[4],splitCmd[5]));
				// check
				System.out.println("[Gm][GameManager] > "+splitCmd[3]+" picked - "+splitCmd[4]+"/"+splitCmd[5]);
				// +1 respond
				Gm.setRespond(Gm.getRespond()+1);
				// broadcast how many players picked
				// server.App.broadcast("game/SETTEXT/TOP_NOTICE/Select your character...("+Gm.getRespond()+" | 7)");
			}
		}
		// game/DIED/[playerRole]
		else if(splitCmd[1].equals("DIED")){
			int diedPlayerRole = -1;
			if(splitCmd[2].equals("sceriffo")) diedPlayerRole = 0;
			else if(splitCmd[2].equals("vice")) diedPlayerRole = 1;
			else if(splitCmd[2].equals("fuorilegge")) diedPlayerRole = 2;
			else if(splitCmd[2].equals("rinnegato")) diedPlayerRole = 3;
			// remove this name in alivePlayer
			Gm.alivePlayerRole[diedPlayerRole]--;
		}
		// game/ENDPHASE
		else if(splitCmd[1].equals("ENDPHASE")){
			Gm.setPhaseAlive(false);
		}
		// game/USEHANDCARD/[id]/[cardColor]/[cardName]/[cardShape]/[cardNum]
		else if(splitCmd[1].equals("USEHANDCARD")){
			String id = splitCmd[2];
			String cardColor = splitCmd[3];
			String cardName = splitCmd[4];
			String cardShape = splitCmd[5];
			String cardNum = splitCmd[6];
			// boradcast this player use this card
			server.App.broadcast_without(id,"game/REMOVE/PLAYER_HAND/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
			// if card color is brown, add into main deck (old), broadcasting it
			if(cardColor.equals("brown")){
				Gm.addCardIntoMainDeck_old(cardColor,cardName,cardShape,cardNum);
				server.App.broadcast_without(id,"game/ADD/MAIN_DECK_OLD/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
			} 		
		}
		// game/DISCARDHANDCARD/[id]/[cardColor]/[cardName]/[cardShape]/[cardNum]
		else if(splitCmd[1].equals("DISCARDHANDCARD")){
			String id = splitCmd[2];
			String cardColor = splitCmd[3];
			String cardName = splitCmd[4];
			String cardShape = splitCmd[5];
			String cardNum = splitCmd[6];
			// boradcast this player use this card
			server.App.broadcast_without(id,"game/REMOVE/PLAYER_HAND/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
			// add into main deck (old) because of discard it, and also broadcasting it
			Gm.addCardIntoMainDeck_old(cardColor,cardName,cardShape,cardNum);
			server.App.broadcast_without(id,"game/ADD/MAIN_DECK_OLD/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
		}
		// game/CARDABILITY/[??]
		else if(splitCmd[1].equals("CARDABILITY")){
			// game/CARDABILITY/BANG/[targetCardExtension]/[targetCardName]/[userCardExtension]/[userCardName]
			if(splitCmd[2].equals("BANG")){
				String targetCardExtension = splitCmd[3];
				String targetCardName = splitCmd[4];
				String userCardExtension = splitCmd[5];
				String userCardName = splitCmd[6];
				// broadcast
				server.App.broadcast("game/CARDABILITY/BANG/"+targetCardExtension+"/"+targetCardName+"/"+userCardExtension+"/"+userCardName);
			}
		}
		// game/HPSET/[targetCardName]/[hp+]
		else if(splitCmd[1].equals("HPSET")){
			String targetCardName = splitCmd[2];
			int hpSize = Integer.parseInt(splitCmd[3]);
			// broadcast
			server.App.broadcast("game/HPSET/"+targetCardName+"/"+hpSize);
		}

		// unknown message
		else{
			System.out.println("[Unknown_message]: "+cmd);
		}
	}

	// set ready player
	public synchronized static void setReadyPlayer(int n){
		readyPlayer = n;
	}
	// get ready player
	public synchronized static int getReadyPlayer(){
		return readyPlayer;
	}
	
}
