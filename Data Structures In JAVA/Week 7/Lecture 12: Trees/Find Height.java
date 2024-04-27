/*Problem statement
Given a generic tree, find and return the height of given tree. The height of a tree is defined as the longest distance from root node to any of the leaf node. Assume the height of a tree with a single node is 1.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1:
3*/
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

	public static int getHeight(TreeNode<Integer> root){
		if(root==null)
			return 0;
		int height=0;
		for(int i=0;i<root.children.size();i++)
		{
			// int currHeight=1;
			int currHeight=getHeight(root.children.get(i));
			 if(currHeight>height)
			 {
				height=currHeight;
			 }
			
		}
		return height+1;
	}

}
