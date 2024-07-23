/*Problem statement
Given an undirected and disconnected graph G(V, E), print its BFS traversal.

Note:

1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2*/
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
	public static void bfsTraversalHelper(int [][] edges,int sv,boolean[] visited)
	{
			Queue<Integer> q=new LinkedList<>();
			q.add(sv);
			visited[sv]=true;
			while(!q.isEmpty())
			{
				int curr=q.poll();
				System.out.print(curr+" ");
				for(int i=0;i<edges.length;i++)
				{
					if(sv==i)
						continue;
					if(edges[curr][i]==1 && !visited[i])
					{
						q.add(i);
						visited[i]=true;
					}
				}
			}
	}
	public static void bfsTraversal(int [][] edges)
	{
			boolean visited[]=new boolean[edges.length];
			for(int i=0;i<visited.length;i++)
			{
				if(!visited[i])
					bfsTraversalHelper(edges, i, visited);
			}
			
	}


	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        
        int[][] edges = new int[V][V];
        
        for (int i = 0; i < E; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            edges[a][b] = 1;
            edges[b][a] = 1;
        }
        
        bfsTraversal(edges);
    }
}

