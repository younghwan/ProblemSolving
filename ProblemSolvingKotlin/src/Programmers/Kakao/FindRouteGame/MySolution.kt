package Programmers.Kakao.FindRouteGame

class MySolution {

    var answer = arrayOf(intArrayOf())
    var index = 0

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        answer = Array(2) { IntArray(nodeinfo.size) }

        var nodeInfoWithCnt = Array(nodeinfo.size) { IntArray(3) }

        for ((i, node) in nodeinfo.withIndex()) {
            nodeInfoWithCnt[i][0] = node[0]
            nodeInfoWithCnt[i][1] = node[1]
            nodeInfoWithCnt[i][2] = i+1
        }

        var new = nodeInfoWithCnt.toList().sortedByDescending { it[1] }.toTypedArray()

        var root = MyNode(new[0][0], new[0][1], new[0][2])


        for (i in 1 until new.size) {
            add(root, MyNode(new[i][0], new[i][1], new[i][2]))
        }

        preOrder(root)
        index = 0
        postOrder(root)

        return answer
    }

    fun add(root: MyNode, newNode: MyNode){
        if (root.x > newNode.x && root.leftNode == null) {
            root.leftNode = newNode
        }
        if (root.x < newNode.x && root.rightNode == null) {
            root.rightNode = newNode
        } else {
            if (root.x > newNode.x) {
                root.leftNode?.let { add(it, newNode) }
            }
            if (root.x < newNode.x) {
                root.rightNode?.let { add(it, newNode) }
            }
        }
    }

    fun preOrder(node: MyNode) {
//        println("x = ${node.x} , y = ${node.y}, num = ${node.num}")
        answer[0][index++] = node.num
        node.leftNode?.let { preOrder(it) }
        node.rightNode?.let { preOrder(it) }
    }

    fun postOrder(node: MyNode) {
        node.leftNode?.let { postOrder(it) }
        node.rightNode?.let { postOrder(it) }
        answer[1][index++] = node.num
//        println("x = ${node.x} , y = ${node.y}, num = ${node.num}")
    }

}

class MyNode(var x: Int, var y: Int, var num: Int) {
    var leftNode: MyNode? = null
    var rightNode: MyNode? = null
}

fun main() {
    var solution = MySolution()

//    var node1 = MyNode(8, 6, 7)
//    var node2 = MyNode(3, 5, 4)
//    var node3 = MyNode(11, 5, 2)
//    var node4 = MyNode(1, 3, 6)
//    var node5 = MyNode(5, 3, 1)
//    var node6 = MyNode(13, 3, 3)
//    var node7 = MyNode(2, 2, 9)
//    var node8 = MyNode(7, 2, 8)
//    var node9 = MyNode(6, 1, 5)
//
//    solution.add(node1, node2)
//    solution.add(node1, node3)
//    solution.add(node1, node4)
//    solution.add(node1, node4)
//    solution.add(node1, node5)
//    solution.add(node1, node6)
//    solution.add(node1, node7)
//    solution.add(node1, node8)
//    solution.add(node1, node9)
//    solution.preOrder(node1)
//    solution.postOrder(node1)

    var nodeInfo = arrayOf(
        intArrayOf(5, 3), intArrayOf(11, 5), intArrayOf(13, 3),
        intArrayOf(3, 5), intArrayOf(6, 1), intArrayOf(1, 3), intArrayOf(8, 6), intArrayOf(7, 2), intArrayOf(2, 2)
    )

    var ans = solution.solution(nodeInfo)

    for(i in ans){
        for(j in i){
            print(j)
        }
        println()
    }

}