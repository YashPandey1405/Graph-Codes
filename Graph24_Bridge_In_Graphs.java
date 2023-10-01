//Bridge Is An Edge whose deletion increases the graph's Number of Connected Components.....
//We Will Use Tarjan's Algorithm For Finding Bridge in the Given Undirected Graph.....

import java.util.*;

public class Graph24_Bridge_In_Graphs {
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
        Graph[3].add(new Edge(3, 5, 1));

        // For Vertex-4 Of The Graph.......
        Graph[4].add(new Edge(4, 3, 1));
        Graph[4].add(new Edge(4, 5, 1));

        // For Vertex-5 Of The Graph.......
        Graph[5].add(new Edge(5, 3, 1));
        Graph[5].add(new Edge(5, 4, 1));

    }

    public static void DFS(ArrayList<Edge> Graph[], int curr, int Par, int DiscTime[], int Lowest[], boolean Visited[],
            int Time) {
        Visited[curr] = true;
        DiscTime[curr] = Lowest[curr] = ++Time;

        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            int Neigh = e.Dest;
            if (Neigh == Par) {
                continue;
            } else if (Visited[Neigh] != true) {
                DFS(Graph, Neigh, curr, DiscTime, Lowest, Visited, Time);
                Lowest[curr] = Math.min(Lowest[curr], Lowest[Neigh]);
                if (DiscTime[curr] < Lowest[Neigh]) {
                    System.out.println("BRIDGE EXISTS IN THE UNDIRECTED GRAPH BETWEEN ::: " + curr + " <--> " + Neigh);
                }
            } else {
                Lowest[curr] = Math.min(Lowest[curr], DiscTime[Neigh]);
            }
        }
    }

    public static void GetBridge(ArrayList<Edge> Graph[], int V) {
        int DiscTime[] = new int[V];
        int Lowest[] = new int[V];
        boolean Visited[] = new boolean[V];
        int Time = 0;

        for (int i = 0; i < V; i++) {
            if (Visited[i] != true) {
                DFS(Graph, i, (-1), DiscTime, Lowest, Visited, Time);
            }
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        GetBridge(Graph, V);
    }
}