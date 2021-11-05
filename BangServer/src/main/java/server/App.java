/*
 * class name: App
 * purpose: get command & manage socket
 */
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
		System.out.println("[System] > Server Start");

		// open server socket
		ServerSocket listener = new ServerSocket(2222);
		System.out.println("[System] > ServerSocket is opened (port: " + listener.getLocalPort() + ")");

		// allocate 10 Threads
		int threadPoolNum = 10;
		ExecutorService pool = Executors.newFixedThreadPool(threadPoolNum);
		System.out.println("[System] > Make ThreadPools (10)");

		// client waiting
		Thread waiter = new Thread(new Runnable(){
			public void run(){
				while(!Thread.interrupted()){
					try{
						// accept connection
						Socket sock = listener.accept();
						// add socket into pool
						Capitalizer cap = new Capitalizer(sock);
						pool.execute(cap);
						System.out.println("\n[Connected] > " + sock);
						System.out.print(">> ");
					} catch(IOException e){
						// if thead is stopped
						if(Thread.interrupted() == true) {
							System.out.println("[System] > Thread(socket) stopped.");
							break;
						}
						// else accept error occured
						else{
							System.out.println("[ERROR] > while accepting listener.");
							System.out.println(e.getMessage());
						}
					}
				}
			}
		});
		// thread start
		waiter.start();

		// command
		while(true){
			Scanner sc = new Scanner(System.in);
			String cmd;
			while(true){
				System.out.print(">> ");
				cmd = sc.nextLine();
				switch(cmd){
					// stop server
					case "stop":
						System.out.println("[System] > Server closing...");
						try{
							// Scanner & listener & Thread stop
							sc.close();
							System.out.println("[System] > Scanner(sc) stopped.");
							listener.close();
							System.out.println("[System] > ServerSocket(listener) stopped.");
							waiter.interrupt();
							System.out.println("[System] > Thread(waiter) interrupted.");
							// System exit
							System.exit(0);
						} catch(IOException e){
							System.out.println("[ERROR] > while closing server.");
							System.out.println(e.getMessage());
						}
						break;
					// nothing..
					case "":
						break;
					// unknown command
					default:
						System.out.println("[System] > Unknown command: " + cmd);
				}
			}
		}
	}
}
