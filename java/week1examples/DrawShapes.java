package week1examples;

import stdlib.*;

public class DrawShapes {
	public static void main(String[] args) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.01);
		StdDraw.square(.5, .5, .5);
		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledCircle(.7, .65, .25);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.line(.5, .5, .9, .5);
		StdDraw.line(.9, .5, .5, .8);
		StdDraw.line(.5, .8, .5, .5);
	}
}
