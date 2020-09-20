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

    var isLive = draw()
    var timeSec = 0
    var posY = 0
    var posX = 0
    var dir = 0 // 0 = x++ , 1 = y++ , 2 = x-- , 3 = y--
    while (isLive) {
        timeSec++
        println(timeSec)
        if (time[timeSec] == "") {
            if (dir) posX++ else posY++

            if (posX >= boardSize || posY >= boardSize) break
            var isEat = map[posY][posX] == 1
            snake.run {
                if (!isEat) {
                    map[body[0].first][body[0].second] = 0
                    body.removeAt(0)
                }
                body.add(Pair(posY, posX))
            }
            isLive = draw()
        }
        if (time[timeSec] == "D") {
            posY++
            if (posX >= boardSize || posY >= boardSize) break
            var isEat = map[posY][posX] == 1
            snake.run {
                if (!isEat) {
                    map[body[0].first][body[0].second] = 0
                    body.removeAt(0)
                }
                body.add(Pair(posY, posX))
            }
            isLive = draw()
            dir = false
        }

        if (time[timeSec] == "L") {
            posY++
            if (posX >= boardSize || posY >= boardSize) break
            var isEat = map[posY][posX] == 1
            snake.run {
                if (!isEat) {
                    map[body[0].first][body[0].second] = 0
                    body.removeAt(0)
                }
                body.add(Pair(posY, posX))
            }
            isLive = draw()
            dir = false
        }
    }
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

fun move(dir: Int){
    var isEat = map[posY][posX] == 1
    snake.run {
        if (!isEat) {
            map[body[0].first][body[0].second] = 0
            body.removeAt(0)
        }
        body.add(Pair(posY, posX))
    }
}