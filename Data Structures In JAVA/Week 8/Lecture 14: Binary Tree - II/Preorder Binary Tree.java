/*Problem statement
Problem statement
You are given a ‘Binary Tree’.



Return the preorder traversal of the Binary Tree.



Example:
Input: Consider the following Binary Tree:
Example

Output: 
Following is the preorder traversal of the given Binary Tree: [1, 2, 5, 3, 6, 4]


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1 2 3 5 4 6 7 -1 -1 -1 -1 -1 -1 -1 -1


 Sample Output 1:
1 2 5 4 3 6 7


Explanation of Sample Input 1:
The Binary Tree given in the input is as follows:
Sample1

Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1


 Sample Output 2:
5 6 2 3 9 10


Explanation of Sample Input 2:
The Binary Tree given in the input is as follows:
Sample2

Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= n <= 100000
where 'n' is the number of nodes in the binary tree.

Time Limit: 1 sec
*/

/*
	
	Following the structure used for Binary Tree
	
	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */

public class Solution {

	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

}
