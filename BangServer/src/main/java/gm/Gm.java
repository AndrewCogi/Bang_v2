/* 
 * class name: Gm
 * purpose: game dealer
 */

package gm;

public class Gm{

	public Gm(){
	}

	// init (setting seat, select role, select scenario, select character)
	public void init(){
		// setting seat
		setting_seat();
		// select role
		select_role();
		// select scenario
		select_scenario();
		// select character
		select_character();
	}

	public void start(){
		System.out.println("[System][Gm] > start Bang.");
		// test
		for(int i=10; i>0; i--){
			System.out.println("[Testing] > Bang end in "+i+"...");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println(e.getMessage());}
		}
		System.out.println("[System][Gm] > end Bang.");
	}

	// setting seat
	private void setting_seat(){

	}

	// select role
	private void select_role(){

	}

	// select scenario
	private void select_scenario(){

	}

	// select_character
	private void select_character(){

	}
}
