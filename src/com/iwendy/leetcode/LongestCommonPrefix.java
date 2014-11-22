package com.iwendy.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
        int len = strs.length;
        boolean run = true;
        
        String pre = "";
        int index = 0;
        while(run){
        	if(strs[0].length() == 0 || index >= strs[0].length()){
        		run = false;
        		continue;
        	}
        	char t = strs[0].charAt(index);
        	int i = 1;
        	for(; i<len; i++){
        		if(strs[i].length() == 0 || index >= strs[i].length() || strs[i].charAt(index) != t){
        			run = false;
        			break;
        		}
        	}
        	index++;
        	if(i == len){
        		pre = strs[0].substring(0,index);
        	}
        }
        return pre;
    }
}
