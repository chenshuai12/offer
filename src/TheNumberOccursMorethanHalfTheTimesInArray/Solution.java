package TheNumberOccursMorethanHalfTheTimesInArray;

import javafx.scene.effect.Bloom;

public class Solution {

    boolean isInputInvalid = true;

    /**
     * 方法一  partition方法
     * @param array
     * @return
     */
    public int moreThanHalfNum1(int[] array){
        if (array == null || array.length <= 0){
            return 0;
        }
        int low = 0;
        int high = array.length - 1;

        int index = partition(array,low,high);
        while (index != array.length >> 1){
            if (index < array.length >> 1){
                low = index + 1;
                index = partition(array,low,high);
            }else {
                high = index - 1;
                index = partition(array,low,high);
            }
        }

        // 判断次数是否超过一半
        int num = array[index];
        int times = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == num){
                times++;
            }
        }
        if (times * 2 > array.length){
            isInputInvalid = false;
            return num;
        }
        return 0;
    }

    private int partition(int[] array, int low, int high) {
        int privotKey = array[low];
        while (low < high){
            while (low < high && array[high] > privotKey){
                high--;
            }
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            while (low < high && array[low] <= privotKey){
                low++;
            }
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        return low;
    }


    public int moreThanHalfNum2(int[] array){
        if (array == null || array.length <= 0){
            return 0;
        }
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++){
            if (count == 0){
                num = array[i];
                count++;
            }else if (array[i] == num){
                count++;
            }else {
                count--;
            }
        }
        if (count > 0){
            int times = 0;
            for (int i = 0; i < array.length; i++){
                if (array[i] == num){
                    times++;
                }
            }
            if (times * 2 > array.length){
                isInputInvalid = false;
                return num;
            }
        }
        return 0;
    }
}
