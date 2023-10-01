import java.util.*;

public class Graph12_AllPaths {
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
            Graph[i] = new ArrayList<>(); // Here , We Initialized The ArrayLists.....
        }

        // Edges For Vertex-0 Of The Graph...
        Graph[0].add(new Edge(0, 3, 1));

        // Edges For Vertex-1 Of The Graph...

        // Edges For Vertex-2 Of The Graph...
        Graph[2].add(new Edge(2, 3, 1));

        // Edges For Vertex-3 Of The Graph...
        Graph[3].add(new Edge(3, 1, 1));

        // Edges For Vertex-4 Of The Graph...
        Graph[4].add(new Edge(4, 0, 1));
        Graph[4].add(new Edge(4, 1, 1));

        // Edges For Vertex-5 Of The Graph...
        Graph[5].add(new Edge(5, 0, 1));
        Graph[5].add(new Edge(5, 2, 1));
    }

    public static int itr; // By-Default Initialization By '0'.....
    public static int Source = 5; // By-Default Initialization By '0'.....
    public static int Destination = 1; // By-Default Initialization By '0'.....

    public static void AllPaths_DirectedGraph(ArrayList<Edge> Graph[], int src, int dest, String Path) {
        if (src == dest) {
            Path = Path + dest;
            itr++;
            System.out.print("Path-" + itr + " FROM Vertex-" + Source + " TO Vertex-" + Destination + " IS ::: ");
            for (int i = 0; i < Path.length(); i++) {
                if (i == (Path.length() - 1)) {
                    System.out.println(Path.charAt(i));
                } else {
                    System.out.print(Path.charAt(i) + " --> ");

                }
            }
        }
        for (int i = 0; i < Graph[src].size(); i++) {
            Edge e = Graph[src].get(i);
            AllPaths_DirectedGraph(Graph, e.Dest, dest, Path + src);
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        AllPaths_DirectedGraph(Graph, Source, Destination, "");
        System.out.println();
        System.out.println("TOTAL NUMBER OF PATHS FROM " + Source + " TO " + Destination + " ARE ::: " + itr);
    }
}
