package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import manager.InputManager;
import ui.UI;

public class App {
	private static Socket socket; // socket for connection
	private static Scanner is; // input stream
	private static PrintWriter os; // output stream
	private static InputManager im; // manage client's input
	public static UI u; // main UI
	
	public static void main(String[] args) throws IOException{
		// init
		socket = new Socket("58.127.238.25",2222);
		is = new Scanner(socket.getInputStream(),"UTF-8");
		os = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")),true);
		
		// login
		String[] loginResult = new String[] {"login","PLAYERNAME","FALSE",""};
		String reason = "(Not allowed blank)";
		while(true) {
			// popup
			String id = (String) JOptionPane.showInputDialog(null,"Enter ID "+reason,"Bang! the board game - login",
					JOptionPane.INFORMATION_MESSAGE,new ImageIcon(".\\.\\resources\\icon\\bang_100.png"),null,"");
			// cancel
			if(id == null) System.exit(0);
			// trimming id
			id = id.trim();
			// prevent empty name
			if(id.equals("")) {
				reason = "(Not allowed blank)";
				continue;
			}
			// prevent 'Unknown~' name
			if(id.startsWith("Unknown")) {
				reason = "(Not allowed name 'Unknown~')";
				continue;
			}
			// prevent too long name
			if(id.length() > 10) {
				reason = "(Too long name. Up to 10 characters)";
				continue;
			}
			
			// send result
			os.println("login/PLAYERNAME/"+id);
			System.out.println("[App][send/App]: "+"login/PLAYERNAME/"+id);
			// login/PLAYERNAME/TRUE
			// login/PLAYERNAME/FALSE/[reason]
			String result = is.nextLine();
			loginResult = result.split("/");
			System.out.println("[get/App]: "+result);
			
			// if login failed, show reason
			if(loginResult[2].equals("FALSE")) {
				reason = " ("+loginResult[3]+")";
			}
			// if login successed, init UI, inputManager
			else {
				im = new InputManager(is,os,id);
				u = new UI(id,os);
				break;
			}
		}
		
		// if you here, login success!
		u.setVisible(true);
		
		// waiting server input
		while(is.hasNextLine()) {
			String cmd = is.nextLine();
			im.request(cmd);
		}
	}
}
