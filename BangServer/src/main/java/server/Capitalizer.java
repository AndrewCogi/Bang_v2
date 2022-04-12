/*
 * class name: Capitalizer
 * purpose: main communicator for each client
 */
package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
	// session manager
	private SessionManager session;
	// game manager
	private GameManager game;

	// constructor
	public Capitalizer(Socket socket, int attemptNum){
		try{
			this.socket = socket;
			this.is = new Scanner(socket.getInputStream(),"UTF-8");
			this.os = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")), true);
		} catch(IOException e){
			System.out.println("[ERROR] > while initalize stream.");
			System.out.println(e.getMessage());
		}
		// manager init
		login = new LoginManager(socket, os, attemptNum);
		session = new SessionManager(is, os);
		game = new GameManager(os);
	}

	@Override
	public void run(){
		// IMPORTANT!: DO NOT STOP!
		// until session is over!
		String cmd;
		while(is.hasNextLine()){
			cmd = is.nextLine();
			// GET ALL COMMAND
			System.out.println("[System][Capitalizer]{GET} > "+cmd);
			// login command
			if(cmd.startsWith("login")) login.request(cmd);
			// session command
			if(cmd.startsWith("session")) session.request(cmd);
			// game command
			if(cmd.startsWith("game")) game.request(cmd);
		}
		// if Capitalizer is end.
		disconnected();
	}

	// disconnected process method
	private void disconnected(){
		DateTime.showTime();
		System.out.println("[DISCONNECTED] > PlayerName["+server.App.getClients().get(socket)+"] "+socket);
		// remove this socket in clients
		server.App.getClients().remove(socket);
		// remove this os in clientsPrintWriter
		server.App.getClientsPrintWriter().remove(os);
		// broadcasting
		server.App.broadcast("player/PLAYERNUM/"+server.App.getPlayerNumber());
	}
}

