package server;

import java.net.Socket;

public class Capitalizer implements Runnable{
	private Socket socket;

	// constructor
	public Capitalizer(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run(){

	}
}

