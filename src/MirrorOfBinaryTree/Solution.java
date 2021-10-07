package MirrorOfBinaryTree;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void mirror(TreeNode root){
        if (root == null){
            return;
        }
        //交换左右子节点
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        mirror(root.left);
        mirror(root.right);
    }
}
