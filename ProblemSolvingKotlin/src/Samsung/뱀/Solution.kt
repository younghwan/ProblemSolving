package Samsung.뱀

import java.util.*
import kotlin.collections.ArrayList

lateinit var map: Array<Array<Int>>
lateinit var snake: Snake
var boardSize = 0

data class Snake(var body: ArrayList<Pair<Int, Int>>)

fun main() {
    var sc = Scanner(System.`in`)
    boardSize = sc.nextInt()
    map = Array(boardSize) { Array(boardSize) { 0 } }
    snake = Snake(arrayListOf())
    snake.body.add(Pair(0, 0))
    var time = Array(10001) { "" }

    var appleCnt = sc.nextInt()
    repeat(appleCnt) {
        var i = sc.nextInt()
        var j = sc.nextInt()
        map[i - 1][j - 1] = 1
    }
    var behaviorCnt = sc.nextInt()
    repeat(behaviorCnt) {
        var i = sc.nextInt()
        var j = sc.next()
        time[i] = j
    }

    var timeSec = 0
    var posY = 0
    var posX = 0
    var dx = arrayOf(1, 0, -1, 0)
    var dy = arrayOf(0, 1, 0, -1)
    var dir = 0
    while (true) {
        timeSec++
//        println(timeSec)
        posY += dy[dir]
        posX += dx[dir]

        if (posX >= boardSize || posY >= boardSize || posX < 0 || posY < 0 || map[posY][posX] == 2) break


        var isEat = map[posY][posX] == 1
        snake.run {
            if (!isEat) {
                map[body[0].first][body[0].second] = 0
                body.removeAt(0)
            }
            body.add(Pair(posY, posX))
        }
        draw()

        if (time[timeSec] == "D") {
            dir = (dir + 1) % 4
        }

        if (time[timeSec] == "L") {
            dir = (dir + 3) % 4
        }
    }

    println(timeSec)
}

fun draw(): Boolean {
    var isDraw = true

    for (i in snake.body) {
        if (i.first < boardSize && i.second < boardSize) {
            map[i.first][i.second] = 2
        } else isDraw = false
    }

    for (i in map) {
        println(i.contentToString())
    }
    println()
    return isDraw
}
