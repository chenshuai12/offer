package ForOneAddToN;

public class Solution {

    public int getSum(int n) {
        int sum=n;
        boolean flag = (n>1) && ((sum+=getSum(n-1))>0);
        //上面这句话相当于：
        //if(n>1)
        //   sum+=getSum(n-1);

        //也可以使用||来实现
        //boolean flag = (n==1) || ((sum+=getSum(n-1))>0);
        return sum;
    }
}
