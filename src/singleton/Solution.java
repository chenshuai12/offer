package singleton;

import java.util.concurrent.*;

public class Solution {
    public static void main(String[] args) {

            System.out.println(EnumSingleton.INSTANCE.getClass());
            EnumSingleton.INSTANCE.doSomething();



            System.out.println(DoubleSynSingleton.getInstance().getClass());
            DoubleSynSingleton.getInstance().doSomething();
    }
}
