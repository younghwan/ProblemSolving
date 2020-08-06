package Leetcode.ReverseString

//Write a function that reverses a string. The input string is given as an array of characters char[].
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//You may assume all the characters consist of printable ascii characters.

//Example 1:
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]

//Example 2:
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]

class Solution {
    fun reverseString(s: CharArray): Unit {
        var half = s.size / 2

        for (i in 0..half) {
            var temp = s[i]
            s[i] = s[s.size-1-i]
            s[s.size-1-i] = temp
        }
    }
}

fun main() {
    var arr = charArrayOf('h', 'e', 'l', 'l', 'o')

    var solution = Solution()
    println(solution.reverseString(arr))
}