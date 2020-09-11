package Programmers.SkilTest

import java.lang.Math.abs

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {

        var A = 0
        var B = 0

        if (a > b) {
            A = a
            B = b
        } else {
            A = b
            B = a
        }
        var cnt = 1
        while (!check(A,B)) {
            A = win(A)
            B = win(B)
            cnt++
        }

        return cnt
    }

    fun check(a: Int, b: Int): Boolean {
        var res = if (a % 2 == 0) {
            a - b
        } else {
            b - a
        }
        return res == 1
    }

    fun win(n: Int): Int {
        return if (n % 2 == 0) {
            n / 2
        } else {
            (n + 1) / 2
        }
    }
}

fun main() {
    var solution = Solution()
    println(solution.solution(1, 2, 3))
    // 1 2 3 4 5 6 7 8
    // 1 2 3 4

//    println(solution.win())
}

