/*
 * class name: App
 * purpose: main App, open ServerSocket & wait clients
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	private static Scanner sc; // Scanner for keyboard input
	private static List<Socket> clients; // List of sockets(clients)
	private static ServerSocket listener; // ServerSocket
	private static ExecutorService pool; // ThreadPool
	private static final int threadPoolNum = 10; // How many threads in pool

	public static void main(String[] args) throws IOException{
		// init
		sc = new Scanner(System.in);
		clients = new ArrayList<>();

		// server start
		System.out.println("[System][App] > Server Start");

		// get port number
		System.out.print("[System][App] > Port required(defult:2222): ");
		int portNum = Integer.parseInt(sc.nextLine());

		// open server socket
		listener = new ServerSocket(portNum);
		System.out.println("[System][App] > ServerSocket is opened (port: " + listener.getLocalPort() + ")");

		// allocate 10 Threads
		pool = Executors.newFixedThreadPool(threadPoolNum);
		System.out.println("[System][App] > Make ThreadPools (" + threadPoolNum + ")");

		// commandThread start
		Commander commandThread = new Commander(sc);
		commandThread.start();

		// client waiting
		System.out.println("[System][App] > Waiting for clients...");
		while(true){
			try{
				// accept connection
				Socket sock = listener.accept();
				// add socket into pool
				Capitalizer cap = new Capitalizer(sock);
				pool.execute(cap);
				// add socket into clients
				clients.add(sock);
				// notify
				System.out.println("\n[Connected] > " + sock);
				System.out.print(">> ");
			} catch(IOException e){
				if(e.getMessage().equals("Socket closed")){
					try{
						System.out.println("[System][App] > waiting for commandThread join...");
						commandThread.join();
					} catch(InterruptedException e1){
						System.out.println("[ERROR] > while commandThread join.");
						System.out.println(e.getMessage());
					} finally{
						// good
						System.out.println("[System][App] > Server successfully closed.");
						System.exit(0);
					}
				}
				else{
					System.out.println("[ERROR] > while accepting listener.");
					System.out.println(e.getMessage());
				}
			}
		}

	}

	public synchronized static ServerSocket getServerSocket(){
		return listener;
	}

	public synchronized static Scanner getScanner(){
		return sc;
	}

	public synchronized static ExecutorService getExecutorService(){
		return pool;
	}

}
