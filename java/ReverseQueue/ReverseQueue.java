package ReverseQueue;

// Patrick Krebs 

import java.util.ArrayList;

import stdlib.StdOut;
import algs13.Queue;

public class ReverseQueue {
	
	public static Queue<Integer> reverseQueue(Queue<Integer> q1) {
		Queue<Integer> q2 = new Queue<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!(q1.isEmpty())){
			int item = q1.dequeue();
			list.add(item);
		} 
		for (int x = list.size() - 1; x > -1; x -= 1){
			q2.enqueue(list.get(x));
		}
		return q2;
	}

	public static void main(String[] args) {
		Queue<Integer> q1 = new Queue<Integer>();
		q1.enqueue(29);
		q1.enqueue(24);
		q1.enqueue(45);
		q1.enqueue(88);
		q1.enqueue(99);
		q1.enqueue(96);
		q1.enqueue(49);
		q1.enqueue(59);
		q1.enqueue(77);
		StdOut.println(q1);
		Queue<Integer> q2 = reverseQueue(q1);
		StdOut.print(q2);

	}
	
}
