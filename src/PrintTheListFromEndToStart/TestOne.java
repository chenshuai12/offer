package PrintTheListFromEndToStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TestOne {
    public ArrayList<Integer> print(ListNode listNode){
        ArrayList<Integer> result = new ArrayList<>();
        ListNode p = listNode;
        Stack<Integer> stack = new Stack<>();
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
