import java.util.*;

public class Graph1_AdjacencyList {
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

    public static void main(String args[]) {
        int V = 5; // As The No Of Vertices In The Graph Are 5....
        // int arr[]=new int[V];
        ArrayList<Edge>[] Graph = new ArrayList[V]; // Every ArrayList in The Array is Empty....
        for (int i = 0; i < V; i++) {
            Graph[i] = new ArrayList<>(); // Initialized ArrayList Of Each index Of Array Graph.....
        }
        // Edges For Vertex-0 Of The Graph...
        Graph[0].add(new Edge(0, 1, 5));

        // Edges For Vertex-1 Of The Graph...
        Graph[1].add(new Edge(1, 0, 5));
        Graph[1].add(new Edge(1, 2, 1));
        Graph[1].add(new Edge(1, 3, 3));

        // Edges For Vertex-2 Of The Graph...
        Graph[2].add(new Edge(2, 1, 1));
        Graph[2].add(new Edge(2, 3, 1));
        Graph[2].add(new Edge(2, 4, 2));

        // Edges For Vertex-3 Of The Graph...
        Graph[3].add(new Edge(3, 2, 1));
        Graph[3].add(new Edge(3, 1, 3));

        // Edges For Vertex-4 Of The Graph...
        Graph[4].add(new Edge(4, 2, 2));

        for (int i = 0; i < V; i++) { // Loop To Print Neighbour Of Each Vertex Of The Graph.....
            System.out.print("THE NEIGHBOUR OF VERTEX-" + i + " IS ::: [ ");
            for (int j = 0; j < Graph[i].size(); j++) {
                Edge e = Graph[i].get(j);
                System.out.print(e.Dest + " ");
            }
            System.out.println("]");
        }
    }
}