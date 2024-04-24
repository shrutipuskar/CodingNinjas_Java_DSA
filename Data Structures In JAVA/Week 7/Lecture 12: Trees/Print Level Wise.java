/*Problem statement
Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in different lines.



The output for the above tree should be 
10
20 30 40
40 50
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50*/
import java.util.LinkedList;
import java.util.*;



public class Solution {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
	
	
	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
		 if(root==null)
		 	return ;
		Queue<TreeNode<Integer>>pendingQueue=new LinkedList<>();
		pendingQueue.add(root);
	
		while(!pendingQueue.isEmpty())
		{
			int n=pendingQueue.size();
			
			for(int i=0;i<n;i++)
			{
				TreeNode<Integer> frontNode=pendingQueue.poll();
				System.out.print(frontNode.data+" ");
			
                   for (int j = 0; j < frontNode.children.size(); j++)
               pendingQueue.add(frontNode.children.get(j));

			}
			System.out.println();

		}
	}
		
}
