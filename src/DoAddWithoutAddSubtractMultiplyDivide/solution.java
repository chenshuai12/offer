package DoAddWithoutAddSubtractMultiplyDivide;

public class solution {

    public int add(int num1,int num2) {
        while(num2!=0){
            int sum=num1^num2;  //没进位的和
            int carry=(num1&num2)<<1;  //进位
            num1=sum;
            num2=carry;
        }
        return num1;
    }
}
