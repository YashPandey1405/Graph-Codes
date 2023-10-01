import java.util.*;

public class Graph8_BipartitrGraph {
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

        // Edges For Vertex-1 Of The Graph...
        Graph[0].add(new Edge(1, 2, 1));
        Graph[0].add(new Edge(1, 5, 1));

        // Edges For Vertex-2 Of The Graph...
        Graph[1].add(new Edge(2, 1, 1));
        Graph[1].add(new Edge(2, 3, 1));

        // Edges For Vertex-3 Of The Graph...
        Graph[2].add(new Edge(3, 2, 1));
        Graph[2].add(new Edge(3, 4, 1));

        // Edges For Vertex-4 Of The Graph...
        Graph[3].add(new Edge(4, 3, 1));
        Graph[3].add(new Edge(4, 5, 1));

        // Edges For Vertex-5 Of The Graph...
        Graph[4].add(new Edge(5, 1, 1));
        Graph[4].add(new Edge(5, 4, 1));
    }

    public static boolean isBipartite(ArrayList<Edge> Graph[]) { // O(V+E).....
        int col[] = new int[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            col[i] = (-1); // Initialized Each Element Of Array Colour By (-1).....
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < Graph.length; i++) {
            if (col[i] == (-1)) { // Now We Will Perform BFS Here...
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < Graph[curr].size(); j++) {
                        Edge e = Graph[curr].get(i);
                        if (col[e.Dest] == (-1)) { // Case-3. Of The Logic...
                            int NextCol = col[curr] == 0 ? 1 : 0;
                            col[e.Dest] = NextCol;
                            q.add(e.Dest);
                        } else if (col[e.Dest] == col[curr]) { // Case-1. Of The Logic...
                            return false;
                        }
                        // Case-2. Where We Will Carry Loop To Further Iterations.....
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph, V);
        boolean ans = isBipartite(Graph);
        System.out.println("THE GRAPH IS AN BI-PARTITE GRAPH ::: " + ans);
    }
}
