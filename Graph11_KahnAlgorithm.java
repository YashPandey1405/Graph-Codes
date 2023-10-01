
//Implementation Of Topological Sort Using BFS Is Known as Kahn's Algorithm......
import java.util.*;

public class Graph11_KahnAlgorithm {
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
            Graph[i] = new ArrayList<>(); // Here , We Initialized The ArrayLists.....
        }

        // Edges For Vertex-0 Of The Graph...

        // Edges For Vertex-1 Of The Graph...

        // Edges For Vertex-2 Of The Graph...
        Graph[2].add(new Edge(2, 3, 1));

        // Edges For Vertex-3 Of The Graph...
        Graph[3].add(new Edge(3, 1, 1));

        // Edges For Vertex-4 Of The Graph...
        Graph[4].add(new Edge(4, 0, 1));
        Graph[4].add(new Edge(4, 1, 1));

        // Edges For Vertex-5 Of The Graph...
        Graph[5].add(new Edge(5, 0, 1));
        Graph[5].add(new Edge(5, 2, 1));
    }

    // Function To Find The In-Degree For Each Vertex Of The Graph....
    public static void Calculate_InDegree(ArrayList<Edge> Graph[], int InDegg[]) {
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph[i].size(); j++) {
                Edge e = Graph[i].get(j);
                InDegg[e.Dest]++;
            }
        }
    }

    public static void TopSort_BFS(ArrayList<Edge> Graph[]) { // O(V+E).....
        int InDegg[] = new int[Graph.length];
        Queue<Integer> q = new LinkedList<>();
        Calculate_InDegree(Graph, InDegg);

        for (int i = 0; i < Graph.length; i++) { // Add Those Vertex Which Has Degree=0 in The Queue....
            if (InDegg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < Graph[curr].size(); i++) {
                Edge e = Graph[curr].get(i);
                InDegg[e.Dest]--;
                if (InDegg[e.Dest] == 0) {
                    q.add(e.Dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        System.out.print("THE TOPOLOGICAL SORT OF THE GRAPH IS ::: ");
        TopSort_BFS(Graph);
    }
}
