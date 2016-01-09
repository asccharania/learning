package algs11;
public class XNumberTest2 {
    public static void main (String[] args) {
        {
            final double d = -1e-256;
            final double e = +1e+256;
            System.out.println (e / d);
        }
        {
            final double d = -0;
            final double e = +0;
            System.out.println (d);
            System.out.println (e);
        }
        {
            final double d = Double.longBitsToDouble (0x8000000000000000L);
            final double e = Double.longBitsToDouble (0x0000000000000000L);
            System.out.println (d);
            System.out.println (e);

            System.out.println (d == 0); // true (uses dcmp instruction)
            System.out.println (0 == e); // true (uses dcmp instruction)
            System.out.println (d == e); // true (uses dcmp instruction)
        }
        {
            final Double d = Double.longBitsToDouble (0x8000000000000000L);
            final Double e = Double.longBitsToDouble (0x0000000000000000L);
            System.out.println (d);
            System.out.println (e);

            System.out.println (d == 0); // true  (uses dcmp instruction)
            System.out.println (0 == e); // true  (uses dcmp instruction)
            System.out.println (d == e); // false (uses acmp instruction) Why?
        }
    }
}
