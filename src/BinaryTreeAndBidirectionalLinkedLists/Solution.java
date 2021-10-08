package BinaryTreeAndBidirectionalLinkedLists;

import java.util.LinkedList;

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
     * 递归版本
     * 1.已知函数返回的是转换好的双向链表头结点
     * 2.左子树处理完后与根节点连接
     * 3.右子树处理，也与根节点连接
     * 4.最后返回头结点
     * @param root
     * @return
     */
    public TreeNode convert(TreeNode root){
        if (root == null){
            return root;
        }
        //处理左子树，获得左子树链表的头结点
        TreeNode left = convert(root.left);
        TreeNode p = left;
        if (left != null){
            // 找到左子树的末尾节点
            while (p.right != null){
                p = p.right;
            }
            // 连接节点
            p.right = root;
            root.left = p;
        }
        // 处理右子树，获得右子树的链表头结点
        TreeNode right = convert(root.right);
        //连接节点
        if (right != null){
            root.right = right;
            right.left = root;
        }
        return left == null ? root : left;
    }

    /**
     * 非递归版本
     * 利用非递归中序遍历来连接节点
     * @param root
     * @return
     */
    public TreeNode convert1(TreeNode root){
        TreeNode head = null;
        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            // 把root当指针使用
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (head == null){
                head = node;
                pre = node;
            }else {
                node.left = pre;
                pre.right = node;
                pre = node;
            }
            root = node.right;
        }
        return head;
    }
}
