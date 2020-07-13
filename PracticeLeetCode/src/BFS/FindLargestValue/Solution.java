package BFS.FindLargestValue;

import java.util.*;

/*
You need to find the largest value in each row of a binary tree.
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        if(root ==null) return new ArrayList<>();
        return BFS(root);
    }


    public List<Integer> BFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur_node = queue.poll();
                tempList.add(cur_node.val);
                if (cur_node.left != null) {
                    queue.add(cur_node.left);
                }
                if (cur_node.right != null) {
                    queue.add(cur_node.right);
                }
            }
            ans.add(Collections.max(tempList));
        }

        return ans;
    }
}

