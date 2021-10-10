package AUniqueNumberInAnArrayThatOccursOnlyOnce;

public class Solution {

    public static int findNumberAppearingOnce(int[] arr) {
        if(arr==null || arr.length<=0)
            throw new RuntimeException();
        int[] bitSum = new int[32];
        for(int i=0;i<32;i++)
            bitSum[i]=0;
        for(int i=0;i<arr.length;i++) {
            int bitMask=1;
            for(int j=31;j>=0;j--) {
                int bit=arr[i]&bitMask;  //注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
                if(bit!=0)
                    bitSum[j]+=1;
                bitMask=bitMask<<1;
            }
        }
        int result=0;
        for(int i=0;i<32;i++) {
            result=result<<1;
            result+=(bitSum[i]%3);
            //result=result<<1;  //不能放在后面，否则最前面一位就没了
        }
        return result;
    }
}
