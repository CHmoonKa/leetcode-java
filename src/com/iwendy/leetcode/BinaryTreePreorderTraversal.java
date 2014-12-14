package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
  /**
   * 将该递归函数转换成非递归的话，一般都要借助于栈。
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<>();
    if(root == null){
      return res;
    }
    
    stack.add(root);
    while(!stack.isEmpty()){
      TreeNode tmp = stack.pop();
      res.add(tmp.val);
      
      if(tmp.right != null){
        stack.add(tmp.right);
      }
      
      if(tmp.left != null){
        stack.add(tmp.left);
      }
    }
    
    return res;
  }
  
  
  
  public List<Integer> preorderTraversal_ite(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    dfs(root,res);
    
    return res;
  }
  
  public void dfs(TreeNode root,List<Integer> res){
    if(root == null)return;
    
    res.add(root.val);
    dfs(root.left,res);
    dfs(root.right,res);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
