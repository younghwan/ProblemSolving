package String.TwoStringAnagram

class SolutionKotlin {
    fun minSteps(s: String, t: String): Int {
        val a = IntArray(26)
        for (c in s.toCharArray()) {
            a[c - 'a']++
        }
        val arr_t = IntArray(26)
        for (c in t.toCharArray()) {
            arr_t[c - 'a']++
        }
        var count = 0
        for (i in a.indices) {
            count += Math.max(0, a[i] - arr_t[i])
        }
        return count
    }

    fun main() {
        var solution = SolutionKotlin()
        solution.minSteps("abb","aba")
    }
}