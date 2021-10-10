package TheNumberOfOccurrencesOf1InTheInteger;

public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i*=10){  //i代表位数
            int high=n/(i*10); //更高位数字
            int low=(n%i);  //更低位数字
            int cur=(n/i)%10;  //当前位数字
            if(cur==0){
                count+=high*i;
            }else if(cur==1){
                count+=high*i+(low+1);
            }else{
                count+=(high+1)*i;
            }
        }
        return count;
    }
}
