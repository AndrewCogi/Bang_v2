/*
 * class name: Capitalizer
 * purpose: main communicator for each client
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import debug.DateTime;
import manager.*;

public class Capitalizer implements Runnable{
	// socket
	private Socket socket;
	// input stream
	private Scanner is;
	// output stream
	private PrintWriter os;
	// login manager
	private LoginManager login;

	// constructor
	public Capitalizer(Socket socket){
		try{
			this.socket = socket;
			this.is = new Scanner(socket.getInputStream());
			this.os = new PrintWriter(socket.getOutputStream(), true);
		} catch(IOException e){
			System.out.println("[ERROR] > while initalize stream.");
			System.out.println(e.getMessage());
		}
		login = new LoginManager(socket, os);
		// game = new GameManager(os);
	}

	@Override
	public void run(){
		// IMPORTANT!: DO NOT STOP!
		// until session is over!
		String cmd;
		while(is.hasNextLine()){
			cmd = is.nextLine();
			// login command
			if(cmd.startsWith("login")) login.request(cmd);
		}
		// if Capitalizer is end.
		disconnected();
	}

	// disconnected process method
	private void disconnected(){
		// send [session/DISCONNECTED] message
		// client: stop client side app
		os.println("session/DISCONNECTED");
		DateTime.showTime();
		System.out.println("[DISCONNECTED] > PlayerName["+server.App.getClients().get(socket)+"] "+socket);
		// remove this socket in clients
		server.App.getClients().remove(socket);
	}
}

