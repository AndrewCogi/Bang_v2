/* 
 * class name: MainCard
 * purpose: have main card (playing card) information
 */

package card;

public class MainCard{
	// card color
	private String cardColor;
	// card name
	private String cardName;
	// card number
	private int cardNumber;
	// card chape
	private char cardShape;

	// constructor
	public MainCard(String cardColor, String cardName, char cardShape, int cardNumber){
		this.cardColor = cardColor;
		this.cardName = cardName;
		this.cardShape = cardShape;
		this.cardNumber = cardNumber;
	}

	// get card color
	public String getCardColor(){
		return cardColor;
	}

	// get card name
	public String getCardName(){
		return cardName;
	}

	// get card shape
	public char getCardShape(){
		return cardShape;
	}

	// get card number
	public int getCardNumber(){
		return cardNumber;
	}
}
