package RepeatNumInArray;

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {

        int[] nums = {4,3,1,0,2,5,3};
        int result = findRepeatNumber(nums);
        System.out.println(result);

    }
    public static int findRepeatNumber(int[] nums){
        int repeat = -1;
        if (Objects.isNull(nums)){
            return repeat;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++){
            while (i != nums[i]){
                if (nums[i] == nums[nums[i]]) {
                    repeat = nums[i];
                    return repeat;
                }
                swap(nums,i,nums[i]);
            }

        }
        return repeat;
    }
    private static void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
