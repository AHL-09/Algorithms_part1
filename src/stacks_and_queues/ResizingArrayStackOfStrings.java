package stacks_and_queues;



public class ResizingArrayStackOfStrings<Item> {
    String[] s;
    int N; //increment in push
    //decrement in pop

    public ResizingArrayStackOfStrings() {
        s = new String[1];

    }

    public void push(String item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
        System.out.println("N is "+ N);
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4)
            resize(s.length / 2);
        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];

        }
        s = copy;
    }






}


