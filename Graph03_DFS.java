import java.util.*;

public class Graph03_DFS {
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

    public static void DFS(ArrayList<Edge> Graph[], int curr, boolean Visited[]) { // O(V+E)....
        System.out.print(curr + " ");
        Visited[curr] = true;
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (Visited[e.Dest] != true) {
                DFS(Graph, e.Dest, Visited);
            }
        }
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        boolean Visited[] = new boolean[V];
        SetGraph(Graph, V);
        System.out.print("Depth First Search ON THE GRAPH IS ::: ");
        DFS(Graph, 0, Visited);
    }
}
