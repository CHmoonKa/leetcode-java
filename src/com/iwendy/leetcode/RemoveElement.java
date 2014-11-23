package com.iwendy.leetcode;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int index = 0;
        int size = A.length;
        for(int i=0; i<size; i++){
        	if(A[i] != elem){
        		A[index++] = A[i];
        	}
        }
        
        return index;
    }
}
