package com.iwendy.leetcode;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode h = head;
		ListNode curr = head.next;
		h.next = null;
		
		while(curr != null)
		{
			ListNode pre = null;
			ListNode c = h;
			while(c != null && c.val <= curr.val){
				pre = c;
				c = c.next;
			}
			
			ListNode next = curr.next;
			if(pre == null){
				curr.next = h;
				h = curr;
			}else{
				curr.next = c;
				pre.next = curr;
			}
			
			curr = next;
		}
		
		return h;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
