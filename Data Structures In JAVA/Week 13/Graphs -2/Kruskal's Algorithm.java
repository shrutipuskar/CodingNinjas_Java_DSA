/*Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.

Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.

For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph

Sample Output 1 :
1 2 1
0 1 3
0 3 5
Input Graph



*/

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int sv;
    int ev;
    int weight;

    Edge(int sv, int ev, int weight) {
        this.sv = sv;
        this.ev = ev;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // Number of vertices
        int E = sc.nextInt(); // Number of edges

        Edge edges[] = new Edge[E];
        Edge output[] = new Edge[V - 1];

        for (int i = 0; i < E; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int weight = sc.nextInt();
            edges[i] = new Edge(sv, ev, weight);
        }

        Arrays.sort(edges);

        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int count = 0;
        int i = 0;

        while (count != V - 1) {
            Edge currentEdge = edges[i];

            int sourceParent = findParent(currentEdge.sv, parent);
            int destParent = findParent(currentEdge.ev, parent);

            if (sourceParent != destParent) {
                output[count] = currentEdge;
                count++;
                union(sourceParent, destParent, parent);
            }
            i++;
        }

        for (i = 0; i < V - 1; i++) {
            if (output[i].sv < output[i].ev) {
                System.out.println(output[i].sv + " " + output[i].ev + " " + output[i].weight);
            } else {
                System.out.println(output[i].ev + " " + output[i].sv + " " + output[i].weight);
            }
        }
    }

    private static int findParent(int vertex, int[] parent) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return findParent(parent[vertex], parent);
    }

    private static void union(int sourceParent, int destParent, int[] parent) {
        parent[sourceParent] = destParent;
    }
}
