package ui;

import javax.swing.JButton;

public class Select_button extends JButton{
	private static final long serialVersionUID = 1L;
	// card name
	private String name;
	// card number (of character hp)
	private int num;
	// card shape
	private char shape;
	// card color
	private String color;
	
	// constructor
	public Select_button() {}
	
	// constructor
	public Select_button(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	// constructor (playing card)
	public Select_button(String color, String name, char shape, int num) {
		this.color = color;
		this.name = name;
		this.shape = shape;
		this.num = num;
	}
	
	// get name
	public String getName() {
		return name;
	}
	
	// get number
	public int getNum() {
		return num;
	}
	
	// get shape
	public char getShape() {
		return shape;
	}
	
	// get color
	public String getColor() {
		return color;
	}
}