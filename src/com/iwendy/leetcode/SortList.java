package com.iwendy.leetcode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
	/**
	 * O(nlgn)的排序算法没几个，无非就是quick sort， heap sort和merge sort. 
	 * 对于链表排序来说，难点之一就是如何O(1)定位节点,如果是数组，那么可以通过下标直接找到节点，
	 * 但是对于链表，如果需要定位到第k个元素，只能从节点头部顺序的访问K次.
	 * 如此，只好merge sort.
	 */
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode h2 = slow.next;
		slow.next = null;
		
		ListNode h1 = head;
		
		h2 = sortList(h2);
		h1 = sortList(h1);
		
		return merge(h1, h2);
	}
	
	
	/**
	 * 合并两个,两个列表都已经是有序列表了。
	 */
	public ListNode merge(ListNode h1, ListNode h2){
		ListNode helper = new ListNode(-1);
		ListNode pre = helper;
		pre.next = h1;
		
		while(h1 != null && h2 != null){
			if(h1.val <= h2.val){
				pre = pre.next;
				h1 = h1.next;
			}else{
				ListNode next = h2.next;
				h2.next = h1;
				pre.next = h2;
				pre = pre.next;
				h2 = next;
			}
		}
		
		if(h2 != null)
		{
			pre.next = h2;
		}
		
		return helper.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
