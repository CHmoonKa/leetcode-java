package com.iwendy.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 */
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    
    return checkSym(root.left, root.right);
  }
  
  boolean checkSym(TreeNode l, TreeNode r){
    if(l == null && r == null) return true;
    
    if(l == null || r == null) return false;
    
    return (l.val == r.val) && checkSym(l.left,r.right) && checkSym(l.right,r.left);
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
