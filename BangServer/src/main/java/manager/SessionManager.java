/* 
 * class name: SessionManager
 * purpose: session input management (re-ack session/SESSIONACK)
 */

package manager;

import java.io.PrintWriter;
import java.util.Scanner;

public class SessionManager{
	// output stream
	private PrintWriter os;

	public SessionManager(Scanner is, PrintWriter os){
		// output stream init
		this.os = os;
	}

	public void request(String cmd){
		// session/[??]
		String[] splitCmd = cmd.split("/");
		// session/SESSIONACK
		if(splitCmd[1].equals("SESSIONACK")){
			// re-ack session/SESSIONACK
			os.println("session/SESSIONACK");
		}
	}
}
