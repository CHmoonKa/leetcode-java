package com.iwendy.leetcode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

  Note:
  You may assume that duplicates do not exist in the tree.
        1
      /   \
     2     3
      \   /
       4 5
   preorder = 1, 2, 4, 3, 5
   inorder =  2, 4, 1, 5, 3
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || inorder == null) return null;
    if(preorder.length != inorder.length) return null;
    
    return build(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
  }
  
  /**
   * 左右子树的个数也许不一样.
   * 左子树个数为: p-ins
   * 右子树个数为: ine-p
   */
  public TreeNode build(int[] inorder, int ins, int ine, int[] preorder, int pres, int pree){
    if(ins > ine){
      return null;
    }
    
    TreeNode tn = new TreeNode(preorder[pres]);
    int p = findPosition(inorder, ins, ine, preorder[pres]);
    tn.left = build(inorder,ins,p-1,preorder,pres+1,pres+p-ins);
    tn.right = build(inorder,p+1,ine,preorder, pree-(ine-p)+1,pree);
    
    return tn;
  }
  
  public int findPosition(int[] inorder,int s, int e, int key){
    int ret = -1;
    for(int i=s; i<=e; i++){
      if(inorder[i] == key){
        ret = i;
        break;
      }
    }
    return ret;
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
