package Samsung.TwoZeroFourEight

import java.lang.Integer.max
import java.util.*

var N = 0
var ans = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    var map = Array(N) { Array(N) { 0 } }
    for (i in 0 until N) {
        for (j in 0 until N) {
            map[i][j] = sc.nextInt()
        }
    }

//    moveLeft(map)
//    for (i in map) {
//        println(i.contentToString())
//    }

    DFS(0, -1, map)
    println(ans)

}

fun DFS(cnt: Int, dir: Int, inputMap: Array<Array<Int>>) {
    var map = Array(N) { Array(N) { 0 } }

    for (i in 0 until N) {
        for (j in 0 until N) {
            map[i][j] = inputMap[i][j]
        }
    }
    when (dir) {
        0 -> {
            map = moveUp(map)
        }
        1 -> {
            map = moveDown(map)
        }
        2 -> {
            map = moveLeft(map)
        }
        3 -> {
            map = moveRight(map)
        }
    }

    if (cnt > 4) {
        for (i in map) {
            for (j in i) {
                ans = max(ans, j)
            }
        }
        return
    }

//    println("cnt = $cnt")
//    for (i in map) {
//        println(i.contentToString())
//    }
//    println()

    DFS(cnt + 1, 0, map)
    DFS(cnt + 1, 1, map)
    DFS(cnt + 1, 2, map)
    DFS(cnt + 1, 3, map)
}

fun moveLeft(inputMap: Array<Array<Int>>): Array<Array<Int>> {
    var map = inputMap.copyOf()
    for (i in 0 until N) {
        var temp = map[i][0]
        var tempI = i
        var tempJ = 0
        for (j in 1 until N) {
            if (map[i][j] == 0) continue
            if (map[i][j] == temp) {
                map[tempI][tempJ] = temp * 2
                map[i][j] = 0
            }
            temp = map[i][j]
            tempI = i
            tempJ = j

        }
    }

    // 이동
    for (i in 0 until N) {
        for (j in 0 until N - 1) {
            if (map[i][j] == 0) {
                var tj = j + 1

                while (map[i][tj] == 0 && tj < N - 1) {
                    tj++
                }
                map[i][j] = map[i][tj]
                map[i][tj] = 0
            }
        }
    }

    return map
}

fun moveRight(inputMap: Array<Array<Int>>): Array<Array<Int>> {
    var map = inputMap.copyOf()
    for (i in 0 until N) {
        var temp = map[i][N - 1]
        var tempI = i
        var tempJ = N - 1
        for (j in N - 2 downTo 0) {
            if (map[i][j] == 0) continue
            if (map[i][j] == temp) {
                map[tempI][tempJ] = temp * 2
                map[i][j] = 0
            }
            temp = map[i][j]
            tempI = i
            tempJ = j

        }
    }

    // 이동
    for (i in 0 until N) {
        for (j in N - 1 downTo 1) {
            if (map[i][j] == 0) {
                var tj = j - 1

                while (map[i][tj] == 0 && tj > 0) {
                    tj--
                }
                map[i][j] = map[i][tj]
                map[i][tj] = 0
            }
        }
    }
    return map
}

fun moveUp(inputMap: Array<Array<Int>>): Array<Array<Int>> {
    var map = inputMap.copyOf()
    for (i in 0 until N) {
        var temp = map[0][i]
        var tempI = i
        var tempJ = 0
        for (j in 1 until N) {
            if (map[j][i] == 0) continue
            if (map[j][i] == temp) {
                map[tempJ][tempI] = temp * 2
                map[j][i] = 0
            }
            temp = map[j][i]
            tempI = i
            tempJ = j

        }
    }

    // 이동
    for (i in 0 until N) {
        for (j in 0 until N - 1) {
            if (map[j][i] == 0) {
                var tj = j + 1

                while (map[tj][i] == 0 && tj < N - 1) {
                    tj++
                }
                map[j][i] = map[tj][i]
                map[tj][i] = 0
            }
        }
    }
    return map
}

fun moveDown(inputMap: Array<Array<Int>>): Array<Array<Int>> {
    var map = inputMap.copyOf()
    for (i in 0 until N) {
        var temp = map[N - 1][i]
        var tempI = i
        var tempJ = N - 1
        for (j in N - 2 downTo 0) {
            if (map[j][i] == 0) continue
            if (map[j][i] == temp) {
                map[tempJ][tempI] = temp * 2
                map[j][i] = 0

            }
            temp = map[j][i]
            tempI = i
            tempJ = j

        }
    }

    // 이동
    for (i in 0 until N) {
        for (j in N - 1 downTo 1) {
            if (map[j][i] == 0) {
                var tj = j - 1

                while (map[tj][i] == 0 && tj > 0) {
                    tj--
                }
                map[j][i] = map[tj][i]
                map[tj][i] = 0
            }
        }
    }

    return map
}