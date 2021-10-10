package TheMissingNumberFromZeroToNReduceOne;

public class Solution {
    public int getMissingNumber(int[] arr) {
        if(arr==null || arr.length<=0)
            return -1;
        int low=0;
        int high=arr.length-1;
        while(low<=high) {
            int mid=(low+high)>>1;
            if(arr[mid]!=mid) {
                if(mid==0 || arr[mid-1]==mid-1)
                    return mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        if(low==arr.length)
            return low;
        return -1;
    }
}
