package com.leetcode.solutions;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8
 */
public class AndTwoNumbers {

  public static void main(String[] args) {

  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    long n1 = 0;
    long n2 = 0;
    
    long t1 = 1;
    while(l1 != null){
      n1 = n1 + l1.val*t1;
      t1 = t1*10;
      l1 = l1.next;
    }
    
    long t2 = 1;
    while(l2 != null){
      n2 = n2 + l2.val*t2;
      t2 = t2*10;
      l2 = l2.next;
    }
    
    long target = n1 + n2;
    ListNode root = new ListNode((int)(target%10));
    ListNode it = root;
    while(target/10 > 0){
      target = target/10;
      ListNode tmp = new ListNode((int)(target%10));
      it.next = tmp;
      it = tmp;
    } 
    
    return root;
  }

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
