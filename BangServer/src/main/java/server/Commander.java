package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class Commander implements Runnable{
	private Scanner sc;
	private String cmd;

	// constructor
	public Commander(Scanner sc){
		this.sc = sc;
		this.cmd = "";
	}

	@Override
	public void run(){
		while(true){
			showCommandLine();
			cmd = sc.nextLine();
			switch(cmd){
				// stop server
				case "stop":
					this.stop();
					break;
				// nothing...
				case "":
					break;
				// unknown command
				default:
					System.out.println("[System] > Unknown command: " + cmd);
			}
		}
	} // end of method(run)

	// stop server
	public void stop(){
		System.out.println("[System] > Server closing...");
		try{
			// Scanner & listener & pool stop
			App.getScanner().close();
			System.out.println("[System] > Scanner(sc) is stopped.");
			App.getServerSocket().close();
			System.out.println("[System] > ServerSocket(listener) is stopped.");
			App.getExecutorService().shutdown();
			System.out.println("[System] > ExecutorService(pool) is terminated.");
			// stop server
			System.exit(0);
		} catch(IOException e){
			System.out.println("[ERROR] > while closing server.");
			System.out.println(e.getMessage());
		}
	} // end of method(stop)

	// show command line interface
	public void showCommandLine(){
		System.out.print(">> ");
	}

} // end of class
