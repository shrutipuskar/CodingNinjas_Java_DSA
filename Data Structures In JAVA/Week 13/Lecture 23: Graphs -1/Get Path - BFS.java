/*Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using BFS and print the shortest path available.

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
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static ArrayList<Integer> getPath(int[][] edges, int v, int v1, int v2) {
        // BFS variables
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        HashMap<Integer, Integer> parent = new HashMap<>();
        ArrayList<Integer> path=new ArrayList<>();
       queue.add(v1);
       visited[v1]=true;
       while(!queue.isEmpty())
       {
           int n=queue.poll();
           if(n==v2)
            {
                path.add(v2);
                int key=v2;
                while(parent.containsKey(key))
                {
                    path.add(parent.get(key));
                    key=parent.get(key);
                }
                return path;
            }
            for(int i=0;i<edges.length;i++)
            {
                if(edges[n][i]==1&&!visited[i])
                {
                    parent.put(i,n);
                    queue.add(i);
                    visited[i]=true;
                }
            }
       }

        // If no path found
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // Number of vertices
        int E = sc.nextInt(); // Number of edges

        int[][] edges = new int[V][V]; // Adjacency matrix

        // Reading edges
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a][b] = 1;
            edges[b][a] = 1; // Undirected graph
        }

        int v1 = sc.nextInt(); // Start vertex
        int v2 = sc.nextInt(); // End vertex

        ArrayList<Integer> path = getPath(edges, V, v1, v2);

        if (path != null) {

            for (int i = 0; i <path.size(); i++ )
			{
                System.out.print(path.get(i) + " ");
            }

    }
}
}
