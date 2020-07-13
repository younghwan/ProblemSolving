package String.MinimumRemoveParentheses;

import java.util.*;

public class Solution {
    public String minRemoveToMakeValid(String s) {


        Stack<Integer> stack = new Stack<>();
        List<Integer> erase = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '(') stack.add(i);
            else if(s.charAt(i) == ')'){
                if(stack.empty()) erase.add(i);
                else {
                    stack.pop();
                }
            }
        }

        erase.addAll(stack);
        for(int i : erase)
        {
            sb.setCharAt(i,'*');
        }
        String ans = sb.toString().replace("*","");

        return ans;

    }

    public static void main(String[] args) {
        String s = "))((";

        Solution solution = new Solution();

        System.out.println(solution.minRemoveToMakeValid(s));
    }
}
