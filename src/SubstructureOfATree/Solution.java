package SubstructureOfATree;

public class Solution {

    public class TreeNode{
        double val;
        TreeNode left = null;
        TreeNode right =null;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    public boolean hasSubtrree(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null){
            return false;
        }
        return doesTree1HasTree2(root1,root2) || hasSubtrree(root1.left,root2)
                || hasSubtrree(root1.right,root2);
    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        return equal(root1.val,root2.val) && doesTree1HasTree2(root1.left,root2.left)
                && doesTree1HasTree2(root1.right,root2.right);
    }

    /**
     * 判断两个浮点数是否相等
     * @param num1
     * @param num2
     * @return
     */
    private boolean equal(double num1,double num2) {
        if(num1-num2<0.0000001 && num1-num2>-0.0000001 )
            return true;
        return false;
    }
}
