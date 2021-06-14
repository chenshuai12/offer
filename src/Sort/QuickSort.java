package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arrays =  {5,1,7,3,110,6,9,4};
        sort(arrays,0,arrays.length-1);
        System.out.println(Arrays.toString(arrays));
    }

    public static void sort(int[] arrays, int low, int high){
        // 如果low>high直接返回，如果low==high，表示只有一个元素，也不用排序，直接返回
        if (low >= high || arrays.length <= 1 || arrays == null){
            return;
        }

        // 低位索引
        int i = low;
        // 高位索引
        int j = high;

        // 待排序的第一个值，作为基准值
        int base = arrays[low];
        
        while (i < j){
            // 高位索引值大于或等于基准值，就继续向低位索引找，一直找到比基准值小的元素
            while (arrays[j] >= base && i < j){
                j--;
            }
            
            // 低位索引小于或等于基准值，就向高位索引找，一直找到比基准值大的元素
            while (arrays[i] <= base && i < j){
                i++;
            }
            // 找到两个元素就将比基准值小的元素放在左边，比基准值大的元素放在右边，交换位置
            swap(arrays,i,j);
        }
        // 再将基准值归为
        swap(arrays,low,j);
        //递归
        sort(arrays,0,j - 1);
        sort(arrays,j + 1,high);
    }

    private static void swap(int[] arrays, int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
}
