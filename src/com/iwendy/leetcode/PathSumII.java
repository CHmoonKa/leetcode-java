package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where 
 * each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
       // dfs(root,sum,res,new ArrayList<Integer>());
        recursivePathSum(root,sum,res,new ArrayList<Integer>());
        
        return res;
    }
	
	public void recursivePathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) 
    {
        if (root == null)return;
        
        if (root.val == sum && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return;
      }
 
        list.add(root.val);
        recursivePathSum(root.left, sum-root.val, res, list);
        recursivePathSum(root.right, sum-root.val, res, list);
        list.remove(list.size()-1);
    }
	
	public void dfs(TreeNode root,int sum, List<List<Integer>> res, List<Integer> list)
	{
		if(root == null)return;
		
		sum = sum - root.val;
		list.add(root.val);
		
		if(root.left == null && root.right == null){
			if(sum == 0){
				res.add(list);
			}
			return;
		}
		
		dfs(root.left,sum,res,new ArrayList<>(list));
		dfs(root.right,sum,res,new ArrayList<>(list));
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
