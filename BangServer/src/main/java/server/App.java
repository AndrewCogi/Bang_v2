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
		// Scanner for input keyboard input
		Scanner sc = new Scanner(System.in);
		// server start
		System.out.println("[System] > Server Start");

		// open server socket
		System.out.print("Port required(defult:2222): ");
		int portNum = Integer.parseInt(sc.nextLine());
		ServerSocket listener = new ServerSocket(portNum);
		System.out.println("[System] > ServerSocket is opened (port: " + listener.getLocalPort() + ")");

		// allocate 10 Threads
		int threadPoolNum = 10;
		ExecutorService pool = Executors.newFixedThreadPool(threadPoolNum);
		System.out.println("[System] > Make ThreadPools (" + threadPoolNum + ")");

		// client waiting
		Thread waiter = new Thread(new Runnable(){
			public void run(){
				// notify
				System.out.println("[System] > Waiting for clients...");
				while(true){
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
							System.out.println("[System] > Thread(waiter) stopped.");
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

		// waiting until thread start
		try{Thread.sleep(500);} catch(InterruptedException e){
			System.out.println("[ERROR] > while waiting thread(waiter) start.");
			System.out.println(e.getMessage());
		}

		// command
		String cmd;
		while(true){
			System.out.print(">> ");
			cmd = sc.nextLine();
			switch(cmd){
				// stop server
				case "stop":
					System.out.println("[System] > Server closing...");
					try{
						// Scanner & listener & Thread & pool stop
						sc.close();
						System.out.println("[System] > Scanner(sc) is stopped.");
						listener.close();
						System.out.println("[System] > ServerSocket(listener) is stopped.");
						waiter.interrupt();
						System.out.println("[System] > Thread(waiter) is interrupted.");
						pool.shutdown();
						System.out.println("[System] > ExecutorService(pool) is terminated.");

						// stop server
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
