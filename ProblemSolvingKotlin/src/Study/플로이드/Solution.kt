package Study.플로이드
//https://www.acmicpc.net/problem/11404
import java.util.*

class Solution {
    lateinit var graph: Array<Array<Int>>
    fun solution() {
        var sc = Scanner(System.`in`)
        var nodeCnt = sc.nextInt()
        var pathCnt = sc.nextInt()
        var INF = 100000000

        graph = Array(nodeCnt + 1) { i -> Array(nodeCnt + 1) { j -> if (i == j) 0 else INF } }


        repeat(pathCnt) {
            var i = sc.nextInt()
            var j = sc.nextInt()
            var n = sc.nextInt()
            if (n < graph[i][j]) {
                graph[i][j] = n
            }
        }

        for (k in 1..nodeCnt) {
            for (i in 1..nodeCnt) {
                for (j in 1..nodeCnt) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j])
                }
            }
        }

        for (i in 1..nodeCnt) {
            for (j in 1..nodeCnt) {
                if (graph[i][j] == INF) print("0 ")
                else print("${graph[i][j]} ")
            }
            println()
        }

    }
}

fun main() {
    var solution = Solution()
    solution.solution()
}