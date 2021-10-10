package TheMaximumProfitFromTheStock;

public class Solution {
    public static int MaxDiff(int[] arr) {
        if(arr==null || arr.length<2)
            return -1;  //error
        int min=arr[0];

        //最大利润可以是负数，只要亏损最小就行
        int maxDiff=arr[1]-min;
        for(int i=1;i<arr.length;i++) {
            if(arr[i-1]<min)     //保存“之前”最小数字
                min=arr[i-1];
            if(arr[i]-min>maxDiff)
                maxDiff=arr[i]-min;
        }

        //默认不能亏本，代码简单，上面复杂的代码注意细节
//      int maxDiff=0;
//      for(int i=1;i<arr.length;i++) {
//          if(arr[i]<min)
//              min=arr[i];
//          else if(arr[i]-min>maxDiff)
//              maxDiff=arr[i]-min;
//      }
        return maxDiff;
    }


    //简单快速测试下
    public static void main(String[] args) {
        int[] arr1=null;
        System.out.println(MaxDiff(arr1)==-1);

        int[] arr2={  };
        System.out.println(MaxDiff(arr2)==-1);

        int[] arr3={ 16, 16, 16, 16, 16 };
        System.out.println(MaxDiff(arr3)==0);

        int[] arr4={ 1, 2, 4, 7, 11, 16 };
        System.out.println(MaxDiff(arr4)==15);

        int[] arr5={  16, 11, 7, 4, 2, 1 };
        System.out.println(MaxDiff(arr5)==-1);

        int[] arr6={ 9, 11, 5, 7, 16, 1, 4, 2 };
        System.out.println(MaxDiff(arr6)==11);

        int[] arr7={ 2,4};
        System.out.println(MaxDiff(arr7)==2);

        int[] arr8={ 4,2};
        System.out.println(MaxDiff(arr8)==-2);
    }
}
