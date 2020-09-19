package Inflearn

import java.util.*
import kotlin.collections.ArrayList

// 41
fun main() {
    var sc = Scanner(System.`in`)

    var n = sc.nextInt()

    for (i in 2 until n / 2) {
        var tmp = n
        for (j in 1..i) {
            tmp -= j
        }
        if (tmp % i == 0) {
            for (k in 1..i) {
                if (k == i) {
                    println("${k + (tmp / i)} = $n")
                }
                else print("${k + (tmp / i)} + ")
            }
        }
    }
}