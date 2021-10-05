package MergeList;

public class Solution {

    public class ListNode{
        int val;
        ListNode next=null;
        public ListNode(int val) {
            this.val=val;
        }
    }

    /**
     * 递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2){
        if (list1 == null) return list2;

        if (list2 == null) return list1;

        if (list1.val < list2.val){
            list1.next = merge(list1.next,list2);
            return list1;
        }else {
            list2.next = merge(list1,list2.next);
            return list2;
        }
    }

    /**
     * 非递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge2(ListNode list1,ListNode list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyHead = new ListNode(0); //不能为null
        ListNode p = dummyHead;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 == null){
            p.next = list2;
        }else {
            p.next = list1;
        }
        return dummyHead.next;
    }
}
