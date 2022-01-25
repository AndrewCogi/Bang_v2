/* 
 * class name: LoginManager
 * purpose: login input management
 */
package manager;

import java.io.PrintWriter;
import java.net.Socket;
import debug.DateTime;

public class LoginManager{
	// socket (for add output stream into clients)
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

			// if game is begin,
			if(server.App.getGameStarted() == true){
				// send result
				os.println("login/PLAYERNAME/FALSE/Game is already started");
				DateTime.showTime();
				System.out.println("[LOGIN FAILED][Game is already Started.] > PlayerName["+playerName+"] "+socket);
				return;
			}

			// if playerName is not available,
			if(!checkPlayerName(tempName)){
				// send result
				os.println("login/PLAYERNAME/FALSE/Name duplicated");
				DateTime.showTime();
				System.out.println("[LOGIN FAILED][Name Duplicated] > PlayerName["+playerName+"] "+socket);
				return;
			}

			// if players > 7,
			if(!checkPlayerNumber()){
				// send result
				os.println("login/PLAYERNAME/FALSE/Member exceeded");
				DateTime.showTime();
				System.out.println("[LOGIN FAILED][Member Exceeded] > PlayerName["+playerName+"] "+socket);
				return;
			}

			// send result
			os.println("login/PLAYERNAME/TRUE/"+server.App.getPw());
		}
		// login/PLAYERLOGIN/[playerName]
		else if(splitCmd[1].equals("PLAYERLOGIN")){
			String tempName = splitCmd[2];
			// one more check (id duplicated)
			if(!checkPlayerName(tempName)){
				// send result
				os.println("login/FALSE");
				DateTime.showTime();
				System.out.println("[LOGIN FAILED][Name Duplicated] > PlayerName["+playerName+"] "+socket);
				return;
			}
			else{
				// send result
				os.println("login/TRUE");
			DateTime.showTime();
			System.out.println("[LOGIN SUCCESSED] > PlayerName["+playerName+"] "+socket);
			}

			// if you here, login success!
			// init
			this.playerName = tempName;
			// add playerName into clients
			server.App.getClients().put(socket,this.playerName);
			// add os into clientsPrintWriter
			server.App.getClientsPrintWriter().put(os,playerName);
			// broadcasting
			server.App.broadcast("player/PLAYERNUM/"+server.App.getPlayerNumber());
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

}
