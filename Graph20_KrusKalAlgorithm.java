import java.util.*;

public class Graph20_KrusKalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int Source;
        int Dest;
        int Weight;

        public Edge(int s, int d, int w) {
            this.Source = s;
            this.Dest = d;
            this.Weight = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.Weight - e2.Weight;
        }
    }

    public static void SetGraph(ArrayList<Edge> Graph) {

        // For Vertex-0 Of The Graph.....
        Graph.add(new Edge(0, 1, 10));
        Graph.add(new Edge(0, 2, 15));
        Graph.add(new Edge(0, 3, 30));

        // For Vertex-1 Of The Graph.....
        Graph.add(new Edge(1, 0, 10));
        Graph.add(new Edge(1, 3, 40));

        // For Vertex-2 Of The Graph.....
        Graph.add(new Edge(2, 0, 15));
        Graph.add(new Edge(2, 3, 50));

        // For Vertex-3 Of The Graph.....
        Graph.add(new Edge(3, 0, 30));
        Graph.add(new Edge(3, 1, 40));
        Graph.add(new Edge(3, 2, 50));

    }

    static int n = 4;
    static int Parent[] = new int[n];
    static int Rank[] = new int[n];

    public static void Initialize() { // Function To Initialize The Above Static Arrays.....
        for (int i = 0; i < n; i++) {
            Parent[i] = i;
            Rank[i] = 0;
        }
    }

    public static int Find(int x) { // O(k).....
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

    // Time Complexity Of KrusKal's Algorithm Is O( V + (E*log(E)) ).....
    public static void KrusKal_Algo(ArrayList<Edge> Graph, int V) {
        Collections.sort(Graph); // O( E*log(E) ).....
        int MST_Cost = 0;
        int count = 0;
        for (int i = 0; count < (V - 1); i++) {
            Edge e = Graph.get(i);
            int Par1 = Find(e.Source);
            int Par2 = Find(e.Dest);
            // if (Par1==Par2) , Then , Simply continue For The Next Edges....
            if (Par1 != Par2) {
                Union(e.Source, e.Dest);
                MST_Cost += e.Weight;
                count++;
            }
        }
        System.out.println("THE COST TP TRAVERSE MST IS ::: " + MST_Cost);
    }

    public static void main(String args[]) {
        Initialize();
        int V = 4;
        ArrayList<Edge> Graph = new ArrayList<>();
        SetGraph(Graph);
        KrusKal_Algo(Graph, V);
    }
}
