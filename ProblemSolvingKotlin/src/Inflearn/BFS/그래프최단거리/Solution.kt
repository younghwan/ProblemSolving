package Inflearn.BFS.그래프최단거리

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var N = sc.nextInt()
    var M = sc.nextInt()
    var arr = Array(N) { Array(N) { 0 } }
    var check = Array(N) {false}
    for (i in 0 until M) {
        var s = sc.nextInt() - 1
        var e = sc.nextInt() - 1
        arr[s][e] = 1
    }

    for(i in arr){
        println(i.contentToString())
    }

    var q: Queue<Int> = LinkedList()
    var ansArr = Array<Int>(N+1) { 0 }

    q.add(0)
    while (!q.isEmpty()) {
        var value = q.poll()
        if (!check[value]) {
            check[value] = true
            for ((idx, i) in arr[value].withIndex()) {
                if (i == 1) {
                    println("idx = $idx")
                    ansArr[idx+1] = ansArr[value] + 1
                    q.add(idx)
                }
            }
        }
    }
    for (i in 1..N) {
        println("$i : ${ansArr[i]}")
    }
}