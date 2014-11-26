package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations(全排列).

  For example,
  [1,2,3] have the following permutations:
  [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
  
  public List<List<Integer>> permute(int[] num) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    allPermutation(num,0,num.length,list,res);
    
    return res;
  }
  
  public void  allPermutation(int[] A, int position, int length, List<Integer> list,List<List<Integer>> res){  
    
    if( position == length){  
        res.add(new ArrayList<Integer>(list));
    }  
    else{  
        for(int i = position; i < length; i++ ){  
            swap(A, position, i);
            list.add(A[position]);
            allPermutation(A, position + 1, length, list, res);  
            swap(A, position, i); 
            list.remove(list.size()-1);
        }  
    }
  }
  
  public void swap(int[] num, int x, int y){  
    int temp = num[x];  
    num[x] = num[y];  
    num[y] = temp;  
  } 
}
