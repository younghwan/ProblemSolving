package String.TwoStringAnagram;
/*
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 */
class Solution {
    public int minSteps(String s, String t) {
        int[] hash = new int[26];
        for(char c: s.toCharArray()){
            hash[c-'a']++;
        }

        int[] hash_t = new int[26];
        for(char c: t.toCharArray()){
            hash_t[c-'a']++;
        }

        int count = 0;
        for(int i=0;i<hash.length;i++){
            count += Math.max(0, hash[i] - hash_t[i]);
        }

        return count;
    }
}
