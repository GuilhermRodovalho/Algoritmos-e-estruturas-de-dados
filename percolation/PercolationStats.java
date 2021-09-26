import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    private static final double CALC = 1.96;

    private final double[] xs; // this is used to calculate the standard deviation, because it uses the result of each iteration of the percolations.
    private final int numberOfTrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        
        this.xs = new double[trials];
        this.numberOfTrials = trials;

        for (int i = 0; i < trials; i++) {
            double result = 0;
            int openSites = 0;
            Percolation perc = new Percolation(n);

            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);

                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                    openSites++;
                }

            }
            result = (double) openSites / (n*n);

            xs[i] = result;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(xs);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(xs);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        double s = stddev();

        double res = mean - ((CALC*s)/Math.sqrt(numberOfTrials));

        return res;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        double s = stddev();

        double res = mean + ((CALC*s)/Math.sqrt(numberOfTrials));

        return res;
    }

   // test client (see below)
    public static void main(String[] args) {
        if (args.length == 2) {
            int n = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);

            PercolationStats stats = new PercolationStats(n, trials);

            StdOut.printf("mean                    = %f\n", stats.mean());
            StdOut.printf("stddev                  = %f\n", stats.stddev());
            
            System.out.printf("95%% confidence interval = [%f, %f]\n", stats.confidenceLo(), stats.confidenceHi());
            
        }


    }

}
