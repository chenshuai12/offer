package TheKTHNodeInList;

class ListNode{
    public int val;
    public ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}

public class Solution {
    public ListNode findKthTailNode(ListNode head, int k){
        if (k <= 0 && head == null){
            return null;
        }


        ListNode pre = head;
        ListNode last = head;


        for (int i = 1; i < k; i++){
            if (pre.next != null){
                // 遍历链表，直到找到尾节点
            }else {
                return null;
            }
        }
        // 此时pre指针走了k-1步，后面两个指针一起遍历，这样，当pre到达末尾，last刚好到达倒数第k个节点
        while (pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
