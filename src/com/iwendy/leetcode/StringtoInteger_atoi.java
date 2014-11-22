package com.iwendy.leetcode;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 *
 * spoilers alert...
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringtoInteger_atoi {

	public static void main(String[] args) {
		String a = "2147483648";
		System.out.println(atoi(a));
	}
	
	/**
	 * 1. "+-2" --> 0
	 * 2. "-0sa321" --> 0
	 * 3. "   - 321" --> 0
	 * 4. " b11228552307" --> 0
	 * 5. "9223372036854775809" --> 2147483647
	 */
	public static int atoi(String str) {
        int sign = 1;
        long ret = 0;
        boolean begin = false;
        for(char a: str.toCharArray()){
        	if(a ==' ' && !begin)continue;
        	
        	if(a == '+' && !begin) {
        		sign = 1;
        		begin = true;
        	}else if(a == '-' && !begin){
        		sign = -1;
        		begin = true;
        	}else{
        		int i = covertChar(a);
        		if(i >= 0) {
                    ret = ret*10 + i;
                    begin = true;
                    if(ret*sign > Integer.MAX_VALUE)
                		return Integer.MAX_VALUE;
            		else if(ret*sign < Integer.MIN_VALUE)
                		return Integer.MIN_VALUE;
                }else {
                	break;
                }
        	}//else
        }//for
        return (int) (ret*sign);
    }
    
    public static int covertChar(char c){
        switch(c){
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return -1;
        }
    }

}
