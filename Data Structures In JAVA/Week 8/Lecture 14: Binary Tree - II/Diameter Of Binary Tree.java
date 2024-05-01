/*Problem statement
For a given Binary of type integer, find and return the ‘Diameter’.

Diameter of a Tree
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
Example:
alt txt

The maximum distance can be seen between the leaf nodes 8 and 9. 
The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1 
Sample Output 1:
9
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
5*/

// /*
	
// 	Following is the structure used to represent the Binary Tree Node

// 	class BinaryTreeNode<T> {
// 		T data;
// 		BinaryTreeNode<T> left;
// 		BinaryTreeNode<T> right;

// 		public BinaryTreeNode(T data) {
// 			this.data = data;
// 			this.left = null;
// 			this.right = null;
// 		}
// 	}

// */

// public class Solution {
// 	public class Pair<T,V>
// {
// 	public T first;
// 	public V second; 
// }
// 	public static Pair<Integer,Integer> diameterOfBinaryTreeHelper(BinaryTreeNode<Integer> root){
// 		if(root==null)
// 		{
// 			Pair <Integer,Integer> output=new Pair<>();
// 			output.first=0;
// 			output.second=0;
// 		}
// 		Pair<Integer,Integer> lo=diameterOfBinaryTreeHelper(root.left);
// 		Pair<Integer,Integer> ro=diameterOfBinaryTreeHelper(root.right);
// 		int height=1+Math.max(lo.first,ro.first);
// 		int opt1=lo.first+ro.first;
// 		int opt2=lo.second;
// 		int opt3=ro.second;
// 		int diameter=Math.max(opt1, Math.max(opt2, opt3));
// 		Pair<Integer,Integer> output=new Pair<>();
// 		output.first=height;
// 		output.second=diameter;
// 		return output;
// 	}
// 	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
// 		Pair <Integer,Integer> output=diameterOfBinaryTreeHelper(root);
// 		return output.second;
// 	}
	
// }

//corrected logic starts here>>
/*
	
	Following is the structure used to represent the Binary Tree Node

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

    // Function to calculate the height of a binary tree
    private static int height(BinaryTreeNode<Integer> root) {
        // Base case: if the root is null, height is 0
        if(root == null) {
            return 0;
        }
        
        // Recursively calculate the height of the left subtree
        int leftH = height(root.left);
        
        // Recursively calculate the height of the right subtree
        int rightH = height(root.right);
        
        // Return the height of the tree as 1 + maximum of left and right subtree heights
        return 1 + Math.max(leftH, rightH);
    }

    // Function to calculate the diameter of a binary tree
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        // Base case: if the root is null, diameter is 0
        if(root == null) {
            return 0;
        }   
        
        // Calculate the diameter using the formula: 
        // max(1 + height of left subtree + height of right subtree, 
        // diameter of left subtree, diameter of right subtree)
        int opt1 = height(root.left) + height(root.right);
        int opt2 = diameterOfBinaryTree(root.left);
        int opt3 = diameterOfBinaryTree(root.right);
        return 1 + Math.max(opt1, Math.max(opt2, opt3));
    }
}
