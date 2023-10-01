import java.util.*;

public class Graph14_BellmanFordAlgorithm {
    static class Edge {
        int Source;
        int Dest;
        int Weight;

        public Edge(int s, int d, int w) {
            this.Source = s;
            this.Dest = d;
            this.Weight = w;
        }
    }

    public static void SetGraph(ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        // For Vertex-0 Of The Graph.....
        Graph[0].add(new Edge(0, 1, 2));
        Graph[0].add(new Edge(0, 2, 4));

        // For Vertex-1 Of The Graph.....
        Graph[1].add(new Edge(1, 2, -4));

        // For Vertex-2 Of The Graph.....
        Graph[2].add(new Edge(2, 3, 2));

        // For Vertex-3 Of The Graph.....
        Graph[3].add(new Edge(3, 4, 4));

        // For Vertex-4 Of The Graph.....
        Graph[4].add(new Edge(4, 1, -1));
    }

    // Time Complexity Of Bellman Ford Algorithm Is O(V*E).......
    public static void BellmanFordAlgo(ArrayList<Edge> Graph[], int src) {
        int Dist[] = new int[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            if (i != src) {
                Dist[i] = Integer.MAX_VALUE;
            }
        }
        int VertexCount = Graph.length;

        // Actual Loops For Bellman Ford Algorithm.....

        // 1st Loop Will Have O(V) As It Runs For O(V-1)=O(V) Times....
        // 2nd & 3rd Loop Combined Have O(E) As It Runs For O(E) Times....
        // Thus , Bellman Ford Algorithm Runs For O(V*E)......
        for (int i = 0; i < (VertexCount - 1); i++) {
            // Time Complexity Of Below 2 Loop Combined Is O(E).....
            for (int j = 0; j < Graph.length; j++) {
                for (int k = 0; k < Graph[j].size(); k++) {
                    Edge e = Graph[j].get(k);
                    int u = e.Source, v = e.Dest, wt = e.Weight;
                    // In Java , ((+Infinity) + SomeValue) --> Negative Value.....
                    // In Java , ((-Infinity) - SomeValue) --> Positive Value.....
                    if (Dist[u] != Integer.MAX_VALUE && Dist[u] + wt < Dist[v]) { // Relaxation Step.....
                        Dist[v] = Dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < Dist.length; i++) {
            System.out.println("SHORTEST PATH FROM " + src + " TO " + i + " IS ::: " + Dist[i]);
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        BellmanFordAlgo(Graph, 0);
    }
}