package Inflearn

import java.util.*

lateinit var arr: Array<IntArray>
fun main() {

    var sc = Scanner(System.`in`)
    var cnt = 0
    var N = sc.nextInt()
    arr = Array<IntArray>( N + 2) { IntArray(N + 2) { 0 } }

    for (i in 1..N) {
        for (j in 1..N) {
            arr[i][j] = sc.nextInt()
        }
    }

    for (y in 1..N) {
        for (x in 1..N) {
            if (isTop(y, x)) {
                println("$y , $x")
                cnt++
            }
        }
    }

    println(cnt)
}

fun isTop(y: Int, x: Int): Boolean {
    var dx = arrayOf(1, -1, 0, 0)
    var dy = arrayOf(0, 0, 1, -1)

    var cur = arr[y][x]

    for (i in 0..3) {
        var nx = x + dx[i]
        var ny = y + dy[i]
        if (cur < arr[ny][nx]) return false
    }
    return true
}