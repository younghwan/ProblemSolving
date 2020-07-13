package DFS.SumOfNode;

class Solution {
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {

        return DFS(root,null,null);
    }

    public int DFS(TreeNode root,TreeNode parent,TreeNode grandParent)
    {
        if(root == null) return 0;

        if(grandParent != null && grandParent.val % 2 ==0) ans += root.val;

        DFS(root.right,root,parent);
        DFS(root.left,root,parent);

        return ans;
    }

}
