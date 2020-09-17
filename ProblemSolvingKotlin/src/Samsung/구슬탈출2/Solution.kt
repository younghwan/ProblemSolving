package Samsung.구슬탈출2

import java.lang.Math.abs
import java.util.*
import java.util.Queue

data class Ball(var rx: Int, var ry: Int, var bx: Int, var by: Int, var count: Int)

var start = Ball(0, 0, 0, 0, 0)
lateinit var board: Array<Array<String>>
fun main() {
    var sc = Scanner(System.`in`)
    var N = sc.nextInt()
    var M = sc.nextInt()

    board = Array(N) { Array(M) { "" } }

    for (y in 0 until M) {
        var str = sc.next()
        for ((x, c) in str.withIndex()) {
            board[y][x] = c.toString()
            if (c == 'R') {
                start.rx = x
                start.ry = y
            }
            if (c == 'B') {
                start.bx = x
                start.by = y
            }
        }
    }


    start.count = 0

    println(bfs())

}

fun bfs(): Int {
    var dy = arrayOf(-1, 1, 0, 0)
    var dx = arrayOf(0, 0, -1, 1)

    var visited = Array(10) { Array(10) { Array(10) { Array(10) { 0 } } } }
    var q: Queue<Ball> = LinkedList()

    q.add(start)
    visited[start.ry][start.rx][start.by][start.bx] = 1

    var ret = -1

    while (!q.isEmpty()) {
        var cur: Ball = q.poll()
        println(cur)
        if (cur.count > 10) break

        if (board[cur.ry][cur.rx] == "O" && board[cur.by][cur.bx] != "O") {
            ret = cur.count
            break
        }

        for (dir in 0..3) {
            var next_ry = cur.ry
            var next_rx = cur.rx
            var next_by = cur.by
            var next_bx = cur.bx

            while (true) {
                if (board[next_ry][next_rx] != "#" && board[next_ry][next_rx] != "O") {
                    next_rx += dx[dir]
                    next_ry += dy[dir]
                } else {
                    if (board[next_ry][next_rx] == "#") {
                        next_ry -= dy[dir]
                        next_rx -= dx[dir]
                    }
                    break
                }
            }

            while (true) {
                if (board[next_by][next_bx] != "#" && board[next_by][next_bx] != "O") {
                    next_bx += dx[dir]
                    next_by += dy[dir]
                } else {
                    if (board[next_by][next_bx] == "#") {
                        next_by -= dy[dir]
                        next_bx -= dx[dir]
                    }
                    break
                }
            }

            if (next_ry == next_by && next_rx == next_bx) {
                if (board[next_ry][next_rx] != "O") {
                    var red_dist = abs(next_ry - cur.ry) + abs(next_rx - cur.rx)
                    var blue_dist = abs(next_by - cur.by) + abs(next_bx - cur.bx)
                    if (red_dist > blue_dist) {
                        next_ry -= dy[dir]
                        next_rx -= dx[dir]
                    } else {
                        next_by -= dy[dir]
                        next_bx -= dx[dir]
                    }
                }
            }

            if (visited[next_ry][next_rx][next_by][next_bx] == 0) {
                visited[next_ry][next_rx][next_by][next_bx] = 1
                q.add(Ball(next_ry, next_rx, next_by, next_bx, cur.count + 1))
            }
        }

    }

    return ret
}
