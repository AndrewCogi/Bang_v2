/* 
 * class name: SessionManager
 * purpose: session contents management
 */
package manager;

import java.io.PrintWriter;
import java.net.Socket;
import timer.SessionTimer;

public class SessionManager{
	// output stream
	private PrintWriter os;
	// session timer
	private SessionTimer timer;

	// constructor
	public SessionManager(Socket socket, PrintWriter os){
		this.os = os;
		// session timer start
		this.timer = new SessionTimer(socket,os);
		this.timer.start();
	}

	// request
	public void request(String cmd){
		// session/[??]
		String[] splitCmd = cmd.split("/");
		System.out.println("[System][SessionManager][get] > "+cmd);
		// respond session check packet
		if(splitCmd[1].equals("SESSIONCHECKPKT")){
			SessionCheckPKT();
			timer.resetSec();
		}
	}

	// respond session check packet
	private void SessionCheckPKT(){
		String respondMessage = "session/SESSIONCHECKPKT";
		os.println(respondMessage);
		System.out.println("[System][SessionManager][send] > "+respondMessage);
	}
}
