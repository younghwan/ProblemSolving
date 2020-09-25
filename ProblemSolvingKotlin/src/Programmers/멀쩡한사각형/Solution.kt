package Programmers.멀쩡한사각형

import java.math.BigInteger

// W*H의 반복패턴은 최대공약수로 나누어지는 사각형의 반복이다. 이때 최대공약수가 1일경우 잘라지는 사각형은 W+H-1 이다.
// W*H의 사각형을 대각선으로 잘랐을때 망가지게되는 사각형을 구하는 최종 공식 : [ W+H-최대공약수 ]

class Solution {
//    fun solution(w: Int, h: Int): Long {
//        var answer: Long = 0
//
//
//        return ((w * h) - (w + h - gcd)).toLong()
//    }
    fun solution(w: Int, h: Int): Long {
        val gcd = BigInteger.valueOf(w.toLong()).gcd(BigInteger.valueOf(h.toLong())).toInt()
        return w.toLong() * h.toLong() - (w.toLong() / gcd + h.toLong() / gcd - 1) * gcd
    }


    fun GCD(a: Int, b: Int): Int {
        var aa = a
        var bb = b
        if (bb > aa) {
            aa = b
            bb = a
        }
        while (bb != 0) {
            var n = aa % bb
            aa = bb
            bb = n
        }
        return aa
    }
}

fun main() {
    var solution = Solution()
    println(solution.solution(8, 12))
}
