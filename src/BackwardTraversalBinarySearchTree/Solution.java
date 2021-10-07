package BackwardTraversalBinarySearchTree;

public class Solution {
    public boolean verifySequenceOfBST(int[] sequence){
        if (sequence == null || sequence.length <= 0){
            return false;
        }
        return verifyCore(sequence,0,sequence.length - 1);
    }

    private boolean verifyCore(int[] sequence, int start, int end) {
        if (start >= end){
            return true;
        }
        // 判断左子树
        int mid = start;
        while (sequence[mid] < sequence[end]){
            mid ++;
        }
        // 判断右子树
        for (int i = mid; i < end; i++){
            if (sequence[i] < sequence[end]){
                return false;
            }
        }
        return verifyCore(sequence,start,mid - 1) && verifyCore(sequence, mid, end - 1);
    }
}
