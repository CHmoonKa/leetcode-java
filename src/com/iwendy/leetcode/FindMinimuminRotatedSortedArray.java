package com.iwendy.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray {
	public static void main(String[] args) {
		int[] t = new int[]{4,5,6,7,0,1,2};
		System.out.println(findMin(t));
	}
	
	public static int findMin(int[] num) {
		if(num == null || num.length == 0){
			return 0;
		}
		
		int i = 0;
		int j = num.length - 1;
		while(i < j)
		{
			int m = i + (j-i)/2;
			if(num[i] < num[m] && num[m] > num[j])
			{
				i = m;
			}
			
			else if(num[i] > num[m] && num[m] < num[j])
			{
				j = m;
			}
			
			else if(num[i] <= num[m] && num[m] <= num[j])
			{
				break;
			}
			else{
				i++;
				j--;
			}
		}
		
		return num[i];
	}
}
