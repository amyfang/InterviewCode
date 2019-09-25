package com.rufang.leetcode.dp;

public class LongestPalindromicString {

	public static void main(String[] args) {
		LongestPalindromicString test = new LongestPalindromicString();
		String input = "cbaba";
		String output = test.longestPalindrome(input);
		System.out.println("output is: " + output);

	}
	
    public String longestPalindrome(String s) {
        if(null == s){
            return null;
        }
        char[] chars = s.toCharArray();
        
        if((chars.length == 0) || (chars.length == 1)){
            return s;
        }
        
        int longestPalindromStart = 0;
        int longestPalindromEnd = 0;
        int longestLength = 1;
        
        boolean [][] isPalindromeResult = new boolean[chars.length][chars.length];
        
        for(int i=0; i<chars.length; i++){
           isPalindromeResult[i][i] = true;
        }
        
        for(int i=0; i<(chars.length-1); i++){
           for(int j=(i+1); j<chars.length; j++) {
               if(((i+1) == j) && (chars[i] == chars[j])){
                    isPalindromeResult[i][j] = true;
                    if((j-i+1)>longestLength){
                        longestPalindromStart = i;
                        longestPalindromEnd = j;
                        longestLength = j-i+1;
                    }
               } else if(((i+1) == (j-1)) && (chars[i] == chars[j])){
                    isPalindromeResult[i][j] = true;
                    if((j-i+1)>longestLength){
                        longestPalindromStart = i;
                        longestPalindromEnd = j;
                        longestLength = j-i+1;
                    }
               } else if((chars[i] == chars[j]) && (isPalindromeResult[i+1][j-1])){
                    isPalindromeResult[i][j] = true;
                    if((j-i+1)>longestLength){
                        longestPalindromStart = i;
                        longestPalindromEnd = j;
                        longestLength = j-i+1;
                    }
               } else {
                    isPalindromeResult[i][j] = false;
               }
           }
        }
        
        return s.substring(longestPalindromStart,longestPalindromEnd+1);
        
    }

}
