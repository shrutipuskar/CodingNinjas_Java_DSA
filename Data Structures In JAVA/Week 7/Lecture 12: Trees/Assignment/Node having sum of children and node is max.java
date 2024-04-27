/*Problem statement
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.

Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Representation of input


Sample Output 1 :
1
Explanation
Sum of node 1 and it's child (15) is maximum among all the nodes, so the output for this is 1.*/

import javafx.util.Pair;
import java.util.ArrayList;

public class Solution {

    public static Pair<TreeNode<Integer>, Integer> maxSumNodeHelper(TreeNode<Integer> root) {
        if (root == null)
            return new Pair<>(null, 0);

        int sum = root.data;

        for (TreeNode<Integer> child : root.children) {
            sum += child.data;
        }

        Pair<TreeNode<Integer>, Integer> ans = new Pair<>(root, sum);

        for (TreeNode<Integer> child : root.children) {
            Pair<TreeNode<Integer>, Integer> childNode = maxSumNodeHelper(child);
            if (childNode.getValue() > ans.getValue()) {
                ans = childNode;
            }
        }

        return ans;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        if (root == null)
            return null;

        return maxSumNodeHelper(root).getKey();
    }
}
