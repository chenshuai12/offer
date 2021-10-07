package StackPushInEjectSequence;

import java.util.Stack;

public class Solution {

    public boolean isPopOrder(int[] pushA, int[] popA){
        if (pushA == null || popA == null){
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        if (popA.length != pushA.length || pushA.length == 0){
            return false;
        }

        int popIndex = 0;

        for (int pushIndex = 0; pushIndex < pushA.length; pushIndex++){
            stack.push(pushA[pushIndex]);
            while (!stack.empty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
