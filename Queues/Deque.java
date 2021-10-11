import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    private class Node {
        Item content;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (this.size == 0 && first == null) {
            return true;
        }
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node newnode = new Node();
        newnode.content = item;
        newnode.next = this.first;
        this.first = newnode;

        if (size == 0)
            this.last = newnode;

        size++;
    }

    // needs a fix
    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node newnode = new Node();
        newnode.content = item;
        newnode.next = null;

        if (isEmpty()) {
            this.first = newnode;
        } else {
            this.last.next = newnode;
        }
        this.last = newnode;

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item item = this.first.content;
        this.first = this.first.next;
        size--;
        return item;
    }

    // remove and return the item from the back
    // node -> node -> node -> node -> node -> null;
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (size == 1) {
            Item it = this.first.content;
            this.first = null;
            this.last = null;
            size--;
            return it;
        }

        Node auxNode = this.first;

        while (auxNode.next.next != null) {
            auxNode = auxNode.next;
        }
        Item item = this.last.content;
        auxNode.next = null;
        this.last = auxNode;

        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null)
                throw new NoSuchElementException();

            Item item = current.content;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> myDeq = new Deque<>();

        if (myDeq.isEmpty())
            System.out.println("The deck is empty");

        myDeq.addLast(13);
        myDeq.addFirst(15);
        myDeq.addLast(22);
        myDeq.addFirst(42);

        if (myDeq.isEmpty())
            System.out.println("The deck is empty");

        int aux = myDeq.removeFirst();
        System.out.println(aux);
        aux = myDeq.removeLast();
        System.out.println(aux);

        int size = myDeq.size();
        System.out.println(size);

        myDeq.addLast(1);
        myDeq.addLast(4);
        myDeq.addLast(2);
        myDeq.addLast(8);
        myDeq.addFirst(90);

        if (myDeq.size() == 6)
            System.out.println("o tamanho é 6");

        for (Integer integer : myDeq) {
            System.out.println(integer);
        }

        myDeq.removeFirst();
        myDeq.removeFirst();
        myDeq.removeFirst();
        myDeq.removeFirst();
        myDeq.removeFirst();
        myDeq.removeFirst();

        if (myDeq.isEmpty())
            System.out.println("The deck is empty");
    }
}
