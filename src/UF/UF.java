package UF;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);

        // Nothing to do if p and q are already
        // in the same component.

        if (pID == qID) return;

        // Rename p’s component to q’s name or vise versa

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
            count--;
        }


    }


    public static void main(String[] args) {

        // Solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt(); // Read number of sites.
        UF uf = new UF(N); // Initialize N components.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // Read pair to connect.
            if (uf.connected(p, q)) continue; // Ignore if connected.
            uf.union(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.
        }
        StdOut.println(uf.getCount() + " components");
    }
}

