package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root == null){
      return res;
    }
    
    boolean reverse = false;
    List<Integer> level = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    
    queue.add(root);
    int currentSize = 1;
    int nextSize = 0;
    
    while(queue.size() > 0)
    {
      TreeNode tn = queue.pop();
      level.add(tn.val);
      currentSize--;
      
      if(tn.left != null){
        queue.add(tn.left);
        nextSize++;
      }
      if(tn.right != null){
        queue.add(tn.right);
        nextSize++;
      }
      
      if(currentSize == 0)
      {
        currentSize = nextSize;
        nextSize = 0;
        
        // 正着读取
        if(!reverse)
        {
          res.add(level);
          reverse = true;
        }else // 反着读取
        {
          Collections.reverse(level);
          res.add(level);
          reverse = false;
        }
        level = new ArrayList<>();
      }//if(currentSize==0)
    }//while
    
    return res;
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
