package StackImplementationQueue;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        // 弹出的元素应该是stack1的第一个push的元素
        while (!stack1.empty()){
            stack2.push(stack1.peek());
            stack1.pop();
        }
        int res = stack2.peek();
        stack2.pop();

        while (!stack2.empty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
        return res;
    }
}
