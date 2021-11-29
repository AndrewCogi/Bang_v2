/*
 * class name: DateTime
 * purpose: show serverlog time
 */

package debug;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime{
	private static Date date;
	private static SimpleDateFormat formatter;

	// constructor: not used
	public DateTime(){
	}

	public static void showTime(){
		date = new Date();
		formatter = new SimpleDateFormat("[HH:mm:ss]");
		System.out.print(formatter.format(date));
	}

}
