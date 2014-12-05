package com.iwendy.leetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
   
   return isSum(root,0,sum);
  }
  
  public boolean isSum(TreeNode root, int sum,int target){
    if(root == null)return false;
    
    sum = sum + root.val;
    if(root.left == null && root.right == null){
      if(sum == target){
        return true;
      }else{
        return false;
      }
    }
    
    return isSum(root.left,sum,target) || isSum(root.right,sum,target);
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
