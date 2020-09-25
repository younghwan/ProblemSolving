package Study.DP.일로만들기

import java.lang.Integer.min
import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var table = Array<Int>(30000) {0}

    for (i in 2..n) {
        table[i] = table[i - 1] + 1
        if (i % 3 == 0) {
            table[i] = min(table[i], table[i / 3] + 1)
        }
        if (i % 5 == 0) {
            table[i] = min(table[i], table[i / 5] + 1)
        }
        if (i % 2 == 0) {
            table[i] = min(table[i], table[i / 2] + 1)
        }
    }
    println(table[n])

}