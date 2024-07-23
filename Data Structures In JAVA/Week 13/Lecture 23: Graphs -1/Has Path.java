/*Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt(); // Number of vertices
        int E = s.nextInt(); // Number of edges

        int edges[][] = new int[V][V]; // Adjacency matrix representation

        // Reading edges
        for (int i = 0; i < E; i++) {
            int sv = s.nextInt(); // Start vertex of the edge
            int ev = s.nextInt(); // End vertex of the edge
            edges[sv][ev] = 1;
            edges[ev][sv] = 1; // Since it's an undirected graph
        }

        int V1 = s.nextInt(); // Start vertex for path check
        int V2 = s.nextInt(); // End vertex for path check

        // Input validation
        if (V1 < 0 || V1 >= V || V2 < 0 || V2 >= V) {
            System.out.println("false");
            return;
        }

        boolean visited[] = new boolean[V]; // To keep track of visited nodes
        boolean ans = hasPath(edges, V1, V2, visited);

        System.out.println(ans);
    }

    // Function to check if there is a path between V1 and V2
    public static boolean hasPath(int[][] edges, int V1, int V2, boolean visited[]) {
        if (edges[V1][V2] == 1) {
            return true; // Directly connected
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(V1);
        visited[V1] = true;

        while (!q.isEmpty()) {
            int n = q.remove();

            for (int i = 0; i < edges.length; i++) {
                if (edges[n][i] == 1 && !visited[i]) {
                    if (i == V2) {
                        return true; // Found a path
                    }
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return false; // No path found
    }
}
