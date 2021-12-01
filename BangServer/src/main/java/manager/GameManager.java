/* 
 * class name: GameManager
 * purpose: game input management
 */
package manager;

import gm.Gm;

public class GameManager{
	// command string
	private String cmd;
	// game dealer
	private Gm gm;

	public GameManager(){
		this.gm = new Gm();
		this.cmd = "";
	}
}
