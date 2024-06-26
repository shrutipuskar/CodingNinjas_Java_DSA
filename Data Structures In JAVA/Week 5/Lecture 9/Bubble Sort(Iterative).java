/*Problem statement
Given a singly linked list of integers, sort it using 'Bubble Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10^3
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
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
    
    public static int findLengthLL(Node<Integer> head)
	{
    	int count=0;
    	while(head.next!=null)
    	{
        	head=head.next;
        	count=count+1;
    	}
    	return count;
    
	}


	public static Node<Integer> bubbleSort(Node<Integer> head) {
		//Your code goes here
        
         if (head==null || head.next==null)
        {
            return head;
        }
        int n=findLengthLL(head);
        Node<Integer> node1=null,node2=null,temp=null;
        int data1=0,data2=0;
        for (int i=0;i<n;i++)
        {
            node1=head;
            node2=head.next;
            for (int j=0;j<n-i;j++)
            {
                data1=node1.data;
                data2=node2.data;
                if (data1>data2)
                {
                    node1.data=data2;
                    node2.data=data1;
                }
                node1=node1.next;
                node2=node2.next;
                
            }
            
        }
       
        return head;
	}
}
