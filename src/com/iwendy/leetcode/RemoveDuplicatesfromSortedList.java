package com.iwendy.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

  For example,
  Given 1->1->2, return 1->2.
  Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
  public static void main(String[] args) {
    ListNode h = new ListNode(1); 
    h.next = new ListNode(1);
    h.next.next = new ListNode(3);
    
    ListNode t = deleteDuplicates(h);
    while(t != null){
      System.out.println(t.val + " ");
      t = t.next;
    }
  }
  
  public static ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode pre = head;
    ListNode nxt = head.next;
    
    pre.next = null;
    while(nxt != null)
    {
      if(pre.val != nxt.val){
        ListNode t = nxt.next;
        nxt.next = null;
        pre.next = nxt;
        pre = nxt;
        nxt = t;
      }else{
        nxt = nxt.next;
      }
      
    }
    return head;
  }
  
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
