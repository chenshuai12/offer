package NumbersRaisedToAnIntegerPower;

public class Solution {

    // 参数是否非法
    static boolean isInvalid = false;


    public static double power(double base,int exponent){
        isInvalid = false;
        double result;

        if (exponent > 0){
            return powerCore(base,exponent);
        }else if (exponent < 0){
            if (base == 0){
                // 0的负数次方不存在
                isInvalid = true;
                return 0;
            }
            return 1 / powerCore(base,-exponent);
        }else {
            return 1;
        }
    }

    private static double powerCore(double base, int exponent) {
        if (exponent == 1){
            return base;
        }
        if (exponent == 0){
            return 1;
        }
        double result = power(base,exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1){
            result *= base;
        }
        return result;
    }


    // ========测试代码========
    static void test(String testName, double base, int exponent, double expected, boolean expectedFlag) {
        if (testName != null)
            System.out.print(testName + ":");
        if (power(base, exponent) == expected && isInvalid == expectedFlag) {
            System.out.println("passed.");
        } else {
            System.out.println("failed.");
        }
    }

    static void test1() {
        Solution.test("test1", 0, 6, 0, false);
    }
    static void test2() {
        test("test2", 0, -6, 0, true);
    }

    static void test3() {
        test("test3", 0, 0, 1, false);
    }

    static void test4() {
        test("test4", 2, 6, 64, false);
    }

    static void test5() {
        test("test5", 2, -3, 0.125, false);
    }

    static void test6() {
        test("test6", 5, 0, 1, false);
    }

    static void test7() {
        test("test7", -2, 6, 64, false);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
