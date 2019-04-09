package linked_list;

/*
 *  21. Merge Two Sorted Lists
 *  合并两个有序链表
 */
public class LeetCode21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        
        ListNode head = null;
        if(l1.val <= l2.val){
            head = l1;
            l1.next = mergeTwoLists(l1.next,l2);
        }else{
            head = l2;
            l2.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
}