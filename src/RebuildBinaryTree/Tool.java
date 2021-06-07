package RebuildBinaryTree;

import java.util.Objects;

public class Tool {

    public static Node construct(int[] preOrder, int[] inOrder, int length) throws Exception {
        if (Objects.isNull(preOrder) || Objects.isNull(inOrder) || length <= 0){
            return null;
        }
        return constructCore(preOrder,0,preOrder.length - 1,inOrder,0,inOrder.length - 1);
    }

    private static Node constructCore(int[] preOrder, int startPreOrder, int endPreOrder, int[] inOrder, int startInOrder, int endInOrder) throws Exception {
        // 前序遍历序列的第一个数字是根节点的值
        int rootValue = preOrder[startPreOrder];
        Node root = new Node(rootValue);
        root.setLeft(null);
        root.setRight(null);

        //只有一个节点
        if (startPreOrder == endPreOrder){
            if (startInOrder == endInOrder && preOrder[startPreOrder] == inOrder[startInOrder]){
                return root;
            }else {
                throw new Exception("输入不合法");
            }
        }

        //在中序中找到根节点的值
        int rootInOrder = startInOrder;
        while (rootInOrder <= endInOrder && inOrder[rootInOrder] != rootValue){
            rootInOrder++;
        }

        //输入两个序列不匹配的情况
        if (rootInOrder == endInOrder && inOrder[rootInOrder] != rootValue){
            throw new Exception("输入不合法");
        }

        //找到了根节点，那么中序根节点左边是左子树，右边是右子树   先序列节点中 前半部分是左子树的先序，后半部分是右子树的先序列，然后递归
        int leftLength = rootInOrder - startInOrder;
        int leftPreOrderEnd = startPreOrder + leftLength;

        if (leftLength > 0){
            //构建左子树
            root.setLeft(constructCore(preOrder,startPreOrder + 1,leftPreOrderEnd,inOrder,startInOrder,rootInOrder - 1));
        }

        if (leftLength < endPreOrder - startPreOrder){
            //构建右子树
            root.setRight(constructCore(preOrder,leftPreOrderEnd + 1,endPreOrder,inOrder,rootInOrder + 1,endInOrder));
        }
        return root;

    }
}
