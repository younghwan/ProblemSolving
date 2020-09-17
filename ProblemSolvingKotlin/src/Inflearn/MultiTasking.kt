package Inflearn

import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var len = sc.nextInt()
    var arr = Array<Int>(len) { 0 }
    for (i in 0 until len) {
        arr[i] = sc.nextInt()
    }
    var end = sc.nextInt()

    var point = -1
    var cnt = 0
    var ans = 0
    while (true) {
        point++
        if (point >= len) point = 0
        if (arr[point] == 0) continue
        arr[point]--
        cnt++
        if (cnt == end) break
    }
    while (true){
        point++
        if(point>=len) point =0
        if(arr[point] != 0) break
    }
    println(point+1)
}