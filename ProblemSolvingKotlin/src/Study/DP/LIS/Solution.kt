package Study.DP.LIS

/**
부분증가수열의 최대길이를 구하는문제 (LIS)

arr의 각 원소가 마지막이라 생각
dp는 각 원소를 마지막으로 만들어질수있는 증가수열의 최대 길이
 */

fun main() {
    var arr = intArrayOf(5, 3, 7, 8, 6, 2, 9, 4)
    var dp = Array<Int>(arr.size) { 1 }

    for (i in 1 until arr.size) {
        for (j in i downTo 0) {
            if(arr[j]<arr[i]){
                dp[i] = Math.max(dp[j] + 1, dp[i])
            }
            // i 뒤로 만들어질수있는 수(j<i) 중에 제일 긴거
        }
    }

    println(dp.contentToString()) //dp 테이블


}