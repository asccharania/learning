package algs15.perc;
import stdlib.*;

/*

My results using QuickUnionUF:

T=200 N= 45 N^2=  2025 mean=0.593 confidence=[0.589,0.597] time= 0.91 ratio=4.51
T=200 N= 64 N^2=  4096 mean=0.594 confidence=[0.591,0.597] time= 3.52 ratio=3.86
T=200 N= 90 N^2=  8100 mean=0.591 confidence=[0.589,0.593] time=13.62 ratio=3.87
T=200 N=128 N^2= 16384 mean=0.591 confidence=[0.589,0.593] time=55.32 ratio=4.06

My results using QuickFindUF:

T=200 N= 45 N^2=  2025 mean=0.591 confidence=[0.588,0.595] time= 0.29 ratio=3.11
T=200 N= 64 N^2=  4096 mean=0.594 confidence=[0.591,0.597] time= 1.14 ratio=3.91
T=200 N= 90 N^2=  8100 mean=0.592 confidence=[0.589,0.594] time= 4.28 ratio=3.75
T=200 N=128 N^2= 16384 mean=0.593 confidence=[0.591,0.595] time=17.27 ratio=4.03

My results using QuickUnionPathCompressionUF:

T=200 N= 45 N^2=  2025 mean=0.590 confidence=[0.586,0.594] time= 0.11 ratio=2.35
T=200 N= 64 N^2=  4096 mean=0.590 confidence=[0.587,0.593] time= 0.47 ratio=4.18
T=200 N= 90 N^2=  8100 mean=0.592 confidence=[0.590,0.594] time= 1.17 ratio=2.49
T=200 N=128 N^2= 16384 mean=0.594 confidence=[0.592,0.595] time= 3.22 ratio=2.74

My results using UF (Weighted Quick Union):

T=200 N= 45 N^2=  2025 mean=0.595 confidence=[0.591,0.599] time= 0.09 ratio=1.74
T=200 N= 64 N^2=  4096 mean=0.592 confidence=[0.590,0.595] time= 0.20 ratio=2.25
T=200 N= 90 N^2=  8100 mean=0.593 confidence=[0.591,0.596] time= 0.49 ratio=2.50
T=200 N=128 N^2= 16384 mean=0.593 confidence=[0.592,0.595] time= 1.25 ratio=2.55
T=200 N=181 N^2= 32761 mean=0.593 confidence=[0.592,0.594] time= 3.34 ratio=2.68
T=200 N=256 N^2= 65536 mean=0.593 confidence=[0.591,0.594] time= 8.93 ratio=2.67

My results using XWeightedQuickUnionHalvingUF:

T=200 N= 45 N^2=  2025 mean=0.593 confidence=[0.589,0.597] time= 0.07 ratio=1.23
T=200 N= 64 N^2=  4096 mean=0.593 confidence=[0.590,0.596] time= 0.23 ratio=3.34
T=200 N= 90 N^2=  8100 mean=0.591 confidence=[0.589,0.594] time= 0.57 ratio=2.45
T=200 N=128 N^2= 16384 mean=0.592 confidence=[0.590,0.594] time= 1.56 ratio=2.73
T=200 N=181 N^2= 32761 mean=0.592 confidence=[0.590,0.593] time= 4.31 ratio=2.76
T=200 N=256 N^2= 65536 mean=0.594 confidence=[0.593,0.595] time=11.79 ratio=2.74

My results using XWeightedQuickUnionByHeightUF:

T=200 N= 45 N^2=  2025 mean=0.593 confidence=[0.589,0.597] time= 0.08 ratio=1.71
T=200 N= 64 N^2=  4096 mean=0.592 confidence=[0.589,0.595] time= 0.17 ratio=2.23
T=200 N= 90 N^2=  8100 mean=0.593 confidence=[0.591,0.596] time= 0.47 ratio=2.74
T=200 N=128 N^2= 16384 mean=0.592 confidence=[0.590,0.594] time= 1.20 ratio=2.54
T=200 N=181 N^2= 32761 mean=0.593 confidence=[0.592,0.595] time= 3.29 ratio=2.74
T=200 N=256 N^2= 65536 mean=0.592 confidence=[0.591,0.593] time= 9.16 ratio=2.78

My results using XWeightedQuickUnionPathCompressionUF:

T=200 N= 45 N^2=  2025 mean=0.593 confidence=[0.589,0.598] time= 0.07 ratio=0.84
T=200 N= 64 N^2=  4096 mean=0.595 confidence=[0.592,0.598] time= 0.25 ratio=3.41
T=200 N= 90 N^2=  8100 mean=0.590 confidence=[0.588,0.593] time= 0.68 ratio=2.68
T=200 N=128 N^2= 16384 mean=0.592 confidence=[0.590,0.594] time= 1.70 ratio=2.52
T=200 N=181 N^2= 32761 mean=0.592 confidence=[0.590,0.593] time= 4.66 ratio=2.74
T=200 N=256 N^2= 65536 mean=0.593 confidence=[0.591,0.594] time=12.89 ratio=2.77
*/
public class PercolationStats {
    double[] results;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N<=0 || T<=0) throw new IllegalArgumentException();
        this.results = new double[T];

        for (int t=0; t<T; t++) {
            int opened = 0;
            Percolation perc = new Percolation(N);
            while (!perc.percolates()) {
                int i = StdRandom.uniform(N);
                int j = StdRandom.uniform(N);
                if (!perc.isOpen(i, j)) {
                    opened ++;
                    perc.open(i, j);
                }
            }
            results[t] = opened / (double) (N*N);
        }
    }
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean (results); 
    }
    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev (results); 
    }
    // low end of 95% confidence interval
    public double confidenceLow() {
        return StdStats.mean(results) 
                - ((1.96 * StdStats.stddev(results)) 
                        / Math.sqrt(results.length));
    }
    // high end of 95% confidence interval 
    public double confidenceHigh() {
        return StdStats.mean(results) 
                + ((1.96 * StdStats.stddev(results)) 
                        / Math.sqrt(results.length));
    }
    // unit tests for this class
    public static void main(String[] args) {
        final int MIN = 16;
        final int MAX = 200000;
        final int T = 200;
        double time = 0;
        double prev = 0;
        for (int NSquare=MIN; NSquare<=MAX; NSquare+=NSquare) {
            int N = (int) Math.floor (Math.sqrt (NSquare));
            Stopwatch timer = new Stopwatch();
            PercolationStats stats = new PercolationStats(N,T);
            time = timer.elapsedTime ();
            StdOut.printf ("T=%d N=%3d N^2=%6d mean=%5.3f confidence=[%5.3f,%5.3f] time=%5.2f ratio=%3.2f\n", 
                    T, N, N*N, stats.mean(), stats.confidenceLow(), stats.confidenceHigh(), time, time/prev);
            prev = time;
        }
    }
}
