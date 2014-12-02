package com.iwendy.leetcode;

/**
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return rec(p,q);
  }
  
  boolean rec(TreeNode p, TreeNode q){
    if(p == null && q == null) return true;
    
    if(p == null || q == null) return false;
    
    if(p.val != q.val)return false;
    
    return rec(p.left,q.left)&&rec(p.right,q.right);
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
}
