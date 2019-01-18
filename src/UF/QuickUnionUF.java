package UF;

public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N) {
        count = N;
        // set id of each object to itself (N array accesses)
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

    }
// chase parent pointers until reach root (depth of i array accesses)
    private int root(int i){
        while(1 != id[i]) i = id[i];
        return i;
    }
// check if p and  have same root (depth of p and q array accesses)
    public boolean connected (int p,int q){
        return root(p) == root (q);
    }
// change root of p to point to root of q (depth of p and q array accesses)
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;

    }




}

