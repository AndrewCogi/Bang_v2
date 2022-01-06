package timer;

import javax.swing.JOptionPane;

public class SessionTimer extends Thread{
	// TTL timer
	private int timer;
	
	public SessionTimer() {
		this.timer = 0;
	}
	
	@Override
	public void run() {
		while(getTimer() < 10) {
			// timer++
			setTimer(getTimer()+1);
			// wait 1 sec
			try{Thread.sleep(1000);} catch(InterruptedException e) {}
		}
		// if you here, timeout disconnected.
		JOptionPane.showMessageDialog(null, "Timeout Disconnected.","Notice",JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
	// set timer
	public synchronized void setTimer(int time) {
		this.timer = time;
	}
	// get timer
	public synchronized int getTimer() {
		return timer;
	}
}
