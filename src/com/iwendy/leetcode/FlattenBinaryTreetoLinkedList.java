package com.iwendy.leetcode;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreetoLinkedList {
	/**
	 * 对root的左子树进行处理，将左子树的根节点和左子树的右子树插入右子树中
	 *   1
		  \
		   2
	      / \
	     3   4
	          \
	           5
	            \
	             6
	 * 
	 */
	public void flatten(TreeNode root) {
      if(root == null) return;
      
      if(root.left != null){
    	  TreeNode rightNode = root.right;
          TreeNode leftNode = root.left;
          root.left = null;
          root.right = leftNode;
          TreeNode p = leftNode;
          while(p.right != null){
              p = p.right;
          }
          p.right = rightNode;
      }
      
      flatten(root.right);
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
