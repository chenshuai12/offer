package SerializeBinaryTrees;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String serialize(TreeNode node){
        StringBuilder sb = new StringBuilder();
        if (node == null){
            sb.append("$,");
        }else {
            sb.append(node.val + ",");
            sb.append(serialize(node.left));
            sb.append(serialize(node.right));
        }
        return sb.toString();
    }


    int index = 0;

    TreeNode deserialize(String str){
        TreeNode node = null;
        if (str == null || str.length() == 0){
            return node;
        }
        int start = index;
        while (str.charAt(index) != ','){
            index++;
        }
        if (!str.substring(start,index).equals("$")){
            node = new TreeNode(Integer.parseInt(str.substring(start,index)));
            index++;
            node.left = deserialize(str);
            node.right = deserialize(str);
        }else {
            index++;
        }
        return node;
    }
}
