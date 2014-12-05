package com.iwendy.leetcode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 *  convert it to a height balanced BST.
 *  可以先将ListNode转换为数组.
 */
public class ConvertSortedListtoBinarySearchTree {
  ListNode current;
  
  public TreeNode sortedListToBST(ListNode head) {
    current = head;
    int size = getLength(head);
    
    return getRoot(size);
  }
  
  public TreeNode getRoot(int size)
  {
    if(size <= 0){
      return null;
    }
    
    TreeNode left = getRoot(size/2);
    TreeNode tn = new TreeNode(current.val);
    current = current.next;
    TreeNode right = getRoot(size-1-size/2);
    tn.left = left;
    tn.right = right;
    
    return tn;
  }
  
  
  public int getLength(ListNode head){
    int size = 0;
    while(head != null){
      size++;
      head = head.next;
    }
    return size;
  }
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
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
