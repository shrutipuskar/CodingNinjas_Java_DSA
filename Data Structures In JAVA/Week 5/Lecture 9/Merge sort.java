/*Problem statement
 Given a singly linked list of integers, sort it using 'Merge Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 */
/*

    Following is the Node class already written for the Linked List

    class Node<T> {
        T data;
        Node<T> next;
    
        public Node(T data) {
            this.data = data;
        }
    }

*/

public class Solution {
    private static Node<Integer> middleNode(Node<Integer>head)
    {
         if(head==null)
            return null;
        Node<Integer> slow=head;
        Node<Integer> fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static Node<Integer> merge(Node<Integer>head1,Node<Integer>head2)
    {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        Node<Integer> t1=head1;
        Node<Integer> t2=head2;
        Node<Integer> t3;
        Node<Integer> head3;
        if(t1.data<=t2.data)
        {
            t3=t1;
            head3=t3;
            t1=t1.next;
        }
        else
        {
             t3=t2;
            head3=t3;
            t2=t2.next;
        }
        while(t1!=null&&t2!=null)
        {
            if(t1.data<=t2.data)
            {
                t3.next=t1;
                t1=t1.next;
                t3=t3.next;
            }
            else
            {
                t3.next=t2;
                t2=t2.next;
                t3=t3.next;
            }
        }
        if(t1!=null)
            t3.next=t1;
        if(t2!=null)
            t3.next=t2;
        return head3;
    }
	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head==null||head.next==null)
            return head;
        Node<Integer> middle=middleNode(head);
        Node<Integer> leftHead=head;
        Node<Integer> rightHead=middle.next;
        middle.next=null;
        leftHead=mergeSort(leftHead);
        rightHead=mergeSort(rightHead);
        return merge(leftHead,rightHead);
	}

}
