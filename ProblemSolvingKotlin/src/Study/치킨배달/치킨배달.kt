package Study.치킨배달

import java.util.*
import kotlin.collections.ArrayList

var M: Int = 0
var curShop = 0
var arr: Array<IntArray> = arrayOf()

var home = ArrayList<POS>()
var shop = ArrayList<POS>()
var pick = ArrayList<POS>()
var ans = Int.MAX_VALUE

data class POS(var y: Int, var x: Int)

fun main() {
    var sc = Scanner(System.`in`)
    var N = sc.nextInt() //size
    M = sc.nextInt() //폐업시키지 않을것
    arr = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        for (j in 0 until N) {
            arr[i][j] = sc.nextInt()
        }
    }

    for (i in arr.indices) {
        for (j in arr.indices) {
            if (arr[i][j] == 2) {
                shop.add(POS(i, j))
            }
            if (arr[i][j] == 1) {
                home.add(POS(i, j))
            }
        }
    }
    DFS(0)
    println(ans)
}

fun DFS(cnt: Int) {

    if (pick.size == M) {
        var cand = 0
        for (i in home) {
            var minDis = Int.MAX_VALUE
            for (j in pick) {
                minDis = Math.min(minDis, Math.abs(i.x - j.x) + Math.abs(i.y - j.y))
            }
            cand += minDis
        }

        if (ans > cand) ans = cand

        return
    }

    for (i in cnt until shop.size) {
        pick.add(POS(shop[i].y, shop[i].x))
        DFS(i + 1)
        pick.removeAt(pick.size - 1)
    }
}

//fun find
/*
5 2
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */

/*
5 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
 */