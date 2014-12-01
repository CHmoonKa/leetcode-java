package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);
  }

  private ArrayList<TreeNode> generateTrees(int left, int right) {
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    if (left > right) {
      res.add(null);
      return res;
    }

    for (int i = left; i <= right; i++) {
      ArrayList<TreeNode> lefts = generateTrees(left, i - 1); // 以i作为根节点，左子树由[1,i-1]构成
      ArrayList<TreeNode> rights = generateTrees(i + 1, right); // 右子树由[i+1, n]构成
      for (int j = 0; j < lefts.size(); j++) {
        for (int k = 0; k < rights.size(); k++) {
          TreeNode root = new TreeNode(i);
          root.left = lefts.get(j);
          root.right = rights.get(k);
          res.add(root); // 存储所有可能行
        }
      }
    }
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
