package com.iwendy.leetcode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		
		int la = 0;
		ListNode ta = headA;
		while(ta != null){
			la++;
			ta = ta.next;
		}
		
		int lb = 0;
		ListNode tb = headB;
		while(tb != null){
			lb++;
			tb = tb.next;
		}
		
		ListNode ln = headA;
		ListNode tln = headB;
		int l = la - lb;
		if(lb > la){
			l = lb - la;
			ln = headB;
			tln = headA;
		}
		
		while(l > 0){
			ln = ln.next;
			l--;
		}
		
		while(ln != null && tln != null && ln != tln){
			ln = ln.next;
			tln = tln.next;
		}
		
		return ln;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
