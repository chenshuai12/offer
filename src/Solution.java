public class Solution {

    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length<=0)
            return 0;
        int firstK = getFirstK(array,0,array.length-1,k);
        if(firstK == -1)
            return 0;
        int lastK = getLastK(array,firstK,array.length-1,k);
        return lastK-firstK+1;
    }

    private int getFirstK(int[] arr, int start, int end,int k){
        if(start>end)
            return -1;
        int mid = (start+end)>>1;
        if(arr[mid]==k){
            if( mid == 0 ||arr[mid-1]!=k )
                return mid;
            else
                end = mid-1;
        }else if(arr[mid]<k){
            start = mid+1;
        }else{
            end = mid-1;
        }
        return getFirstK(arr,start,end,k);
    }

    private int getLastK(int[] arr, int start, int end,int k){
        if(start>end)
            return -1;
        int mid = (start+end)>>1;
        if(arr[mid]==k){
            if(mid==arr.length-1 || arr[mid+1]!=k )
                return mid;
            else
                start = mid+1;
        }else if(arr[mid]<k){
            start = mid+1;
        }else{
            end = mid-1;
        }
        return getLastK(arr,start,end,k);
    }

    /**
     * 牛客网上还有一种算法：如果找数字k的次数，由于数组是整数，可以直接找k-0.5和k+0.5应该在数组中哪个位置，这种方法就不用讨论这么多情况了。（不过double类型的大小比较不知道是否会增加太多时间消耗）。
     */
    public int GetNumberOfK1(int [] arr , int k) {
        if(arr==null || arr.length<=0)
            return 0;
        int first = getLoc(arr, k , k-0.5);
        int last = getLoc(arr,k,k+0.5);
        return last-first;
    }

    private int getLoc(int[]arr, int k, double m){ //同样是二分查找
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=(start+end)>>1;
            if(arr[mid]>m){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}
