package tt

import java.util.*

class Solution {
    fun solution(encrypted_text: String, key: String, rotation: Int): String {
        var answer: String = ""
        var rotatedStr = reverse(encrypted_text, rotation)
        println(rotatedStr)
        for (i in rotatedStr.indices) {
            var pos = (rotatedStr[i] - key[i])
            answer += if (pos < 0) {
                (pos + 122).toChar()
            } else (pos + 96).toChar()
        }
        return answer
    }

    fun reverse(str: String, n: Int): String {
        val q = LinkedList<Char>()
        if (n > 0) {
            val len = n % str.length
            if (len == 0) return str
            for (i in 0 until len) {
                q.add(str[i])
            }
            var res = str.substring(len, str.length)
            println(res)
            while (q.isNotEmpty()) {
                res += q.pop()
            }
            return res
        } else if (n < 0) {
            val len = (-n) % str.length
            if (len == 0) return str
            for (i in 0 until len) {
                q.add(str[str.length - i - 1])
            }
            var res = ""
            while (q.isNotEmpty()) {
                res = q.pop() + res
            }
            res += str.substring(0, str.length - len)
            return res
        }
        return str
    }
}

fun main() {
    var sol = Solution();
    println(sol.reverse("qyyigoptvfb", 3))
    sol.solution("qyyigoptvfb", "abcdefghijk", 3)
}