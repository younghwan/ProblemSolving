package Programmers.Kakao.InspectionWall

class Solution {
    private var n = 0
    private var num = 0
    private var finish = false
    lateinit var weak: IntArray
    lateinit var dist: IntArray
    lateinit var choice: IntArray
    lateinit var rotateWeak: Array<IntArray>
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        this.n = n
        this.weak = weak
        this.dist = dist
        setWeak()
        for (i in 1..dist.size) {
            num = i
            choice = IntArray(num)
            permutation(0, BooleanArray(dist.size))
            if (finish) break
        }
        return if (finish) num else -1
    }

    fun permutation(depth: Int, visit: BooleanArray) {
        if (finish) return
        if (depth == num) {
            check()
            return
        }
        for (i in dist.indices) {
            if (!visit[i]) {
                choice[depth] = dist[i]
                visit[i] = true
                permutation(depth + 1, visit)
                visit[i] = false
            }
        }
    }

    fun check() {
        for (weak in rotateWeak) {
            var idx = 0
            var start = 0
            val visit = BooleanArray(weak.size)
            while (idx != num) {
                val i = start
                val value = choice[idx++]
                for (j in start until weak.size) {
                    if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value)) break
                    visit[j] = true
                    start++
                }
            }
            if (isFinish(visit)) {
                finish = true
                return
            }
        }
    }

    fun isFinish(visit: BooleanArray): Boolean {
        for (bool in visit) {
            if (!bool) return false
        }
        return true
    }

    fun setWeak() { // weak를 0 ~ n-1번 회전하여 rotateWeak에 저장
        val len = weak.size
        rotateWeak = Array(len) { IntArray(len) }
        for (i in 0 until len) {
            rotateWeak[i] = rotate(weak, i)
        }
    }

    fun rotate(weak: IntArray, idx: Int): IntArray {
        val len = weak.size
        val result = IntArray(len)
        for (i in 0 until len) {
            if (i + idx < len) result[i] = weak[i + idx] else result[i] = weak[i + idx - len] + n
        }
        return result
    }
}
