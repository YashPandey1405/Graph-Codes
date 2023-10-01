import java.util.*;

public class Graph13_DijkstraAlgorithm {
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

    static class Pair implements Comparable<Pair> {
        int Vertex;
        int Path;

        public Pair(int v, int p) {
            this.Vertex = v;
            this.Path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.Path - p2.Path;
        }

    }

    public static void SetGraph(ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>(); // Here , We Initialized The ArrayLists.....
        }

        // Edges For Vertex-0 Of The Graph...
        Graph[0].add(new Edge(0, 1, 2));
        Graph[0].add(new Edge(0, 2, 4));

        // Edges For Vertex-1 Of The Graph...
        Graph[1].add(new Edge(1, 2, 1));
        Graph[1].add(new Edge(1, 3, 7));

        // Edges For Vertex-2 Of The Graph...
        Graph[2].add(new Edge(2, 4, 3));

        // Edges For Vertex-3 Of The Graph...
        Graph[3].add(new Edge(3, 5, 1));

        // Edges For Vertex-4 Of The Graph...
        Graph[4].add(new Edge(4, 3, 2));
        Graph[4].add(new Edge(4, 5, 5));

        // Edges For Vertex-5 Of The Graph...

    }

    // Time Complexity Of Dijkstra Algorithm Without PriorityQueues Is O(V^2).......
    // Time Complexity Of Dijkstra Algorithm Witf PQ Is O(V + E(logV)).......

    public static void DijkstraAlgorithm(ArrayList<Edge> Graph[], int src) {
        int Dist[] = new int[Graph.length]; // Dist[i] -> Distance From src to (i).....

        for (int i = 0; i < Graph.length; i++) { // Initialized All Index By Infinity....
            if (i != src) {
                Dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean Visited[] = new boolean[Graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (Visited[curr.Vertex] != true) {
                Visited[curr.Vertex] = true;
                for (int i = 0; i < Graph[curr.Vertex].size(); i++) { // Neighbour Detection.....
                    Edge e = Graph[curr.Vertex].get(i);
                    int u = e.Source, v = e.Dest, wt = e.Weight;
                    // Relaxation Step In Dijkstra's Algorithm.....
                    if (Dist[u] + wt < Dist[v]) { // Updation Case In The Dijkstra Algorithm.....
                        Dist[v] = Dist[u] + wt;
                        pq.add(new Pair(v, Dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < Dist.length; i++) {
            System.out.println("SHORTEST PATH FROM " + src + " TO " + i + " IS ::: " + Dist[i]);
        }
    }

    public static void main(String args[]) {
        int V = 6, src = 0;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        DijkstraAlgorithm(Graph, src);
    }
}