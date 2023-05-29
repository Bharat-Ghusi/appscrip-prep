package appscripprep.javaprep.general;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

public class ParseUsage {

	public static void main(String[] args) throws ParseException {
//		String age="P15Y9M5D";
//		Period parse = Period.parse(age);
//		System.out.println(parse.getYears());
//		System.out.println(parse.getMonths());
//		System.out.println(parse.getDays());
		
		String str="16/05/2023";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
		Date date = simpleDateFormat.parse(str);
		System.out.println(date);
		
	}

}
