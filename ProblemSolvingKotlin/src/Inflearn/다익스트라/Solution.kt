package Inflearn.다익스트라

import java.util.*
import kotlin.Comparator

// 다익스트라는 간선값이 무조건 양수여야한다.
// 갱신될일이 없는 노드를 기준으로 최소 간선을 찾는방식

/**
시간 복잡도

다익스트라는 모든 간선(E)을 검사하며 정점을 우선순위 큐에 넣고 뺀다.
1  모든 간선을 검사할 경우. O( E )
2 모든 간선을 검사할 때마다 우선순위 큐에 모든 정점을 삽입/삭제하는 경우
모든 정점 x 우선순위 큐 자체의 수행시간
=> O( ElgE )

O(ElgE) = 간선 검사 할때마다 우선순위 큐에 저장 x 우선순위 큐에서 삭제 및 추가
단, 대게 E는 V^2보다 작기 때문에 상한을 기준으로 O(ElgV)가 된다.
최종적으로, O(E) + O(ElgV) => O(ElgV) 시간 복잡도가 된다.
 */

lateinit var dist: Array<Int>
lateinit var graph: Array<Array<Int>>

data class Node(var vertex: Int, var distance: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return distance - other.distance
    }
}

class Solution {
    fun dijkstra() {
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        val M = sc.nextInt()
        val pq = PriorityQueue<Node>()

        graph = Array(N + 1) { Array(N + 1) { 0 } }
        dist = Array(N + 1) { Int.MAX_VALUE }

        repeat(M) {
            val start = sc.nextInt()
            val end = sc.nextInt()
            val len = sc.nextInt()
            graph[start][end] = len
        }

        pq.add(Node(1, 0))
        dist[1] = 0
        while (pq.isNotEmpty()) {
            var cur = pq.peek().vertex
            var cost = pq.peek().distance
            pq.remove()

            if (cost > dist[cur]) continue

            for ((ver, dis) in graph[cur].withIndex()) {
                var nextDis = cost + dis
                if (dist[ver] > nextDis && dis != 0) {
                    dist[ver] = nextDis
                    pq.add(Node(ver, nextDis))
                }
            }
        }

        for (i in 2 until dist.size) {
            println("$i : ${dist[i]}")
        }
    }
}

fun main() {
    var solution = Solution()
    solution.dijkstra()
}

//6 9 1 2 12 1 3 4 2 1 2 2 3 5 2 5 5 3 4 5 4 2 2 4 5 5 6 4 5
