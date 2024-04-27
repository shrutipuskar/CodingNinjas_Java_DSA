/*Problem statement
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40*/

public class Solution {

    // public static class TreeNode<T> {
    //     T data;
    //     ArrayList<TreeNode<T>> children;

    //     TreeNode(T data){
    //         this.data = data;
    //         children = new ArrayList<>();
    //     }
    // }

    public static class Pair<T> {
        T first;
        T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root) {
        if (root == null)
            return new Pair<>(null, null);

        Pair<TreeNode<Integer>> output = new Pair<>(root, null);

        for (TreeNode<Integer> child : root.children) {
            Pair<TreeNode<Integer>> childPair = findSecondLargestHelper(child);

            if(childPair.first.data > output.first.data) {
                if(childPair.second == null || childPair.second.data < output.first.data) {
                    output.second = output.first;
                    output.first = childPair.first;
                } else {
                    output.first = childPair.first;
                    output.second = childPair.second;
                }
            } else if(childPair.first.data.equals(output.first.data) && childPair.second != null) {
                output.second = childPair.second;
            } else if(!childPair.first.data.equals(output.first.data) && (output.second == null || childPair.first.data > output.second.data)) {
                output.second = childPair.first;
            }
        }

        return output;
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        return findSecondLargestHelper(root).second;
    }

    
}
