package com.rufang.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        
		if((null == nums) || (nums.length < 3)){
			return null;
		}
		
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0 ; i<nums.length; i++){
			List<Integer> oneResult = new ArrayList<Integer>();
			int first = nums[0];
			for(int j=i+1; j<nums.length; j++){
				
			}
		}
		
		return null;
    }
	
	

}
