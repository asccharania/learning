package utilities;
import stdlib.StdOut;
import Jama.Matrix;
import Jama.QRDecomposition;

/* ***********************************************************************
 *  Compilation:  javac -classpath jama.jar:. MultipleLinearRegression.java
 *  Execution:    java  -classpath jama.jar:. MultipleLinearRegression
 *  Dependencies: jama.jar
 *
 *  Compute least squares solution to X beta = y using Jama library.
 *  Assumes X has full column rank.
 *
 *       http://math.nist.gov/javanumerics/jama/
 *       http://math.nist.gov/javanumerics/jama/Jama-1.0.1.jar
 *
 *************************************************************************/

public class XMultipleLinearRegression {
    private final int N;        // number of
    //private final int p;        // number of dependent variables
    private final Matrix beta;  // regression coefficients
    private final double SSE;         // sum of squared
    private double SST;         // sum of squared

    public XMultipleLinearRegression(double[][] x, double[] y) {
        if (x.length != y.length) throw new RuntimeException("dimensions don't agree");
        N = y.length;
        //p = x[0].length;

        final Matrix X = new Matrix(x);

        // create matrix from vector
        final Matrix Y = new Matrix(y, N);

        // find least squares solution
        final QRDecomposition qr = new QRDecomposition(X);
        beta = qr.solve(Y);


        // mean of y[] values
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum += y[i];
        final double mean = sum / N;

        // total variation to be accounted for
        for (int i = 0; i < N; i++) {
            final double dev = y[i] - mean;
            SST += dev*dev;
        }

        // variation not accounted for
        final Matrix residuals = X.times(beta).minus(Y);
        SSE = residuals.norm2() * residuals.norm2();

    }

    public double beta(int j) {
        return beta.get(j, 0);
    }

    public double R2() {
        return 1.0 - SSE/SST;
    }

    public static void main(String[] args) {
        final double[][] x = { {  1,  10,  20 },
                {  1,  20,  40 },
                {  1,  40,  15 },
                {  1,  80, 100 },
                {  1, 160,  23 },
                {  1, 200,  18 } };
        final double[] y = { 243, 483, 508, 1503, 1764, 2129 };
        final XMultipleLinearRegression regression = new XMultipleLinearRegression(x, y);

        StdOut.printf("%.2f + %.2f beta1 + %.2f beta2  (R^2 = %.2f)\n",
                regression.beta(0), regression.beta(1), regression.beta(2), regression.R2());
    }
}

