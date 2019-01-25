/******************************************************************************
 * Dependencies: StdIn.java StdOut.java
 * Data files:   tobe.txt
 *
 * An abstract data type for a fixed-capacity generic stack
 *
 ******************************************************************************/

package stacks_and_queues;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}
