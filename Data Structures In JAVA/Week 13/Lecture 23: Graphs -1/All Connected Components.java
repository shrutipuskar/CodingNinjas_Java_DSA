/*Problem statement
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Sample Input 1:
4 2
0 1
2 3
Sample Output 1:
0 1 
2 3 
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
0 1 3 
2*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static ArrayList<Integer> bfsTraversal(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> component = new ArrayList<>();
        
        q.add(sv);
        visited[sv] = true;

        while (!q.isEmpty()) {
            int front = q.poll();
            component.add(front);

            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return component;
    }

    public static ArrayList<ArrayList<Integer>> findConnectedComponents(int[][] edges, int V) {
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = bfsTraversal(edges, i, visited);
                components.add(component);
            }
        }
        
        return components;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        int[][] edges = new int[V][V];
        
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a][b] = 1;
            edges[b][a] = 1;
        }
        
        ArrayList<ArrayList<Integer>> components = findConnectedComponents(edges, V);
        
        for (ArrayList<Integer> component : components) {
            Collections.sort(component);
            for (int j = 0; j < component.size(); j++) {
                System.out.print(component.get(j) + " ");
            }
            System.out.println();
        }

    }
}
