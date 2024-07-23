/*Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using DFS and print the first path that you encountered.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1:
3 0 1  

*/
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static ArrayList<Integer> getPath(int v1, int v2, int[][] edges, boolean[] visited) {
        // If v1 is the same as v2, return a path containing just v2
        if (v1 == v2) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(v2);
            return ans;
        }

        // Mark v1 as visited
        visited[v1] = true;

        // Check all neighbors of v1
        for (int i = 0; i < edges.length; i++) {
            if (edges[v1][i] == 1 && !visited[i]) {
                // Recursively find path from i to v2
                ArrayList<Integer> path = getPath(i, v2, edges, visited);
                if (path != null) {
                    // If path is found, add v1 to the path and return it
                    path.add(v1); // Add v1 to the path
                    return path;
                }
            }
        }

        // If no path is found from v1 to v2, return null
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // Number of vertices
        int e = sc.nextInt(); // Number of edges

        int edges[][] = new int[v][v]; // Adjacency matrix representation

        // Reading edges
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt(); // Start vertex of the edge
            int b = sc.nextInt(); // End vertex of the edge
            edges[a][b] = 1;
            edges[b][a] = 1; // Since it's an undirected graph
        }

        int v1 = sc.nextInt(); // Start vertex for path check
        int v2 = sc.nextInt(); // End vertex for path check

        // Input validation
        if (v1 < 0 || v1 >= v || v2 < 0 || v2 >= v) {
            return;
        }

        boolean visited[] = new boolean[v]; // To keep track of visited nodes
        ArrayList<Integer> ans = getPath(v1, v2, edges, visited);

        if (ans != null) {
            // Print the path
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}

