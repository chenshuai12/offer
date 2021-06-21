package DeleteRepeatNodeList;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public ListNode deleteRepeat(ListNode pHead){
        ListNode pre = null;
        ListNode node = pHead;
        while (node != null){
            boolean needDelete = false;
            if (node.next != null && node.next.val == node.val){
                needDelete = true;
            }
            if (needDelete){
                int value = node.val;
                while (node != null && node.val == value){
                    node = node.next;
                }
                if (pre == null){
                    pHead = node;
                }else {
                    pre.next = node;
                }
            }else {
                pre = node;
                node = node.next;
            }
        }
        return  pHead;
    }
}
