package com.iwendy.leetcode;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		
		int len = s.length();
		String sb = "";
		
		boolean start = false;
		boolean ok = false;
		int p = 0;
		for(int i=0; i<len; i++){
			if(s.charAt(i) == ' '){
				if(start){
					start = false;
					ok = true;
				}
			}else{
				if(!start){
					start = true;
					p = i;
				}
			}
			
			if(i == len-1){
				if(start){
					ok = true;
					i = len;
				}
			}
			
			if(ok){
				if(sb.equals(""))
					sb = s.substring(p, i);
				else{
					sb = " " + sb;
					sb = s.substring(p,i) + sb;
				}
				ok = false;
			}
		}
		return sb;
	}
}
