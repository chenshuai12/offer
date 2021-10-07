package CopyComplicatedList;

public class Solution {

    public class ComplexListNode {
        int val;
        ComplexListNode next = null;
        ComplexListNode sibling = null;

        ComplexListNode(int label) {
            this.val = label;
        }
    }

    public ComplexListNode cloneList(ComplexListNode head){
        // 复制节点
        cloneNodes(head);
        // 设置sibling
        connectSiblingNodes(head);
        // 拆分长链表
        return reconnectNodes(head);
    }


    private void cloneNodes(ComplexListNode head) {
        ComplexListNode pNode = head;
        while (pNode != null){
            ComplexListNode cloneNode = new ComplexListNode(pNode.val);
            cloneNode.next = pNode.next;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }
    }

    private void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode pNode = head;
        while (pNode != null){
            if (pNode.sibling != null){
                pNode.next.sibling = pNode.sibling.next;
            }
            pNode = pNode.next.next;
        }
    }

    private ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;
        ComplexListNode pNode = head;
        if (head != null){
            cloneHead = head.next;
            cloneNode = pNode.next;
            pNode.next = cloneNode.next;
            // 提前将pNode指向下一个节点方便判断是否为null
            pNode = pNode.next;
        }
        while (pNode != null){
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;

            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }

}
