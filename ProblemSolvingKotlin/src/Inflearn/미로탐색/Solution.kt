package Inflearn.미로탐색

import java.util.*


lateinit var arr: Array<Array<Int>>
lateinit var check: Array<Array<Boolean>>
var dy = arrayOf(0, 0, 1, -1)
var dx = arrayOf(1, -1, 0, 0)
var cnt = 0

fun main() {
    var sc = Scanner(System.`in`)
    arr = Array(7) { Array(7) { 0 } }
    check = Array(7) { Array(7) { false } }

    check[0][0] = true

    for (i in 0..6) {
        for (j in 0..6) {
            arr[i][j] = sc.nextInt()
        }
    }

    DFS(0,0)
    println(cnt)
}

fun DFS(y: Int, x: Int) {
    if (y == 6 && x == 6) {
        cnt++
        return
    }

    for (i in 0..3) {
        var nx = x + dx[i]
        var ny = y + dy[i]

        if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && !check[ny][nx] && arr[ny][nx] == 0) {
            check[ny][nx] = true
            DFS(ny, nx)
            check[ny][nx] = false
        }
    }

}