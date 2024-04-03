/*Problem statement
You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
1
1 2 3 3 3 3 4 4 4 5 5 7 -1
Sample Output 1 :
1 2 3 4 5 7 
Sample Input 2 :
2
10 20 30 40 50 -1
10 10 10 10 -1
Sample Output 2 :
10 20 30 40 50
10*/


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

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one element, no duplicates can exist
        }
        
        Node<Integer> current = head;
        
        while (current != null && current.next != null) {
            if (current.data.equals(current.next.data)) {
                current.next = current.next.next; // Skip the next node if it's a duplicate
            } else {
                current = current.next; // Move to the next node
            }
        }
        
        return head;
    }
}
