
//We Will Apply Topological Sort On Direced Acyclic Graph(DAG) Using Modified DFS Approach...........
import java.util.*;

public class Graph10_TopologicalSorting_DFS {
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

        // For Vertex-1 Of The Graph.....

        // For Vertex-2 Of The Graph.....
        Graph[2].add(new Edge(2, 3, 1));

        // For Vertex-3 Of The Graph.....
        Graph[3].add(new Edge(3, 1, 1));

        // For Vertex-4 Of The Graph.....
        Graph[4].add(new Edge(4, 0, 1));
        Graph[4].add(new Edge(4, 1, 1));

        // For Vertex-3 Of The Graph.....
        Graph[5].add(new Edge(5, 0, 1));
        Graph[5].add(new Edge(5, 2, 1));
    }

    public static void TopologicalSort(ArrayList<Edge> Graph[]) { // O(V+E)..........
        boolean Visited[] = new boolean[Graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < Graph.length; i++) {
            if (Visited[i] != true) {
                TopologicalSortutil(Graph, i, Visited, s);
            }
        }
        System.out.print("TOPOLOGICAL SORT OF THE GRAPH IS ::: ");
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void TopologicalSortutil(ArrayList<Edge> Graph[], int curr, boolean Visited[], Stack<Integer> s) {
        Visited[curr] = true;
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (Visited[e.Dest] != true) {
                TopologicalSortutil(Graph, e.Dest, Visited, s);
            }
        }
        s.push(curr);
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        TopologicalSort(Graph);
    }
}
