package DeleteNodeInList;


class ListNode {
    int value;
    ListNode next;
}


public class Solution {
    public void deleteNode(ListNode head,ListNode toBeDeleted){
        if (head == null || toBeDeleted == null){
            return;
        }

        if (toBeDeleted.next != null){
            // 要删除的节点不是尾节点
            ListNode pNext = toBeDeleted.next;
            toBeDeleted.value = pNext.value;
            toBeDeleted.next = pNext.next;
            pNext.next = null;
        }else if (head == toBeDeleted){
            // 链表中只有一个节点，但是删除头结点（也就是尾节点）
            head = null;
            toBeDeleted = null;
        }else {
            // 链表中有多个节点中，但是删除尾节点
            ListNode node = head;
            while (node.next.next != null){
                node = node.next;
            }
            node.next = null;
            toBeDeleted = null;
        }
    }
}


