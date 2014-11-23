package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, remove the nth node from the end of list and return it head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5. 
 * Note: 
 * 		Given n will always be valid. 
 * 		Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
	
	/**
	 * 利用的是faster和slower双指针来解决。
	 * 1. faster先走n，使faster 与 slower 相差 n
	 * 1.1 如果faster == null,说明n正好是list的长度,删除第一个就好了
	 * 2. 当faster走到头时，slower也就正好到倒数第n的位置了
	 */
	public ListNode removeNthFromEnd_2(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		for(int i=0; i<n; i++){
			fast = fast.next;
		}
		if(fast == null){
			head = head.next;
			return head;
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		return head;
	}
	
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> tmp = new ArrayList<>();
		ListNode h = head;
		while(head != null){
			tmp.add(head);
			head = head.next;
		}
		
		int len = tmp.size();
		if(len - n > 0){
			ListNode br = tmp.remove(tmp.size() - n);
			tmp.get(len - n - 1).next = br.next;
		}else{
			h = h.next;
		}
		tmp = null;
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
