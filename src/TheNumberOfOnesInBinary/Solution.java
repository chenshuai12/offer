package TheNumberOfOnesInBinary;

public class Solution {

    private static int count(int n){
        int count = 0;
        while(n != 0){
            ++count;
            n=n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(0));
        System.out.println(count(1));
        System.out.println(count(2));
        System.out.println(count(3));
    }
}
