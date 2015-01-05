package com.iwendy.leetcode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.
 */
public class BinarySearchTreeIterator {

  Stack<TreeNode> small = new Stack<>();
  
  public BinarySearchTreeIterator(TreeNode root) {
    while(root != null){
      small.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
      return !small.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = small.pop();  
    int ret = node.val;  
    if (node.right != null) {  
        node = node.right;  
        while (node != null) {  
          small.push(node);  
          node = node.left;  
        }  
    }  
    return ret;
  }
  
  class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
