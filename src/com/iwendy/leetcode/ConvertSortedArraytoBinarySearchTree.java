package com.iwendy.leetcode;

/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced (左边的数小于等于节点,右边的数大于等于节点).
 */
public class ConvertSortedArraytoBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] num) {
    if(num == null || num.length == 0) return null;
    
    return buildBst(num, 0, num.length-1);
  }
  
  public TreeNode buildBst(int[] num, int s, int e){
    if(s > e) return null;
    
    int mid = (s + e)/2;
    TreeNode tn = new TreeNode(num[mid]);
    tn.left = buildBst(num, s, mid-1);
    tn.right = buildBst(num, mid+1, e);
    
    return tn;
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
