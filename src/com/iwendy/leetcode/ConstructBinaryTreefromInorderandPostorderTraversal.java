package com.iwendy.leetcode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
        1
      /   \
     2     3
      \   /
       4 5
   postorder = 4, 2, 5, 3, 1
    inorder =  2, 4, 1, 5, 3
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(postorder == null || inorder == null) return null;
    if(postorder.length != inorder.length) return null;
    
    return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
  }
  
  /**
   * 左右子树的个数也许不一样.
   * 左子树个数为: p-ins
   * 右子树个数为: ine-p
   */
  public TreeNode build(int[] inorder, int ins, int ine, int[] postorder, int posts, int poste){
    if(ins > ine){
      return null;
    }
    
    TreeNode tn = new TreeNode(postorder[poste]);
    
    int p = findPosition(inorder, ins, ine, postorder[poste]);
    
    tn.left = build(inorder,ins,p-1,postorder,posts,posts+p-ins-1);
    tn.right = build(inorder,p+1,ine,postorder, posts+p-ins,poste-1);
    
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
