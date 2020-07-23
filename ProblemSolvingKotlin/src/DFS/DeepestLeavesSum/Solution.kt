package DFS.DeepestLeavesSum

import java.util.*


class Solution {
    var cur_level = 0
    var max_level = 0
    var ans =0
    fun DFS(root: TreeNode?):Int{

        if(root?.left == null && root?.right == null && cur_level >= max_level)
        {
            if(cur_level>max_level){
                max_level = cur_level
                ans = root?.`var`?:0
            }
            else ans += root?.`var`?:0
        }
        if(root?.left != null){
            cur_level++
            DFS(root.left)
        }

        if(root?.right != null){
            cur_level++
            DFS(root.right)
        }
        cur_level--;

        return ans
    }

    fun BFS(root:TreeNode?) : Int{
        val queue : Queue<TreeNode> = LinkedList()
        var sum = 0

        queue.add(root)
        while(queue.isNotEmpty())
        {
            var numOfNode = queue.size
            sum = 0
            while(numOfNode > 0){
                val node : TreeNode = queue.remove()
                sum += node.`var`
                if(node.left != null) queue.add(node.left)
                if(node.right != null) queue.add(node.right)
                --numOfNode
            }
        }
        return sum
    }

}