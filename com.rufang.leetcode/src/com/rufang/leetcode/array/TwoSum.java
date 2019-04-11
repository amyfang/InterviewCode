package com.rufang.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
		
		int[] test1 = {2, 7, 11, 15};
		int[] result = getTwoSum2(test1, 9);
		System.out.println(result[0] + " " + result[1]);

		int[] test2 = {3, 2, 4};
		int[] result2 = getTwoSum2(test2, 6);
		System.out.println(result2[0] + " " + result2[1]);
		
		//same entry
		int[] test3 = {3, 3};
		int[] result3 = getTwoSum2(test3, 6);
		System.out.println(result3[0] + " " + result3[1]);
		
		//0
		int[] test4 = {0,4,3,0};
		int[] result4 = getTwoSum2(test4, 0);
		System.out.println(result4[0] + " " + result4[1]);
		
		//negative value
		int[] test5 = {-1,-2,-3,-4,-5};
		int[] result5 = getTwoSum2(test5, -8);
		System.out.println(result5[0] + " " + result5[1]);
		
	}
	
	public static int[] getTwoSum(int[] nums, int target){
		int firstIndex = -1;
		int secondIndex = -1;
		if((null == nums) || (nums.length == 0)){
			 return new int[]{firstIndex, secondIndex} ;
		}
		
		Map<Integer, HashSet<Integer>> numMap = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i=0; i<nums.length; i++){
			if(numMap.containsKey(new Integer(nums[i]))){
				numMap.get(new Integer(nums[i])).add(new Integer(i));
			} else {
				HashSet<Integer> value = new HashSet<Integer>();
				value.add(new Integer(i));
				numMap.put(new Integer(nums[i]), value);
			}
			
		}
		
		for(int i=0; i<nums.length; i++){
			int num = nums[i];
			int second = target - num;
			
			if(numMap.containsKey(new Integer(second))){
				
				HashSet<Integer> value = numMap.get(new Integer(second));
				
				if(value != null){
					Iterator<Integer> items = value.iterator();
					while(items.hasNext()){
						int v = items.next().intValue();
						if(v != i){
							firstIndex = i;
							secondIndex = v;
							return new int[]{firstIndex, secondIndex} ;
						}
					}
					
				}
				
			}
		}
		
		return new int[]{firstIndex, secondIndex} ;
	}
	
	
	public static int[] getTwoSum2(int[] nums, int target){
		if (nums == null || nums.length < 2)
			return new int[] { 0, 0 };

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			} else {
				map.put(target - nums[i], i);
			}
		}

		return new int[] { 0, 0 };
	}

}
