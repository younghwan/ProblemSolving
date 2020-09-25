package Inflearn.최대수입스케쥴

import java.lang.Integer.max
import java.util.*

fun main() {
    var N = 6
    var arr = arrayOf(
        arrayOf(50, 2),
        arrayOf(20, 1),
        arrayOf(40, 2),
        arrayOf(60, 3),
        arrayOf(30, 3),
        arrayOf(30, 1)
    )

    arr.sortWith(compareByDescending { it[1] })
    var pq = PriorityQueue<Int>(compareByDescending { it })
    var ans = 0
    var maxDay = arr.maxOf { it[1] }
    var i = 0
    while (i < arr.size){
        if(arr[i][1] == maxDay){
            pq.add(arr[i][0])
            i++
            continue
        }
        ans += pq.poll()
        maxDay--
    }
        ans += pq.poll()
        println(ans)
}