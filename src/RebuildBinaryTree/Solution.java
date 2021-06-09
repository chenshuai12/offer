package RebuildBinaryTree;

public class Solution {
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        constructTestPortal("ConstructTest1", preorder, inorder, 8);
    }

    private static void constructTestPortal(String testName, int[] preOrder, int[] inOrder, int length){
        System.out.println(testName);

        System.out.println("先序遍历");
        for (int i = 0; i < length; i++){
            System.out.print(preOrder[i]);
        }
        System.out.println();
        System.out.println("中序遍历");
        for (int i = 0; i < length; i++){
            System.out.print(inOrder[i]);
        }
        System.out.println();

        try
        {
            Node root = Tool.construct(preOrder, inOrder, length);
            System.out.println(root);
        } catch (Exception e) {
            System.out.println("输入不合法");
        }
    }
}
