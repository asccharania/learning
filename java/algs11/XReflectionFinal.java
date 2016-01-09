package algs11;
import java.lang.reflect.*;

// see http://stackoverflow.com/questions/3301635/change-private-static-final-field-using-java-reflection
public class XReflectionFinal {
    static void makeAccessible (Field field) throws Exception {
        field.setAccessible (true);

        final Field modifiersField = Field.class.getDeclaredField ("modifiers");
        modifiersField.setAccessible (true);
        modifiersField.setInt (field, field.getModifiers () & ~Modifier.FINAL);
    }
    public static void main (String args[]) throws Exception {
        final Field fFalse = Boolean.class.getField ("FALSE");
        makeAccessible (fFalse);
        fFalse.set (null, true);
        System.out.printf ("false is %s\n", false); // "false is true"

        final Field fValue = Integer.class.getDeclaredField ("value");
        makeAccessible (fValue);
        final Integer x = Integer.valueOf (5);
        fValue.setInt (x, 4);
        System.out.printf ("x is %s\n", x); // "x is 4"

        final Integer y = Integer.valueOf (5);
        System.out.printf ("y is %s\n", y); // "y is 4"
    }
}
