package MaximumSumOfContiguousSubarrays;

public class Solution {

    boolean invalidInput = false;

    public int findGreatestSumOfSubArray(int[] array){
        if (array == null || array.length <= 0){
            invalidInput = true;
            return 0;
        }

        invalidInput = false;
        int sum = array[0];
        int maxSum = array[0];

        for (int i = 1; i < array.length; i++){
            if (sum < 0){
                sum = array[i];
            }else {
                sum += array[i];
            }
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
