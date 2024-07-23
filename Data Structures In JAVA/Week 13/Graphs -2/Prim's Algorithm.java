/*Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.



Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.



For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note: Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph



Sample Output 1 :
0 1 3
1 2 1
0 3 5
Input Graph*/
import java.util.Scanner;

public class Solution {
	public static void prims(int[][] edges) {
		int V = edges.length;
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		int[] weights = new int[V];

		// Initialize weights and parents
		for (int i = 0; i < V; i++) {
			weights[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		weights[0] = 0;

		for (int i = 0; i < V; i++) {
			int minVertex = findMin(weights, visited);
			visited[minVertex] = true;

			// Update weights and parents for adjacent vertices
			for (int j = 0; j < V; j++) {
				if (edges[minVertex][j] != 0 && !visited[j]) {
					if (edges[minVertex][j] < weights[j]) {
						weights[j] = edges[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}

		// Print the MST
		for (int i = 1; i < V; i++) {
			if (parent[i] < i) {
				System.out.println(parent[i] + " " + i + " " + weights[i]);
			} else {
				System.out.println(i + " " + parent[i] + " " + weights[i]);
			}
		}
	}

	public static int findMin(int[] weights, boolean[] visited) {
		int minVertex = -1;
		for (int i = 0; i < weights.length; i++) {
			if (!visited[i] && (minVertex == -1 || weights[i] < weights[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int V = s.nextInt();
			int E = s.nextInt();

			int[][] edges = new int[V][V];
			for (int i = 0; i < E; i++) {
				int sv = s.nextInt();
				int ev = s.nextInt();
				int weight = s.nextInt();

				edges[sv][ev] = weight;
				edges[ev][sv] = weight;
			}
			prims(edges);
		}
	}
}
