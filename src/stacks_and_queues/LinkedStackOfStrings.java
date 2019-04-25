package stacks_and_queues;

public class LinkedStackOfStrings {
    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    private class Node {
        String item;
        Node next;
    }
}
