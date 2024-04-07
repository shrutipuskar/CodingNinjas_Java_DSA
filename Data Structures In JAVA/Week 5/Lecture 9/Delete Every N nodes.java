/*Problem statement
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list. Indexing starts from 1.

To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list. You can return null in case where all nodes will be deleted.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5 

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7.
public class Solution {
    
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (M == 0) {
            return null;
        }

        Node<Integer> t1 = head;
        Node<Integer> t2 = null;


*/
public class Solution {
    
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (M == 0) {
            return null;
        }

        Node<Integer> t1 = head;
        Node<Integer> t2 = null;

        while (t1 != null) {
            int count = 0;

            for (count = 0; count < M && t1 != null; count++) {
                t2 = t1;
                t1 = t1.next;
            }

            count = 0;
            for (count = 0; count < N && t1 != null; count++) {
                t1 = t1.next;
            }

            if (t2 != null) {
                t2.next = t1;
            }

            if (t1 == null) {
                break;
            }
        }
        
        return head;
    }
}
