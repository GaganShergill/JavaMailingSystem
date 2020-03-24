package gagan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Returns the current date in the "yyyy/MM/dd HH:mm:ss" form.
 */
public class Formatter {

	public static String getcurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
