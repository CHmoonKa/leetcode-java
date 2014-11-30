package com.iwendy.leetcode;

/**
 * Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes
 *  greater than or equal to x.(比x小的值，都将排在 >= x的值前面)

	You should preserve the original relative order of the nodes
	 in each of the two partitions.
	
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode small = new ListNode(-1);
		ListNode smallTmp = small;
		
		ListNode big = new ListNode(-1);
		ListNode bigTmp = big;
		
		while(head != null){
			if(head.val < x){
				smallTmp.next = head;
				smallTmp = head;
			}else{
				bigTmp.next = head;
				bigTmp = head;
			}
			head = head.next;
		}
		
		bigTmp.next = null;
		smallTmp.next = big.next;
		return small.next;
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
