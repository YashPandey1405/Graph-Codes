
/*

--> Articulation Point/Vertex Is An Vertex In An Undirected Connected Graphh.....
--> Removal Of Articulation Point And The Connected Edges Through The Articulation Point
Increases The Connected Components Of The Graph......
--> We Will Use Tarjan's Algorithm To Find Articulation Point In An Undirected Graph.....

*/
import java.util.*;

public class Graph25_ArticulationPoint {
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

        // For Vertex-0 Of The Graph.......
        Graph[0].add(new Edge(0, 1, 1));
        Graph[0].add(new Edge(0, 2, 1));
        Graph[0].add(new Edge(0, 3, 1));

        // For Vertex-1 Of The Graph.......
        Graph[1].add(new Edge(1, 0, 1));
        Graph[1].add(new Edge(1, 2, 1));

        // For Vertex-2 Of The Graph.......
        Graph[2].add(new Edge(2, 0, 1));
        Graph[2].add(new Edge(2, 1, 1));

        // For Vertex-3 Of The Graph.......
        Graph[3].add(new Edge(3, 0, 1));
        Graph[3].add(new Edge(3, 4, 1));

        // For Vertex-4 Of The Graph.......
        Graph[4].add(new Edge(4, 3, 1));

    }

    public static void DFS(ArrayList<Edge> Graph[], int curr, int Par, int DiscTime[], int Lowest[], boolean Visited[],
            int Time, boolean AP[]) {
        Visited[curr] = true;
        DiscTime[curr] = Lowest[curr] = ++Time;
        int Children = 0;

        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            int Neigh = e.Dest;
            if (Neigh == Par) {
                continue;
            } else if (Visited[Neigh] == true) {
                Lowest[curr] = Math.min(Lowest[curr], DiscTime[Neigh]);
            } else {
                DFS(Graph, Neigh, curr, DiscTime, Lowest, Visited, Time, AP);
                Lowest[curr] = Math.min(Lowest[curr], Lowest[Neigh]);
                if (Par != (-1) && DiscTime[curr] <= Lowest[Neigh]) {
                    AP[curr] = true;
                    // System.out.println("VERTEX-" + curr + " IS Articulation Point FOR GIVEN
                    // UNDIRECTED GRAPH");
                }
                Children++;
            }
        }

        if (Par == (-1) && Children > 1) {
            AP[curr] = true;
            // System.out.println("VERTEX-" + curr + " IS Articulation Point FOR GIVEN
            // UNDIRECTED GRAPH");
        }
    }

    public static void Get_ArticulationPoint(ArrayList<Edge> Graph[], int V) { // O(V+E)....
        int DiscTime[] = new int[V];
        int Lowest[] = new int[V];
        boolean Visited[] = new boolean[V];
        boolean AP[] = new boolean[V]; // AP = Articulation Point....
        int Time = 0;

        for (int i = 0; i < V; i++) {
            if (Visited[i] != true) {
                DFS(Graph, i, (-1), DiscTime, Lowest, Visited, Time, AP);
            }
        }

        // Loop To Print The Articulation Points Of The Given Undirected Graph....
        for (int i = 0; i < V; i++) {
            if (AP[i]) {
                System.out.println("VERTEX-" + i + " IS Articulation Point FOR GIVEN UNDIRECTED GRAPH");
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        System.out.println();
        Get_ArticulationPoint(Graph, V);
    }
}