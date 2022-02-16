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
		// game/DRAWCARD/[player]/[cardNum]
		else if(splitCmd[1].equals("DRAWCARD")){
			String player = splitCmd[2];
			int cardNum = Integer.parseInt(splitCmd[3]);
			// give [cardNum] cards to player
			for(int i=0; i<cardNum; i++){
				// extract card info
				String cardInfo = Gm.mainDeck_new.pop();
				String cardColor = cardInfo.split("/")[0];
				String cardName = cardInfo.split("/")[1];
				String cardShape = cardInfo.split("/")[2];
				String cardNumber = cardInfo.split("/")[3];
				// broadcast game/ADD/PLAYER_HAND/[playerID]/[cardColor]/[cardName]/[cardShape]/[cardNumber]
				server.App.broadcast("game/ADD/PLAYER_HAND/"+player+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNumber);
			}
			// delay
			try{Thread.sleep(1000);}catch(InterruptedException e){}
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
			// check
			System.out.println("[GameManager][DIED] > "+splitCmd[2]+" is dead! , Now surviver is: "+Gm.alivePlayerRole.toString());
			// check game is over
			if(Gm.checkGameEnd() != 0) Gm.setThisGameIsOver(true);
		}
		// game/ENDPHASE/[player]/[num]
		else if(splitCmd[1].equals("ENDPHASE")){
			String player = splitCmd[2];
			int phaseNum = Integer.parseInt(splitCmd[3]);
			// if phase == 0
			if(phaseNum == 0){
				// send phase1
				server.App.broadcast("game/PHASE/1/"+player);
			}
			// if phase == 1
			else if(phaseNum == 1){
				// send phase2
				server.App.broadcast("game/PHASE/2/"+player);
			}
			// if phase == 2
			else if(phaseNum == 2){
				// send phase3
				server.App.broadcast("game/PHASE/3/"+player);
			}
			// if phase == 3
			else if(phaseNum == 3){
				// change turn
				Gm.turn.add(Gm.turn.remove(0));
				// set next turn player
				server.App.broadcast("game/PHASE/0/"+Gm.turn.get(0));
			}
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
			// game/CARDABILITY/VOLCANIC/[id]/[cardColor]/[cardName]/[cardShape]/[cardNum]
			else if(splitCmd[2].equals("VOLCANIC")){
				String id = splitCmd[3];
				String cardColor = splitCmd[4];
				String cardName = splitCmd[5];
				String cardShape = splitCmd[6];
				String cardNum = splitCmd[7];
				//broadcast
				server.App.broadcast("game/CARDABILITY/VOLCANIC/"+id+"/"+cardColor+"/"+cardName+"/"+cardShape+"/"+cardNum);
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
