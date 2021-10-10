package PairsOfInversionsInAnArray;

public class Solution {

    public static int inversePairs(int [] array) {
        if(array==null || array.length<=0)
            return 0;
        int count=getCount(array,0,array.length-1);
        return count;
    }

    private static int getCount(int[] array,int start,int end){
        if(start>=end)
            return 0;
        int mid=(end+start)>>1;
        int left=getCount(array,start,mid);
        int right=getCount(array,mid+1,end);

        //合并
        int count=0;
        int i=mid; //左边区域的指针
        int j=end; //右边区域的指针
        int[] temp= new int[end-start+1];  //临时区域
        int k=end-start; //临时区域的指针
        while(i>=start && j>=mid+1){
            if(array[i]>array[j]){
                count+=(j-mid);
                temp[k--]=array[i--];
            }else{
                temp[k--]=array[j--];
            }
        }
        while(i>=start)
            temp[k--]=array[i--];
        while(j>=mid+1)
            temp[k--]=array[j--];
        for(k=0;k<temp.length;k++)
            array[k+start]=temp[k];

        return count+left+right;
    }
}
