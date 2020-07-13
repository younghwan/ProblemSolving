package BFS.NaryTreeLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node curNode = queue.poll();
                tempList.add(curNode.val);
                if (curNode.children != null) queue.addAll(curNode.children);
            }
            res.add(tempList);
        }
        return res;
    }

    // DFS solution
//    private List<List<Integer>> result = new ArrayList<>();
//
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root != null) traverseNode(root, 0);
//        return result;
//    }
//
//    private void traverseNode(Node node, int level) {
//        if (result.size() <= level) {
//            result.add(new ArrayList<>());
//        }
//        result.get(level).add(node.val);
//        for (Node child : node.children) {
//            traverseNode(child, level + 1);
//        }
//    }
}
