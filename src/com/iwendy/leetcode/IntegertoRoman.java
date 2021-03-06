package com.iwendy.leetcode;

/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
 * 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 * 右加左减：
 *		在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
 * 		在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
 * 		左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 		但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。
 * 				（等同于阿拉伯数字每位数字分别表示。）
 *  	左减数字必须为一位，比如8写成VIII，而非IIX。
 *  	右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
 * 加线乘千：
 * 		在罗马数字的上方加上一条横线或者加上下标的Ⅿ，表示将这个数乘以1000，即是原数的1000倍。
 * 		同理，如果上方有两条横线，即是原数的1000000（1000^{2}）倍。
 * 数码限制：
 *  	同一数码最多只能出现三次，如40不可表示为XXXX，而要表示为XL。
 *  	例外：由于IV是古罗马神话主神朱庇特（即IVPITER，古罗马字母里没有J和U）的首字，因此有时用IIII代替IV。
 *  
 * 3999范围内的罗马数字不会用到加上划线的字母
 * http://www.blackwasp.co.uk/NumberToRoman.aspx
 */
public class IntegertoRoman {

	public static void main(String[] args) {
		int s = 1;
		System.out.println(intToRoman(s));
	}
	
	// 可以先组合一些常用数字，只有4，9需要后一个减去前一个，所以列出
	// integer      roman_numeral  
	//  _______    _________________
	//    1       'I'              
	//    2       'II'             
	//    3       'III'            
	//    4       'IV' 需要减去一个            
	//    5       'V'              
	//    6       'VI'             
	//    7       'VII'            
	//    8       'VIII'           
	//    9       'IX'             
	//   10       'X'
	public static String intToRoman(int num) {
		String[] symbol = { "M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
	    int[] value =     {1000, 900, 500, 400,100, 90,  50, 40,  10,  9,  5,   4,  1}; 
	    String result = "";

	    for(int i=0; num!=0; i++){
	        while(num >= value[i]){
	            num -= value[i];
	            result+=symbol[i];
	        }
	    }

	    return result;
    }
}
