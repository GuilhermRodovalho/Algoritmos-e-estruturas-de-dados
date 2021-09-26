import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {
    public RandomWord() {
        super();
    }
    public static void main(String[] args) {
        double i = 1;
        String winner = "";
        while (!StdIn.isEmpty()) {
            String nome = StdIn.readString();
            if (StdRandom.bernoulli(1/i)) {
                winner = nome;
            }
            i++;
        }
        StdOut.println(winner);
    }
}
