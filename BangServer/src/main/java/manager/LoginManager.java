/* 
 * class name: LoginManager
 * purpose: login contents management
 */
package manager;

import java.io.PrintWriter;
import java.net.Socket;
import debug.DateTime;

public class LoginManager{
	// socket (for check connection)
	private Socket socket;
	// playerName
	private String playerName;
	// output stream
	private PrintWriter os;

	// constructor
	public LoginManager(Socket socket, PrintWriter os, int attemptNum){
		this.socket = socket;
		this.os = os;
		this.playerName = "Unknown_"+attemptNum;
	}

	public void request(String cmd){
		// login/[??]
		String[] splitCmd = cmd.split("/");
		// login/PLAYERNAME/[playerName]
		if(splitCmd[1].equals("PLAYERNAME")){
			String tempName = splitCmd[2];
			// check this playerName is available
			if(checkPlayerName(tempName)){
				// check the number of players
				if(!checkPlayerNumber()){
					// send result
					os.println("login/PLAYERNAME/FALSE/Member exceeded");
					DateTime.showTime();
					System.out.println("[LOGIN FAILED][Member Exceeded] > PlayerName["+playerName+"] "+socket);
				}
				else{
					// init
					this.playerName = tempName;
					// add playerName into clients
					setPlayerName(this.playerName);
					// send result
					os.println("login/PLAYERNAME/TRUE");
					DateTime.showTime();
					System.out.println("[LOGIN SUCCESSED] > PlayerName["+playerName+"] "+socket);
					// add os into clientsPrintWriter
					server.App.getClientsPrintWriter().add(os);
					// broadcasting
					server.App.broadcast("player/PLAYERNUM/"+server.App.getPlayerNumber());
				}
			}
			// this playerName is not available
			else{
				// send result
				os.println("login/PLAYERNAME/FALSE/Name duplicated");
				DateTime.showTime();
				System.out.println("[LOGIN FAILED][Name Duplicated] > PlayerName["+playerName+"] "+socket);
			}
		}
	}

	// check this playerName is available
	private boolean checkPlayerName(String tempName){
		for(String name : server.App.getClients().values()){
			if(name.equals(tempName)) return false;
		}
		return true;
	}

	// check player number
	private boolean checkPlayerNumber(){
		int num = 0;
		for(String s : server.App.getClients().values()){
			if(!s.startsWith("Unknown")) num++;
		}
		return (num < 7) ? true : false;
	}

	// set playerName into clients
	private void setPlayerName(String newName){
		server.App.getClients().put(socket,newName);
	}

}
