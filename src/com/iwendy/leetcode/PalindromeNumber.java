package com.iwendy.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 *
 * You could also try reversing an integer. However, 
 * if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
 * How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 121;
		System.out.println(isPalindrome_1(x));
		System.out.println(isPalindrome_2(x));
	}
	
	// 对数字进行首位比较，这样不用担心溢出。
    public static boolean isPalindrome_1(int x) {
        if(x < 0)return false;
        int tmp = x;
        
        // 计算这个数字有多少个零
        int len = 1;
        while(tmp >= 10){
            len = len*10;
            tmp = tmp / 10;
        }
        
        while( x > 0){
            int l = x / len;
            int r = x % 10;
            
            if(l != r){
                return false;
            }
            
            x = (x % len) / 10;
            len = len / 100;
        }
        return true;
    }
    
    public static boolean isPalindrome_2(int x) {
        if(x < 0)return false;
        
        long y = 0;
        long tmp = x;
        while(x > 0){
            y = y*10 + x%10;
            x = x / 10;
        }
        
        if(y == tmp){
            return true;
        }
        
        return false;
    }

}
