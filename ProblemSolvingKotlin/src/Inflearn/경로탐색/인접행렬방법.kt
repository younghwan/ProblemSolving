package Inflearn.경로탐색

import java.util.*
import kotlin.collections.ArrayList

lateinit var arr: Array<Array<Int>>
lateinit var check: Array<Boolean>
lateinit var map: Array<ArrayList<Int>>
var N = 0
var cnt = 0

// 인접리스트 방법(좀더 효율적)
fun sol2() {
    var sc = Scanner(System.`in`)
    N = sc.nextInt()
    var M = sc.nextInt()
    check = Array(N+1) { it == 1 }

    map = Array<ArrayList<Int>>(M+1) { arrayListOf() }

    for (i in 0 until M) {
        var start = 0
        var end = 0
        start = sc.nextInt()
        end = sc.nextInt()
        map[start].add(end)
    }

    DFS2(1)
    for(i in map){
        println(i)
    }

    println(cnt)

}

// 인접행렬 방법
fun sol1() {
    var sc = Scanner(System.`in`)
    N = sc.nextInt()
    var M = sc.nextInt()
    arr = Array<Array<Int>>(N) { Array(N) { 0 } }
    check = Array(N) { it == 0 }

    for (i in 0 until M) {
        var start = 0
        var end = 0
        start = sc.nextInt()
        end = sc.nextInt()

        arr[start - 1][end - 1] = 1
    }

    for (i in arr) {
        println(i.contentToString())
    }
    DFS(0)
    println(cnt)
}

fun DFS(n: Int) {
    if (n == N - 1) {
        println(check.contentToString())
        cnt++
        check[n - 1] = false
        return
    }
    for (i in 0 until N) {
        if (arr[n][i] == 1 && !check[i]) {
            check[i] = true
            DFS(i)
            check[i] = false
        }
    }

}

fun DFS2(n : Int) {
    if(n == N){
        cnt++
        check[n] = false
        return
    }
    for(i in map[n]){
        println(i)
        if(!check[i]){
            check[i] = true
            DFS2(i)
            check[i] = false
        }
    }
}

fun main() {
    sol2()
}
