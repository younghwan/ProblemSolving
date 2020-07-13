package String.PalindromicSubstrings;

/*
No.647
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class Solution {

    public int countSubstrings(String s) {
        int res = 0;
        for(int startIndex =0 ; startIndex<s.length(); startIndex++){
            for(int lastIndex = startIndex+1; lastIndex<=s.length(); lastIndex++){
                String sub = s.substring(startIndex,lastIndex);
                if(isPalindrom(sub)) res++;
            }
        }

        return res;
    }

    boolean isPalindrom(String str){
        for(int i = 0 ; i<str.length()/2; i++)
        {
            if(str.charAt(i) != str.charAt((str.length()-1)-i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "text";

//        System.out.println(s.substring(2,3));

        System.out.println(solution.countSubstrings(s));

    }
}
