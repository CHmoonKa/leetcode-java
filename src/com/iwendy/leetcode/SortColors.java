package com.iwendy.leetcode;

/**
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Note:
	You are not suppose to use the library's sort function for this problem.
	
	Follow up:(计数排序)
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, 
	then overwrite array with total number of 0's, then 1's and followed by 2's.
	Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {
	/**
	 * 这里track两个index，一个是red的index，一个是blue的index，两边往中间走。
		i从0到blue index扫描，
		遇到0，放在red index位置，red index后移；
		遇到2，放在blue index位置，blue index前移；
		遇到1，i后移。
		扫描一遍得到排好序的数组。时间O(n)，空间O(1)，
	 */
	public void sortColors(int[] A) {
		int n = A.length;
		int red = 0;
		int blue = n - 1;
		
		int i = 0;
		while (i < blue + 1) {
			if (A[i] == 0) {
				swap(A, i, red);
				red++;
				i++;
				continue;
			}
			if (A[i] == 2) {
				swap(A, i, blue);
				blue--;
				continue;
			}
			i++;
		}
	}
	
	void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	
	//  two-pass solution, Counting sort solution
	public void sortColors_2(int[] A) {
		int red = 0;
		int white = 0;
		int n = A.length;
		
		for (int i = 0; i < n; i++) 
		{
			switch (A[i]) {
			case 0:
				red++;
				break;
			case 1:
				white++;
				break;
			case 2:
				break;
			}
		}
		for (int i = 0; i < n; i++)
		{
			if (red > 0) {
				A[i] = 0;
				red--;
				continue;
			}
			if (white > 0) {
				A[i] = 1;
				white--;
				continue;
			}
			A[i] = 2;
		}
	}
	
	
	
}
