/* 
 * class name: Commander
 * purpose: command management
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Commander extends Thread{
	// Scanner for command
	private Scanner sc;
	// command info
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
					// game start!
				case "game start":
					game_start();
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

	// game start!
	private void game_start(){
		// if game is already started,
		if(App.getGameStarted() == true){
			System.out.println("[System][Commander] > Game is already started.");
			return;
		}
		// if not in 7 players,
		if(App.getClientsPrintWriter().size() != 7){
			System.out.println("[System][Commander] > We don't have enough players. (now: "+App.getClientsPrintWriter().size()+"/7)");
			return;
		}
		// broadcast game is begin
		for(int cnt=5; cnt>0; cnt--){
			System.out.println("[System][Commander] > Game start in "+cnt+"...");
			App.broadcast("game/GAMESTART/"+cnt);
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println("[ERROR] > while count down."); return;}
		}
		System.out.println("[System][Commander] > Game start!");
		// game start == true
		App.setGameStarted(true);
	}


	// helper
	private void help(){
		System.out.println("[System][Commander] > stop server:\t Stops the server.");
		System.out.println("[System][Commander] > show clients:\t Show information of the client.");
		System.out.println("[System][Commander] > game start:\t Start game.");
	}

	// show online & logined clients
	private void show_clients(){
		// if no clients,
		if(App.getClients().size() == 0){
			System.out.println("[System][Commander] > Nobody in here.");
			return;
		}
		System.out.println("[System][Commander] > =======Log on Clients=======");
		// online clients,
		int idx = 0;
		for(Socket s : App.getClients().keySet()){
			if(!App.getClientsPrintWriter().containsValue(App.getClients().get(s))){
				System.out.println("[System][Commander] > "+s);
				idx++;
			}
		}
		// no online clients,
		if(idx == 0) System.out.println("[System][Commander] > Nobody in here.");

		// ingame clients,
		idx = 0;
		System.out.println("[System][Commander] > =======Log in Clients=======");
		for(String s : App.getClientsPrintWriter().values()){
			System.out.println("[System][Commander] > PlayerName ["+s+"]");
			idx++;
		}
		// no ingame clients,
		if(idx == 0) System.out.println("[System][Commander] > Nobody in here.");
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
