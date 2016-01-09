package algs14;

import stdlib.*;
import algs13.ResizingArrayStack;
import algs13.XResizingSlowStack;

public class XTestResizingStacks {
    public static double timeTrial1(int N) {
        ResizingArrayStack<Object> stack = new ResizingArrayStack<>();
        final Stopwatch sw = new Stopwatch();
        for (int j=0; j<N; j++)
            stack.push (null);
        return sw.elapsedTime();
    }
    public static double timeTrial2(int N) {
        XResizingSlowStack<Object> stack = new XResizingSlowStack<>();
        final Stopwatch sw = new Stopwatch();

        for (int j=0; j<N; j++)
            stack.push (null);
        return sw.elapsedTime();
    }


    public static void main(String[] args) {
        final int MAXSIZE = 32768000;
//        {
//            double prev = timeTrial1(125);
//            for (int N = 250; N <= MAXSIZE; N += N) {
//                final double time = timeTrial1(N);
//                StdOut.printf("1: %8d %7.1f %5.1f\n", N, time, time/prev);
//                prev = time;
//            }
//        }
        {
            double prev = timeTrial2(125);
            for (int N = 250; N <= MAXSIZE; N += N) {
                final double time = timeTrial2(N);
                StdOut.printf("2: %8d %7.1f %5.1f\n", N, time, time/prev);
                prev = time;
            }
        }
    }
}
