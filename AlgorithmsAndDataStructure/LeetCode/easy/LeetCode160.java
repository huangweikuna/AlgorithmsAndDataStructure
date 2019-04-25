package easy;

import java.util.HashSet;

import linked_list.ListNode;

public class LeetCode160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        HashSet<Integer> map = new HashSet<>();
        while(headA != null){
            map.add(headA.hashCode());
            headA = headA.next;
        }
        while(headB != null){
            if(map.contains(headB.hashCode()))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
