package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        //新建一个临时数组存放
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high){
            int mid = (low + high) / 2;
            mergeSort(arr,low,mid,tmp);
            mergeSort(arr,mid + 1, high, tmp);
            merge(arr,low,mid,high,tmp);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        // 左边和右边序列的起始索引
        int j = low,k = mid + 1;

        while (j <= mid && k <= high){
            if (arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else {
                tmp[i++] = arr[k++];
            }
        }

        // 若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid){
            tmp[i++] = arr[j++];
        }
        // 若右边还有剩余，则将其全部拷贝进tmp[]中
        while (k <= high){
            tmp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++){
            arr[low+t] = tmp[t];
        }
    }
}
