public class Graph19_UnionSet_DS {
    static int n = 8;
    static int Parent[] = new int[n];
    static int Rank[] = new int[n];

    public static void Initialize() {
        for (int i = 0; i < n; i++) {
            Parent[i] = i;
            Rank[i] = 0;
        }
    }

    public static int Find(int x) { // O(k)......
        if (x == Parent[x]) { // Supreme Node......
            return x;
        }
        Parent[x] = Find(Parent[x]); // Path Compression Optimization.....
        return Parent[x];
    }

    public static void Union(int x, int y) { // O(4k) --> O(k)....
        int Par_X = Find(x);
        int Par_Y = Find(y);
        if (Rank[Par_X] == Rank[Par_Y]) {
            Parent[Par_Y] = Par_X;
            Rank[Par_X]++;
        } else if (Rank[Par_X] < Rank[Par_Y]) {
            Parent[Par_X] = Par_Y;
        } else {
            Parent[Par_Y] = Par_X;
        }
    }

    public static void main(String args[]) {
        Initialize();
        Union(1, 3);
        Union(2, 4);
        Union(3, 6);
        Union(1, 4);
        Union(1, 5);
        // System.out.println(Find(3));
        // System.out.println(Find(4));
        // System.out.println(Find(3));
        System.out.print("Parent[] --> ");
        for (int i = 0; i < n; i++) {
            System.out.print(Parent[i] + " ");
        }
        System.out.println();
        System.out.print("Rank[]   --> ");
        for (int i = 0; i < n; i++) {
            System.out.print(Rank[i] + " ");
        }
    }
}
