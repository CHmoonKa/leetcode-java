package com.iwendy.leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

  For example,
  Given 1->2->3->3->4->4->5, return 1->2->5.
  Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null)return head;
    
    ListNode fake = new ListNode(-1);
    fake.next = head;
    
    ListNode pre = fake; // 标记有相同节点的前一个节点
    ListNode now = head; // 用来标记当前节点的
    
    while(now != null && now.next != null)
    {
      if(now.val == now.next.val)
      {
        while(now.next != null && now.val == now.next.val){
          now = now.next;
        }
        pre.next = now.next;
        now = now.next;
      }else{
        pre = now;
        now = now.next;
      }
    }//while
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
