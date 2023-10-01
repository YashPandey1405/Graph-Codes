import java.util.*;

public class Graph17_CheapestFlight {
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

    static class Info {
        int Vertex;
        int Cost;
        int Stops;

        public Info(int v, int c, int s) {
            this.Vertex = v;
            this.Cost = c;
            this.Stops = s;
        }
    }

    public static void SetGraph(ArrayList<Edge> Graph[], int Flights[][]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < Flights.length; i++) {
            int src = Flights[i][0];
            int dest = Flights[i][1];
            int wt = Flights[i][2];
            Graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int CheapestFlight(int Flights[][], int src, int dest, int k, int V) {
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph, Flights);
        int Dist[] = new int[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            if (i != src) {
                Dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.Stops > k) {
                break;
            }
            for (int i = 0; i < Graph[curr.Vertex].size(); i++) {
                Edge e = Graph[curr.Vertex].get(i);
                int u = e.Source, v = e.Dest, wt = e.Weight;
                if (((curr.Cost + wt) < Dist[v]) && (curr.Stops <= k)) {
                    Dist[v] = curr.Cost + wt;
                    q.add(new Info(v, Dist[v], curr.Stops + 1));
                }
            }
        }
        if (Dist[dest] == Integer.MAX_VALUE) {
            return (-1);
        } else {
            return Dist[dest];
        }

    }

    public static void main(String args[]) {
        int V = 4;
        int Flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int Src = 0, Dest = 3, k = 1;
        int ans = CheapestFlight(Flights, Src, Dest, k, V);
        System.out.println("THE CHEAPEST FLIGHT FROM " + Src + "->" + Dest + " WITHIN " + k + " STOPS IS ::: " + ans);
    }
}