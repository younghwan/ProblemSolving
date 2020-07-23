package Programmers.StringCustomSort

import java.util.*

fun main() {
    var sol = Solution()
    var str: Array<String> = arrayOf("sun", "bed", "car")
    println(sol.solution(str, 1))
}

class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        Arrays.sort(
            strings
        ) { o1: String, o2: String ->
            val char1 = o1[n]
            val char2 = o2[n]
            if (char1 == char2) {
                return@sort o1.compareTo(o2)
            } else {
                return@sort char1.compareTo(char2)
            }
        }
        return strings
    }
}

//class Solution {
//    fun solution(strings: Array<String>, n: Int): Array<String> {
//        var answer = strings
//
//        var list =  answer.sortedWith(compareBy({ it[n] }, { it }))
//        return list.toTypedArray()
//    }
//}