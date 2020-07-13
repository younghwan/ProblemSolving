package BFS.BottomLeftTreeValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    int ans = 0;
    int max = -1;

    public int findBottomLeftValue(TreeNode root) {
//        DFS(root, 0);
        return BFS(root);
    }

    public void DFS(TreeNode node, int level) {

        if (node.left == null && node.right == null && level > max) {
            ans = node.val;
            max = level;
        }

        if (node.left != null) DFS(node.left, level + 1);
        if (node.right != null) DFS(node.right, level + 1);

    }


    public Integer BFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur_node = queue.poll();
                tempList.add(cur_node.val);
                if (cur_node.left != null) {
                    queue.add(cur_node.left);
                    tempList.add(cur_node.left.val);
                }
                if (cur_node.right != null) {
                    queue.add(cur_node.right);
                    tempList.add(cur_node.right.val);
                }
            }
            list.add(tempList);
        }
        return list.get(list.size() - 1).get(0);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.findBottomLeftValue(root));

    }
}
