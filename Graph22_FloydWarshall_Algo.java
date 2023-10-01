/*Floyd Warshall's Algorithm is an algorithm for finding the shortest path between all the pairs
of vertices in a weighted graph. This algorithm works for both the directed and undirected
weighted graphs. But, it does not work for the graphs with negative cycles (where the sum
of the edges in a cycle is negative). */

//Important Points About Floyd Warshall's Algorithm.....
/*
● Initialize the solution matrix same as the input graph matrix as a first step.
● Then update the solution matrix by considering all vertices as an intermediate vertex.
● The idea is to one by one pick all vertices and updates all shortest paths which include the picked vertex as an intermediate vertex in the shortest path.
● When we pick vertex number k as an intermediate vertex, we already have considered vertices {0, 1, 2, .. k-1} as intermediate vertices.
● For every pair (i, j) of the source and destination vertices respectively, there are two possible cases As : -

--> k is not an intermediate vertex in shortest path from i to j. We keep the value of dist[i][j] as it is.
--> k is an intermediate vertex in shortest path from i to j. We update the value of dist[i][j] as :-
            if( dist[i][j] > (dist[i][k] + dist[k][j]) ) { dist[i][j] = dist[i][k] + dist[k][j];   }  //Easy To Understand.....

*/

public class Graph22_FloydWarshall_Algo {
    static int V = 4;
    static int INF = 1000000;

    public static void FloydWarshall_Algo(int Graph[][]) {
        int Dist[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                Dist[i][j] = Graph[i][j];
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (Dist[i][k] + Dist[k][j] < Dist[i][j]) {
                        Dist[i][j] = Dist[i][k] + Dist[k][j];
                    }
                }
            }
        }

        // Loops To Print The OUTPUT.......
        for (int i = 0; i < V; i++) {
            System.out.print("FOR VERTEX-" + i + " OF THE GRAPH -> (Row=" + i + ")--> ");
            for (int j = 0; j < V; j++) {
                if (Dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(" " + Dist[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int Graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
        FloydWarshall_Algo(Graph);
    }
}