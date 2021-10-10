package AndAreContinuousSequencesOfPositiveNumbersOfS;

import java.util.ArrayList;

public class Solution {
    //方法一：采用两个指针的方法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > sequenceList = new ArrayList<ArrayList<Integer> >();
        if(sum<=0)
            return sequenceList;

        int small = 1;
        int big = 2;
        int curSum = small+big;
        while(small <= sum/2){
            if(curSum == sum){
                ArrayList<Integer> sequence = new ArrayList<Integer>();
                for(int i=small;i<=big;i++)
                    sequence.add(i);
                sequenceList.add(sequence);
                curSum-=small;
                small++; //这两行位置先后要注意
            }
            if(curSum < sum){
                big++;
                curSum+=big;
            }
            if(curSum > sum){
                curSum-=small;
                small++;
            }
        }
        return sequenceList;
    }


    //方法二：数学分析法
    public ArrayList<ArrayList<Integer> > FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer> > sequenceList = new ArrayList<ArrayList<Integer> >();
        if(sum<=0)
            return sequenceList;

        for(int n=(int) Math.sqrt(2*sum);n>=2;n--){
            if(((n&1)==1 && sum%n==0) || ((n&1)==0 && (sum%n)*2==n)){
                ArrayList<Integer> sequence = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    sequence.add(k);
                }
                sequenceList.add(sequence);
            }
        }
        return sequenceList;
    }
}
