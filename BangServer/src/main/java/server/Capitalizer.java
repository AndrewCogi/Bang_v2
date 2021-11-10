package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Capitalizer implements Runnable{
	// input stream
	private InputStream is;
	// output stream
	private OutputStream os;
	// socket
	private Socket socket;

	// constructor
	public Capitalizer(Socket socket){
		this.socket = socket;
		try{
			this.is = socket.getInputStream();
			this.os = socket.getOutputStream();
		} catch(IOException e){
			System.out.println("[ERROR] > while initalize stream.");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run(){

	}
}

