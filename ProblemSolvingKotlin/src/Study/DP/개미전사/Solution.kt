package Study.DP.개미전사

import java.lang.Integer.max

fun main() {
    var arr = arrayOf(1, 3, 1, 5)
    var d = Array(101) { 0 }
    d[0] = arr[0]
    d[1] = max(arr[0], arr[1])
    for (i in 2 until arr.size) {
        d[i] = max(d[i - 1], d[i - 2] + arr[i]) // 내자리를 먹냐 or 안먹냐
    }
    println(d[arr.size-1])
}