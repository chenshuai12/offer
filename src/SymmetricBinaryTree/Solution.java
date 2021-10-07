package SymmetricBinaryTree;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean isSymmmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }
        return isEqual(pRoot.left,pRoot.right);
    }

    private boolean isEqual(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null){
            return true;
        }
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }
        return pRoot1.val == pRoot2.val && isEqual(pRoot1.left,pRoot2.right) && isEqual(pRoot1.right,pRoot2.left);
    }
}
