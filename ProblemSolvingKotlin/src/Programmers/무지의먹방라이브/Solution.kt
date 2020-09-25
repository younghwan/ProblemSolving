package Programmers.무지의먹방라이브

import java.util.*

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var answer = 0
        var totalTime = k
        var pq = PriorityQueue<Pair<Int, Int>>()

        for ((idx, time) in food_times.withIndex()) {
            pq.add(Pair(idx, time))
        }

        while (pq.isNotEmpty()) {
            var time = pq.poll().second
            if (pq.size * time + time > k) {
                totalTime -= pq.size * time + time
            } else {
                break
            }
        }



        return answer
    }
}