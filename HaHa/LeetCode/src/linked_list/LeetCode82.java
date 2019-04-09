package linked_list;

/*
 *  82. Remove Duplicates from Sorted List II
 *  删除链表中的重复结点
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;        
        ListNode cur = head;
        while(cur!= null && cur.next != null){
            ListNode next = cur.next;
            if(next.val == cur.val){
                while(next != null && next.val == cur.val){
                    next = next.next;
                }
                pre.next = next;
                cur = next;
            }else{
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
}