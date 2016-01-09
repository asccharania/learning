package PrintCalendar;

// Patrick Krebs 


import stdlib.StdIn;
import stdlib.StdOut;
import algs12.Date; 

public class PrintCalendar {

	public static void main(String[] args) {

		StdOut.print("Enter a Start Date: ");
		Date date1 = new Date(StdIn.readString());
		
		StdOut.print("Enter an End Date: ");
		Date date2 = new Date(StdIn.readString());
	
		
		int lineCount = 0;
		
		while (date1.isBefore(date2.next())) {
			StdOut.print(date1);
			StdOut.print('\t');
			date1 = date1.next();
			lineCount += 1;
			if (lineCount == 7){
				StdOut.println();
				lineCount = 0;}
		}
	}
};
