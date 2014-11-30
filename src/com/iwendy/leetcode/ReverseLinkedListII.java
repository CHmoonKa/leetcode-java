package com.iwendy.leetcode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null || m == n){
			return head;
		}
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode pre = fake;
		
		// 找到m的前一个
		for (int i = 1; i < m; i++)  
        {  
            pre = pre.next;  
        } 
		
		// 开始反转
		ListNode npre = pre.next;
		for( int i = m; i<n; i++)
		{
			ListNode cur = npre.next;
			npre.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
		}
		
		return fake.next;
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
