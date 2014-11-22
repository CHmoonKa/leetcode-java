package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 *  A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 */
public class _3Sum {

	public static void main(String[] args) {
		int[] s = {-1, 0, 1 ,2, -1 ,-4};
		
		System.out.println(threeSum_2(s));
	}
	
	public static List<List<Integer>> threeSum_2(int[] num)  
	{  
		List<List<Integer>> res = new ArrayList<List<Integer>>();  
	    if(num==null || num.length<=2)  
	        return res;  
	    Arrays.sort(num);  
	    for(int i=num.length-1;i>=2;i--)  
	    {  
	        if(i<num.length-1 && num[i]==num[i+1])  
	            continue;  
	         ArrayList<ArrayList<Integer>> curRes = threeSum_2_tmp(num,i-1,-num[i]);  
	         for(int j=0;j<curRes.size();j++)  
	         {  
	             curRes.get(j).add(num[i]);  
	         }  
	         res.addAll(curRes);  
	    }  
	    return res;  
	}  
	
	// 先计算2sum
	public static ArrayList<ArrayList<Integer>> threeSum_2_tmp(int[] num, int end,int target)  
	{  
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    if(num==null || num.length<=1)  
	        return res;  
	    int l = 0;  
	    int r = end;  
	    while(l<r)  
	    {  
	        if(num[l]+num[r]==target)  
	        {  
	            ArrayList<Integer> item = new ArrayList<Integer>();  
	            item.add(num[l]);  
	            item.add(num[r]);  
	            res.add(item);  
	            l++;  
	            r--;  
	            while(l<r&&num[l]==num[l-1])  // 避免重复
	                l++;  
	            while(l<r&&num[r]==num[r+1])  
	                r--;  
	        }  
	        else if(num[l]+num[r]>target)  
	        {  
	            r--;  
	        }  
	        else  
	        {  
	            l++;  
	        }  
	    }  
	    return res;  
	} 

	public List<List<Integer>> threeSum_1(int[] num) {
		List<List<Integer>> ret = new ArrayList<>();
		if(num.length >= 3){
			for(int i=0; i< num.length; i++){
				for(int j=i+1; j< num.length; j++){
					for(int k=j+1; k< num.length; k++){
						if(num[i] + num[j] + num[k] == 0){
							List<Integer> t = new ArrayList<>();
							int l1 = num[i];
							int l2 = num[j];
							int l3 = num[k];
							if(l1 > l2){
								int ti = l1;
								l1 = l2;l2 = ti;
							}
							if(l2 > l3){
								int ti = l2;
								l2 = l3;l3 = ti;
							}
							if(l1 > l2){
								int ti = l1;
								l1 = l2;l2 = ti;
							}
							t.add(l1);
							t.add(l2);
							t.add(l3);
							ret.add(t);
						}
					}
				}
			}
		}
        return ret;
    }
}
