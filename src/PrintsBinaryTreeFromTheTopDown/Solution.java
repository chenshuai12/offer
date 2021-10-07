package PrintsBinaryTreeFromTheTopDown;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 不分行从上往下打印二叉树
     * @param root
     */
    public void pringTree1(TreeNode root){
       if (root == null){
           return;
       }
        LinkedList<TreeNode> queue = new LinkedList<>();

       queue.offer(root);
       TreeNode node = null;
       while (queue.size() != 0){
           node = queue.poll();
           System.out.println(node.val + " ");
           if (node.left != null){
               queue.offer(node.left);
           }
           if (node.right != null){
               queue.offer(node.right);
           }
       }
        System.out.println();
    }

    /**
     * 分行从上到下打印二叉树
     * @param root
     */
    public void pringTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        //当前层结点数目
        int pCount = 0;
        //下一层结点数目
        int nextCount = 1;

        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            // 打印当前层数字，并计算下一层节点数目
            for (int i = 1; i <= pCount; i++) {
                node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            System.out.println();
        }
    }

    /**
     *  之字形 采用两个栈进行操作的方法
     * @param root
     */
    public void pringTree3(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = null;
        stack1.push(root);
        while(!stack1.empty() || !stack2.empty()) {
            while(!stack1.empty()) {
                node=stack1.pop();
                System.out.print(node.val + " ");
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            System.out.println();
            while(!stack2.empty()) {
                node=stack2.pop();
                System.out.print(node.val + " ");
                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            System.out.println();
        }
    }
}
