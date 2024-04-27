/*Problem statement
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.

Return NULL if no node is present with value greater than n.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0 
Representation of Input


Sample Output 1 :
20
Explanation
In the given tree, the value which is just greater than 18 is 20.
Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
30

public class Solution {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){

*/

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
	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		if(root==null)
			return null;
		TreeNode<Integer> ans=null;
		if (root.data > n) {
            if (ans == null || root.data < ans.data) {
                ans = root;
            }
        }
		for(int i=0;i<root.children.size();i++)
		{
			TreeNode <Integer> temp=findNextLargerNode(root.children.get(i), n);
			if(temp != null && (ans == null || (temp.data > n && temp.data < ans.data)))
				ans=temp;
		}

		return ans;
	}
	
}
