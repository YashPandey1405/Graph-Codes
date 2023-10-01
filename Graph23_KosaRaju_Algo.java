import java.util.*;

public class Graph23_KosaRaju_Algo {
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
        Graph[0].add(new Edge(0, 3, 1));

        // For Vertex-1 Of The Graph.....
        Graph[1].add(new Edge(1, 0, 1));

        // For Vertex-2 Of The Graph.....
        Graph[2].add(new Edge(2, 1, 1));

        // For Vertex-3 Of The Graph.....
        Graph[3].add(new Edge(3, 4, 1));

        // For Vertex-4 Of The Graph --> No Edge....

    }

    // Function To Obtain The Topological Sort Of The Given Graph......
    public static void Transpose(ArrayList<Edge> Graph[], ArrayList<Edge> TransGraph[], boolean Visited[]) {
        for (int i = 0; i < TransGraph.length; i++) {
            Visited[i] = false;
            TransGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph[i].size(); j++) {
                Edge e = Graph[i].get(j);
                TransGraph[e.Dest].add(new Edge(e.Dest, e.Source, e.Weight));
            }
        }
    }

    // Function To Perform Topological Sorting On The Adjacency Graph......
    public static void TopSort(ArrayList<Edge> Graph[], int curr, boolean Visited[], Stack<Integer> s) {
        Visited[curr] = true;

        for (int j = 0; j < Graph[curr].size(); j++) {
            Edge e = Graph[curr].get(j);
            if (Visited[e.Dest] != true) {
                TopSort(Graph, e.Dest, Visited, s);
            }
        }
        s.push(curr);
    }

    // Function To Perform Depth First Search(DFS) On The Graph......
    public static void DFS(ArrayList<Edge> TransGraph[], int curr, boolean Visited[]) {
        Visited[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < TransGraph[curr].size(); i++) {
            Edge e = TransGraph[curr].get(i);
            if (Visited[e.Dest] != true) {
                DFS(TransGraph, e.Dest, Visited);
            }
        }
    }

    // Time Complexity Of KosaRaju Algorithm Is O(V+E)....
    public static void KosaRaju_Algo(ArrayList<Edge> Graph[], int V) {

        // Step 1 --> Obtain The Topological Sort Of The Graph & Store In The Stack.....

        Stack<Integer> s = new Stack<>();
        boolean Visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (Visited[i] != true) {
                TopSort(Graph, i, Visited, s);
            }
        }

        // Step 2 --> Obtain The Transpose Graph Of The Given Graph.....

        ArrayList<Edge> TransGraph[] = new ArrayList[V];
        Transpose(Graph, TransGraph, Visited);

        // Step 3 --> Perform Reverse DFS Approach On The Transpose Graph With Stack....

        int itr = 1;
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (Visited[curr] != true) {
                System.out.print("Strongly Connected Component-" + itr + " IN THE GRAPH IS ::: ");
                DFS(TransGraph, curr, Visited);
                System.out.println();
                itr++;
            }
        }
        System.out.println();
        System.out.println("TOTAL NUMBER OF SCC IN THE GRAPH IS ::: " + (itr - 1));
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> Graph[] = new ArrayList[V];
        SetGraph(Graph);
        System.out.println("THE STRONGLY CONNECTED COMPONENTS (SCC) ARE ::: ");
        KosaRaju_Algo(Graph, V);
    }
}
