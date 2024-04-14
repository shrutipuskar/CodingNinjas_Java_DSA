/*Problem statement
For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.

If the expression can't be balanced, return -1.

Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1:
{{{
Sample Output 1:
-1
Sample Input 2:
{{{{}}
Sample Output 2:
1*/

import java.util.Stack;

public class Solution {

    public static int countBracketReversals(String input) {
        if (input.length() % 2 != 0) {
            return -1; // If the length is odd, it can't be balanced
        }

        Stack<Character> stk = new Stack<>();
        int unmatchedOpenCount = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '{') {
                stk.push(ch);
            } else if (ch == '}') {
                if (!stk.isEmpty() && stk.peek() == '{') {
                    stk.pop(); // Matching opening bracket found, pop it
                } else {
                    stk.push(ch); // Unmatched closing bracket, push it
                }
            }
        }
		int count=0;
		char c1,c2;
        while (!stk.isEmpty() ) {
            c1=stk.pop();
			c2=stk.pop();
			if(c1==c2)
				count++;
			else
				count+=2;
            // unmatchedOpenCount++;
        }
		return count;

        // int totalReversals = (stk.size() / 2) + (unmatchedOpenCount / 2) + (stk.size() % 2) * 2;
        // return totalReversals;
    }

}
