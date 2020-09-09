package Programmers.Kakao.FindRouteGame

import java.util.*


class Solution {
    var index = 0
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val list: MutableList<Node> = ArrayList()
        for (a in nodeinfo.indices) {
            list.add(Node(nodeinfo[a][0], nodeinfo[a][1], a + 1))
        }

        list.sortWith(Comparator { n1, n2 ->
            // 노드들을 y가 높은 순으로 정렬, y가 같다면 x가 낮은 순으로 정렬
            if (n1.y > n2.y) {
                -1
            } else if (n1.y < n2.y) {
                1
            } else {
                if (n1.x > n2.x) {
                    1
                } else if (n1.x < n2.x) {
                    -1
                } else {
                    0
                }
            }
        })

        val root = list[0]
        val answer = Array(2) { IntArray(list.size) }
        for (i in 1 until list.size) {
            addNode(root, list[i])
        }
        preorder(answer, root)
        index = 0
        postorder(answer, root)
        return answer
    }

    fun addNode(parent: Node?, child: Node) {
        if (parent!!.x > child.x) {
            if (parent.left == null) {
                parent.left = child
            } else {
                addNode(parent.left, child)
            }
        } else {
            if (parent.right == null) {
                parent.right = child
            } else {
                addNode(parent.right, child)
            }
        }
    }

    fun preorder(arr: Array<IntArray>, root: Node?) { // 전위순회
        if (root != null) {
            arr[0][index++] = root.num
            preorder(arr, root.left)
            preorder(arr, root.right)
        }
    }

    fun postorder(arr: Array<IntArray>, root: Node?) { // 후위순회
        if (root != null) {
            postorder(arr, root.left)
            postorder(arr, root.right)
            arr[1][index++] = root.num
        }
    }
}

class Node(var x: Int, var y: Int, var num: Int) {
    var left: Node? = null
    var right: Node? = null
}