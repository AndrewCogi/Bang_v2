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
	public LoginManager(Socket socket, PrintWriter os){
		this.socket = socket;
		this.os = os;
		this.playerName = "Unknown";
	}

	public void request(String cmd){
		// login/[??]
		String[] splitCmd = cmd.split("/");
		System.out.println("[System][LoginManager][get] > "+cmd);
		// login/PLAYERNAME/[playerName]
		if(splitCmd[1].equals("PLAYERNAME")){
			String tempName = splitCmd[2];
			// check this playerName is available
			if(checkPlayerName(tempName)){
				// init
				this.playerName = tempName;
				// add playerName into clients
				setPlayerName(this.playerName);
				// send result
				os.println("login/PLAYERNAME/TRUE");
				DateTime.showTime();
				System.out.println("[ENTERED] > PlayerName["+playerName+"] "+socket);
			}
			// this playerName is not available
			else{
				// send result
				os.println("login/PLAYERNAME/FALSE");
				DateTime.showTime();
				System.out.println("[System][LoginManager][FAIL] > PlayerName["+playerName+"] "+socket);
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

	// set playerName into clients
	private void setPlayerName(String newName){
		server.App.getClients().put(socket,newName);
	}

}
