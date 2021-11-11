/* 
 * class name: Commander
 * purpose: command management
 *
 */
package server;

import java.io.IOException;
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
			showCommandLine();
			cmd = sc.nextLine();
			switch(cmd){
				// stop server
				case "stop":
					stop_server();
					break;
				// nothing...
				case "":
					break;
				// unknown command
				default:
					System.out.println("[System][Commander] > Unknown command: " + cmd);
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

	// show command line interface
	public void showCommandLine(){
		System.out.print(">> ");
	}

} // end of class
