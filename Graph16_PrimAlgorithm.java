import java.util.*;

public class Graph16_PrimAlgorithm {
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

    static class Pair implements Comparable<Pair> {
        int Vertex;
        int Cost;

        public Pair(int v, int c) {
            this.Vertex = v;
            this.Cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.Cost - p2.Cost;
        }
    }

    public static void SetGraph(ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        // For Vertex-0 Of The Graph.....
        Graph[0].add(new Edge(0, 1, 10));
        Graph[0].add(new Edge(0, 2, 15));
        Graph[0].add(new Edge(0, 3, 30));

        // For Vertex-1 Of The Graph.....
        Graph[1].add(new Edge(1, 0, 10));
        Graph[1].add(new Edge(1, 3, 40));

        // For Vertex-2 Of The Graph.....
        Graph[2].add(new Edge(2, 0, 15));
        Graph[2].add(new Edge(2, 3, 50));

        // For Vertex-3 Of The Graph.....
        Graph[3].add(new Edge(3, 0, 30));
        Graph[3].add(new Edge(3, 1, 40));
        Graph[3].add(new Edge(3, 2, 50));

    }

    public static void PrimAlgorithm(ArrayList<Edge> Graph[]) {
        boolean Visited[] = new boolean[Graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int FinalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (Visited[curr.Vertex] != true) {
                Visited[curr.Vertex] = true;
                FinalCost += curr.Cost;

                for (int i = 0; i < Graph[curr.Vertex].size(); i++) {
                    Edge e = Graph[curr.Vertex].get(i);
                    pq.add(new Pair(e.Dest, e.Weight));
                }
            }
        }
        System.out.println("THE FINAL COST OF MINIMUM SPAMMING TREE IS ::: " + FinalCost);
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        PrimAlgorithm(Graph);
    }
}