package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.
    
    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 2,3,6,7 and target 7, 
    A solution set is: 
    [7] 
    [2, 2, 3] 
 */
public class CombinationSum {
  
  public static void main(String[] args) {
    List<List<Integer>> ret =  combinationSum(new int[]{2,2,3}, 5);
    System.out.println(ret);
  }
  
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0){
      return res;
    }
    
    Arrays.sort(candidates);
    List<Integer> list = new ArrayList<Integer>();

    dfs(0, candidates, target, list, res);
    
    return res;
  }
  
  // dfs --> depth first search
  public static void dfs(int level, 
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
      //判断重复的,如{2,2,3}
        if(i != 0){
          if(a[i] == a[i-1]){
            continue;
          }
        }
        if (a[i] <= num) {
          list.add(a[i]);
          dfs(i, a, num - a[i], list, result);
          list.remove(list.size() - 1); // 还原现场
        }
      }//for
    }//else
  }//method
}
