package Leetcode.LongestSubstringWithoutRepeatingCharacters

import kotlin.math.max

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3

Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    // using map
//    fun lengthOfLongestSubstring(s: String): Int {
//        var leftPoint = 0
//        var ans = 0
//        var map = mutableMapOf<Char,Int>()
//
//        for(i in s.indices){
//            if(map.contains(s[i])){
//                leftPoint = max(map[s[i]]!!,leftPoint)
//            }
//
//            ans = max(ans,i-leftPoint+1)
//            map[s[i]] = i+1
//
//        }
//        return ans
//    }

    // using set
    fun lengthOfLongestSubstring(s: String): Int {
        var ans = 0
        var left = 0
        var right = 0
        var set = HashSet<Char>()

        while (left < s.length && right < s.length) {
            if (!set.contains(s[right])) {
                set.add(s[right++])
                ans = max(set.size, ans)
            } else {
                set.remove(s[left++])
            }

        }
        return ans
    }
}

fun main() {
    var sol = Solution()
    print(sol.lengthOfLongestSubstring("abcbc"))
}