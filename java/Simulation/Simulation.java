package Simulation;

// Written by John Rogers

// Developed during class on Wednesday, April 29th, and
// revised Friday, May 1st.

import java.util.Random;
import stdlib.StdOut;
import algs13.Queue;

public class Simulation {

	public static void main(String[] args) {
		Random r = new Random();
		Queue<Integer> q = new Queue<Integer>();
		
		final int clockLimit = 3600; 
		final int serviceTime = 60;
		
		int timer = 0;
		int totalWaitTime = 0;
		int carCount = 0;
		
		// Run the simulation as long as either the clock has not reached
		// its limit or the queue is not empty.
		for (int second=0; second < clockLimit || !q.isEmpty(); second++) {
			// If we're still under the clock limit, ask
			// "Did a car arrive?"  If so, put its arrival
			// time into the queue.
			if (second < clockLimit) {
				int diceRoll = r.nextInt(60);
				if (diceRoll < 1) { // On average, one car arrives every 60 seconds
					q.enqueue(second);
					carCount++;
				}
			}
			// Is the car wash available?
			if (timer == 0) { // Yes, it's available
				// Is a car waiting to be washed?
				if (!q.isEmpty()) { // Yes, there's a car waiting to be washed
					int arrivalTime = q.dequeue();
					int waitTime = second - arrivalTime;
					totalWaitTime += waitTime;
					timer = serviceTime;
				}
			}
			else { // No, the car wash is not available.
				timer--;
			}
		}
		StdOut.println("Number of cars washed: " + carCount);
		StdOut.println("The average wait time is " + (double) totalWaitTime/carCount);
	}
}
