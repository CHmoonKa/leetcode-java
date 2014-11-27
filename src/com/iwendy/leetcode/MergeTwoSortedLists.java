package com.iwendy.leetcode;

// Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode head;
		ListNode tmp;
		if(l1.val < l2.val){
			head = new ListNode(l1.val);
			l1 = l1.next;
		}else{
			head = new ListNode(l2.val);
			l2 = l2.next;
		}
		tmp = head;
		
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				tmp.next = new ListNode(l1.val);
				l1 = l1.next;
			}else{
				tmp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		
		ListNode ln = l1 == null?l2:l1;
		while(ln != null){
			tmp.next = new ListNode(ln.val);
			tmp = tmp.next;
			ln = ln.next;
		}
		return head;
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
