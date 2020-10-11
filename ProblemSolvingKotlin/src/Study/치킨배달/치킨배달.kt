package Study.치킨배달

import java.util.*

var M: Int = 0
var arr: Array<IntArray> = arrayOf()
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

//    for(i in arr){
//        println(i.contentToString())
//    }
    DFS(0, 0, 0)

}

fun DFS(cnt: Int, y: Int, x: Int) {
    if (cnt == M) {
        for (i in arr) {
            println(i.contentToString())
        }
        println()
        return
    } else {
        for (i in y until arr.size) {
            for (j in x until arr.size) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 0
                    DFS(cnt + 1, i, j)
                    arr[i][j] = 2
                }
            }
        }
    }
}

/*
5 2
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */