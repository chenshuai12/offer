package TheSmallestNumberOfK;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {

    /**
     * 方法1 采用partition
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNum1(int[] input, int k){
        ArrayList<Integer> leastNum = new ArrayList<>();
        while (input == null || k < 0 || k > input.length){
            return leastNum;
        }
        int start = 0;
        int end = input.length - 1;

        int index = patition(input,start,end);

        while (index != k - 1){
            if (index < k - 1){
                start = index + 1;
                index = patition(input,start,end);
            }else {
                end = index - 1;
                index = patition(input,start,end);
            }
        }
        for (int i = 0;i < k; i++){
            leastNum.add(input[i]);
        }
        return leastNum;
    }

    private int patition(int[] arr, int start, int end) {
        int pivotKey=arr[start];
        while(start<end){
            while(start<end && arr[end]>=pivotKey){
                end--;
            }
            swap(arr,start,end);
            while(start<end && arr[start]<=pivotKey){
                start++;
            }
            swap(arr,start,end);
        }
        return start;
    }

    private void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public ArrayList<Integer> getLeastNum2(int[] input, int k){
        ArrayList<Integer> leastNum = new ArrayList<>();
        while (input == null || k <= 0 || k > input.length){
            return leastNum;
        }

        // 用于存放最小的k个数
        int[] numbers = new int[k];

        // 先放入前k个数
        for (int i = 0; i < k; i++){
            numbers[i] = input[i];
        }

        //将数组构造成最大堆形式
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(numbers,i,k-1);
        }

        for(int i=k;i<input.length;i++){
            if(input[i]<numbers[0]){ //存在更小的数字时
                numbers[0]=input[i];
                adjustHeap(numbers,0,k-1);//重新调整最大堆
            }
        }
        for(int n:numbers){
            leastNum.add(n);
        }
        return leastNum;
    }

    //最大堆的调整方法，忘记时可以复习一下堆排序。
    private void adjustHeap(int[] arr,int start,int end){
        int temp=arr[start];
        int child=start*2+1;
        while(child<=end){
            if(child+1<=end && arr[child+1]>arr[child]){
                child++;
            }
            if(arr[child]<temp){
                break;
            }
            arr[start]=arr[child];
            start=child;
            child=child*2+1;
        }
        arr[start]=temp;
    }
}
