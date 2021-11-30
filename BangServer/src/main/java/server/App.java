/*
 * class name: App
 * purpose: main App, open ServerSocket & wait clients
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debug.DateTime;

public class App {
	private static Scanner sc; // Scanner for keyboard input
	private static HashMap<Socket,String> clients; // Map of socket-clientName
	private static List<PrintWriter> clientsPrintWriter; // list of clients' PrintWriter
	private static ServerSocket listener; // ServerSocket
	private static ExecutorService pool; // ThreadPool
	private static final int threadPoolNum = 10; // How many threads in pool
	private static int accessAttempt = 0; // How many times access atteption

	public static void main(String[] args) throws IOException{
		// init
		sc = new Scanner(System.in);
		clients = new HashMap<>();
		clientsPrintWriter = new ArrayList<>();

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

		// client waiting
		System.out.println("[System][App] > Waiting for clients...");
		System.out.println("[System][App] > 'h' or '?' for help.");

		// commandThread start
		Commander commandThread = new Commander(sc);
		commandThread.start();

		while(true){
			try{
				// accept connection
				Socket sock = listener.accept();
				// add socket into pool
				Capitalizer cap = new Capitalizer(sock,(getAccessAttempt()+1));
				pool.execute(cap);
				// add socket into clients
				clients.put(sock,"Unknown_"+(getAccessAttempt()+1));
				// accessAttempt ++
				accessAttempt++;
				// notify
				DateTime.showTime();
				System.out.println("[CONNECTED] > "+sock);
			} catch(IOException e){
				// listener is stopped
				if(e.getMessage().equals("Socket closed")){
					try{
						System.out.println("[System][App] > waiting for commandThread join...");
						commandThread.join();
						System.out.println("[System][App] > Thread(commandThread) is stopped confirm.");
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

	public synchronized static HashMap<Socket,String> getClients(){
		return clients;
	}

	public synchronized static List<PrintWriter> getClientsPrintWriter(){
		return clientsPrintWriter;
	}

	public synchronized static void broadcast(String cmd){
		for(PrintWriter os : getClientsPrintWriter()){
			os.println(cmd);
		}
	}

	// get player number
	public synchronized static int getPlayerNumber(){
		int num = 0;
		for(String s : getClients().values()){
			if(!s.startsWith("Unknown")) num++;
		}
		return num;
	}

	// get accessAttempt
	public synchronized static int getAccessAttempt(){
		return accessAttempt;
	}
}
