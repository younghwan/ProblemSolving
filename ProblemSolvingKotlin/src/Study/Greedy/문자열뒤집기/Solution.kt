package Study.Greedy.문자열뒤집기

import java.lang.Integer.min
import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var str = sc.nextLine()
    var cntZero = 0
    var cntOne = 0
    var cur = 0
    if (str[0] == '0') {
        cntZero += 1
    } else {
        cntOne += 1
        cur = 1
    }


    for (c in str) {
        if (cur == 1 && c == '0') {
            cntZero++
            cur = 0
        } else if (cur == 0 && c == '1') {
            cntOne++
            cur = 1
        }
    }
    println(min(cntOne,cntZero))
}