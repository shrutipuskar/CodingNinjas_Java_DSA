/*Problem statement
For a given a string expression containing only round 
  brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.
  


Example:
Expression: (()())
Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence the output will be, 'true'.
You need to return a boolean value indicating whether the expression is balanced or not.

Note:
The input expression will not contain spaces in between.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and the only line of input contains a string expression without any spaces in between. Input string will only consists of round brackets.
 Output Format:
The only line of output prints 'true' or 'false'.
Note:
You don't have to print anything explicitly. It has been taken care of. Just implement the function. 
Constraints:
1 <= N <= 10^7
 Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1 :
(()()())
Sample Output 1 :
true
Sample Input 2 :
()()(()
Sample Output 2 :
false
Explanation to Sample Input 2:
The initial two pairs of brackets are balanced. But when you see, the opening bracket at the fourth index doesn't have its 
  corresponding closing bracket which makes it imbalanced and in turn, making the whole expression imbalanced. Hence the output prints 'false'.  */

//Approch 1:By creating own stack class

import java.util.*;
class Stack {
    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(char element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public char pop() {
        if (isEmpty()) {
            return ' '; // or throw an exception
        }
        char poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }

    public char top() {
        if (isEmpty()) {
            return ' '; // or throw an exception
        }
        return top.data;
    }

    private static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
}
public class Solution {
    
    public static boolean isBalanced(String expression) {
        Stack stk=new Stack();
        // boolean res=false;
        for(char ch:expression.toCharArray())
        {
            if(ch=='('||ch=='['||ch=='{')
            {
                stk.push(ch);
            }
            else if(ch==')')
            {
                if(stk.isEmpty())
                    return false;
                else if(stk.top()=='(')
                    stk.pop();
                else
                    return false;
            }
             else if(ch==']')
            {
                if(stk.isEmpty())
                    return false;
                else if(stk.top()=='[')
                    stk.pop();
                else
                    return false;
            }
             else if(ch=='}')
            {
                if(stk.isEmpty())
                    return false;
                else if(stk.top()=='{')
                    stk.pop();
                else
                    return false;
            }
        }
        if(stk.isEmpty())
            return true;
        return false;
        
    }
}

//Approch 2: By using Collection Framework
import java.util.Stack;

public class Solution {
    
    // Function to check if the given expression has balanced parentheses
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the expression
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                // If the character is an opening parenthesis, push it onto the stack
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                // If the character is a closing parenthesis
                if (stack.isEmpty()) {
                    // If the stack is empty, there's no corresponding opening parenthesis
                    return false;
                }
                char top = stack.pop(); // Get the top element from the stack
                // Check if the current closing parenthesis matches the last opening parenthesis
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty at the end, all parentheses are balanced
        return stack.isEmpty();
    }
    
    // public static void main(String[] args) {
    //     String expression = "((({}[])))"; // Example expression
        
    //     if (isBalanced(expression)) {
    //         System.out.println("Balanced");
    //     } else {
    //         System.out.println("Not balanced");
    //     }
    // }
}
