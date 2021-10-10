package TwoNumbersThatAppearOnlyOnceInAnArray;

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<2)
            return;
        int resultExclusiveOR=0;
        for(int i=0;i<array.length;i++)
            resultExclusiveOR^=array[i];

        int indexOf1=0;
        while(((resultExclusiveOR&1)==0) && (indexOf1<=4*8)){
            resultExclusiveOR=resultExclusiveOR>>1;  //只有n>>1不完整，要n=n>>1
            indexOf1++;
        }

        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if(((array[i]>>indexOf1)&1)==1)
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }
}
