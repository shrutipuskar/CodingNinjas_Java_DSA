/*Problem statement
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements. 
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.

The second line of input contains N integers, all separated by a single space. It represents the Postorder-traversal of the binary tree.

The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
2 9 3 6 10 5 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 */

public class Solution {
    public static BinaryTreeNode<Integer> BinaryTreeNodeHelper(int[] postOrder, int[] inOrder, int pS, int pE, int iS, int iE) {
        // Check if the ranges are invalid
        if (pS > pE || iS > iE)
            return null;

        // Create the root node using the last element of postOrder
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[pE]);

        // Find the index of the root in the inOrder array
        int idx = -1;
        for (int i = iS; i <= iE; i++) {
            if (root.data.equals(inOrder[i])) { // Compare data using equals()
                idx = i;
                break;
            }
        }

        // Calculate indices for the right subtree
        int rIS = idx + 1;
        int rIE = iE;
        int rPS = pE - (rIE - rIS) - 1;
        int rPE = pE - 1;

        // Calculate indices for the left subtree
        int lIS = iS;
        int lIE = idx - 1;
        int lPS = pS;
        int lPE = rPS - 1;

        // Recursively build the right and left subtrees
        root.right = BinaryTreeNodeHelper(postOrder, inOrder, rPS, rPE, rIS, rIE);
        root.left = BinaryTreeNodeHelper(postOrder, inOrder, lPS, lPE, lIS, lIE);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        // Start with full ranges for postOrder and inOrder arrays
        return BinaryTreeNodeHelper(postOrder, inOrder, 0, postOrder.length - 1, 0, inOrder.length - 1);
    }
}
