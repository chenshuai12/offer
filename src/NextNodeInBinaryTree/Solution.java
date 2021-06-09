package NextNodeInBinaryTree;

import java.util.Objects;

public class Solution {
    public TreeLinkNode getNext(TreeLinkNode node){
        if (Objects.isNull(node)){
            return null;
        }

        // 如果有右子树，则找有右子树最左节点
        if (Objects.nonNull(node.right)){
            node = node.right;
            while (Objects.nonNull(node.left)){
                node = node.left;
            }
            return node;
        }

        //如果没右子树，则找第一个当前节点是父节点左孩子的节点
        while (Objects.nonNull(node.next)){
            if (node.next.left == node){
                return node.next;
            }
        }
        return null;
    }
}
