import java.util.*;

public class Graph04_HasPathProblem {
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

    public static void SetGraph(ArrayList<Edge> Graph[], int V) {
        for (int i = 0; i < V; i++) {
            Graph[i] = new ArrayList<>(); // Initialized ArrayList Of Each index Of Array Graph.....
        }
        // Edges For Vertex-0 Of The Graph...
        Graph[0].add(new Edge(0, 1, 1));
        Graph[0].add(new Edge(0, 2, 1));

        // Edges For Vertex-1 Of The Graph...
        Graph[1].add(new Edge(1, 0, 1));
        Graph[1].add(new Edge(1, 3, 1));

        // Edges For Vertex-2 Of The Graph...
        Graph[2].add(new Edge(2, 0, 1));
        Graph[2].add(new Edge(2, 4, 1));

        // Edges For Vertex-3 Of The Graph...
        Graph[3].add(new Edge(3, 1, 1));
        Graph[3].add(new Edge(3, 4, 1));
        Graph[3].add(new Edge(3, 5, 1));

        // Edges For Vertex-4 Of The Graph...
        Graph[4].add(new Edge(4, 2, 1));
        Graph[4].add(new Edge(4, 3, 1));
        Graph[4].add(new Edge(4, 5, 1));

        // Edges For Vertex-5 Of The Graph...
        Graph[5].add(new Edge(5, 3, 1));
        Graph[5].add(new Edge(5, 4, 1));
        Graph[5].add(new Edge(5, 6, 1));

        // Edges For Vertex-6 Of The Graph...
        Graph[6].add(new Edge(6, 5, 1));
    }

    // Time Complexity Of HasPath() Function Is O(V+E).......
    public static boolean HasPath(ArrayList<Edge> Graph[], int src, int dest, boolean Visited[]) {
        if (src == dest) {
            return true;
        }
        Visited[src] = true;
        for (int i = 0; i < Graph[src].size(); i++) {
            Edge e = Graph[src].get(i);
            // boolean hasPath = HasPath(Graph, e.Dest, Dest, Visited);
            if ((Visited[e.Dest] != true) && (HasPath(Graph, e.Dest, dest, Visited))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        boolean Visited[] = new boolean[V];
        SetGraph(Graph, V);
        boolean ans = HasPath(Graph, 0, 6, Visited);
        System.out.println("PATH FROM VERTEX-0 TO VERTEX-5 IN THE GRAPH :::" + ans);
    }
}