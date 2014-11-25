package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.

    Each number in C may only be used once in the combination.
    
    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
    A solution set is: 
    [1, 7] 
    [1, 2, 5] 
    [2, 6] 
    [1, 1, 6]
 */
public class CombinationSumII {
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0){
      return res;
    }
    
    Arrays.sort(candidates);
    List<Integer> list = new ArrayList<Integer>();

    dfs(0, candidates, target, list, res);
    
    return res;
  }

//dfs --> depth first search
 public void dfs(int level, 
                 int[] a, 
                 int num, 
                 List<Integer> list,
                 List<List<Integer>> result) 
 {
   if (num == 0) {
     result.add(new ArrayList<Integer>(list));
   } else if (num < 0)
     return;
   else {
     for (int i = level; i < a.length; i++) {
       if (a[i] <= num) {
         list.add(a[i]);
         dfs(i+1, a, num - a[i], list, result);
         list.remove(list.size() - 1); // 还原现场
         
         //去重
         while (i < a.length - 1 && a[i] == a[i + 1])
           i++;
       }
     }//for
   }//else
 }//method
}
