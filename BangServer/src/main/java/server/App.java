package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) throws IOException{
		// server start
		System.out.println("Server Start");

		// open server socket
		ServerSocket listener = new ServerSocket(2222);;

		// allocate 20 Threads
		ExecutorService pool = Executors.newFixedThreadPool(20);

		// commands
		new Thread(new Runnable(){
			public void run(){
				Scanner sc = new Scanner(System.in);
				String cmd;
				while(true){
					cmd = sc.nextLine();
					switch(cmd){
						// stop server
						case "/stop":
							System.out.println("Server closing...");
							sc.close();
							try{
								listener.close();
							} catch(IOException e){
								System.out.println("[ERROR] while closing...");
								System.out.println(e.getMessage());
							}
							break;
					}
				}
			}
		}).start();
		// client waiting
		while(true){
			Socket sock = listener.accept();
			Capitalizer cap = new Capitalizer(sock);
			pool.execute(cap);
			System.out.println("[Connected] > "+ sock);
		}

	}
}
