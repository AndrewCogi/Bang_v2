/* 
 * class name: Commander
 * purpose: command management
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Commander extends Thread{
	private Scanner sc;
	private String cmd;

	// constructor
	public Commander(Scanner sc){
		this.sc = sc;
		this.cmd = "";
	}

	@Override
	public void run(){
		while(!this.isInterrupted()){
			cmd = sc.nextLine();
			switch(cmd){
				// help
				case "?":
				case "h":
					help();
					break;
					// stop server
				case "stop server":
					stop_server();
					break;
					// show clients info
				case "show clients":
					show_clients();
					break;
				case "check health":
					check_health();
					break;
					// nothing...
				case "":
					break;
					// unknown command
				default:
					System.out.println("[System][Commander] > Unknown command: " + cmd);
			}
		}
		// end of run
		System.out.println("[System][Commander] > Thread(commandThread) is stopped.");
	}


	// helper
	private void help(){
		System.out.println("[System][Commander] > stop server:\t Stops the server.");
		System.out.println("[System][Commander] > show clients:\t Show information of the client.");
		System.out.println("[System][Commander] > check health:\t Show variables informations.");
	}

	// check variables
	private void check_health(){
		// clients
		System.out.println("[System][Commander] > clients size: "+App.getClients().size());
		// clientsPrintWriter
		System.out.println("[System][Commander] > clientsPrintWriter size: "+App.getClientsPrintWriter().size());
	}

	// show clients
	private void show_clients(){
		// if no clients,
		if(App.getClients().size() == 0){
			System.out.println("[System][Commander] > Nobody in here.");
		}
		// if have clients,
		else{
			int idx = 1;
			for(Socket s : App.getClients().keySet()){
				System.out.println("Client["+idx+"] > PlayerName[" + App.getClients().get(s) + "]\t" + s);
				idx++;
			}
		}
	}

	// stop server
	private void stop_server(){
		System.out.println("[System][Commander] > Server closing...");
		// broadcasting [session/DISCONNECTED] message
		App.broadcast("session/DISCONNECTED");
		// thread stop
		this.interrupt();
		try {
			// listener stop
			App.getServerSocket().close();
			System.out.println("[System][Commander] > ServerSocket(listener) is stopped.");
		} catch (IOException e) {
			System.out.println("[ERROR] > while closing ServerSocket(listener).");
			System.out.println(e.getMessage());
		} finally {
			// sc stop
			sc.close();
			App.getScanner().close();
			System.out.println("[System][Commander] > Scanner(App.sc, Commander.sc) is stopped.");
			// pool stop
			App.getExecutorService().shutdown();
			System.out.println("[System][Commander] > ExecutorService(pool) is terminated.");
		}
	}

} // end of class
