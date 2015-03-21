package com.iwendy.leetcode;

/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
"aaa", ".a" --false
 */
public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aaa","aa") == false);
		System.out.println(isMatch("aaa", "ab*a") == false);
		System.out.println(isMatch("aa", "a*") == true);
		System.out.println(isMatch("aa", ".*") == true);
		System.out.println(isMatch("aab", "c*a*b") ==true);
		System.out.println(isMatch("aaa", ".a") == false);
		System.out.println(isMatch("aaba", "ab*a*c*a") == false);
		System.out.println(isMatch("", ".*") == true);
	}
	
	public static boolean isMatch(String s, String p) {
        
        // 两个都不为空
        int m = s.length();
        int n = p.length();
        return isM(s, 0, m, p, 0, n);
    }
	
	// timeout
	static boolean internalMath(String s, int i, int m, String p, int j, int n)
	{
		if(i == m && j == n){
			return true;
		}
		if(i >= m || j >= n){
			return false;
		}
		
		if(j < n-1 && p.charAt(j+1) == '*')
		{
			if(p.charAt(j) == '.'){
				for(int index = 1;index <= m-i; index++){
					if(internalMath(s, i+index, m, p, j, n) || internalMath(s, i+index, m, p, j+2, n)){
						return true;
					}
				}
			}else{
				if(p.charAt(j) == s.charAt(i)){
					if(internalMath(s, i, m, p, j+2, n) || internalMath(s, i+1, m, p, j, n) || internalMath(s, i+1, m, p, j+2, n)){
						return true;
					}
				}else{
					if(internalMath(s, i, m, p, j+2, n)){
						return true;
					}
				}
			}
		}else{
			if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
				if(internalMath(s, i+1, m, p, j+1, n)){
					return true;
				}
			}else {
				return false;
			}
		}
		return false;
	}
	
	public static boolean isM(String s, int i, int m, String p, int j, int n){  
        if(j >= n){         // pattern已经用光  
            return i >= m;  // 如果s已经走完则匹配，否则不匹配  
        }  
        if(j == n-1){  // 如果pattern的j已经走到最后一个字符，如果想匹配，则s的i也必须在最后一个，且相等  
            return (i == m-1) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');  
        }  
  
        // 如果pattern的下一个字符(j+1)不是*  
        if(j+1<n && p.charAt(j+1) != '*'){  
            if(i == m){    // 如果s已经走完，则说明不匹配  
                return false;  
            }  
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){   // 如果当前字符匹配  
                return isM(s, i+1,m, p, j+1, n);     // 继续下一个字符判断  
            }else{  // 如果当前字符不匹配，直接返回false  
                return false;  
            }  
        }  
          
        // 如果下一个字符(j+1)是* 且 当前字符匹配，则进行搜索：  
        while(i<m && j<n && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){  
            // 因为*可以取0,1,2,...所以i=i,i+1,i+2,...对所有可能进行测试  
            // 最后能否匹配取决于剩下的匹配是否成功  
            if(isM(s, i, m, p, j+2,n)){  // 只要找到一个匹配成功即可  
                return true;  
            }  
            i++;  
        }  
          
        // 如果下一个字符(j+1)是* 且 当前字符不匹配，则pattern跳过两个，继续比较  
        // 还有一种情况到这里是上面的最后一次尝试（i==s.length()）  
        return isM(s, i, m, p, j+2,n);  
    }  
}
