package com.rufang.leetcode.array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {1,8,6,2,5,4,8,3,7};
		int result1 = maxArea(input1);
		int result1_1 = maxArea2(input1);
		System.out.println(result1);
		System.out.println(result1_1);
		
		int[] input2 = {1};
		int result2 = maxArea(input2);
		System.out.println(result2);

	}

	//brute force O(n2)
	public static int maxArea(int[] height) {
		if(null == height)
			return 0;
		
		if(height.length == 1)
			return 0;
		
		int maxValue = 0;
		
		for(int i=0; i<height.length-1; i++){
			
			for(int j=i+1; j<height.length; j++){
				int value = (j-i) * Math.min(height[i], height[j]);
				System.out.println("i=" + i + " j=" +j + " value=" + value);
				if(value > maxValue){
					maxValue = value;
				}
			}
		}
		
        return maxValue;
    }
	
	//two pointer solution, O(n)
	public static int maxArea2(int[] height) {
		if(null == height)
			return 0;
		
		if(height.length == 1)
			return 0;
		
		int maxValue = 0;
		int left = 0, right = height.length - 1;
		while(left < right){
			int value = (right - left) * Math.min(height[left], height[right]);
			System.out.println("left=" + left + " right=" +right + " value=" + value);
			maxValue = maxValue < value ? value : maxValue;
			
			if(height[left] < height[right]){
				left ++;
			} else {
				right --;
			}
		}
		
		return maxValue;
	}
}
