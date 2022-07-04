/*
 * class name: App
 * purpose: main App, open ServerSocket & wait clients
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debug.DateTime;
import gm.Gm;

public class App {
	private static Scanner sc; // Scanner for keyboard input
	private static HashMap<Socket,String> clients; // Map of socket-clientName in public
	private static HashMap<PrintWriter,String> clientsPrintWriter; // Map of clients' PrintWriter & name in public
	private static ServerSocket listener; // ServerSocket
	private static ExecutorService pool; // ThreadPool
	private static final int threadPoolNum = 10; // How many threads in pool
	private static int accessAttempt = 0; // How many times access attempt
	private static boolean gameStarted = false; // Check game is started
	private static int loginPw; // login password (6-digits)
	private static int startPw; // game start password (6-digits)
	private static Gm gm; // game dealer

	public static void main(String[] args) throws IOException{
		// init
		sc = new Scanner(System.in);
		clients = new HashMap<>();
		clientsPrintWriter = new HashMap<>();
		gm = new Gm();
		
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

		// make passwords
		do{
			loginPw = make_pw();
			startPw = make_pw();
		} while(loginPw == startPw);

		// show password
		System.out.println("[System][App] > Login password is ["+loginPw+"]");
		System.out.println("[System][App] > Start password is ["+startPw+"]");

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

	// set gameStarted
	public synchronized static void setGameStarted(boolean b){
		gameStarted = b;
	}

	// get gameStarted
	public synchronized static boolean getGameStarted(){
		return gameStarted;
	}

	// get gm
	public synchronized static Gm getGm(){
		return gm;
	}

	// get listener
	public synchronized static ServerSocket getServerSocket(){
		return listener;
	}

	// get sc
	public synchronized static Scanner getScanner(){
		return sc;
	}

	// get pool
	public synchronized static ExecutorService getExecutorService(){
		return pool;
	}

	// get clients
	public synchronized static HashMap<Socket,String> getClients(){
		return clients;
	}

	// get clientsPrintWriter
	public synchronized static HashMap<PrintWriter,String> getClientsPrintWriter(){
		return clientsPrintWriter;
	}

	// broadcast
	public synchronized static void broadcast(String cmd){
		for(PrintWriter os : getClientsPrintWriter().keySet()){
			os.println(cmd);
		}
	}

	// broadcast without id
	public synchronized static void broadcast_without(String id, String cmd){
		for(PrintWriter os : getClientsPrintWriter().keySet()){
			if(getClientsPrintWriter().get(os).equals(id)) continue;
			os.println(cmd);
		}
	}

	// broadcast to id
	public synchronized static void broadcast_within(String id, String cmd){
		for(PrintWriter os : getClientsPrintWriter().keySet()){
			if(getClientsPrintWriter().get(os).equals(id)){ os.println(cmd); break; }
		}
	}
	
	// get player number
	public synchronized static int getPlayerNumber(){
		return getClientsPrintWriter().size();
	}

	// get accessAttempt
	public synchronized static int getAccessAttempt(){
		return accessAttempt;
	}

	// get login password
	public static int getLoginPw(){
		return loginPw;
	}

	// get start password
	public static int getStartPw(){
		return startPw;
	}

	// reset login password
	public static void resetPw(String target){
		if(target.equals("login")) loginPw = make_pw();
		else if(target.equals("start")) startPw = make_pw();
	}

	// making password
	public static int make_pw(){
		// until get 6-digit code
		int newPw = -1;
		do{
			Random generator = new Random();
			generator.setSeed(System.currentTimeMillis());
			newPw = generator.nextInt(1000000)%1000000;
		} while(newPw < 100000);
		return newPw;
	}
}
