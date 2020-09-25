package Study.DP.일로만들기

import kotlin.math.min

var ans = Int.MAX_VALUE

fun main() {
    var n = 26

    DFS(n,0)
    println(ans)
}

fun DFS(n: Int, cnt: Int) {

    if (n == 1) {
        ans = min(ans, cnt)
        return
    }
    if (n % 5 == 0) DFS(n / 5, cnt + 1)
    if (n % 3 == 0) DFS(n / 3, cnt + 1)
    if (n % 2 == 0) DFS(n / 2, cnt + 1)
    DFS(n - 1, cnt + 1)

}