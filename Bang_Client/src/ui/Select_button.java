package ui;

import javax.swing.JButton;

public class Select_button extends JButton{
	private static final long serialVersionUID = 1L;
	// button name
	private String name;
	// button number (of character hp)
	private int num;
	
	// constructor
	public Select_button(String nameNum) {
		String[] spliter = nameNum.split("/");
		this.name = spliter[0];
		this.num = Integer.parseInt(spliter[1]);
	}
	
	// get name
	public String getName() {
		return name;
	}
	
	// get number
	public int getNum() {
		return num;
	}
}