package timer;

import java.io.PrintWriter;
import java.net.Socket;

public class SessionTimer extends Thread{
	// socket (for check connection)
	private Socket socket;
	// timer
	private int sec;
	// output stream
	private PrintWriter os;

	public SessionTimer(Socket socket, PrintWriter os){
		this.socket = socket;
		this.os = os;
		this.sec = 0;
	}

	@Override
	public void run(){
		// not timeout, add 1 in 1sec
		while(!checkTimeout()){
			sec++;
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}

		// timeout, DISCONNECTED
		disconnected();
		// stop this thread
		this.interrupt();
		System.out.println("[System][SessionTimer] > SessionTimer(timer) is stopped.");
	}

	// disconnected process method
	private void disconnected(){
		// send [session/DISCONNECTED] message
		// client: stop client side app
		os.println("session/DISCONNECTED");
		System.out.println("\n[DISCONNECTED] > "+socket);
		// remove this socket in clients
		server.App.getClients().remove(server.App.getClients().indexOf(socket));
	}

	// true: yes! timeout / false: no! not yet
	private boolean checkTimeout(){
		if(sec > 10) return true;
		else return false;
	}

	public synchronized void resetSec(){
		sec = 0;
	}
}
