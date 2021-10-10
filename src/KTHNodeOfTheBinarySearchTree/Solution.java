package KTHNodeOfTheBinarySearchTree;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index=0;

    TreeNode KthNode(TreeNode pRoot, int k){
        TreeNode pNode = null;
        if(pRoot==null || k<=0)
            return pNode;
        pNode = getKthNode(pRoot,k);
        return pNode;
    }

    private TreeNode getKthNode(TreeNode pRoot, int k){
        TreeNode kthNode=null;

        if(pRoot.left!=null)
            kthNode=getKthNode(pRoot.left,k);

        if(kthNode==null){
            index++;
            if(k==index)
                kthNode = pRoot;
        }

        if(kthNode==null && pRoot.right!=null)
            kthNode=getKthNode(pRoot.right,k);

        return kthNode;
    }
}
