package manager;

import java.io.PrintWriter;

import javax.swing.JOptionPane;

import timer.SessionTimer;

public class SessionManager extends Thread{
	// check server is alive (TTL = 10 sec)
	private SessionTimer sessionTimer;
	// output stream
	private PrintWriter os;
	
	public SessionManager(PrintWriter os) {
		// timer start
		this.sessionTimer = new SessionTimer();
		this.sessionTimer.start();
		// output stream init
		this.os = os;
		// send first SESSIONACK
		os.println("session/SESSIONACK");
	}
	
	public void request(String cmd) {
		// session/[??]
		String[] splitCmd = cmd.split("/");
		// session/DISCONNECTED
		// -> server is closed.
		if(splitCmd[1].equals("DISCONNECTED")) {
			// stop sessionTimer
			this.sessionTimer.interrupt();
			// notify
			JOptionPane.showMessageDialog(null, "Server is closed.","Notice",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// session/SESSIONACK
		// -> server alive check
		else if(splitCmd[1].equals("SESSIONACK")) {
			os.println("session/SESSIONACK");
			sessionTimer.setTimer(0);
			try {Thread.sleep(10);} catch(InterruptedException e) {}
		}
	}
}
