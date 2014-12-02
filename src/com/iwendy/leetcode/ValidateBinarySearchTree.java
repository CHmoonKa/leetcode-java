package com.iwendy.leetcode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
  }
  
  public boolean dfs(TreeNode root,long left, long right) {
    if(root == null)return true;
    
    if(root.val <= left || root.val >= right){
      return false;
    }else{
      return dfs(root.left,left,root.val) && dfs(root.right,root.val,right);
    }
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
