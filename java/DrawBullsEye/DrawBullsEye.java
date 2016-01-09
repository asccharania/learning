package DrawBullsEye;

// Written by Patrick Krebs 

import stdlib.*;

public class DrawBullsEye {

	public static void main(String[] args) {
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledCircle(.5, .5, .5 );
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(.5, .5, .375);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(.5, .5, .25 );
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(.5, .5, .125 );
	}

}
