package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DetailReader {
	public static Scanner sc;
	
	public static String getDetail(String dir) {
		// connect file
		try {sc = new Scanner(new File(dir));} catch (FileNotFoundException e) {System.out.println(e.getMessage());}
		// get contents
		String cardName = sc.nextLine();
		sc.nextLine();
		String cardExp = sc.nextLine();
		// make string
		StringBuilder detail = new StringBuilder();
		detail.append("<html><body style='text-align:center;'>"+cardName+"<br /><br />"+cardExp+"</body></html>");
		return detail.toString();
	}
}
