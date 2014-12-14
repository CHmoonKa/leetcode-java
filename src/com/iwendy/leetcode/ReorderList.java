package com.iwendy.leetcode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
  public static void main(String[] args) {
    ListNode h = new ListNode(1);
    ListNode h1 = new ListNode(2);
    ListNode h2 = new ListNode(3);
    ListNode h3 = new ListNode(4);
    
    h.next = h1;
    h1.next = h2;
    h2.next = h3;
    h3.next = null;
    
    reorderList(h);
    
    while(h != null){
      System.out.println(h.val);
      h = h.next;
    }
  }
  
  
  /**
   * 1) 用快慢指针找到中间节点，将链表分成两部分。
   * 2) 对后面一半的链表逆序, 分别设置三个指针.
   *    第一个指针向前一个，
   *    第二个指针指向当前的节点，
   *    第三个指针保存下一个节点。
   * 3) 合并两个链表。
   */
  public static void reorderList(ListNode head) {
    if(head == null || head.next == null) return;
    
    /**
     * 利用快慢指针找到需要插入的部分
     */
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null)
    {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    /**
     * 从slow的下一个开始反转
     */
    ListNode pre = null;
    ListNode curr = slow.next;
    while(curr != null)
    {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    
    /**
     * 合并
     */
    slow.next = null;
    while (head != null && pre != null) {
      ListNode next1 = head.next;
      head.next = pre;
      pre = pre.next;
      head.next.next = next1;
      head = next1;
    }
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
