import edu.princeton.cs.algs4.StdIn;


public class Permutation {
    public static void main(String[] args) {
        
        if (args.length > 0) {
            int qtd = Integer.parseInt(args[0]);
            
            RandomizedQueue<String> randq = new RandomizedQueue<>();

            while (!StdIn.isEmpty()) {
                String str = StdIn.readString();
                randq.enqueue(str);
            }

            while (!randq.isEmpty() && qtd > 0) {
                System.out.println(randq.dequeue());
                qtd--;
            }
        }
    }
}
