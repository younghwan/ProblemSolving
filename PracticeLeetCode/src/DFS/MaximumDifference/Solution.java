package DFS.MaximumDifference;

public class Solution {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        int cur_val = root.val;
        dfs(root, cur_val, cur_val);
        return ans;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) return;
        int cur_val = root.val;

        if(cur_val > max) max = cur_val;
        if(cur_val < min) min = cur_val;

        int temp = max-min;
        if(temp>ans) ans = temp;

        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
