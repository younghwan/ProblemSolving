package String.ScoreOfParentheses;
/* LeetCode : 856
Given a balanced parentheses string S,
compute the score of the string based on the following rule:

    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Example 1:
Input: "()"
Output: 1

Example 2:
Input: "(())"
Output: 2

Example 3:
Input: "()()"
Output: 2

Example 4:
Input: "(()(()))"
Output: 6

 */

public class Solution {
    public int scoreOfParentheses(String S) {
        int depth = 0;
        int res = 0;
        char[] chars =S.toCharArray();
        for(int i =0; i<chars.length;i++)
        {
            if(chars[i] == '(') depth++;
            else depth--;

            if(chars[i] == ')' && chars[i-1] == '(') res += Math.pow(2,depth);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.scoreOfParentheses("(()(()))");

    }

}