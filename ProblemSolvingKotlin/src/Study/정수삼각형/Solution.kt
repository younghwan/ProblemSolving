package Study.정수삼각형

import java.util.*

var size = 0
lateinit var board: Array<Array<Int>>
var ans = 0
fun main() {
    var sc = Scanner(System.`in`)
    size = sc.nextInt()

    board = Array(size + 1) { Array(size + 1) { -1 } }

    for (i in 1..size) {
        for (j in 0 until i) {
            board[i][j] = sc.nextInt()
        }
    }

//    for (i in board) {
//        println(i.contentToString())
//    }
//    println()

    for (i in 2..size) {
        for (j in 0 until i) {
            var first = 0
            var second = board[i - 1][j]
            if (j - 1 >= 0) first = board[i - 1][j - 1]
            board[i][j] += Math.max(first, second)
        }
    }

//    for (i in board) {
//        println(i.contentToString())
//    }
//    DFS(1, 0, 0)

    println(board[size].max())
}

fun DFS(y: Int, x: Int, res: Int) {
    if (y == size + 1) {
        if (res > ans) ans = res
        return
    }
    val sum = res + board[y][x]

    DFS(y + 1, x, sum)
    DFS(y + 1, x + 1, sum)
}