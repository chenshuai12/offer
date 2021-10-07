package StackContainingMainFunction;

import java.util.Stack;

public class Solution {

    Stack<Integer> stack_data =  new Stack<>();

    Stack<Integer> stack_min = new Stack<>();

    public void push(int node){
        stack_data.push(node);
        if (stack_min.empty() || stack_min.peek() > node){
            stack_min.push(node);
        }else {
            stack_min.push(stack_min.peek());
        }
    }

    public void pop(){
        if (!stack_data.empty()){
            stack_data.pop();
            stack_min.pop();
        }
    }
    public int min(){
        return stack_min.peek();
    }
}
