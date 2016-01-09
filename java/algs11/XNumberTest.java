package algs11;
import stdlib.*;
public class XNumberTest {

    public static void main (String[] args) {
        StdOut.printf("pos inf %016x\n", Double.doubleToLongBits(Double.POSITIVE_INFINITY));
        StdOut.printf("neg inf %016x\n", Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
        StdOut.printf("nan     %016x\n", Double.doubleToLongBits(Double.NaN));
        StdOut.printf("nan     %016x\n", Double.doubleToLongBits(Double.POSITIVE_INFINITY+Double.NEGATIVE_INFINITY));
        StdOut.printf("0       %016x\n", Double.doubleToLongBits(0));
        StdOut.printf("-0      %016x\n", Double.doubleToLongBits(-0));
        StdOut.printf("-0      %016x\n", Double.doubleToLongBits(Double.parseDouble("-0")));


        final double x1 = 0.0;
        double y1 = -0.0;
        final Double a1 = x1, b1 = y1;
        StdOut.printf("x1 %016x\n", Double.doubleToLongBits(x1));
        StdOut.printf("y1 %016x\n", Double.doubleToLongBits(y1));
        StdOut.println(x1 == y1);
        StdOut.println(a1.equals(b1));

        //  The following line of code sets x to 0 if x==0
        if (y1 == 0.0f) y1 = 0.0f;
        StdOut.printf("y1 %016x\n", Double.doubleToLongBits(y1));


        final double x2 = 0.0/0.0, y2 = 0.0/0.0;
        StdOut.printf("x2 %016x\n", Double.doubleToLongBits(x2));
        StdOut.printf("y2 %016x\n", Double.doubleToLongBits(y2));
        final Double a2 = x2, b2 = y2;
        StdOut.println(x2 == y2);
        StdOut.println(a2.equals(b2));
    }

}
