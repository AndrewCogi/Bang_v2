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
	public void help(){
		System.out.println(" stop server: Stops the server.");
		System.out.println(" show clients: Show information of the client.");
	}

	// show clients
	public void show_clients(){
		// if no clients,
		if(App.getClients().size() == 0) System.out.println("[System][Commander] no clients!");
		// if have clients,
		else{
			for(Socket s : App.getClients().keySet()){
				System.out.println("PlayerName[" + App.getClients().get(s) + "] " + s);
			}
		}
	}

	// stop server
	public void stop_server(){
		System.out.println("[System][Commander] > Server closing...");
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
