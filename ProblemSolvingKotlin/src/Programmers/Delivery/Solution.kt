package Programmers.Delivery

import KotlinPractice.Interview.Sol
import java.lang.Integer.min
import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/12978

data class Node(var ver: Int, var dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return dist - other.dist
    }
}

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {


        val arr = Array(N + 1) { Array(N + 1) { 0 } }
        var distArr = Array<Int>(N + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Node>()


        for (i in road) {
            if (arr[i[0]][i[1]] == 0) {
                arr[i[0]][i[1]] = i[2]
                arr[i[1]][i[0]] = i[2]
            } else {
                arr[i[0]][i[1]] = min(arr[i[0]][i[1]], i[2])
                arr[i[1]][i[0]] = min(arr[i[1]][i[0]], i[2])
            }
        }

//        for (i in arr) {
//            println(i.contentToString())
//        }
        pq.add(Node(1, 0))
        distArr[1] = 0

        while (pq.isNotEmpty()) {
            var curNode = pq.peek().ver
            var curDist = pq.peek().dist
            pq.remove()
//            println("node = $curNode, dist = $curDist")
            if (distArr[curNode] < curDist) continue

            for ((idx, cost) in arr[curNode].withIndex()) {
                val newDist = curDist + cost
                if (cost != 0 && newDist < distArr[idx]) {
                    distArr[idx] = newDist
                    pq.add(Node(idx, newDist))
                }
            }
        }
        var cnt = 0
        for ((idx, i) in distArr.withIndex()) {
//            println("$idx , $i")
            if (i <= k) cnt++
        }

        return cnt
    }
}

fun main() {
    var sol = Solution()
    sol.solution(
        6, arrayOf(
            intArrayOf(1, 2, 1), intArrayOf(1, 3, 2), intArrayOf(2, 3, 2), intArrayOf(3, 4, 3),
            intArrayOf(3, 5, 2),
            intArrayOf(3, 5, 3),
            intArrayOf(5, 6, 1)
        ), 4
    )
}

/*
class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val linkM = HashMap<Int, MutableList<TD>>().apply {
            road.groupBy({ it[0] }, { TD(it[1], it[2]) }).forEach { key, value ->
                put(key, getOrDefault(key, mutableListOf()).apply { addAll(value) })
            }
            road.groupBy({ it[1] }, { TD(it[0], it[2]) }).forEach { key, value ->
                put(key, getOrDefault(key, mutableListOf()).apply { addAll(value) })
            }
        }

        val delivery = HashSet<Int>().apply { add(1) }
        val shorts = IntArray(N) { 500001 }.also { it[0] = 0 }
        val nextDT = LinkedList<TD>()

        fun search(td: TD) {
            linkM[td.town]?.asSequence()!!.filter { td.distance + it.distance <= k }.map { TD(it.town, td.distance + it.distance) }.forEach {
                if (shorts[it.town - 1] > it.distance) {
                    shorts[it.town - 1] = it.distance
                    delivery.add(it.town)
                    nextDT.add(it)
                }
            }
        }

        search(TD(1, 0))
        while (nextDT.isNotEmpty()) {
            search(nextDT.pollFirst())
        }

        return delivery.size
    }

    data class TD(var town: Int, var distance: Int)
}
 */

/*
class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer:Int = 0
        var len:Int = road.size - 1
    var dist:IntArray = IntArray(N+1, {i->100000000})
    dist[1] = 0
    var flag:Boolean = true

    while(flag){
        flag = false

        for(i in 0..len){
            if(dist[road[i][0]] + road[i][2] < dist[road[i][1]]){
                flag = true
                dist[road[i][1]] = dist[road[i][0]] + road[i][2]
            }
            if(dist[road[i][1]] + road[i][2] < dist[road[i][0]]){
                flag = true
                dist[road[i][0]] = dist[road[i][1]] + road[i][2]
            }
        }
    }

    for(i in 1..N)
    {
        if(dist[i] <= k) answer++
//      println(">>>> ${dist[i]}")
    }

    return answer;
    }
}
 */