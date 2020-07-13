package String.BinaryStringWithSubstrings;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

Example 1:
Input: S = "0110", N = 3
Output: true

Example 2:
Input: S = "0110", N = 4
Output: false
 */
public class Solution {
    public boolean queryString(String S, int N) {
        for(int i =1;i<=N; i++){
            if(!S.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "0110";
        int N = 4;
        Solution solution = new Solution();
        System.out.println(solution.queryString(S,N));
    }
}
