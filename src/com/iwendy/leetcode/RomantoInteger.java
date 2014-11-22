package com.iwendy.leetcode;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger {

	public static void main(String[] args) {
		String r = "MCMXCVI";
		
		System.out.println(romanToInt(r));
	}
	
	public static int romanToInt(String s) {
		int ret = read(s.charAt(0));
        for(int i=1; i< s.length(); i++){
        	if(read(s.charAt(i)) > read(s.charAt(i-1))){
        		ret = ret-read(s.charAt(i-1)) + read(s.charAt(i)) - read(s.charAt(i-1));
        	}else{
        		ret = ret + read(s.charAt(i));
        	}
        }
        return ret;
    }
	
	public static int read(char c){  
        switch(c){  
        case 'M': return 1000;  
        case 'D': return 500;  
        case 'C': return 100;  
        case 'L': return 50;  
        case 'X': return 10;  
        case 'V': return 5;  
        case 'I': return 1;  
        default: return 0;  
        } 
	}
}
