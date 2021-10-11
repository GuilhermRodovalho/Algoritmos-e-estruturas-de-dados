import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] values;
    private int size;
    private int capacity;


    // construct an empty randomized queue
    public RandomizedQueue() {
        this.values = (Item[]) new Object[1];
        this.capacity = 1;
        this.size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (size == capacity) {
            capacity = capacity * 2; 
            
            Item[] newarr = (Item[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newarr[i] = this.values[i];
            }            
            this.values = newarr;
        }
        this.values[size++] = item;
    }

    // need to thow an exception IMPORTANTEEEE
    // remove and return a random item
    public Item dequeue() {
        
        int pos = StdRandom.uniform(size);

        Item swap = this.values[pos];
        this.values[pos] = this.values[size-1];
        this.values[size-1] = null;
        size--;

        if (size < capacity / 3) {
            Item[] item = (Item[]) new Object[capacity/3];
            
            for (int i = 0; i < size; i++) {
                item[i] = values[i];
            }
            this.values = item;

            this.capacity = capacity/3;
        }
        
        return swap;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return values[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private int innerSize; 
        private Item[] innerValues;

        public ListIterator() {
            this.innerSize = size;
            this.innerValues = values;
        }

        @Override
        public boolean hasNext() {
            return innerSize > 0;
        }

        @Override
        public Item next() {
            if (innerSize < 0) 
                throw new NoSuchElementException();
            
            int pos = StdRandom.uniform(innerSize);
            Item swap = innerValues[pos];
            innerValues[pos] = innerValues[innerSize-1];
            innerValues[innerSize-1] = swap;
            innerSize--;

            return swap;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        
        RandomizedQueue<Integer> randq = new RandomizedQueue<>();

        randq.enqueue(14);
        randq.dequeue();
        randq.enqueue(15);
        randq.dequeue();

        randq.enqueue(14);
        randq.enqueue(17);
        randq.enqueue(29);
        randq.enqueue(109);

        System.out.println(randq.isEmpty());
        System.out.println(randq.size());
        System.out.println(randq.sample());
        System.out.println(randq.dequeue());

        System.out.println();

        for (Integer inte : randq) {
            System.out.println(inte);
        }

        System.out.println();

        randq.enqueue(55);

        for (Integer inte : randq) {
            System.out.println(inte);
        }

        System.out.println();

        System.out.println(randq.dequeue());
        System.out.println(randq.dequeue());
        System.out.println(randq.dequeue());
        System.out.println(randq.dequeue());
    }
}
