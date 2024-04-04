/*Problem statement
You have been given a singly linked list of integers. Write a function to print the list in a reverse order.

To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.

Note :
You can’t change any of the pointers in the linked list, just print the linked list in the reverse order.
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Output format :
For each test case, print the singly linked list of integers in a reverse fashion, in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^3


Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
Sample Input 2 :
2
1 2 3 -1
10 20 30 40 50 -1
Sample Output 2 :
3 2 1
50 40 30 20 1
*/



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

	public static void printReverse(Node<Integer> root) {
		Node temp=root;
		int count=0;
		if(root==null)
			return;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		int arr[]=new int[count];
		int i=0;
		temp=root;
		while(temp!=null)
		{
			arr[i]=(int)temp.data;
			i++;
			temp=temp.next;
		}
		for( i=arr.length-1;i>=0;i--)
			System.out.print(arr[i]+" ");
	}

}
