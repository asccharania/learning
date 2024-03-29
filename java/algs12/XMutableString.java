package algs12;
import stdlib.*;
import java.lang.reflect.Field;
/* ***********************************************************************
 *  Compilation:  javac MutableString.java
 *  Execution:    java MutableString
 *
 *  Shows that Strings are mutable if you allow reflection.
 *
 *************************************************************************/

public class XMutableString {

    public static void main(String[] argv) {
        final String s = "Immutable";
        final String t = "Notreally";

        mutate(s, t);
        StdOut.println(t);

        // strings are interned so this doesn't print "Immutable"
        StdOut.println("Immutable");
    }

    // change the first min(|s|, |t|) characters of s to t
    public static void mutate(String s, String t) {
        try {
            final Field val = String.class.getDeclaredField("value");
            final Field off = String.class.getDeclaredField("offset");
            val.setAccessible(true);
            off.setAccessible(true);
            final int offset   = off.getInt(s);
            final char[] value = (char[]) val.get(s);
            for (int i = 0; i < Math.min(s.length(), t.length()); i++)
                value[offset + i] = t.charAt(i);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

}
