package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryTreeLevelOrderTraversalII {
  /**
   * 先顺着排,最后反转结果即可.
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root == null)return res;
    
    LinkedList<TreeNode> queue = new LinkedList<>();
    List<Integer> level = new ArrayList<>();
    int currentLevel = 1;
    int nextLevel = 0;
    
    queue.add(root);
    
    while(!queue.isEmpty()){
      TreeNode tn = queue.poll();
      currentLevel--;
      level.add(tn.val);
      
      if(tn.left != null){
        nextLevel++;
        queue.add(tn.left);
      }
      if(tn.right != null){
        nextLevel++;
        queue.add(tn.right);
      }
      
      if(currentLevel == 0){
        currentLevel = nextLevel;
        nextLevel = 0;
        res.add(level);
        level = new ArrayList<>();
      }
      
    }//while
    
    // 反转结果
    Collections.reverse(res);
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
