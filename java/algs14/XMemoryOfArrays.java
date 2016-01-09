package algs14;
import stdlib.*;
import utilities.XLinearRegression;
import utilities.XMultipleLinearRegression;
import algs12.Date;
import com.javamex.classmexer.MemoryUtil;
/* ***********************************************************************
 *  Compilation:  javac -cp .:classmexer.jar:jama.jar XMemoryOfArrays.java
 *  Execution:    java  -cp .:classmexer.jar -javaagent:classmexer.jar:jama.jar XMemoryOfArrays
 *  Dependencies: StdOut.java StdRandom.java classmexer.jar jama.jar
 *                LinearRegression.java MultipleLinearRegresssion.java
 *
 *  In eclipse, add
 *    -javaagent:classmexer.jar
 *  under Run -> Run Configurations... -> Arguments -> VM arguments
 *
 *  % java -cp .:classmexer.jar:jama.jar -javaagent:classmexer.jar XMemoryOfArrays
 *  boolean[] array of length N  = 1.00 N + 24.00  (R^2 = 1.000)
 *  char[]    array of length N  = 2.00 N + 24.00  (R^2 = 1.000)
 *  int[]     array of length N  = 4.00 N + 24.00  (R^2 = 1.000)
 *  double[]  array of length N  = 8.00 N + 24.00  (R^2 = 1.000)
 *  array of N null references   = 8.00 N + 24.00  (R^2 = 1.000)
 *  Date                         = 32
 *  Date[] array of length N     = 40.00 N + 24.00  (R^2 = 1.000)
 *  M-by-N int[][] array         = 24.00 + 32.00 M + 0.00 N + 4.00 MN bytes (R^2 = 1.000)
 *  M-by-N double[][] array      = 24.00 + 32.00 M + 0.00 N + 8.00 MN bytes (R^2 = 1.000)
 *
 *************************************************************************/

public class XMemoryOfArrays {

    // boolean array
    public static void booleanArray() {
        final int[] sizes = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };
        final int M = sizes.length;

        final double[] x = new double[M];
        final double[] memory = new double[M];

        for (int i = 0; i < M; i++) {
            final int N = sizes[i];
            final boolean[] a = new boolean[N];
            x[i] = a.length;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XLinearRegression regression = new XLinearRegression(x, memory);
        StdOut.println("boolean[] array of length N  = " + regression);
    }

    // character array
    public static void charArray() {
        final int[] sizes = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };
        final int M = sizes.length;

        final double[] x = new double[M];
        final double[] memory = new double[M];

        for (int i = 0; i < M; i++) {
            final int N = sizes[i];
            final char[] a = new char[N];
            x[i] = a.length;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XLinearRegression regression = new XLinearRegression(x, memory);
        StdOut.println("char[]    array of length N  = " + regression);
    }

    // integer array
    public static void intArray() {
        final int[] sizes = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };
        final int M = sizes.length;

        final double[] x = new double[M];
        final double[] memory = new double[M];

        for (int i = 0; i < M; i++) {
            final int N = sizes[i];
            final int[] a = new int[N];
            x[i] = a.length;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XLinearRegression regression = new XLinearRegression(x, memory);
        StdOut.println("int[]     array of length N  = " + regression);
    }

    // double array
    public static void doubleArray() {
        final int[] sizes = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };
        final int M = sizes.length;

        final double[] x = new double[M];
        final double[] memory = new double[M];

        for (int i = 0; i < M; i++) {
            final int N = sizes[i];
            final double[] a = new double[N];
            x[i] = a.length;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XLinearRegression regression = new XLinearRegression(x, memory);
        StdOut.println("double[]  array of length N  = " + regression);
    }

    // Integer array of null
    public static void nullArray() {
        final int[] sizes = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };
        final int M = sizes.length;

        final double[] x = new double[M];
        final double[] memory = new double[M];

        for (int i = 0; i < M; i++) {
            final int N = sizes[i];
            final Date[] a = new Date[N];
            x[i] = a.length;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XLinearRegression regression = new XLinearRegression(x, memory);
        StdOut.println("array of N null references   = " + regression);
    }

    // Integer array
    public static void DateArray() {
        final int[] sizes = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };
        final int M = sizes.length;

        final double[] x = new double[M];
        final double[] memory = new double[M];

        for (int i = 0; i < M; i++) {
            final int N = sizes[i];
            final Date[] a = new Date[N];
            for (int j = 0; j < N; j++) {
                final int month = 1 + StdRandom.uniform(12);
                final int day   = 1 + StdRandom.uniform(28);
                final int year  = 1900 + StdRandom.uniform(100);
                a[j] = new Date(month, day, year);
            }
            x[i] = a.length;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final Date date = new Date(12, 31, 1999);
        StdOut.println("Date                         = " + MemoryUtil.deepMemoryUsageOf(date));
        final XLinearRegression regression = new XLinearRegression(x, memory);
        StdOut.println("Date[] array of length N     = " + regression);
    }


    // int[][] array
    public static void int2dArray() {
        final int[] sizes1 = {
                64, 128, 192, 256, 320, 384, 448, 512, 576,
                640, 704, 768, 832, 896, 960, 1024
        };

        final int[] sizes2 = {
                64, 64, 64, 384, 384, 384, 96, 96, 96,
                16, 8, 128, 32, 16, 24, 24
        };

        final double[][] x = new double[sizes1.length][4];
        final double[] memory = new double[sizes1.length];

        for (int i = 0; i < sizes1.length; i++) {
            final int M = sizes1[i];
            final int N = sizes2[i];
            final int[][] a = new int[M][N];
            x[i][0] = 1.0;
            x[i][1] = M;
            x[i][2] = N;
            x[i][3] = M*N;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XMultipleLinearRegression regression = new XMultipleLinearRegression(x, memory);
        StdOut.print("M-by-N int[][] array         = ");
        StdOut.printf("%.2f + %.2f M + %.2f N + %.2f MN bytes (R^2 = %.3f)\n",
                regression.beta(0), regression.beta(1), regression.beta(2), regression.beta(3), regression.R2());
    }

    // double[][] array
    public static void double2dArray() {
        final int[] sizes1 = {
                64, 128, 192, 256, 320, 384, 448, 512, 576, 640, 704, 768, 832, 896, 960, 1024
        };

        final int[] sizes2 = {
                64, 64, 64, 384, 384, 384, 96, 96, 96, 16, 8, 128, 32, 16, 24, 24
        };

        final double[][] x = new double[sizes1.length][4];
        final double[] memory = new double[sizes1.length];

        for (int i = 0; i < sizes1.length; i++) {
            final int M = sizes1[i];
            final int N = sizes2[i];
            final double[][] a = new double[M][N];
            x[i][0] = 1.0;
            x[i][1] = M;
            x[i][2] = N;
            x[i][3] = M*N;
            memory[i] = MemoryUtil.deepMemoryUsageOf(a);
        }

        final XMultipleLinearRegression regression = new XMultipleLinearRegression(x, memory);
        StdOut.print("M-by-N double[][] array      = ");
        StdOut.printf("%.2f + %.2f M + %.2f N + %.2f MN bytes (R^2 = %.3f)\n",
                regression.beta(0), regression.beta(1), regression.beta(2), regression.beta(3), regression.R2());
    }


    public static void main(String[] args) {
        booleanArray();
        charArray();
        intArray();
        doubleArray();
        nullArray();
        DateArray();
        int2dArray();
        double2dArray();
    }
}
