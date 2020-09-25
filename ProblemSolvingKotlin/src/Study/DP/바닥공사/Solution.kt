package Study.DP.바닥공사

import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var N = sc.nextInt()
    var arr = Array(N + 1) { 0 }

    arr[1] = 1
    arr[2] = 3

    for (i in 3..N) {
        arr[i] = arr[i - 1] + (2 * arr[i - 2])
    }
    println(arr[N])

}