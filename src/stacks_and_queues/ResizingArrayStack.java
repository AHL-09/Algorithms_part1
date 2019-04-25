package stacks_and_queues;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // stack items
    private int N = 0;                         // number of items
    //decrement in pop

    public ResizingArrayStack() {
        a = (Item[]) new Object[1];

    }

    public void push(Item item) {
        // Add item to top of stack.
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
        System.out.println("N is " + N);
    }

    public Item pop() {
        // Remove item from top of stack.
        Item item = a[--N];
        a[N] = null; //Avoid loitering
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    private void resize(int capacity) {
        // Move stack to new array of size capacity.
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = a[i];

        }
        a = copy;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // Support LIFO iteration.
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public void remove() { /* not supported */
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}