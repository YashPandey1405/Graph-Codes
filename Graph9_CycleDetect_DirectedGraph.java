import java.util.*;

public class Graph9_CycleDetect_DirectedGraph {
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
        Graph[0].add(new Edge(0, 2, 1));

        // For Vertex-1 Of The Graph.....
        Graph[1].add(new Edge(1, 0, 1));

        // For Vertex-2 Of The Graph.....
        Graph[2].add(new Edge(2, 3, 1));

        // For Vertex-3 Of The Graph.....
        Graph[3].add(new Edge(3, 0, 1));
    }

    public static boolean isCycle_DirectedGraph(ArrayList<Edge> Graph[]) { // O(V+E)..........
        boolean Visited[] = new boolean[Graph.length];
        boolean Stacks[] = new boolean[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            if (Visited[i] != true) {
                if (isCycle_DirectedGraphUtil(Graph, i, Visited, Stacks)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle_DirectedGraphUtil(ArrayList<Edge> Graph[], int curr, boolean Visited[],
            boolean Stacks[]) {
        Visited[curr] = true;
        Stacks[curr] = true;
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (Stacks[e.Dest]) { // Condition For Existance Of Cycle In The Graph.........
                return true;
            }
            if (Visited[e.Dest] != true && (isCycle_DirectedGraphUtil(Graph, e.Dest, Visited, Stacks))) {
                return true;
            }
        }
        Stacks[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        boolean ans = isCycle_DirectedGraph(Graph);
        System.out.println("CYCLE EXISTS IN THE GIVEN DIRECTED GRAPH ::: " + ans);
    }
}