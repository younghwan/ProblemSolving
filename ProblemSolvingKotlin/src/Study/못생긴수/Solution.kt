package Study.못생긴수

import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var dp = IntArray(n + 1) { 0 }
    dp[1] = 1

    var p2 = 1
    var p3 = 1
    var p5 = 1
    var min = 0
    for (i in 2..n) {
        min = if (dp[p2] * 2 < dp[p3] * 3) dp[p2] * 2 else dp[p3] * 3
        if (min > dp[p5] * 5) min = dp[p5] * 5

        if (dp[p2] * 2 == min) p2++
        if (dp[p3] * 3 == min) p3++
        if (dp[p5] * 5 == min) p5++

        dp[i] = min

    }

    println(dp[n])
}





