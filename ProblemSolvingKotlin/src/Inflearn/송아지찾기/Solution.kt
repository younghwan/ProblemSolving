package Inflearn.송아지찾기

import java.util.*

data class Node(var curPos: Int, var cnt: Int)

fun main() {
    var S = 5
    var E = 14

    var check = Array(1000) { false }
    var q: Queue<Node> = LinkedList()
    q.add(Node(10, 0))

    while (q.isNotEmpty()) {
        var node = q.poll()
        if (check[node.curPos]) continue
        check[node.curPos] = true
        if (node.curPos < 0) continue
        if (node.curPos == E) {
            println(node.cnt)
            return
        }

        q.add(Node(node.curPos + 1, node.cnt + 1))
        q.add(Node(node.curPos - 1, node.cnt + 1))
        q.add(Node(node.curPos + 5, node.cnt + 1))

    }
}