package com.rufang.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 		Example:
 * 		Given nums = [2, 7, 11, 15], target = 9,
 * 		Because nums[0] + nums[1] = 2 + 7 = 9,
 * 		return [0, 1].
 * @author rufang
 *
 */

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {2, 7, 11, 15};
		int[] result = getTwoSum(test1, 9);
		System.out.println(result[0] + " " + result[1]);

	}
	
	public static int[] getTwoSum(int[] nums, int target){
		int firstIndex = -1;
		int secondIndex = -1;
		if((null == nums) || (nums.length == 0)){
			 return new int[]{firstIndex, secondIndex} ;
		}
		
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++){
			numMap.put(new Integer(nums[i]), new Integer(i));
		}
		
		for(int i=0; i<nums.length; i++){
			int num = nums[i];
			int second = target - num;
			if(second <= 0){
				continue;
			}
			if(numMap.containsKey(new Integer(second))){
				firstIndex = i;
				secondIndex = numMap.get(new Integer(second)).intValue();
				break;
			}
		}
		
		return new int[]{firstIndex, secondIndex} ;
	}

}
