package BalancedBinaryTree;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public int getDepth(TreeNode root) {
        if(root==null)    return 0;
        int left=getDepth(root.left);
        if(left==-1)    return -1;
        int right=getDepth(root.right);
        if(right==-1)    return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
