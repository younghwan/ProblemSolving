package Study.특정거리의도시찾기

import java.util.*

// https://www.acmicpc.net/problem/18352

fun main() {
    var sc = Scanner(System.`in`)
    var nodeCnt = sc.nextInt()
    var pathCnt = sc.nextInt()
    var len = sc.nextInt()
    var start = sc.nextInt()

    var graph = Array(nodeCnt + 1) { arrayListOf<Int>() }
    var dis = Array(nodeCnt + 1) { -1 }

    for (i in 0 until pathCnt) {
        var a = sc.nextInt()
        var b = sc.nextInt()
        graph[a].add(b)
    }

    var q: Queue<Int> = LinkedList()
    dis[start] = 0
    q.add(start)

    while (q.isNotEmpty()) {
        var curNode = q.poll()
        for (i in graph[curNode]) {
            if (dis[i] == -1) {
                q.add(i)
                dis[i] = dis[curNode] + 1
            }
        }
    }

    var isEmpty = true

    for ((idx, i) in dis.withIndex()) {
        if (i == len) {
            isEmpty = false
            println(idx)
        }
    }

    if (isEmpty) {
        println("-1")
        return
    }
}

/*
4 4 2 1
1 2
1 3
2 3
2 4
 */
// 4

/*
4 3 2 1
1 2
1 3
1 4
 */
//-1