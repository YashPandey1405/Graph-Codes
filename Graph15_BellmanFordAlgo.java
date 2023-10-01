//Both Previous Bellman Ford Algorithm Implementaion And This Method Is Same....
//In This Method , We Will Use 'Arraylist<Edge>' Instead Of 'ArrayList<Edge> Array[]'.....
//Time Complexity Of SetGraph Function Of Both Method Is Also Same.....

import java.util.*;

public class Graph15_BellmanFordAlgo {
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

    public static void SetGraph_MethodII(ArrayList<Edge> Graph) {

        // For Vertex-0 Of The Graph.....
        Graph.add(new Edge(0, 1, 2));
        Graph.add(new Edge(0, 2, 4));

        // For Vertex-1 Of The Graph.....
        Graph.add(new Edge(1, 2, -4));

        // For Vertex-2 Of The Graph.....
        Graph.add(new Edge(2, 3, 2));

        // For Vertex-3 Of The Graph.....
        Graph.add(new Edge(3, 4, 4));

        // For Vertex-4 Of The Graph.....
        Graph.add(new Edge(4, 1, -1));
    }

    // Time Complexity Of Bellman Ford Algorithm Is O(V*E).......
    public static void BellmanFordAlgo_MethodII(ArrayList<Edge> Graph, int src, int Vertex) {
        int Dist[] = new int[Vertex];
        for (int i = 0; i < Vertex; i++) {
            if (i != src) {
                Dist[i] = Integer.MAX_VALUE;
            }
        }

        // Actual Loops For Bellman Ford Algorithm.....

        // 1st Loop Will Have O(V) As It Runs For O(V-1)=O(V) Times....
        // 2nd Loop Has O(E) As It Runs For O(E) Times....
        // Thus , Bellman Ford Algorithm Runs For O(V*E)......
        for (int i = 0; i < (Vertex - 1); i++) {
            // Time Complexity Of Below Loop Is O(E).....
            for (int j = 0; j < Graph.size(); j++) {
                Edge e = Graph.get(j);
                int u = e.Source, v = e.Dest, wt = e.Weight;
                // In Java , ((+Infinity) + SomeValue) --> Negative Value.....
                // In Java , ((-Infinity) - SomeValue) --> Positive Value.....
                if (Dist[u] != Integer.MAX_VALUE && Dist[u] + wt < Dist[v]) { // Relaxation Step.....
                    Dist[v] = Dist[u] + wt;
                }
            }
        }
        for (int i = 0; i < Dist.length; i++) {
            System.out.println("SHORTEST PATH FROM " + src + " TO " + i + " IS ::: " + Dist[i]);
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph = new ArrayList<>();
        SetGraph_MethodII(Graph);
        BellmanFordAlgo_MethodII(Graph, 0, V);
    }
}