package Study.퇴사

import java.util.*

object Solution {
    var n // 전체 상담 개수
            = 0
    var t = IntArray(15) // 각 상담을 완료하는데 걸리는 기간
    var p = IntArray(15) // 각 상담을 완료했을 때 받을 수 있는 금액
    var dp = IntArray(16) // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
    var maxValue = 0
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    Solution.n = sc.nextInt()
    for (i in 0 until Solution.n) {
        Solution.t[i] = sc.nextInt()
        Solution.p[i] = sc.nextInt()
    }

    // 배열을 뒤에서부터 거꾸로 확인
    for (i in Solution.n - 1 downTo 0) {
        val time = Solution.t[i] + i
        // 상담이 기간 안에 끝나는 경우
        if (time <= Solution.n) {
            // 점화식에 맞게, 현재까지의 최고 이익 계산
            Solution.dp[i] = Math.max(Solution.p[i] + Solution.dp[time], Solution.maxValue)
            Solution.maxValue = Solution.dp[i]
        } else Solution.dp[i] = Solution.maxValue
    }
    println(Solution.maxValue)
}