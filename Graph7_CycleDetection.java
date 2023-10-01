import java.util.*;

public class Graph7_CycleDetection {
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
        Graph[0].add(new Edge(0, 3, 1));

        // Edges For Vertex-1 Of The Graph...
        Graph[1].add(new Edge(1, 0, 1));
        Graph[1].add(new Edge(1, 2, 1));

        // Edges For Vertex-2 Of The Graph...
        Graph[2].add(new Edge(2, 0, 1));
        Graph[2].add(new Edge(2, 1, 1));
        Graph[2].add(new Edge(2, 4, 1));

        // Edges For Vertex-3 Of The Graph...
        Graph[3].add(new Edge(3, 0, 1));

        // Edges For Vertex-4 Of The Graph...
        Graph[4].add(new Edge(4, 2, 1));
    }

    public static boolean DetectCycle(ArrayList<Edge> Graph[]) {
        boolean Visited[] = new boolean[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            if (Visited[i] != true) {
                if (DetectCycleUtil(Graph, Visited, i, -1)) { // Cycle Exists.....
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DetectCycleUtil(ArrayList<Edge> Graph[], boolean Visited[], int curr, int par) {
        Visited[curr] = true;
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);

            // Case-3. Of The Explination.....
            if (Visited[e.Dest] != true) {
                if ((DetectCycleUtil(Graph, Visited, e.Dest, curr))) {
                    return true;
                }
            }

            // Case-1. Of The Explination.....
            else if (Visited[e.Dest] == true && e.Dest != par) {
                return true;
            }

            // Case-2. Of The Explination --> Do Nothing , Just Continue Traversal.....
        }
        return false;
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph, V);
        boolean ans = DetectCycle(Graph);
        System.out.print("DOES GRAPH CONTAINS AN CYCLE ::: " + ans);
    }
}
