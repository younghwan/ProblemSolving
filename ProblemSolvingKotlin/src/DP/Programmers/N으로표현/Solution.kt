package DP.Programmers.N으로표현
// DFS 풀이
class Solution {
    var answer = -1
    fun solution(N: Int, number: Int): Int {
        dfs(N, 0, 0, number, "")
        return answer
    }

    fun dfs(n: Int, pos: Int, num: Int, number: Int, s: String) {
        if (pos > 8) return
        if (num == number) {
            if (pos < answer || answer == -1) {
                println(s)
                answer = pos
            }
            return
        }
        var nn = 0
        for (i in 0..7) {
            nn = nn * 10 + n
            dfs(n, pos + 1 + i, num + nn, number, "$s+")
            dfs(n, pos + 1 + i, num - nn, number, "$s-")
            dfs(n, pos + 1 + i, num * nn, number, "$s*")
            dfs(n, pos + 1 + i, num / nn, number, "$s/")
        }
        // dfs(n,pos+1,num*10+n,number,s+"5");
    }
}

// DP 풀이
class Solution2 {
    fun solution(N: Int, number: Int): Int {
        var answer = -1
        val dp = Array(8) { hashSetOf( Array(it + 1) { "1" }.fold("")
        { total, next -> total + next }.toInt() * N ) }

        first@for (i in 1..7) {
            for (j in 0 until i) {
                for (num1 in dp[j]) {
                    for (num2 in dp[i-j-1]) {
                        dp[i].add(num1 + num2)
                        dp[i].add(num1 - num2)
                        dp[i].add(num1 * num2)
                        if (num2 != 0) dp[i].add(num1 / num2)
                    }
                }
            }

            if (number in dp[i]) {
                answer = i + 1
                first@break
            }
        }
        return answer
    }
}

fun main() {
    var solution = Solution2()
    var ar1 = arrayListOf<Int>(5)
    var ar2 = arrayListOf<Int>(55, 10, 0, 25, 1)
//    solution.oper(ar1, ar2)
    println(solution.solution(5, 12))
}

