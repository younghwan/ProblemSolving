package Inflearn.공주구하기

import java.util.*

fun main() {
    var N = 8
    var num = 3

    var q: Queue<Int> = LinkedList()
    for(i in 1..N) q.add(i)
    var cnt = 0
    while (q.size != 1) {
        cnt++
        if (cnt % num == 0) {
            q.remove()
            continue
        }
        q.add(q.poll())
    }
    println(q.poll())
}