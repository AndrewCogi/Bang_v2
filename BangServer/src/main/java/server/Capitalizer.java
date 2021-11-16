/*
 * class name: Capitalizer
 * purpose: main communicator for each client
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import manager.*;

public class Capitalizer implements Runnable{
	// input stream
	private Scanner is;
	// output stream
	private PrintWriter os;
	// session manager
	private SessionManager session;

	// constructor
	public Capitalizer(Socket socket){
		try{
			this.is = new Scanner(socket.getInputStream());
			this.os = new PrintWriter(socket.getOutputStream(), true);
		} catch(IOException e){
			System.out.println("[ERROR] > while initalize stream.");
			System.out.println(e.getMessage());
		}
		session = new SessionManager(socket, os);
		// login = new LoginManager(os);
		// game = new GameManager(os);
	}

	@Override
	public void run(){
		String cmd;
		while(is.hasNextLine()){
			cmd = is.nextLine();
			// session command
			if(cmd.startsWith("session")) session.request(cmd);
		}
	}
}

