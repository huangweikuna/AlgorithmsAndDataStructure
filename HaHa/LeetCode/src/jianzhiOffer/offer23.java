package jianzhiOffer;

import linked_list.ListNode;

/*
	在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class offer23 {
	public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)return null;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode p = dummy;
        ListNode q = pHead;
        while(q != null && q.next != null){
            ListNode next = q.next;
            if(q.val == next.val){
                while(next != null && next.val == q.val){
                    next = next.next;
                }
                p.next = next;
                q = next;
            }else{
                q = q.next;
                p = p.next;
            }
        }
        	return dummy.next;
    }
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
		node.next.next = new ListNode(1);
//		node.next.next.next = new ListNode(3);
//		node.next.next.next.next = new ListNode(4);
//		node.next.next.next.next.next = new ListNode(4);
//		node.next.next.next.next.next.next = new ListNode(5);
		int arr[] = {0,0,0,0,10};
		ListNode res= new offer23().deleteDuplication(node);
		while(res != null) {
			System.out.println(res.val + "->");
			res = res.next;
		}
	}
}