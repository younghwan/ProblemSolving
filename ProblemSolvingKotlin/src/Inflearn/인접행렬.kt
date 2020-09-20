package Inflearn

import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var N = sc.nextInt()
    var M = sc.nextInt()
    var arr = Array<Array<Int>>(N) { Array(N) { 0 } }

    for (i in 0 until M) {
        var start = 0
        var end = 0
        var len = 0
        start = sc.nextInt()
        end = sc.nextInt()
        len = sc.nextInt()

        arr[start - 1][end - 1] = len
    }

    for (i in arr) {
        println(i.contentToString())
    }

}