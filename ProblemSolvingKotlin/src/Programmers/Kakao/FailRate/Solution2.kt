package Programmers.Kakao.FailRate


class Solution2 {
    fun solution(N: Int, stages: IntArray): IntArray {
        val stagesToFailure = (1..N).map { n ->
            val arrived = stages.count { n <= it }
            if (arrived == 0)
                n to 0f
            else {
                val notCleared = stages.count { n == it }
                n to notCleared.toFloat() / arrived.toFloat()
            }
        }.toMap()

        return stagesToFailure.keys.sortedWith(Comparator { l, r ->
            if (l == r)
                r.compareTo(l)
            else
                stagesToFailure[r]!!.compareTo(stagesToFailure[l]!!)
        }).toIntArray()
    }
}

