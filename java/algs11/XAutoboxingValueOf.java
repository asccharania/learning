package algs11;
public class XAutoboxingValueOf {
    public static String concat(String s, String t) {
        return (s + t);
    }
    public static void main (String[] args) {
        {
            System.out.print ("\nString Dog:    ");
            final String x1 = "Dog";
            final String x2 = "Dog";
            final String x3 = new String ("Dog");
            final String x4 = new String ("Dog");

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final String x3i = x3.intern ();
            final String x4i = x4.intern ();
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nString ...:    ");
            final String x1 = "Antidisestablishmentarianism";
            final String x2 = "Antidisestablishmentarianism";
            final String x3 = new String ("Antidisestablishmentarianism");
            final String x4 = new String ("Antidisestablishmentarianism");

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final String x3i = x3.intern ();
            final String x4i = x4.intern ();
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nString + :     ");
            final String x1 = "hi" + "mom";
            final String x2 = "hi" + "mom";
            final String x3 = new String ("hi" + "mom");
            final String x4 = new String ("hi" + "mom");

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final String x3i = x3.intern ();
            final String x4i = x4.intern ();
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nString concat: ");
            final String x1 = concat ("hi", "mom");
            final String x2 = concat ("hi", "mom");
            final String x3 = new String (concat ("hi", "mom"));
            final String x4 = new String (concat ("hi", "mom"));

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final String x3i = x3.intern ();
            final String x4i = x4.intern ();
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nCharacter a:   ");
            final Character x1 = 'a';
            final Character x2 = 'a';
            final Character x3 = new Character ('a');
            final Character x4 = new Character ('a');

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final Character x3i = Character.valueOf (x3);
            final Character x4i = Character.valueOf (x4);
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nCharacter \u13A7:   ");
            final Character x1 = '\u13A7';
            final Character x2 = '\u13A7';
            final Character x3 = new Character ('\u13A7');
            final Character x4 = new Character ('\u13A7');

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final Character x3i = Character.valueOf (x3);
            final Character x4i = Character.valueOf (x4);
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nInteger 0:     ");
            final Integer x1 = 0;
            final Integer x2 = 0;
            final Integer x3 = new Integer (0);
            final Integer x4 = new Integer (0);

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final Integer x3i = Integer.valueOf (x3);
            final Integer x4i = Integer.valueOf (x4);
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nInteger 12:    ");
            final Integer x1 = Integer.valueOf(12);
            final Integer x2 = Integer.valueOf(12);
            final Integer x3 = new Integer (12);
            final Integer x4 = new Integer (12);

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final Integer x3i = Integer.valueOf (x3);
            final Integer x4i = Integer.valueOf (x4);
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nInteger 13297: ");
            final Integer x1 = 13297;
            final Integer x2 = 13297;
            final Integer x3 = new Integer (13297);
            final Integer x4 = new Integer (13297);

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final Integer x3i = Integer.valueOf (x3);
            final Integer x4i = Integer.valueOf (x4);
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
        {
            System.out.print ("\nDouble 0.0:    ");
            final Double x1 = 0.0;
            final Double x2 = 0.0;
            final Double x3 = new Double (0);
            final Double x4 = new Double (0);

            System.out.format ("%-5b ", x1 == x2);
            System.out.format ("%-5b ", x1 == x3);
            System.out.format ("%-5b ", x3 == x4);

            final Double x3i = Double.valueOf (x3);
            final Double x4i = Double.valueOf (x4);
            System.out.format ("%-5b ", x1 == x3i);
            System.out.format ("%-5b ", x3i == x4i);
        }
    }
}
