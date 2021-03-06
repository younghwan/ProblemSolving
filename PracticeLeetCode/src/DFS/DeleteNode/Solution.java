package DFS.DeleteNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 */
public class Solution {
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> delList = new HashSet<>();
        for (int value : to_delete) {
            delList.add(value);
        } // 3 5

        root = newNode(root, delList);
        if(root!=null) {
            if (!delList.contains(root.val)) {
                ans.add(root);
            }
        }
        return ans;
    }

    public TreeNode newNode(TreeNode node, Set<Integer> delList) {
        if(node == null) {
            return null;
        }
        node.left = newNode(node.left, delList);
        node.right = newNode(node.right, delList);

        if(delList.contains(node.val)) {
            if(node.left!=null) {
                ans.add(node.left);
            }
            if(node.right!=null) {
                ans.add(node.right);
            }
            return null;
        }

        return node;
    }

//    Set<Integer> to_delete_set;
//    List<TreeNode> res;
//    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        to_delete_set = new HashSet<>();
//        res = new ArrayList<>();
//        for (int i : to_delete)
//            to_delete_set.add(i);
//        helper(root, true);
//        return res;
//    }
//
//    private TreeNode helper(TreeNode node, boolean is_root) {
//        if (node == null) return null;
//        boolean deleted = to_delete_set.contains(node.val);
//        if (is_root && !deleted) res.add(node);
//        node.left = helper(node.left, deleted);
//        node.right =  helper(node.right, deleted);
//        return deleted ? null : node;
//    }
}
