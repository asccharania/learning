package algs22;
import stdlib.*;
import java.security.SecureRandom;
/* ***********************************************************************
 *  Compilation:  javac SecureShuffle.java
 *  Execution:    java SecureShuffle < list.txt
 *
 *  Reads in a list of strings and prints them in random order.
 *  Our shuffling algorithm guarantees to rearrange the elements
 *  in uniformly random order, under the assumption that Math.random()
 *  generates independent and uniformly distributed numbers between
 *  0 and 1.
 *
 *  % more cards.txt
 *  2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC KC AC
 *  2D 3D 4D 5D 6D 7D 8D 9D 10D JD QD KD AD
 *  2H 3H 4H 5H 6H 7H 8H 9H 10H JH QH KH AH
 *  2S 3S 4S 5S 6S 7S 8S 9S 10S JS QS KS AS
 *
 *  % java Shuffle < cards.txt
 *  6H
 *  9C
 *  8H
 *  7C
 *  JS
 *  ...
 *  KH
 *
 *************************************************************************/

public class XSecureShuffle {
    public static void main(String[] args) {

        // read in the data
        final String[] a = StdIn.readAll().split("\\s+");
        final int N = a.length;

        // create random array of real numbers between 0 and 1
        final SecureRandom random = new SecureRandom();
        final Double[] r = new Double[N];
        for (int i = 0; i < N; i++) {
            r[i] = random.nextDouble();
        }

        // shuffle and get resulting permutation
        final int[] index = Merge.indexSort(r);

        // print permutation
        for (int i = 0; i < N; i++)
            StdOut.println(a[index[i]]);
    }
}
