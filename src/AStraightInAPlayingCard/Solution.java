package AStraightInAPlayingCard;

import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<=0)
            return false;
        Arrays.sort(numbers);
        int numberOf0 = 0;
        int numberOfGap = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0)
                numberOf0++;
        }
        int small = numberOf0;
        int big = numberOf0+1;
        while(big<numbers.length){
            if(numbers[small]==numbers[big])
                return false;
            numberOfGap+=numbers[big++]-numbers[small++]-1;
        }
        if(numberOf0>=numberOfGap)  //大于等于，而不是等于！
            return true;
        return false;
    }
}
