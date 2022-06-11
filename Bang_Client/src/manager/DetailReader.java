package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DetailReader {
	public static Scanner scn;
	
	public static String getDetail(String dir) {
		// connect file
		try {scn = new Scanner(new File(dir),"UTF-8");} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());}
		// get contents
		String cardName = scn.nextLine();
		scn.nextLine();
		String cardExp = scn.nextLine();
		// make string
		StringBuilder detail = new StringBuilder();
		detail.append("<html><body style='text-align:center;'>"+cardName+"<br /><br />"+cardExp+"</body></html>");
		return detail.toString();
	}
}
