/*
 * class name: Session
 * purpose: check clients' socket is alive(closed).
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Session extends Thread{
	private Scanner is;
	private PrintWriter os;
	private Socket socket;
	public Session(Socket socket){
		this.socket = socket;
		try{
			this.is = new Scanner(socket.getInputStream());
			this.os = new PrintWriter(socket.getOutputStream(), true);
		} catch(IOException e){
			System.out.println("[ERROR] > while initalize stream.");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run(){
		while(true){
			os.println("test");
			System.out.println("[System][Session] > Sending test...");
			try{
				Thread.sleep(2000);
			} catch(InterruptedException e){}
		}
	}
	 
}
