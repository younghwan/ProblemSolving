package Study.Greedy.만들수없는금액

import java.util.*

fun main() {
    var arr = arrayOf(3, 2, 1, 1, 9)
    var pq = PriorityQueue<Int>(compareByDescending { it })

    pq.addAll(arr)
    arr.sort()
    if (arr[0] > 1) {
        println(arr[0] - 1)
        return
    }

    for (i in arr[0]..arr.sum()) {
        var temp = i
        var tempPQ = pq
        println(tempPQ)
        var flag = false
        while (tempPQ.isNotEmpty() || temp == 0) {
            val n = tempPQ.poll()
            if (n == temp) {
                flag = true
                break
            }
            if (n > temp) continue
            temp -= n
        }
        if (!flag) {
            println(i)
            return
        }
        tempPQ.clear()
        tempPQ.addAll(arr)
    }

}