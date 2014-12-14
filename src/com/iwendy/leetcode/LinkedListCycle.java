package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {
  public static void main(String[] args) {
    ListNode h = new ListNode(1);
    ListNode n = new ListNode(2);
    h.next = n;
    n.next = h;
    
    System.out.println(hasCycle_3(h));
  }
  
  /**
   * Currently the best way is the classic two pointers.
   * One pointer is slow (1 step a time)
   * One pointer is fast (2 steps a time)
   * If there is a cycle, the two pointers will eventually meet (equal).
   * 
   * 用两个移动的指针可以确保：如果有环的话两个指针都会进入有环的部分。
   * 一旦进入有环的部分，一快一慢，就相当于一个静止另一个移动。
   * 进入环后快的每次追一个, 所以肯定相遇。
   */
  public static boolean hasCycle_3(ListNode head) {
    if(head == null || head.next == null){
      return false;
    }
    
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast.next != null && fast.next.next != null)
    {
      slow = slow.next;
      fast = fast.next.next;
      
      /**
       * 相遇则退出
       * 但是相遇的点不一定就是环的起始点
       */
      if(slow == fast)return true;
    }
    
    return false;
  }
  
  // 使用空间换时间
  // Time Limit Exceeded
  public static boolean hasCycle_2(ListNode head) {
    if(head == null || head.next == null){
      return false;
    }
    
    List<ListNode> list = new ArrayList<>();
    list.add(head);
     
    ListNode p = head.next;
    while(p != null){
      if(list.contains(p)){
        return true;
      }
      list.add(p);
      p = p.next;
    }
    return false;
  }
  
  //Time Limit Exceeded
  public static boolean hasCycle_1(ListNode head) {
    if(head == null || head.next == null){
      return false;
    }
    
    ListNode p = head;
    while(p != null && p.next != null)
    {
      ListNode q = p.next;
      while(q != null)
      {
        if(p == q){
          return true;
        }
        q = q.next;
      }//q
      p = p.next;
    }//p
    
    return false;
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
