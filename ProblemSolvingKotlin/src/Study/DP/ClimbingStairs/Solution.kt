package Study.DP.ClimbingStairs

class Solution {
    fun climbStairs(n: Int): Int {

        var arr = Array(n+1){0}
        arr[1] = 1
        arr[2] = 2
        for (i in 3..n) {
            arr[i] = arr[i - 1] + arr[i - 2]
        }

        return arr[n]
    }
}

fun main() {
    var solution = Solution()

    print(solution.climbStairs(2))
}
