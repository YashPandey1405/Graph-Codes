import java.util.*;

public class Graph18_ConnectCities {
    static class Edge implements Comparable<Edge> {
        int Source;
        int Dest;
        int Weight;

        public Edge(int s, int d, int w) {
            this.Source = s;
            this.Dest = d;
            this.Weight = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.Weight - e2.Weight;
        }
    }

    public static void SetGraph(int Cities[][], ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < Cities.length; i++) {
            for (int j = 0; j < Cities[0].length; j++) {
                if (Cities[i][j] != 0) {
                    Graph[i].add(new Edge(i, j, Cities[i][j]));
                }
            }
        }
    }

    public static void ConnectCities(int Cities[][]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Cities, Graph);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean Visited[] = new boolean[V];
        pq.add(new Edge(0, 0, 0));
        int FinalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!Visited[curr.Dest]) {
                Visited[curr.Dest] = true;
                FinalCost += curr.Weight;
                for (int i = 0; i < Cities[curr.Dest].length; i++) {
                    if (Cities[curr.Dest][i] != 0) {
                        pq.add(new Edge(curr.Dest, i, Cities[curr.Dest][i]));
                    }
                }
            }
        }
        System.out.println("THE MINIMUM COST TO CONNECT ALL CITIES IS ::: " + FinalCost);
    }

    public static void main(String args[]) {
        int Cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        ConnectCities(Cities);
    }
}
