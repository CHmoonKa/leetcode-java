package com.iwendy.leetcode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 */
public class RotateList {
	/**
	 * 1.遍歷list，找到長度，並且將list，連接成環狀的
	 * 2.向前移動指針即可。
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0)
		{
			return head;
		}
		
        int len = 1;
        ListNode tmpHead = head;
        while(head.next != null){
        	len++;
        	head = head.next;
        }
        head.next = tmpHead;
        k = k%len;
        
        for(int i=0; i<len-k;i++){
        	head = head.next;
        }
        
        tmpHead = head.next;
        head.next = null;
        head = tmpHead;
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
