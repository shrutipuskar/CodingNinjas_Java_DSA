/*Problem statement
Given a singly linked list of integers, reverse it iteratively and return the head to the modified list.

 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
Where N is the size of the singly linked list.

Time Limit: 1 sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
Sample Output 1 :
8 7 6 5 4 3 2 1
Sample Input 2 :
2
10 -1
10 20 30 40 50 -1
Sample Output 2 :
10 
50 40 30 20 10 */

/*************** 
     * Following is the Node class already written 
            class Node<T> {
                T data;
                Node<T> next;

                public Node(T data) {
                    this.data = data;
                }
            }
 ***************/

 public class Solution {

	public static Node<Integer> reverse_I(Node<Integer> head){
        if(head==null||head.next==null)
            return head;
        // Node<Integer> tail=head.next;
        // Node<Integer> smallHead=reverse_I(head.next);
        // tail.next=head;
        // head.next=null;
        // return smallHead;
        Node<Integer> newHead=reverse_I(head.next);
        Node<Integer> front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
 }
