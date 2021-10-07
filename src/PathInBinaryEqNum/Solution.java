package PathInBinaryEqNum;

import java.util.ArrayList;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void findPath(TreeNode root, int target){
        if (root == null){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        pringPath(root,target,list);
    }

    private void pringPath(TreeNode node, int target, ArrayList<Integer> list) {
        if (node == null){
            return;
        }
        list.add(node.val);
        target -= node.val;
        if (target ==0 && node.left == null && node.right == null){
            for (Integer integer : list){
                System.out.println(integer + " ");
            }
            System.out.println();
        }else {
            pringPath(node.left,target,list);
            pringPath(node.right,target,list);
        }
        list.remove(list.size() - 1);
    }
}
