/* 
 * class name: LoginManager
 * purpose: login contents management
 */
package manager;

public class LoginManager{
	private String playerName;

	public LoginManager(){
		this.playerName = "";
	}

	public void request(String cmd){
		// login/[??]
		String[] splitCmd = cmd.split("/");
		System.out.println("[System][LoginManager][get] > "+cmd);
		// player first login
		if(splitCmd[1].equals("PLAYERNAME")){
			if(checkPlayerName()){
				// setPlayerName();
			}
		}
	}

	// check this playerName is available
	private boolean checkPlayerName(){
		return false;
	}

}
