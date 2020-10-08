package Study.DP.병사배치하기

import java.util.*

// https://www.acmicpc.net/problem/18353

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val arr = Array(N) { 0 }
    val dp = Array(N) { 1 }

    for (i in 0 until N) {
        arr[i] = sc.nextInt()
    }
    for (i in 1 until N) {
        for (j in i - 1 downTo 0) {
            if (arr[j] > arr[i]) {
                dp[i] = Math.max(dp[j] + 1, dp[i])
            }
        }
    }
    println(N-dp.max()!!.toInt())
}
/*
7
15 11 4 8 5 2 4
 */