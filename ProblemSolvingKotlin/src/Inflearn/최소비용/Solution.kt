package Inflearn.최소비용

import java.lang.Integer.min
import java.util.*

var N = 0
var res = Int.MAX_VALUE
lateinit var arr: Array<Array<Int>>
lateinit var check: Array<Boolean>

fun main() {
    var sc = Scanner(System.`in`)
    N = sc.nextInt()
    var M = sc.nextInt()
    arr = Array<Array<Int>>(N) { Array(N) { 0 } }
    check = Array(N) { it == 0 }

    for (i in 0 until M) {
        var start = 0
        var end = 0
        var len = 0
        start = sc.nextInt()
        end = sc.nextInt()
        len = sc.nextInt()

        arr[start - 1][end - 1] = len
    }

    DFS(0,0)
    println(res)

}

fun DFS(n: Int, cost: Int) {
    if (n == N - 1) {
        res = min(res, cost)
        check[n] = false
        return
    }
    for (i in 0 until N) {
        if (!check[i] && arr[n][i] != 0) {
            check[i] = true
            var newCost = cost + arr[n][i]
            DFS(i,newCost)
            check[i] = false
        }
    }
}