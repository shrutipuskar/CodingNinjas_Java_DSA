/*Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.

Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.

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
0 0
1 3
2 4
3 5


*/

import java.util.Scanner;

public class Solution {

	public static void dijkshtra(int[][] edges)
	{
		int v=edges.length;
		boolean visited[]=new boolean[v];
		int dist[]=new int[v];

		for(int i=0;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		dist[0]=0;

		for(int i=0;i<v;i++)
		{
			int minV=findMin(dist,visited);
			visited[minV]=true;
			for(int j=0;j<v;j++)
			{
				if(!visited[j] && edges[minV][j]!=0)
				{
					int d=dist[minV]+edges[minV][j];
					if(d<dist[j])
					{
						dist[j]=d;
					}
				}
			}
		}

		for(int i=0;i<v;i++)
		{
			System.out.println(i+" "+dist[i]);
		}
	}

	public static int findMin(int dist[],boolean[] visited)
	{
		int minVertex=-1;
		for(int i=0;i<dist.length;i++)
		{
			if(!visited[i] && (minVertex==-1 || dist[i]<dist[minVertex]))
				minVertex=i;
		}
		return minVertex;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
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
			dijkshtra(edges);
		}
}
