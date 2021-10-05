package WhetherThereAreRingsInTheList;

public class Solution {

    public ListNode entryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return null;
        }
        // 快指针每次走两步
        ListNode fast = pHead;
        // 慢指针每次走一步
        ListNode slow = pHead;
        // 因为fast每次走两步，所以需要判断fast的下一个是否为空
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // 判断是否相遇，相遇后让快指针从头开始走，每次都是走一步，第二次相遇的节点就是环的入口
            if (fast.val == slow.val){
                fast = pHead;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            if (fast == slow){
                return slow;
            }
        }
        // 如果没有相遇，此链表没有环返回为空
        return null;
    }
}
