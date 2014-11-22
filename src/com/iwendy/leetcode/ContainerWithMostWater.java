package com.iwendy.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 *
 * Note: You may not slant(倾斜) the container.
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = {1,2,3,5,2,1};
		
		System.out.println(maxArea_1(height));

	}

	/**
	 * 当从两边向中间考虑时，乘水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的。
 	 *
	 * 假定初始的盛水面积为ans=0，lh为左边的高度，rh为右边的高度，如果lh < rh, 则向右运动，
	 * 寻找第一个比当前lh大的左节点。同理，如果lh > rh，则向左运动，寻找第一个比当前rh大的右节点。
	 */
	public static int maxArea_1(int[] height) {
	    if(height==null || height.length==0)
	        return 0;
	    int l = 0;
	    int r = height.length-1;
	    int maxArea = 0;
	    while(l<r)
	    {
	    	int h = height[l] > height[r] ? height[r] : height[l];
	        maxArea = Math.max(maxArea, h*(r-l));
	        if(height[l]<height[r])
	            l++;
	        else
	            r--;
	    }
	    return maxArea;
	}
}
