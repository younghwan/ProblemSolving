package Programmers.StringHandlingBasic

import java.lang.NumberFormatException

class Solution {
    fun solution(s: String): Boolean {

        if(s.length != 4 && s.length != 6) return false

        try {
            s.toInt()
        }catch (e:NumberFormatException){
            return false
        }

        return true
    }
}

//class Solution {
//    fun solution(s: String): Boolean
//    {
//        val length = s.filter { it.isDigit() }.length
//        return (length == 4 || length == 6) && length == s.length
//    }
//}

fun main(){
    var s = "a234"
    var s2 = "1234"
    var solution = Solution()

    println(s.filter { it.isDigit() })

    println(s)

//    println(solution.solution(s))
//    println(solution.solution(s2))
}